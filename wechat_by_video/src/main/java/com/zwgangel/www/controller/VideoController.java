package com.zwgangel.www.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwgangel.www.domain.Video;
import com.zwgangel.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                            @RequestParam(value = "size",defaultValue = "2")int size){
        PageHelper.startPage(page,size);        // 添加这行语句就可实现分页功能
        List<Video> videoList = videoService.findAll();
        System.out.println(videoList);
        PageInfo<Video> pageInfo = new PageInfo<>(videoList);       // 获取这个分页查询的所有信息
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("total_size",pageInfo.getTotal());      // 总条数
        dataMap.put("total_page",pageInfo.getPages());      // 总页数
        dataMap.put("current_page",page);                   // 当前页
        dataMap.put("data",pageInfo.getList());            // 当前分页数据
        return dataMap;
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
