package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/16 0016 15:19
 * @content
 */
public class SMSCodeReponse implements Serializable {

    /**
     * code : a0bb46ce800748f7a5ffff5f8fe87d41
     * expireTime : 2017-10-16 15:21:16
     * sendTime : 2017-10-16 15:16:16
     */

    private String code;
    private String expireTime;
    private String sendTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
