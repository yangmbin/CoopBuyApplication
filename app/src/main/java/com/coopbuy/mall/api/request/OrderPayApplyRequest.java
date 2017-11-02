package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/28 0028 18:33
 * @content
 */
public class OrderPayApplyRequest implements Serializable {
    /**
     * channelId : string
     * orderId : string
     * bankCradPayId : string
     */

    private String channelId;
    private String orderId;
    private String bankCradPayId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBankCradPayId() {
        return bankCradPayId;
    }

    public void setBankCradPayId(String bankCradPayId) {
        this.bankCradPayId = bankCradPayId;
    }
}
