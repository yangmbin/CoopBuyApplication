package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/4 0004 10:34
 * @content 忘记密码 请求短信
 */
public class SmsResetPasswordGetCodeRequest implements Serializable {

    /**
     * mobilePhone : 18286882993
     * token : null
     * key : 1501813917247
     * imageCheckCode : s6nc
     */

    private String mobilePhone;
    private String token;
    private String key;
    private String imageCheckCode;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageCheckCode() {
        return imageCheckCode;
    }

    public void setImageCheckCode(String imageCheckCode) {
        this.imageCheckCode = imageCheckCode;
    }
}
