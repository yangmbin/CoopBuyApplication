package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 16:42
 * @content
 */
public class NewUserGoodsOrderresponse implements Serializable {

    /**
     * orderId : 1708076959882946
     * payAmount : 596
     * goodsQuantity : 4
     * isSiteMasterPayApply : false
     * orderType : 1
     * isSiteOrder : false
     */

    private String orderId;
    private int payAmount;
    private int goodsQuantity;
    private boolean isSiteMasterPayApply;
    private int orderType;
    private boolean isSiteOrder;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public boolean isIsSiteMasterPayApply() {
        return isSiteMasterPayApply;
    }

    public void setIsSiteMasterPayApply(boolean isSiteMasterPayApply) {
        this.isSiteMasterPayApply = isSiteMasterPayApply;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public boolean isIsSiteOrder() {
        return isSiteOrder;
    }

    public void setIsSiteOrder(boolean isSiteOrder) {
        this.isSiteOrder = isSiteOrder;
    }
}
