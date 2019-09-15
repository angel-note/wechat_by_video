package com.zwgangel.www.mapper;

import com.zwgangel.www.domain.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Title: VideoMapper
 * @Package: com.zwgangel.www.mapper.VideoMapper
 * @Description: Video 数据访问层，视频Dao层的数据库表操作(增、删、改、查)
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-14 22:17
 */
public interface VideoMapper {

    /**
     * 查询所有数据
     * 注意：
     *      由于在application.properties中进行了配置，但要注意。实体类的属性一定是驼峰命名规范
     *      所以移除了@Results的注解
     * @return
     */
    @Select("select * from video")
//    @Results({
//            @Result(column = "cover_img",property = "coverImg"),
//            @Result(column = "view_num",property = "viewNum"),
//            @Result(column = "create_time",property = "createTime")
//    })
    List<Video> findAll();

    /**
     * 根据 id 查询一条记录
     * @param videoId
     * @return
     */
    @Select("select * from video where id = #{id}")
    Video findVideoById(int videoId);

    /**
     * 根据 id 修改一条记录
     * @param video
     * @return
     */
    @Update("update video set title = #{title},summary = #{summary},view_num =#{viewNum}," +
            "create_time=#{createTime} where id = #{id}")
    int updateVideoById(Video video);


    /**
     * 根据 id 删除一条记录
     * @param id
     * @return
     */
    @Delete("delete from video where id = #{id}")
    int deleteVideoById(int id);

    /**
     * 保存一条数据，并得到返回的唯一id
     * @param video
     * @return
     */
    @Insert("INSERT INTO " +
            "`video`(`title`, `summary`, `cover_img`, `view_num`, `price`, `create_time`, `online`, `point`) " +
            "VALUES (#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price}, #{createTime}, #{online}, #{point});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int saveVideo(Video video);

}
