package com.nike.reptile.task;

import com.nike.reptile.entity.ShoeEntity;
import com.nike.reptile.service.BigBoyService;
import com.nike.reptile.service.ManShoesService;
import com.nike.reptile.service.WomanShoesService;
import com.nike.reptile.service.serviceImpl.BigBoyServiceImpl;
import com.nike.reptile.service.serviceImpl.ManShoesServiceImpl;
import com.nike.reptile.service.serviceImpl.WomanShoesServiceImpl;
import com.nike.reptile.util.EmailUtil;
import com.nike.reptile.util.IPUtil;
import com.nike.reptile.util.ReadAndWriteUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

/**
 * @program: reptile
 * @description: 项目启动自动执行的Task
 * @author: Geekye
 * @create: 2018-12-05 15:46
 **/
@Component
@Order(value = 2)
public class getShoesTask implements ApplicationRunner {

    //用于鞋对比的Hash集合
    private Set<String> localtionHashSet = new HashSet<>();

    /**
     * 获取数据的线程池
     */
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
            2000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024));

    /**
     * 任务周期调用的scheduleThreadPool
     */
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);


    @Override
    public void run(ApplicationArguments args) {

        //更换有效IP地址
        new IPUtil().getValidIP();

        //获取总的鞋子实体类List
        List<ShoeEntity> shoesResult = getShoeEntities();

        //统计鞋子的数量
        countShoesNum(shoesResult);

        //获取shoesList的Hashcode
        List<String> shoesHash = listShoesHashCode(shoesResult);

        File fileName = new File("./ShoesHash.txt");

        if (!fileName.exists()) {
            //如果本地没有文件，则将ListHash存到本地
            new ReadAndWriteUtil().writeListIntoFile(shoesHash);
        }
        //则本地文件存的Hash存到Set中
        List<String> localtionHashList = new ReadAndWriteUtil().readFileIntoList();
        localtionHashSet.addAll(localtionHashList);

        //每10分钟调用该schedule,通知用户，追加数据
        scheduledExecutorService.scheduleAtFixedRate((Runnable) () -> noticeTask(),
                0L,
                1000L * 60 * 10,
                TimeUnit.MILLISECONDS);
    }

    //通知
    private void noticeTask() {

        System.out.println("开始监控任务，noticeTask运行！");
        //获取总的鞋子实体类List
        List<ShoeEntity> shoesResult = getShoeEntities();

        //临时存放新上线鞋的HashList
        List<String> shoeHashListTemp = new ArrayList<>();
        //临时存放新上线鞋的List
        List<ShoeEntity> shoeEntities = new ArrayList<>();
        for (ShoeEntity shoe : shoesResult
                ) {
            //是否存在LocaltionHashSet中
            boolean flag = localtionHashSet.add(String.valueOf(shoe.hashCode()));
            if (flag) {
                //将Hash追加到临时存放新上线鞋的HashList
                shoeHashListTemp.add(String.valueOf(shoe.hashCode()));
                shoeEntities.add(shoe);
            }
        }

        if (shoeHashListTemp.size() >= 1) {
            //通知
            try {
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new EmailUtil().sendEmail("有新款上线了！如下:"+shoeEntities.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            //将临时存放新上线鞋的HashList追加到到本地文件中
            new ReadAndWriteUtil().writeListIntoFileByAppend(shoeHashListTemp);
        }
    }

    private List<String> listShoesHashCode(List<ShoeEntity> shoesResult) {
        List<String> shoesHash = new ArrayList<>();
        for (ShoeEntity shoe : shoesResult
                ) {
            shoesHash.add(String.valueOf(shoe.hashCode()));
        }
        return shoesHash;
    }

    private List<ShoeEntity> getShoeEntities() {
        Map<String, Future<List<ShoeEntity>>> futureMap = new HashMap();
        List<ShoeEntity> shoesResult = new ArrayList<>();
        //获取大童鞋的List并放到FutureMap中
        setBigBoyIntoFutureMap(futureMap);
        //获取男人鞋的List并放到FutureMap中
        setManIntoFutureMap(futureMap);
        //获取女人鞋的List并放到FutureMap中
        setWomanIntoFutureMap(futureMap);

        for (String key : futureMap.keySet()
                ) {
            Future<List<ShoeEntity>> shoeFuture = futureMap.get(key);
            try {
                List<ShoeEntity> shoes = shoeFuture.get(8000L, TimeUnit.MILLISECONDS);
                shoesResult.addAll(shoes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        return shoesResult;
    }

    private void countShoesNum(List<ShoeEntity> shoesResult) {
        int count = 0;
        for (ShoeEntity shoe : shoesResult
                ) {
            count++;
            System.out.println(shoe.toString());
        }

        System.out.println("总共" + count + "双鞋！");
    }

    private void setWomanIntoFutureMap(Map<String, Future<List<ShoeEntity>>> futureMap) {
        Future<List<ShoeEntity>> womanShoesFuture = threadPoolExecutor.submit(() -> {
            WomanShoesService womanShoesService = new WomanShoesServiceImpl();
            List<ShoeEntity> womanShoes = womanShoesService.getWomanShoes();
            return womanShoes;
        });
        futureMap.put("woman", womanShoesFuture);
    }

    private void setManIntoFutureMap(Map<String, Future<List<ShoeEntity>>> futureMap) {
        Future<List<ShoeEntity>> manShoesFuture = threadPoolExecutor.submit(() -> {
            ManShoesService manShoesService = new ManShoesServiceImpl();
            List<ShoeEntity> manShoes = manShoesService.getManShoes();
            return manShoes;
        });
        futureMap.put("man", manShoesFuture);
    }

    private void setBigBoyIntoFutureMap(Map<String, Future<List<ShoeEntity>>> futureMap) {
        Future<List<ShoeEntity>> bigBoyShoesFuture = threadPoolExecutor.submit(() -> {
            BigBoyService bigBoyService = new BigBoyServiceImpl();
            List<ShoeEntity> bigBoyShoes = bigBoyService.getBigBoyShoes();
            return bigBoyShoes;
        });
        futureMap.put("bigBoy", bigBoyShoesFuture);
    }
}
