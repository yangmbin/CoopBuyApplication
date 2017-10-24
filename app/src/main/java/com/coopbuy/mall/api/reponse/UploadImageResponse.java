package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class UploadImageResponse implements Serializable {

    /**
     * success : true
     * message : string
     * filePath : string
     */

    private boolean success;
    private String message;
    private String filePath;

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
