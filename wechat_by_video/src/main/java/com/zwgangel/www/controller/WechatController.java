package com.zwgangel.www.controller;

import com.zwgangel.www.config.WeChatConfig;
import com.zwgangel.www.domain.JsonData;
import com.zwgangel.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Title: WechatController
 * @Package: com.zwgangel.www.controller.WechatController
 * @Description:
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-16 09:10
 */
@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private UserService  userService;

    /**
     * 功能描述 ： 拼装微信扫一扫登录的rul
     *  @ResponseBody : 如果上面是以@Controller进行请求的，如果是返回页面，则不需要加 @ResponseBody
     *  如果要返回数据，则加 @ResponseBody
     * @param accessPage    指的是扫描成功后需要返回的页面(一开始是从哪个页面进行点击登录，就得返回原页面)
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true)String accessPage) throws UnsupportedEncodingException{
        String redirectUrl = weChatConfig.getOpenRedirectUrl();     // 获取开放平台重定向地址
        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");      // 进行编码
        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppid(),callbackUrl,accessPage); // 对配置中的%s进行字符格式化
        return JsonData.buildSuccess(qrcodeUrl);

    }


    /**
     * 功能描述 ： 通过用户扫码确认后，微信平台会返回一个code，并回调这个方法的逻辑
     *      需要通过 code 来向微信公众平台获取 access_token
     * @param code      微信平台返回的 code
     * @param state     请求时带过去的页面请求路径
     * @param response  页面需要重定向
     */
    @GetMapping("/user/callback")
    public  void wechatUserCallback(@RequestParam(value = "code",required = true) String code, String  state, HttpServletResponse response){
        System.out.println("返回的 code  : "+ code);
        System.out.println("返回的 state "  + state);
        userService.saveWeChatUser(code);


    }
}
