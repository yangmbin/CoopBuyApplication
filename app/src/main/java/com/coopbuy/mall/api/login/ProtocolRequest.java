package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 13:38
 * @content
 */
public class ProtocolRequest implements Serializable{

    /**
     * payId : string
     * smsCheckCode : string
     */

    private String payId;
    private String smsCheckCode;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getSmsCheckCode() {
        return smsCheckCode;
    }

    public void setSmsCheckCode(String smsCheckCode) {
        this.smsCheckCode = smsCheckCode;
    }
}
