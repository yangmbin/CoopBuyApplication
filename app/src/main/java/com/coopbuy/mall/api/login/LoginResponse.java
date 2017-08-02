package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/1 0001 14:16
 * @content
 */
public class LoginResponse implements Serializable {

    /**
     * isLoginSuccess : true
     * error : null
     * msg : null
     */

    private boolean isLoginSuccess;
    private Object error;
    private Object msg;

    public boolean isIsLoginSuccess() {
        return isLoginSuccess;
    }

    public void setIsLoginSuccess(boolean isLoginSuccess) {
        this.isLoginSuccess = isLoginSuccess;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "isLoginSuccess=" + isLoginSuccess +
                ", error=" + error +
                ", msg=" + msg +
                '}';
    }
}
