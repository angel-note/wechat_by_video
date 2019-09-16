package com.zwgangel.www.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: HttpUtils
 * @Package: com.zwgangel.www.utils.HttpUtils
 * @Description:  封装http get post 的请求
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-16 10:44
 */
public class HttpUtils {

    private static  final Gson gson = new Gson();

    /**
     * 功能描述 ： 封装 get 方法请求
     *      用于微信扫描登录后，需要重定向一个第三方应用.
     * @param url
     * @return
     */
    public static Map<String,Object> doGet(String url){
        Map<String,Object> map = new HashMap<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 设置一些基本信息
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)    // 连接超时
                .setConnectionRequestTimeout(5000)  // 请求超时
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)    // 允许自动重定向
                .build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);    // 执行请求
            if(httpResponse.getStatusLine().getStatusCode() == 200){    // 判断状态码
                String jsonResult = EntityUtils.toString(httpResponse.getEntity());     // Entity 是结果
                map = gson.fromJson(jsonResult,map.getClass());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return map;
    }

    /**
     * 功能描述 ： 封装 post 方法请求
     *      用于微信支付时，需要使用post发送一些请求到微信中
     * @param url
     * @param data
     * @return
     */
    public static String doPost(String url, String data, int timeout){

        CloseableHttpClient httpClient = HttpClients.createDefault();

        //超时设置
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout)    // 连接超时
                .setConnectionRequestTimeout(timeout)  // 请求超时
                .setSocketTimeout(timeout)
                .setRedirectsEnabled(true)    // 允许自动重定向
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        httpPost.addHeader("Content-Type","text/html;chartset=UTF-8");
        if(data != null && data instanceof String){     // 使用字符串进行传参
            StringEntity stringEntity = new StringEntity(data,"UTF-8");
            httpPost.setEntity(stringEntity);
        }
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(httpEntity);
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }


}
