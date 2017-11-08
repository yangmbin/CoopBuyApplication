package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class UploadImageResponse implements Serializable {
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
