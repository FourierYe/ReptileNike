package com.nike.reptile.task;

import com.nike.reptile.entity.ShoeEntity;
import com.nike.reptile.service.BigBoyService;
import com.nike.reptile.service.ManShoesService;
import com.nike.reptile.service.serviceImpl.BigBoyServiceImpl;
import com.nike.reptile.service.serviceImpl.ManShoesServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: reptile
 * @description: 项目启动自动执行的Task
 * @author: Geekye
 * @create: 2018-12-05 15:46
 **/
@Component
@Order(value = 2)
public class getShoesTask implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BigBoyService bigBoyService = new BigBoyServiceImpl();
        ManShoesService manShoesService = new ManShoesServiceImpl();
        List<ShoeEntity> shoes = manShoesService.getManShoes();
//        List<ShoeEntity> shoes = bigBoyService.getBigBoyShoes();
        Integer count = 0;
        for (ShoeEntity shoe:shoes
             ) {
            count++;
            System.out.println(shoe.toString());
        }
        System.out.println("总共男鞋："+count+"双！");
//        System.out.println("总共大童鞋："+count+"双！");
    }
}
