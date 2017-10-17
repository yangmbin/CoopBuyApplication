package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/17 0017 9:45
 * @content
 */
public class ChangeAndForgetPwdResponse implements Serializable {

    /**
     * succeeded : true
     * message : string
     */

    private boolean succeeded;
    private String message;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
