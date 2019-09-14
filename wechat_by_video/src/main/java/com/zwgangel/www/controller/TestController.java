package com.zwgangel.www.controller;

import com.zwgangel.www.config.WeChatConfig;
import com.zwgangel.www.domain.Video;
import com.zwgangel.www.service.VideoService;
import com.zwgangel.www.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: VideoController
 * @Package: com.zwgangel.www.controller.VideoController
 * @Description:
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 15:08
 */
@RestController
@RequestMapping("/wechat_by_video")
public class TestController {

    @RequestMapping("test")
    public String test(){
        return "hello wrold";
    }



    /**
     * 测试微信公众号配置
     * @return
     */
    @Autowired
    private WeChatConfig weChatConfig;
    @RequestMapping("test_wechat_config")
    public String testWeChatConfig(){

        String wechat_appid = weChatConfig.getAppid();
        String wechat_appsecret = weChatConfig.getAppsecret();
        System.out.println("公众号appid : " + wechat_appid);
        System.out.println("公众号密钥 : " + wechat_appsecret);

        return "公众号appid : " + wechat_appid +"公众号密钥 : " + wechat_appsecret;
    }


    /**
     * 测试MySQL和MyBatis的配置
     * @return
     */
    @Autowired
    private VideoService videoService;
    @RequestMapping("test_db")
    public Object testDB(){
        List<Video> videoList = videoService.findAll();
        System.out.println(videoList);
        return videoList;
    }

}
