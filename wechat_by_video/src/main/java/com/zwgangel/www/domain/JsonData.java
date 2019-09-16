package com.zwgangel.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Title: JsonData
 * @Package: com.angel.cn.utils.JsonData
 * @Description:    响应结果类(统一规范接口协议)
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-12 10:52
 */
@Setter
@Getter
@ToString
public class JsonData implements Serializable {

    private Integer code;       // 状态码： 0 表示成功，1 表示处理中， -1 表示失败
    private Object data;        // 封装的数据
    private String message;     // 返回的信息描述

    public JsonData() {
    }

    public JsonData(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    // 执行成功后，不传入数据
    public static JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }
    // 执行成功后，传入数据
    public static JsonData buildSuccess(Object data){
        return new JsonData(0,data,null);
    }
    // 执行成功后，传入状态码和返回的信息
    public static JsonData buildSuccess(Integer code,String message){
        return new JsonData(code,null,message);
    }
    // 执行成功后，传入状态码和数据
    public static JsonData buildSuccess(Integer code,Object data){
        return new JsonData(code,data,null);
    }


    // 执行失败后，传入返回的信息描述
    public static JsonData buildError(String message){
        return new JsonData(-1,null,message);
    }
    // 执行失败后，传入状态码和返回的信息描述
    public static JsonData buildError(Integer code, String message){
        return new JsonData(code,null,message);
    }

}
