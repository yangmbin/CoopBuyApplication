package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/4 0004 10:34
 * @content 忘记密码 请求短信
 */
public class SmsResetPasswordRequest implements Serializable {


    /**
     * sendKey : 8fa5c7adb0794bb997ae9ff8ef8d82bb
     * newPassword : q
     * checkCode : 47332
     * mobilePhone : 18286882993
     */

    private String sendKey;
    private String newPassword;
    private String checkCode;
    private String mobilePhone;

    public String getSendKey() {
        return sendKey;
    }

    public void setSendKey(String sendKey) {
        this.sendKey = sendKey;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
