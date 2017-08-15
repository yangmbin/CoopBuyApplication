package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 14:04
 * @content
 */
public class NewApplyRequest  implements Serializable{

    /**
     * orderId : string
     * skuId : 0
     * isReceiptOfGoods : true
     * isNeedReturnGoods : true
     * reason : string
     * amount : 0
     * explain : string
     * voucherImageUrls : ["string"]
     */

    private String orderId;
    private int skuId;
    private boolean isReceiptOfGoods;
    private boolean isNeedReturnGoods;
    private String reason;
    private int amount;
    private String explain;
    private List<String> voucherImageUrls;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public boolean isIsReceiptOfGoods() {
        return isReceiptOfGoods;
    }

    public void setIsReceiptOfGoods(boolean isReceiptOfGoods) {
        this.isReceiptOfGoods = isReceiptOfGoods;
    }

    public boolean isIsNeedReturnGoods() {
        return isNeedReturnGoods;
    }

    public void setIsNeedReturnGoods(boolean isNeedReturnGoods) {
        this.isNeedReturnGoods = isNeedReturnGoods;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public List<String> getVoucherImageUrls() {
        return voucherImageUrls;
    }

    public void setVoucherImageUrls(List<String> voucherImageUrls) {
        this.voucherImageUrls = voucherImageUrls;
    }
}
