package com.zwgangel.www.service.impl;

import com.zwgangel.www.config.WeChatConfig;
import com.zwgangel.www.domain.User;
import com.zwgangel.www.mapper.UserMapper;
import com.zwgangel.www.service.UserService;
import com.zwgangel.www.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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

    @Autowired
    private UserMapper userMapper;

    /**
     * 功能描述 ： 传入微信公众平台返回的 code.然后根据code获得 access_token .
     * @param code ：传入微信公众平台返回的 code
     * @return
     */
    @Override
    public User saveWeChatUser(String code){
        String accessTokenUrl = String.format(WeChatConfig.getOpenAccessTokenUrl(),weChatConfig.getOpenAppid(),weChatConfig.getOpenAppsecret(),code);   // 通过 code 来获取 access_token.
        // 通过 code 获得access_token 和返回 openId
        Map<String,Object> baseMap = HttpUtils.doGet(accessTokenUrl);
        if(baseMap == null || baseMap.isEmpty()){   // 如果没有数据，则返回空
            return null;
        }
        String accessToken = (String)  baseMap.get("access_token");
        String openId = (String)  baseMap.get("openid");

        // 如果User表中已经存在openid，说明该用户已经登录过。我们不需要进再次请求微信，可以直接返回用户的对象
        User dbUser = userMapper.findUserByOpenId(openId);
        if (dbUser != null)
        {
            return dbUser;      // 直接返回用户信息到前台
        }

        //  通过access_token 获取微信用户基本信息
        String userInfoUrl = String.format(WeChatConfig.getOpenUserInfoUrl(),accessToken,openId);
        Map<String,Object> baseUserMap = HttpUtils.doGet(userInfoUrl);
        if(baseUserMap == null || baseUserMap.isEmpty()){   // 如果没有数据，则返回空
            return null;
        }
        String nickname = (String)baseUserMap.get("nickname");
        Double sexTemp = (Double)baseUserMap.get("sex");
        int sex = sexTemp.intValue();       // 把1.0转换成1;把double转换成int类型
        String province = (String)baseUserMap.get("province");
        String city = (String)baseUserMap.get("city");
        String country = (String)baseUserMap.get("country");
        String headimgurl = (String)baseUserMap.get("headimgurl");
        try {
            if(nickname !=null){
                nickname = new String(nickname.getBytes("ISO-8859-1"), "UTF-8");// 把中文乱码进行编码
            }
            if(province !=null){
                province = new String(province.getBytes("ISO-8859-1"), "UTF-8");// 把中文乱码进行编码
            }
            if(city !=null){
                city = new String(city.getBytes("ISO-8859-1"), "UTF-8");// 把中文乱码进行编码
            }
            if(country !=null){
                country = new String(country.getBytes("ISO-8859-1"), "UTF-8");// 把中文乱码进行编码
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 封装用户信息
        User user = new User();
        user.setName(nickname);
        user.setHeadImg(headimgurl);
        StringBuilder stringBuilder = new StringBuilder(country).append("||").append(province).append("||").append(city);
        // 中国||上海||闵行   方便以后分割
        String finalAddress = stringBuilder.toString();
        user.setCity(finalAddress);
        user.setOpenid(openId);
        user.setSex(sex);
        user.setCreateTime(new Date());
        //  如果数据库没查到，则会向微信请求数据，然后进行保存用户基本数据
        userMapper.saveUser(user);
        int id = user.getId();
        System.out.println("用户信息保存后的自增id = "+ id);



        return user;
    }
}
