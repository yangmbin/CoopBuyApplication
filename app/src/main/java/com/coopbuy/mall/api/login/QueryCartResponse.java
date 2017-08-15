package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 13:41
 * @content
 */
public class QueryCartResponse implements Serializable {

    /**
     * isValid : true
     * telecomCarrier : string
     * message : string
     */

    private boolean isValid;
    private String telecomCarrier;
    private String message;

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getTelecomCarrier() {
        return telecomCarrier;
    }

    public void setTelecomCarrier(String telecomCarrier) {
        this.telecomCarrier = telecomCarrier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
