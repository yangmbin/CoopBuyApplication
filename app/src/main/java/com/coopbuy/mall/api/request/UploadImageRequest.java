package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/24 20:05
 */
public class UploadImageRequest implements Serializable {

    /**
     * type : 0
     * image :
     */

    private int type;
    private String image;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
