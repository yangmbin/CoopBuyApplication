package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 10:50
 * @content
 */
public class OrderDetailResponse implements Serializable {

    /**
     * orderId : 1711021054839611
     * shopId : 90
     * shopName : 供销严选
     * shopTel :
     * orderStatus : 1
     * orderType : 2
     * statusName : 待支付
     * totalAmount : 10.0
     * freightAmount : 0.0
     * orderAmount : 10.0
     * remark :
     * createTime : 2017-11-02 16:14:00
     * finishTime :
     * paymentTime :
     * consignerName : 18786712371
     * consignerTel : 18786712371
     * consignerAddress : 18786712371
     * regionId : 520000000000
     * regionName : 贵州省
     * orderItems : [{"canApplyRefund":false,"applyRefundButtonText":"","itemId":19630,"skuId":-100,"productName":"贵州移动话费10元","productImageUrl":"","quantity":1,"unitPrice":10,"commissionRate":0,"specifications":"贵州贵阳移动","properties":"","refundStatus":""}]
     * cargoInfo : {"text":"","time":""}
     * canCancel : true
     * canDelete : false
     * canPayment : true
     * canDelayedReceipt : false
     * canFindExpressInfo : false
     * canReceipt : false
     * canApplyRefund : false
     * applyRefundButtonText :
     * canRemindShipment : false
     * canRepeatSubmitOrder : false
     */

    private String orderId;
    private int shopId;
    private String shopName;
    private String shopTel;
    private int orderStatus;
    private int orderType;
    private String statusName;
    private double totalAmount;
    private double freightAmount;
    private double orderAmount;
    private String remark;
    private String createTime;
    private String finishTime;
    private String paymentTime;
    private String consignerName;
    private String consignerTel;
    private String consignerAddress;
    private long regionId;
    private String regionName;
    private CargoInfoBean cargoInfo;
    private boolean canCancel;
    private boolean canDelete;
    private boolean canPayment;
    private boolean canDelayedReceipt;
    private boolean canFindExpressInfo;
    private boolean canReceipt;
    private boolean canApplyRefund;
    private String applyRefundButtonText;
    private boolean canRemindShipment;
    private boolean canRepeatSubmitOrder;
    private boolean isApplyLieuPay;
    private List<OrderItemsBean> orderItems;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getConsignerName() {
        return consignerName;
    }

    public void setConsignerName(String consignerName) {
        this.consignerName = consignerName;
    }

    public String getConsignerTel() {
        return consignerTel;
    }

    public void setConsignerTel(String consignerTel) {
        this.consignerTel = consignerTel;
    }

    public String getConsignerAddress() {
        return consignerAddress;
    }

    public void setConsignerAddress(String consignerAddress) {
        this.consignerAddress = consignerAddress;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public CargoInfoBean getCargoInfo() {
        return cargoInfo;
    }

    public void setCargoInfo(CargoInfoBean cargoInfo) {
        this.cargoInfo = cargoInfo;
    }

    public boolean isCanCancel() {
        return canCancel;
    }

    public void setCanCancel(boolean canCancel) {
        this.canCancel = canCancel;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public boolean isCanPayment() {
        return canPayment;
    }

    public void setCanPayment(boolean canPayment) {
        this.canPayment = canPayment;
    }

    public boolean isCanDelayedReceipt() {
        return canDelayedReceipt;
    }

    public void setCanDelayedReceipt(boolean canDelayedReceipt) {
        this.canDelayedReceipt = canDelayedReceipt;
    }

    public boolean isCanFindExpressInfo() {
        return canFindExpressInfo;
    }

    public void setCanFindExpressInfo(boolean canFindExpressInfo) {
        this.canFindExpressInfo = canFindExpressInfo;
    }

    public boolean isCanReceipt() {
        return canReceipt;
    }

    public void setCanReceipt(boolean canReceipt) {
        this.canReceipt = canReceipt;
    }

    public boolean isCanApplyRefund() {
        return canApplyRefund;
    }

    public void setCanApplyRefund(boolean canApplyRefund) {
        this.canApplyRefund = canApplyRefund;
    }

    public String getApplyRefundButtonText() {
        return applyRefundButtonText;
    }

    public void setApplyRefundButtonText(String applyRefundButtonText) {
        this.applyRefundButtonText = applyRefundButtonText;
    }

    public boolean isCanRemindShipment() {
        return canRemindShipment;
    }

    public void setCanRemindShipment(boolean canRemindShipment) {
        this.canRemindShipment = canRemindShipment;
    }

    public boolean isCanRepeatSubmitOrder() {
        return canRepeatSubmitOrder;
    }

    public void setCanRepeatSubmitOrder(boolean canRepeatSubmitOrder) {
        this.canRepeatSubmitOrder = canRepeatSubmitOrder;
    }

    public boolean isApplyLieuPay() {
        return isApplyLieuPay;
    }

    public void setApplyLieuPay(boolean applyLieuPay) {
        isApplyLieuPay = applyLieuPay;
    }

    public List<OrderItemsBean> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsBean> orderItems) {
        this.orderItems = orderItems;
    }

    public static class CargoInfoBean {
        /**
         * text :
         * time :
         */

        private String text;
        private String time;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class OrderItemsBean {
        /**
         * canApplyRefund : false
         * applyRefundButtonText :
         * itemId : 19630
         * skuId : -100
         * productName : 贵州移动话费10元
         * productImageUrl :
         * quantity : 1
         * unitPrice : 10.0
         * commissionRate : 0.0
         * specifications : 贵州贵阳移动
         * properties :
         * refundStatus :
         */

        private boolean canApplyRefund;
        private String applyRefundButtonText;
        private int itemId;
        private int skuId;
        private String productName;
        private String productImageUrl;
        private int quantity;
        private double unitPrice;
        private double commissionRate;
        private String specifications;
        private String properties;
        private String refundStatus;

        public boolean isCanApplyRefund() {
            return canApplyRefund;
        }

        public void setCanApplyRefund(boolean canApplyRefund) {
            this.canApplyRefund = canApplyRefund;
        }

        public String getApplyRefundButtonText() {
            return applyRefundButtonText;
        }

        public void setApplyRefundButtonText(String applyRefundButtonText) {
            this.applyRefundButtonText = applyRefundButtonText;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductImageUrl() {
            return productImageUrl;
        }

        public void setProductImageUrl(String productImageUrl) {
            this.productImageUrl = productImageUrl;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public double getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(double commissionRate) {
            this.commissionRate = commissionRate;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public String getProperties() {
            return properties;
        }

        public void setProperties(String properties) {
            this.properties = properties;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }
    }
}
