package com.zwgangel.www.config;

import com.zwgangel.www.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title: IntercepterConfig
 * @Package: com.zwgangel.www.config.IntercepterConfig
 * @Description:  配置一个拦截器，使用那些定义好的拦截器
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-20 01:12
 */
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/user/api/v1/*/**");// 拦截/user/api/v1 下的所有请求
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
