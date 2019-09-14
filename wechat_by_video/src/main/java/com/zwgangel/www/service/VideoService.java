package com.zwgangel.www.service;

import com.zwgangel.www.domain.Video;

import java.util.List;

/**
 * @Title: VideoService
 * @Package: com.zwgangel.www.service.VideoService
 * @Description:
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

}
