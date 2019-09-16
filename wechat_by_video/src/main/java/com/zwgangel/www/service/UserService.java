package com.zwgangel.www.service;

import com.zwgangel.www.domain.User;

/**
 * @Title: UserService
 * @Package: com.zwgangel.www.service.UserService
 * @Description:  用户业务接口类
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-16 20:21
 */
public interface UserService {

    /**
     * 功能描述 ：传入微信公众平台返回的 code.然后根据code获得 access_token .
     *  根据 token 进行获取用户的基本信息，从而保存到数据库中
     * @param code ：传入微信公众平台返回的 code
     * @return ： 获得用户的基本信息并保存
     */
    User saveWeChatUser(String code);
}
