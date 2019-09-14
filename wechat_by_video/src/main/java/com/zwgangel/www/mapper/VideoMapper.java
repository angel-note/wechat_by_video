package com.zwgangel.www.mapper;

import com.zwgangel.www.domain.Video;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Title: VideoMapper
 * @Package: com.zwgangel.www.mapper.VideoMapper
 * @Description: 视频Dao层的数据库表操作(增、删、改、查)
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 22:17
 */
public interface VideoMapper {

    /**
     * 查询所有数据
     * @return
     */
    @Select("select * from video")
    @Results({
            @Result(column = "cover_img",property = "coverImg"),
            @Result(column = "view_num",property = "viewNum"),
            @Result(column = "create_time",property = "createTime")
    })
    List<Video> findAll();
}
