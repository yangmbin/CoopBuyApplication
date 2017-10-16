package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/16 0016 9:56
 * @content
 */
public class ImageCodeRequest implements Serializable {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
