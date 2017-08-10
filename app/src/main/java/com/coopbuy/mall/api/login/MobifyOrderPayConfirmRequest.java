package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 10:09
 * @content
 */
public class MobifyOrderPayConfirmRequest implements Serializable {

    /**
     * orderId : 1708074920513052
     */

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
