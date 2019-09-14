package com.zwgangel.www.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 章节实体类：章节表
 */
@Setter
@Getter
@ToString
public class Chapter implements Serializable {

  private Integer id;
  private Integer videoId;
  private String title;
  private Integer ordered;
  private java.util.Date createTime;

}
