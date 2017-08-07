package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/4 0004 10:34
 * @content
 */
public class SmsResetPasswordGetCodeResponse implements Serializable {


    /**
     * sendKey : cf73e8d535d546a2a45a32740d3a973c
     * expireTime : 2017-08-04 10:37:24
     * sendTime : 2017-08-04 10:32:24
     */

    private String sendKey;
    private String expireTime;
    private String sendTime;

    public String getSendKey() {
        return sendKey;
    }

    public void setSendKey(String sendKey) {
        this.sendKey = sendKey;
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
