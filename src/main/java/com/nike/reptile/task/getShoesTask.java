package com.nike.reptile.task;

import com.nike.reptile.entity.ShoeEntity;
import com.nike.reptile.service.BigBoyService;
import com.nike.reptile.service.ManShoesService;
import com.nike.reptile.service.WomanShoesService;
import com.nike.reptile.service.serviceImpl.BigBoyServiceImpl;
import com.nike.reptile.service.serviceImpl.ManShoesServiceImpl;
import com.nike.reptile.service.serviceImpl.WomanShoesServiceImpl;
import com.nike.reptile.util.ReadAndWriteUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    /**
     * 线程池
     */
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
            2000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024));

    @Override
    public void run(ApplicationArguments args) {

        Map<String, Future<List<ShoeEntity>>> futureMap = new HashMap();
        List<ShoeEntity> shoesResult = new ArrayList<>();
        //获取大童鞋的List并放到FutureMap中
        setBigBoyIntoFutureMap(futureMap);
        //获取男人鞋的List并放到FutureMap中
        setManIntoFutureMap(futureMap);
        //获取女人鞋的List并放到FutureMap中
        setWomanIntoFutureMap(futureMap);

        for (String key:futureMap.keySet()
             ) {
            Future<List<ShoeEntity>> shoeFuture = futureMap.get(key);
            try {
                List<ShoeEntity> shoes = shoeFuture.get(3000L, TimeUnit.MILLISECONDS);
                shoesResult.addAll(shoes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        int count = 0;
        for (ShoeEntity shoe:shoesResult
             ) {
            count++;
            System.out.println(shoe.toString());
        }

        System.out.println("总共"+count+"双鞋！");
//        new ReadAndWriteUtil().writeListIntoFile(shoesHash);
//        System.out.println("总共男鞋：" + count + "双！");
//        System.out.println("总共大童鞋："+count+"双！");
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
