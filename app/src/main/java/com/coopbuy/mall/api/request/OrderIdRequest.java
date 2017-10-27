package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/10/27 10:27
 */
public class OrderIdRequest implements Serializable {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
