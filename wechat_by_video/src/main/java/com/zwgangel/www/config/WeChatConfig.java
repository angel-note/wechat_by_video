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
}
