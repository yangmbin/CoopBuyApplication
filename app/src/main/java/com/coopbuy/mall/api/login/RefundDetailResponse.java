package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 14:10
 * @content
 */
public class RefundDetailResponse implements Serializable{
    /**
     * id : string
     * orderId : string
     * skuId : 0
     * userName : string
     * userPhone : string
     * finishTime : 2017-08-11T00:47:08.625Z
     * finishRemark : string
     * isReceiptOfGoods : true
     * isNeedReturnGoods : true
     * reason : string
     * amount : 0
     * explain : string
     * voucherImageUrls : ["string"]
     * applyTime : 2017-08-11T00:47:08.625Z
     * applyStatus : 0
     * applyStatusName : string
     * auditRemark : string
     * auditTime : 2017-08-11T00:47:08.625Z
     * isApplyPlatform : true
     * returnGoods : {"postCode":"string","address":"string","explain":"string","voucherImageUrls":["string"],"logisticsName":"string","logisticsCode":"string","waybillNo":"string","returnGoodsTime":"2017-08-11T00:47:08.625Z"}
     */

    private String id;
    private String orderId;
    private int skuId;
    private String userName;
    private String userPhone;
    private String finishTime;
    private String finishRemark;
    private boolean isReceiptOfGoods;
    private boolean isNeedReturnGoods;
    private String reason;
    private int amount;
    private String explain;
    private String applyTime;
    private int applyStatus;
    private String applyStatusName;
    private String auditRemark;
    private String auditTime;
    private boolean isApplyPlatform;
    private ReturnGoodsBean returnGoods;
    private List<String> voucherImageUrls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getFinishRemark() {
        return finishRemark;
    }

    public void setFinishRemark(String finishRemark) {
        this.finishRemark = finishRemark;
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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyStatusName() {
        return applyStatusName;
    }

    public void setApplyStatusName(String applyStatusName) {
        this.applyStatusName = applyStatusName;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public boolean isIsApplyPlatform() {
        return isApplyPlatform;
    }

    public void setIsApplyPlatform(boolean isApplyPlatform) {
        this.isApplyPlatform = isApplyPlatform;
    }

    public ReturnGoodsBean getReturnGoods() {
        return returnGoods;
    }

    public void setReturnGoods(ReturnGoodsBean returnGoods) {
        this.returnGoods = returnGoods;
    }

    public List<String> getVoucherImageUrls() {
        return voucherImageUrls;
    }

    public void setVoucherImageUrls(List<String> voucherImageUrls) {
        this.voucherImageUrls = voucherImageUrls;
    }

    public static class ReturnGoodsBean {
        /**
         * postCode : string
         * address : string
         * explain : string
         * voucherImageUrls : ["string"]
         * logisticsName : string
         * logisticsCode : string
         * waybillNo : string
         * returnGoodsTime : 2017-08-11T00:47:08.625Z
         */

        private String postCode;
        private String address;
        private String explain;
        private String logisticsName;
        private String logisticsCode;
        private String waybillNo;
        private String returnGoodsTime;
        private List<String> voucherImageUrls;

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public String getLogisticsName() {
            return logisticsName;
        }

        public void setLogisticsName(String logisticsName) {
            this.logisticsName = logisticsName;
        }

        public String getLogisticsCode() {
            return logisticsCode;
        }

        public void setLogisticsCode(String logisticsCode) {
            this.logisticsCode = logisticsCode;
        }

        public String getWaybillNo() {
            return waybillNo;
        }

        public void setWaybillNo(String waybillNo) {
            this.waybillNo = waybillNo;
        }

        public String getReturnGoodsTime() {
            return returnGoodsTime;
        }

        public void setReturnGoodsTime(String returnGoodsTime) {
            this.returnGoodsTime = returnGoodsTime;
        }

        public List<String> getVoucherImageUrls() {
            return voucherImageUrls;
        }

        public void setVoucherImageUrls(List<String> voucherImageUrls) {
            this.voucherImageUrls = voucherImageUrls;
        }
    }
}
