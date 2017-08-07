package com.guinong.net;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/7/25 0025 18:00
 * @content
 */
public class NetworkErrorInfo implements Serializable {

    private int code;
    private String message;
    //这里下行是details 不是idetail 所以拿不到同时错误
    private String details;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return details;
    }

    public void setDetail(String detail) {
        this.details = detail;
    }
}
