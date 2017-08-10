package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 10:10
 * @content
 */
public class MobifyOrderPayConfirmResponse implements Serializable {

    /**
     * payAmount : 10
     * goodsQuantity : 1
     * isSiteMasterPayApply : false
     * orderType : 2
     * isSiteOrder : false
     */

    private int payAmount;
    private int goodsQuantity;
    private boolean isSiteMasterPayApply;
    private int orderType;
    private boolean isSiteOrder;

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
