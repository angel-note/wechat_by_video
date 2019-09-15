package com.zwgangel.www.service;

import com.zwgangel.www.domain.Video;

import java.util.List;

/**
 * @Title: VideoService
 * @Package: com.zwgangel.www.service.VideoService
 * @Description:   视频业务类接口
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 16:12
 */
public interface VideoService {

    /**
     * 查询所有数据
     * @return
     */
    List<Video> findAll();

    /**
     * 根据 id 查询一条记录
     * @param videoId
     * @return
     */
    Video findVideoById(int videoId);

    /**
     * 根据 id 修改一条记录
     * @param video
     * @return
     */
    int updateVideoById(Video video);


    /**
     * 根据 id 删除一条记录
     * @param id
     * @return
     */
    int deleteVideoById(int id);

    /**
     * 保存一条数据，并得到返回的唯一id
     * @param video
     * @return
     */
    int saveVideo(Video video);

}
