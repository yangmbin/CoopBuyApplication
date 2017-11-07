package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/10/31 17:25
 */
public class BeforeApplyRefundRequest implements Serializable {

    /**
     * skuId : 0
     * orderId : string
     */

    private int skuId;
    private String orderId;
    private String applyNo;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }
}
