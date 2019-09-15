package com.zwgangel.www.utils;

import com.zwgangel.www.domain.User;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @Title: JwtUtilsTest
 * @Package: com.zwgangel.www.utils.JwtUtilsTest
 * @Description:  测试 jwt 生成 token 或解析 token 方法
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-15 18:19
 */
public class JwtUtilsTest {

    /**
     * 功能描述 ： 测试使用JWT 生成 token
     */
    @Test
    public void generateJsonWebTokenTest(){
        User user = new User();
        user.setId(999);
        user.setHeadImg("www.zwgangel.com");
        user.setName("周伟国");
        String token = JwtUtils.generateJsonWebToken(user);
        System.out.println("生成的 JWT 的 token : " +  token);
    }

    /**
     * 功能描述 ： 对生成 token 字符串进行解析，得到body中的User对象的信息
     */
    @Test
    public void decryptJsonWebTokenest(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6d2dhbmdlbCIsImlkIjo5OTksIm5hbWUiOiLlkajkvJ_lm70iLCJpbWciOiJ3d3cuendnYW5nZWwuY29tIiwiaWF0IjoxNTY4NTQzNTI1LCJleHAiOjE1NjkxNDgzMjV9.sxUxs-ke1rhgOST5fP1p6jSda3wHDiidT8JPGvmobTY";
        Claims claims = JwtUtils.decryptJsonWebToken(token);
        if(claims !=null){
            int id = (Integer) claims.get("id");
            String img = (String) claims.get("img");
            String name = (String) claims.get("name");

            System.out.println("id = " + id);
            System.out.println("img = " + img);
            System.out.println("name = " + name);
        } else {
            System.out.println("非法 token .");
        }

    }


}
