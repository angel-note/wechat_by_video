package com.zwgangel.www.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户表
 */
@Setter
@Getter
@ToString
public class User implements Serializable {

  private Integer id;
  private String openid;
  private String name;
  private String headImg;
  private String phone;
  private String sign;
  private Integer sex;
  private String city;
  private java.util.Date createTime;

}
