package org.youyuan.jwt.utils.common.response;

import lombok.Data;

import java.util.ArrayList;

/**
 * @Describe: #请描述当前类的功能#
 * @Author: youjiancheng
 * @Date: 2021/2/2 15:26
 */
@Data
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response(ResponseCode responseCode,T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    public Response(int code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Response(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
//        this.data = (T) new EmptyResult();
    }


    public Response(int code, String message) {
        this.code = code;
        this.message = message;
//        this.data = (T) new EmptyResult();
    }

    public class EmptyResult<T> {

    }



}
