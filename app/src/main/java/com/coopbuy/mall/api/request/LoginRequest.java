package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/13 0013 14:13
 * @content
 */
public class LoginRequest implements Serializable {

    /**
     * userName : string
     * password : string
     * verificationCode : string
     */

    private String userName;
    private String password;
    private String verificationCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
