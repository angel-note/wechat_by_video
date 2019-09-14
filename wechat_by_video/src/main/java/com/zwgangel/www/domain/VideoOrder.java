package com.zwgangel.www.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 订单表
 */
@Setter
@Getter
@ToString
public class VideoOrder implements Serializable {

  private Integer id;
  private String openid;
  private String outTradeNo;
  private Integer state;
  private java.util.Date createTime;
  private java.util.Date notifyTime;
  private Integer totalFee;
  private String nickname;
  private String headImg;
  private Integer videoId;
  private String videoTitle;
  private String videoImg;
  private Integer userId;
  private String ip;
  private Integer del;


}
