package com.zwgangel.www.service.impl;

import com.zwgangel.www.domain.Video;
import com.zwgangel.www.mapper.VideoMapper;
import com.zwgangel.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: VideoServiceImpl
 * @Package: com.zwgangel.www.service.impl.VideoServiceImpl
 * @Description:
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 16:13
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> findAll() {
        List<Video> videoList = videoMapper.findAll();
        return videoList;
    }

    @Override
    public Video findVideoById(int videoId) {
        Video video = videoMapper.findVideoById(videoId);
        return video;
    }

    @Override
    public int updateVideoById(Video video) {
        int num = videoMapper.updateVideoById(video);
        return num;
    }

    @Override
    public int deleteVideoById(int id) {
        int num = videoMapper.deleteVideoById(id);
        return num;
    }

    @Override
    public int saveVideo(Video video) {
        int rows = videoMapper.saveVideo(video);
        int id = video.getId();
        System.out.println("保存数据的对象 id = " + id);
        return rows;
    }
}
