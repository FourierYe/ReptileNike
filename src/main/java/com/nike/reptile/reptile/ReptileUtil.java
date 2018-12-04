package com.nike.reptile.reptile;

import com.nike.reptile.constant.URLConstant;
import com.nike.reptile.util.HttpUtil;

import java.text.MessageFormat;

/**
 * @program: reptile
 * @description: 爬虫工具类
 * @author: Geekye
 * @create: 2018-11-28 16:53
 **/
public class ReptileUtil {

//    public List<>

    public static void main(String[] args) {
        String result = HttpUtil.sendGet(MessageFormat.format(URLConstant.NIKE_MAN_URL,1));
        System.out.println(result);
    }
}
