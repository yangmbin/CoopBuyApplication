package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/16 0016 15:22
 * @content
 */
public class RegisterRequest implements Serializable {

    /**
     * phone : string
     * password : string
     * code : string
     * verificationCode : string
     */

    private String phone;
    private String password;
    private String code;
    private String verificationCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
