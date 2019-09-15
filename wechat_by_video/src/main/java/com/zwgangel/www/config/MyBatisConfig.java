package com.zwgangel.www.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Title: MyBatisConfig
 * @Package: com.zwgangel.www.config.MyBatisConfig
 * @Description:  MyBatis分页插件配置
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-15 15:38
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        // 设置为true时，针将RowBounds第一个参数offset当成pageNum页码使用
        p.setProperty("offsetAsPageNum","true");
        // 设置为true时，使用RowBounds分布会进行count查询
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
