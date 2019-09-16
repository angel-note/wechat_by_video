package com.zwgangel.www.service.impl;

import com.zwgangel.www.config.WeChatConfig;
import com.zwgangel.www.domain.User;
import com.zwgangel.www.service.UserService;
import com.zwgangel.www.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Title: UserServiceImpl
 * @Package: com.zwgangel.www.service.impl.UserServiceImpl
 * @Description:
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-16 20:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WeChatConfig weChatConfig;

    /**
     * 功能描述 ： 传入微信公众平台返回的 code.然后根据code获得 access_token .
     * @param code ：传入微信公众平台返回的 code
     * @return
     */
    @Override
    public User saveWeChatUser(String code) {
        String accessTokenUrl = String.format(WeChatConfig.getOpenAccessTokenUrl(),weChatConfig.getOpenAppid(),weChatConfig.getOpenAppsecret(),code);   // 通过 code 来获取 access_token.
        // 通过 code 获得access_token 和返回 openId
        Map<String,Object> baseMap = HttpUtils.doGet(accessTokenUrl);
        if(baseMap == null || baseMap.isEmpty()){   // 如果没有数据，则返回空
            return null;
        }
        String accessToken = (String)  baseMap.get("access_token");
        String openId = (String)  baseMap.get("openid");

        //  通过access_token 获取微信用户基本信息
        String userInfoUrl = String.format(WeChatConfig.getOpenUserInfoUrl(),accessToken,openId);
        Map<String,Object> baseUserMap = HttpUtils.doGet(userInfoUrl);
        if(baseUserMap == null || baseUserMap.isEmpty()){   // 如果没有数据，则返回空
            return null;
        }
        String nickname = (String)  baseMap.get("nickname");
        String sex = (String)  baseMap.get("sex");
        String province = (String)  baseMap.get("province");
        String city = (String)  baseMap.get("city");
        String country = (String)  baseMap.get("country");
        String headimgurl = (String)  baseMap.get("headimgurl");


        return null;
    }
}
