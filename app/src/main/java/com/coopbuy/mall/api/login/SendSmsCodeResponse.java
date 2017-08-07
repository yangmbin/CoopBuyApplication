package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/3 0003 9:27
 * @content
 */
public class SendSmsCodeResponse implements Serializable {

    /**
     * sendKey : c0476f9569164c96ada7e492b453e6f1
     * expireTime : 2017-08-03 09:31:37
     * sendTime : 2017-08-03 09:26:37
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
