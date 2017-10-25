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
     * orderId : 1710169717892215
     * shopId : 54
     * shopName : 奈儿斯服饰专营店
     * shopTel :
     * orderStatus : 1
     * orderType : 1
     * statusName : 待支付
     * totalAmount : 79
     * freightAmount : 0
     * orderAmount : 79
     * remark : 测试第一单啊
     * createTime : 2017-10-16 13:01:20
     * finishTime :
     * paymentTime :
     * consignerName : 王晶
     * consignerTel : 18302626270
     * consignerAddress : 测试的下单
     * regionId : 520425102201
     * regionName : 贵州省,安顺市,紫云苗族布依族自治县,猴场镇,猴场村民委员会
     * orderItems : [{"canApplyRefund":false,"applyRefundButtonText":"","itemId":1,"skuId":6305,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","productImageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","quantity":1,"unitPrice":79,"commissionRate":6,"specifications":"规格:XXL","properties":"属性:蓝色","refundStatus":""}]
     * cargoInfo : {"text":"","time":""}
     * canCancel : false
     * canDelete : false
     * canPayment : false
     * canApplyLieuPay : false
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
    private int totalAmount;
    private int freightAmount;
    private int orderAmount;
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
    private boolean canApplyLieuPay;
    private boolean canDelayedReceipt;
    private boolean canFindExpressInfo;
    private boolean canReceipt;
    private boolean canApplyRefund;
    private String applyRefundButtonText;
    private boolean canRemindShipment;
    private boolean canRepeatSubmitOrder;
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(int freightAmount) {
        this.freightAmount = freightAmount;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
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

    public boolean isCanApplyLieuPay() {
        return canApplyLieuPay;
    }

    public void setCanApplyLieuPay(boolean canApplyLieuPay) {
        this.canApplyLieuPay = canApplyLieuPay;
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
         * itemId : 1
         * skuId : 6305
         * productName : 维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL
         * productImageUrl : https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg
         * quantity : 1
         * unitPrice : 79
         * commissionRate : 6
         * specifications : 规格:XXL
         * properties : 属性:蓝色
         * refundStatus :
         */

        private boolean canApplyRefund;
        private String applyRefundButtonText;
        private int itemId;
        private int skuId;
        private String productName;
        private String productImageUrl;
        private int quantity;
        private int unitPrice;
        private int commissionRate;
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

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(int commissionRate) {
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
