package com.zwgangel.www.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Title: WeChatConfig
 * @Package: com.zwgangel.www.config.WeChatConfig
 * @Description:    微信配置类
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 21:50
 */
@Setter
@Getter
@ToString
@Configuration
@PropertySource(value="classpath:application.properties")
public class WeChatConfig {

    /**
     * 公众号appid
     */
    @Value("${wxpay.appid}")
    private String appid;

    /**
     * 公众号密钥
     */
    @Value("${wxpay.appsecret}")
    private String appsecret;


    /**
     *  微信开放平台  appid
     */
    @Value("${wxopen.appid}")
    private String openAppid;
    /**
     * 微信开放平台 appsecret
     */
    @Value("${wxopen.appsecret}")
    private String openAppsecret;

    /**
     * 微信开放平台(回调地址)重定向 url
     */
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;

    /**
     * 第一步：微信开放平台二维码连接 , 扫描二维码后会返回一个请求CODE
     * appid	是	应用唯一标识
     * redirect_uri	是	请使用urlEncode对链接进行处理
     * response_type	是	填code
     * scope	是	应用授权作用域，拥有多个作用域用逗号（,）分隔，网页应用目前仅填写snsapi_login即
     * state	否	用于保持请求和回调的状态，授权请求后原样带回给第三方
     */
    private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";


    /**
     * 第二步：微信开放平台获access_token地址
     * 通过传入appid、secret、code  来获取access_token.
     * 然后通过 access_token 获取微信的基本信息
     * // https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     */
    private final static String OPEN_ACCESS_TOKEN_URL  = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    //
    /**
     * 第三步：根据 access_token获取用户信息
     * // https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
     */
    private final static String OPEN_USER_INFO_URL  = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";


    public static String getOpenQrcodeUrl() {
        return OPEN_QRCODE_URL;
    }

    public static String getOpenAccessTokenUrl() {
        return OPEN_ACCESS_TOKEN_URL;
    }

    public static String getOpenUserInfoUrl() {
        return OPEN_USER_INFO_URL;
    }
}
