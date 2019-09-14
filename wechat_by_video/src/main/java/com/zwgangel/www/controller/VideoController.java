package com.zwgangel.www.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class VideoController {

    @RequestMapping("test")
    public String test(){
        return "hello world";
    }

}
