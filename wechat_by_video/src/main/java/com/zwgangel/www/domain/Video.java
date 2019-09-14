package com.zwgangel.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 视频表
 */
@Setter
@Getter
@ToString
public class Video implements Serializable {

  private Integer id;
  private String title;
  private String summary;
  private String coverImg;
  private Integer viewNum;
  private Integer price;
  private java.util.Date createTime;
  private Integer online;
  private double point;

}
