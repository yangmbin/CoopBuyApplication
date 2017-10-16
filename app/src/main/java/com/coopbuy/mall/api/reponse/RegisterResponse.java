package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/16 0016 15:38
 * @content
 */
public enum RegisterResponse implements Serializable {
    ;

    /**
     * isRegistered : true
     * message : string
     */

    private boolean isRegistered;
    private String message;

    public boolean isIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
