package com.zwgangel.www.controller;

import com.zwgangel.www.domain.Video;
import com.zwgangel.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Title: VideoController
 * @Package: com.zwgangel.www.controller.VideoController
 * @Description: 视频访问层
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
     * 查询数据就使用get请求
     * @return
     */
    @GetMapping("find_all")
    public Object findAll(){
        List<Video> videoList = videoService.findAll();
        System.out.println(videoList);
        return videoList;
    }

    /**
     * 查询数据就使用get请求
     * @param videoId
     * @return
     */
    @GetMapping("find_video_by_id")
    public Object findVideoById(int videoId){
        Video video = videoService.findVideoById(videoId);
        System.out.println(video);
        return video;
    }

    /**
     * 修改数据就使用put请求
     * @param videoId
     * @param title
     * @param summary
     * @param viewNum
     * @return
     */
    @PutMapping("update_video_by_id")
    public Object updateVideoById(int videoId , String title, String summary, int viewNum){
        Video video = new Video();
        video.setId(videoId);
        video.setTitle(title);
        video.setSummary(summary);
        video.setViewNum(viewNum);
        video.setCreateTime(new Date());
        int num = videoService.updateVideoById(video);
        System.out.println(num);
        return num;
    }

    /**
     * 删除数据就使用delete请求
     * @param videoId
     * @return
     */
    @DeleteMapping("delete_video_by_id")
    public Object deleteVideoById(int videoId){
        int num = videoService.deleteVideoById(videoId);
        System.out.println(num);
        return num;
    }

    /**
     * 保存数据就使用post请求
     * @param title
     * @return
     */
    @PostMapping("save_video")
    public Object saveVideo(String title){
        Video video = new Video();
        video.setTitle(title);
        video.setCreateTime(new Date());
        int rows = videoService.saveVideo(video);
        return rows;
    }




}
