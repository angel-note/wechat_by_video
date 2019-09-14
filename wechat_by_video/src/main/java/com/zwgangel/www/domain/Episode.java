package com.zwgangel.www.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 集实体类：每章的小节表
 */
@Setter
@Getter
@ToString
public class Episode implements Serializable {

  private Integer id;
  private String title;
  private Integer num;
  private String duration;
  private String coverImg;
  private Integer videoId;
  private String summary;
  private java.util.Date createTime;
  private Integer chapterId;

}
