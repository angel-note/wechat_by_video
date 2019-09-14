package com.angel.www.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: VideoController
 * @Package: com.angel.www.controller.VideoController
 * @Description:
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 10:42
 */
@RestController
public class VideoController {


    @RequestMapping("test")
    public Object test(){
        return "Hello zwgangel";
    }
}
