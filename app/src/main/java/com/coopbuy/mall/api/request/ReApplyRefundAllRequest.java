package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 15:39
 */
public class ReApplyRefundAllRequest implements Serializable {

    /**
     * applyNo : string
     * isNeedReturnGoods : true
     * reason : string
     * explain : string
     * voucherImageUrls : ["string"]
     * orderId : string
     */

    private String applyNo;
    private boolean isNeedReturnGoods;
    private String reason;
    private String explain;
    private String orderId;
    private List<String> voucherImageUrls;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
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

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<String> getVoucherImageUrls() {
        return voucherImageUrls;
    }

    public void setVoucherImageUrls(List<String> voucherImageUrls) {
        this.voucherImageUrls = voucherImageUrls;
    }
}
