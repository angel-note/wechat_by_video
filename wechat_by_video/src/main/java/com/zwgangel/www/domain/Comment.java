package com.zwgangel.www.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 评论实体类：评论表
 */
@Setter
@Getter
@ToString
public class Comment implements Serializable {

  private Integer id;
  private String content;
  private Integer userId;
  private String headImg;
  private String name;
  private double point;
  private Integer up;
  private java.util.Date createTime;
  private Integer orderId;
  private Integer videoId;

}
