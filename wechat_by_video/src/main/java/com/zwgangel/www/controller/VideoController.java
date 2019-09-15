package com.zwgangel.www.controller;

import com.zwgangel.www.domain.Video;
import com.zwgangel.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: VideoController
 * @Package: com.zwgangel.www.controller.VideoController
 * @Description: video 视频访问层 （普通成员）只有查询的操作
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 15:08
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 功能描述：
     * 查询数据就使用get请求
     * @param page  : 当前第几页 ， 默认是第一页
     * @param size  : 每页显示几条记录
     * @return
     */
    @GetMapping("page")
    public Object pageVideo(@RequestParam(value = "page",defaultValue = "1")int page,
                            @RequestParam(value = "size",defaultValue = "10")int size){
        List<Video> videoList = videoService.findAll();
        System.out.println(videoList);
        return videoList;
    }

    /**
     * 功能描述：根据 id 查找视频
     * 查询数据就使用get请求
     * @param videoId
     * @return
     */
    @GetMapping("find_video_by_id")
    public Object findVideoById(@RequestParam(value = "video_id",required = true)int videoId){
        Video video = videoService.findVideoById(videoId);
        System.out.println(video);
        return video;
    }

}
