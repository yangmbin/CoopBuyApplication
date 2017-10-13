package com.coopbuy.mall.api.login.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/13 0013 14:14
 * @content
 */
public class LoginResponse implements Serializable {

    /**
     * success : false
     * message : 用户名或密码错误
     * needVerificationCode : false
     */

    private boolean success;
    private String message;
    private boolean needVerificationCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isNeedVerificationCode() {
        return needVerificationCode;
    }

    public void setNeedVerificationCode(boolean needVerificationCode) {
        this.needVerificationCode = needVerificationCode;
    }
}
