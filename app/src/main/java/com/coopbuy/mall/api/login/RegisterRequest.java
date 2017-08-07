package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/3 0003 9:33
 * @content
 */
public class RegisterRequest implements Serializable {

    /**
     * mobilePhone (string, optional): 手机号 ,
     * email (string, optional): 注册邮箱 ,
     * checkCode (string, optional): 验证码 ,
     * loginPassword (string, optional): 登陆密码 ,
     * sendKey (string): 发送Key ,
     * userName (string, optional): 用户名
     */

    private String mobilePhone;
    private String email;
    private String checkCode;
    private String loginPassword;
    private String sendKey;
    private String userName;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getSendKey() {
        return sendKey;
    }

    public void setSendKey(String sendKey) {
        this.sendKey = sendKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
