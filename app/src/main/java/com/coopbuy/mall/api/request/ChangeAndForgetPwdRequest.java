package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/17 0017 9:44
 * @content
 */
public class ChangeAndForgetPwdRequest implements Serializable {

    /**
     * phone : string
     * newPassword : string
     * code : string
     * verificationCode : string
     */

    private String phone;
    private String newPassword;
    private String code;
    private String verificationCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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
