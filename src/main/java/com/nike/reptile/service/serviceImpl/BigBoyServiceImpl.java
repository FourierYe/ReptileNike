package com.nike.reptile.service.serviceImpl;

import com.nike.reptile.constant.URLConstant;
import com.nike.reptile.entity.ShoeEntity;
import com.nike.reptile.reptile.ReptileUtil;
import com.nike.reptile.service.BigBoyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @program: reptile
 * @description: 获取大男孩鞋的实现类
 * @author: Geekye
 * @create: 2018-12-05 10:47
 **/
public class BigBoyServiceImpl implements BigBoyService ,Callable<List<ShoeEntity>> {

    @Override
    public List<ShoeEntity> getBigBoyShoes() {

        List<ShoeEntity> bigBoyShoes = new ArrayList<>();

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            try {
                List<ShoeEntity> shoes = new ReptileUtil().getNikeResource(URLConstant.NIKE_BIG_BOY_URL, i);
                bigBoyShoes.addAll(shoes);
            } catch (Exception e) {
                // TODO: 2018/12/5 记录异常日志
                break;
            }
        }
        return bigBoyShoes;
    }

    @Override
    public List<ShoeEntity> call() throws Exception {
        return getBigBoyShoes();
    }

}
