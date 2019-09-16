package com.zwgangel.www.controller;

import com.zwgangel.www.config.WeChatConfig;
import com.zwgangel.www.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
