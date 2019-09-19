package com.zwgangel.www.intercepter;

import com.google.gson.Gson;
import com.zwgangel.www.domain.JsonData;
import com.zwgangel.www.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Title: LoginIntercepter
 * @Package: com.zwgangel.www.intercepter.LoginIntercepter
 * @Description: 定义一个登录功能的拦截器
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-20 00:48
 */
public class LoginIntercepter implements HandlerInterceptor {

    private static final Gson gson = new Gson();

    /**
     * 功能描述：进入Controller请求之前进行拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 得到token.一般token会放入到header中，如果没有，也会放到参数当中。
        // StringUtils.isEmpty(token) 等同于   token == null
        String token = request.getHeader("token");
        if(token == null){  // 尝试从参数中获取
            token = request.getParameter("token");
        }

        if (token  !=null){
            // 2. 如果不为空，则需要进行解密
            Claims claims = JwtUtils.decryptJsonWebToken(token);
            if (claims != null){
                // 3.  获取需要的值
                Integer userId = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                // 4. 放入到request中，以便后面的参数获取
                request.setAttribute("user_id",userId);
                request.setAttribute("name",name);
                return true;
            }
        }
        // 5. 如果没有token，则需要给出信息提示
        sendJsonMessage(response, JsonData.buildError("请登录"));
        return false;
    }


    /**
     * 功能描述：响应数据给前端的公共方法
     * @param response
     * @param object
     */
    public static void sendJsonMessage(HttpServletResponse response, Object object){
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.println(gson.toJson(object));    // 把数据封装成一个json
            writer.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
