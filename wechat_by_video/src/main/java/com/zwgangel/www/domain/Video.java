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
  private String title; // 视频标题
  private String summary;  // 概述
  private String coverImg;  // 封面图
  private Integer viewNum;  // 观看数
  private Integer price;  // 价格，分
  private java.util.Date createTime;  // 创建时间
  private Integer online; // 上线状态
  private Double point; // 评分

}
