package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/3 0003 9:01
 * @content
 */
public class ImageCodeResponse implements Serializable {
    private String imageArray;

    public String getImageArray() {
        return imageArray;
    }

    public void setImageArray(String imageArray) {
        this.imageArray = imageArray;
    }
}
