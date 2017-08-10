package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 9:58
 * @content
 */
public class PayApplyAndChannelRequest implements Serializable {

    /**
     * orderId : 1708074920513052
     * channelId : AliPay.APP
     */

    private String orderId;
    private String channelId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
