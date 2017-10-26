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
     * totalCount : 1
     * items : [{"orderId":"1710169717892215","shopId":54,"shopName":"奈儿斯服饰专营店","orderStatus":1,"orderType":1,"statusName":"待支付","totalAmount":79,"freightAmount":0,"items":[{"itemId":1,"skuId":6305,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","productImageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","quantity":1,"unitPrice":79,"commissionRate":6,"specifications":"规格:XXL","properties":"属性:蓝色","refundStatus":""}],"canCancel":true,"canDelete":false,"canPayment":true,"canApplyLieuPay":true,"canDelayedReceipt":false,"canFindExpressInfo":false,"canReceipt":false,"canApplyRefund":false,"applyRefundButtonText":"","canRemindShipment":false,"canRepeatSubmitOrder":false}]
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
         * orderId : 1710169717892215
         * shopId : 54
         * shopName : 奈儿斯服饰专营店
         * orderStatus : 1
         * orderType : 1
         * statusName : 待支付
         * totalAmount : 79
         * freightAmount : 0
         * items : [{"itemId":1,"skuId":6305,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","productImageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","quantity":1,"unitPrice":79,"commissionRate":6,"specifications":"规格:XXL","properties":"属性:蓝色","refundStatus":""}]
         * canCancel : true
         * canDelete : false
         * canPayment : true
         * canApplyLieuPay : true
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
        private int totalAmount;
        private int freightAmount;
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

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
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
}
