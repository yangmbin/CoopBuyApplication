package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 10:27
 * @content
 */
public class OrderListResponse implements Serializable {

    /**
     * totalCount : 2
     * items : [{"orderId":"1711021054839611","shopId":90,"shopName":"供销严选","orderStatus":1,"orderType":2,"statusName":"待支付","totalAmount":10,"freightAmount":0,"items":[{"itemId":19630,"skuId":-100,"productName":"贵州移动话费10元","productImageUrl":"","quantity":1,"unitPrice":10,"commissionRate":0,"specifications":"贵州贵阳移动","properties":"","refundStatus":""}],"canCancel":true,"canDelete":false,"canPayment":true,"canApplyLieuPay":true,"canDelayedReceipt":false,"canFindExpressInfo":false,"canReceipt":false,"canApplyRefund":false,"applyRefundButtonText":"","canRemindShipment":false,"canRepeatSubmitOrder":false}]
     */

    private int totalCount;
    private List<ItemsBeanX> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ItemsBeanX> getItems() {
        return items;
    }

    public void setItems(List<ItemsBeanX> items) {
        this.items = items;
    }

    public static class ItemsBeanX {
        /**
         * orderId : 1711021054839611
         * shopId : 90
         * shopName : 供销严选
         * orderStatus : 1
         * orderType : 2
         * statusName : 待支付
         * totalAmount : 10.0
         * freightAmount : 0.0
         * items : [{"itemId":19630,"skuId":-100,"productName":"贵州移动话费10元","productImageUrl":"","quantity":1,"unitPrice":10,"commissionRate":0,"specifications":"贵州贵阳移动","properties":"","refundStatus":""}]
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
        private int orderStatus;
        private int orderType;
        private String statusName;
        private double totalAmount;
        private double freightAmount;
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
        private List<ItemsBean> items;

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

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
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
}
