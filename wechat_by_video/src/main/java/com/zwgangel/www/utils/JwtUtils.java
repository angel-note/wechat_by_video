package com.zwgangel.www.utils;

import com.zwgangel.www.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Title: JwtUtils
 * @Package: com.zwgangel.www.utils.JwtUtils
 * @Description:  JWT 生成  Token 工具类 (用于校验登录的信息)
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-15 17:42
 */
public class JwtUtils {

    public static final String SUBJECT = "zwgangel";            // 定义一个发行者，就是作者

    // 定义一个过期时间(这里是一周)，时间：毫秒 (1000毫秒 * 60秒 * 60 分 * 24小时 * 7天) 1000毫秒 = 1 秒
    public static final long EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;

    public static final String APP_SECRET  = "zwgangel";       // 这是一个密钥，用于加密用的。(后期需要MD5进行加密一下再得到)


    public static String generateJsonWebToken(User user){

        // 先判断用户的一些信息是否还存在，如果不存在则直接返回一个null.(说明用户没有登录或者有人伪造数据)
        if (user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null){
            return null;
        }else{      // 生成 token
            String token = Jwts.builder().setSubject(SUBJECT)       // 设置签名
                    .claim("id",user.getId())               // 填入基本信息
                    .claim("name",user.getName())           // 填入基本信息
                    .claim("img",user.getHeadImg())         // 填入基本信息
                    .setIssuedAt(new Date())                    // 设置发行时间
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))              // 设置过期时间
                    .signWith(SignatureAlgorithm.HS256,APP_SECRET)  // 签名方法，使用密钥
                    .compact();     // 把上面生成的token，进行压缩，得到一个小串的字符串

            return token;
        }
    }


    /**
     * 功能描述 ： 校验并解密 token
     * @param token
     * @return
     */
    public static Claims decryptJsonWebToken(String token){
        try {
            if(token != null){
                final Claims claims = Jwts.parser()     // 分析器
                        .setSigningKey(APP_SECRET)      // 传入密钥进行解析
                        .parseClaimsJws(token)          // 把token传入进行解析
                        .getBody();         // 它是由header + body + signature 组成，我们只拿用户的基本信息
                return claims;
            }else{
                return null;
            }
        }catch (Exception e){
            // 如果提供的 token 无法解析，则会抛出异常，所以这里需要捕获异常
        }
        return null;

    }
}
