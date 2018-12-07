package com.nike.reptile.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * The type Http util.
 * @author geekye.ye
 */
public class HttpUtil {

    private static final CloseableHttpClient httpclient = HttpClients.createDefault();

    /**
     * 发送HttpGet请求
     *
     * @param url the url
     * @return string
     */
    public static String sendGet(String url) {

        HttpGet httpget = new HttpGet(url);
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpget.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * Send post json object.
     *
     * @param url        the url
     * @param jsonObject the json object
     * @return the json object
     */
    public static String sendPost(String url, JSONObject jsonObject) {

        HttpPost post = new HttpPost(url);
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(2000).build();
        post.setConfig(requestConfig);
        String result="";
        try {
            StringEntity stringEntity = new StringEntity(jsonObject.toString());
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            post.setEntity(stringEntity);

            HttpResponse res = httpclient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回json格式：
                 result = EntityUtils.toString(res.getEntity());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    /**
     * 发送不带参数的HttpPost请求
     *
     * @param url the url
     * @return string
     */
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httppost.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
        String ip = "93.91.200.146";
//        ip = "221.130.18.5";
//        ip = "221.130.23.135";
//        ip = "221.130.18.78";
//        ip = "221.130.23.134";
//        ip = "221.130.18.49";
//        ip = "111.1.32.36";
//        ip = "221.130.18.49";
//        ip = "221.130.18.49";
        System.getProperties().setProperty("http.proxyHost", ip);
        System.getProperties().setProperty("http.proxyPort", "80");

        //确定代理是否设置成功
        String result = sendGet("https://store.nike.com/html-services/gridwallData?country=CN&lang_locale=zh_CN&gridwallPath=mens-shoes/7puZoi3&pn=2");
        System.out.println(result);
    }
}
