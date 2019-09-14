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
}
