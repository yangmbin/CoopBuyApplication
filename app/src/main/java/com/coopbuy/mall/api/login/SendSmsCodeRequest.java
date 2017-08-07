package com.coopbuy.mall.api.login;

import com.guinong.net.verify.NotNull;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/3 0003 9:27
 * @content
 */
public class SendSmsCodeRequest implements Serializable {

    /**
     * mobilePhone : 13560478012
     * token : string
     * key : 1
     * imageCheckCode : 2mgd
     */
    @NotNull(friendlyName = "号码不能为空")
    private String mobilePhone;
    //token不用传
    private String token;
    //key为图形验证码的key
    @NotNull(friendlyName = "key不能为空")
    private String key;
    @NotNull(friendlyName = "验证码不能为空")
    private String imageCheckCode;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getToken() {
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
