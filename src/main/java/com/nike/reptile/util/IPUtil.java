package com.nike.reptile.util;

import com.nike.reptile.constant.CommonConstant;
import com.nike.reptile.entity.ShoeEntity;
import com.nike.reptile.reptile.ReptileUtil;
import com.nike.reptile.service.serviceImpl.ManShoesServiceImpl;

import java.util.List;

/**
 * @program: reptile
 * @description: IP工具类
 * @author: Geekye
 * @create: 2018-12-07 16:33
 **/
public class IPUtil {

    //验证当前Ip是否可用
    public boolean testIPVaild() {
        List<ShoeEntity> shoes = null;
        try {
            shoes = new ReptileUtil().getNikeResource("https://store.nike.com/html-services/gridwallData?country=CN&lang_locale=zh_CN&gridwallPath=mens-shoes/7puZoi3&pn={0}", 1);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (shoes == null || shoes.size() <= 0) {
            return false;
        }
        return true;
    }

    public void getValidIP() {

        for (String ip : CommonConstant.IP_POOL
                ) {
            //验证当前IP是否可用
            boolean flag = testIPVaild();
            if (flag) {
                break;
            } else {
                changeCurrentIP(ip);
            }
        }

    }

    public void changeCurrentIP(String Ip) {
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
        System.getProperties().setProperty("http.proxyHost", Ip);
        System.getProperties().setProperty("http.proxyPort", "80");
    }

    public static void main(String[] args) {
        new IPUtil().getValidIP();
    }
}
