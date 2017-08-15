package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/15 0015 14:23
 * @content
 */
public class OrderDetailRequest implements Serializable {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
