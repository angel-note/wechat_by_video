package com.zwgangel.www.controller.admin;

import com.zwgangel.www.domain.Video;
import com.zwgangel.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: VideoAdminController
 * @Package: com.zwgangel.www.controller.admin.VideoAdminController
 * @Description: Video管理员操作
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-15 11:27
 */

@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {


    @Autowired
    private VideoService videoService;


    /**
     * 功能描述：根据 id 删除视频
     * 删除数据就使用delete请求
     * @param videoId
     * @return
     */
    @DeleteMapping("delete_video_by_id")
    public Object deleteVideoById(@RequestParam(value = "video_id",required = true) int videoId){
        int num = videoService.deleteVideoById(videoId);
        return num;
    }


    /**
     * 功能描述：根据 id 更新视频
     * 修改数据就使用put请求
     * @param video 把所有的参数通过 @RequestBody 进行封装到Video实体对象中
     * @return
     */
    @PutMapping("update_video_by_id")
    public Object updateVideoById(@RequestBody Video video){
        int rows = videoService.updateVideoById(video);
        System.out.println("影响的行数 number = " + rows);
        return "影响的行数 rows = " + rows;
    }


    /**
     * 功能描述：保存视频对象
     * 保存数据就使用post请求
     * @param video     把所有的参数通过 @RequestBody 进行封装到Video实体对象中
     * @return
     */
    @PostMapping("save_video")
    public Object saveVideo(@RequestBody Video video){
        int rows = videoService.saveVideo(video);
        System.out.println("影响的行数 number = " + rows);
        return "影响的行数 rows = " + rows;
    }


    /***
     * 请求很多参数如何处理？
     * 更新和保存是不能通过罗列一个一个请求的参数进行传值，这样太麻烦。
     * @RequestParam(value = "参数名1"),@RequestParam(value = "参数名2")
     * 但是：
     *  @RequestBody 请求体映射实体类
     *    需要指定http头为 content-type为application/json charset=utf-8
     * 所以，更新和保存需要用到 @RequestBody Video video这种注解，@RequestBody 是把所有的请求封装到Video对象里面
     * ，然后进行取值。
     * 针对查询、删除操作可以使用@RequestParam(value = "参数名1")来获取单个参数。
     */

}
