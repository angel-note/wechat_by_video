package com.zwgangel.www.provider;

import com.zwgangel.www.domain.Video;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Title: VideoProvider
 * @Package: com.zwgangel.www.provider.VideoProvider
 * @Description: video 构建动态SQL语句操作
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-15 14:37
 */
public class VideoProvider {

    /**
     * 功能描述：根据 id 动态更新SQL语句
     * @param video
     * @return
     */
    public String updateVideoById(final Video video){
        return new SQL(){{
            UPDATE("video");

            // 表中字段的拼接，条件写法
             if(video.getTitle()!= null){           // 视频标题
                 SET("title=#{title}");
             }
             if(video.getSummary()!= null){         // 概述
                 SET("summary=#{summary}");
             }
            if(video.getCoverImg()!= null){         // 封面图
                SET("cover_img=#{coverImg}");
            }
            if(video.getViewNum()!= null){          // 观看数
                SET("view_num=#{viewNum}");
            }
            if(video.getPrice()!= null){            // 价格，分
                SET("price=#{price}");
            }
            if(video.getCreateTime()!= null){       // 创建时间
                SET("create_time=#{createTime}");
            }
            if(video.getOnline()!= null){           // 上线状态
                SET("online=#{online}");
            }
            if(video.getPoint()!= null){            // 评分
                SET("point=#{point}");
            }
             WHERE("id=#{id}");
        }}.toString();
    }

}
