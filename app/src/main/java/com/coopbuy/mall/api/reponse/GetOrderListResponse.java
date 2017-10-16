package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 10:27
 * @content
 */
public class GetOrderListResponse implements Serializable {

    /**
     * rowCount : 0
     * pageCount : 0
     * currentPage : 0
     * pageSize : 0
     * items : [{"orderId":"string","shopId":0,"shopName":"string","orderType":0,"orderStatus":0,"statusName":"string","totalAmount":0,"payableAmount":0,"secondFreightAmount":0,"freightAmount":0,"isComment":true,"isSiteMasterPayApply":true,"createTime":"2017-08-09T01:41:09.478Z","payExpires":0,"recieveExpires":0,"consignee":"string","recieverPhone":"string","regionId":0,"regionName":"string","shippingAddress":"string","remark":"string","orderItem":[{"goodsId":0,"goodsName":"string","skuId":0,"imageUrl":"string","quantity":0,"unitPrice":0,"specifications":"string","properties":"string","refundState":0}],"refundStatus":0,"refundStatusName":"string","isSiteOrder":true}]
     */

    private int rowCount;
    private int pageCount;
    private int currentPage;
    private int pageSize;
    private List<ItemsBean> items;

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * orderId : string
         * shopId : 0
         * shopName : string
         * orderType : 0
         * orderStatus : 0
         * statusName : string
         * totalAmount : 0
         * payableAmount : 0
         * secondFreightAmount : 0
         * freightAmount : 0
         * isComment : true
         * isSiteMasterPayApply : true
         * createTime : 2017-08-09T01:41:09.478Z
         * payExpires : 0
         * recieveExpires : 0
         * consignee : string
         * recieverPhone : string
         * regionId : 0
         * regionName : string
         * shippingAddress : string
         * remark : string
         * orderItem : [{"goodsId":0,"goodsName":"string","skuId":0,"imageUrl":"string","quantity":0,"unitPrice":0,"specifications":"string","properties":"string","refundState":0}]
         * refundStatus : 0
         * refundStatusName : string
         * isSiteOrder : true
         */

        private String orderId;
        private int shopId;
        private String shopName;
        private int orderType;
        private int orderStatus;
        private String statusName;
        private int totalAmount;
        private int payableAmount;
        private int secondFreightAmount;
        private int freightAmount;
        private boolean isComment;
        private boolean isSiteMasterPayApply;
        private String createTime;
        private int payExpires;
        private int recieveExpires;
        private String consignee;
        private String recieverPhone;
        private int regionId;
        private String regionName;
        private String shippingAddress;
        private String remark;
        private int refundStatus;
        private String refundStatusName;
        private boolean isSiteOrder;
        private List<OrderItemBean> orderItem;

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

        public int getOrderType() {
            return orderType;
        }

        public void setOrderType(int orderType) {
            this.orderType = orderType;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
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

        public int getPayableAmount() {
            return payableAmount;
        }

        public void setPayableAmount(int payableAmount) {
            this.payableAmount = payableAmount;
        }

        public int getSecondFreightAmount() {
            return secondFreightAmount;
        }

        public void setSecondFreightAmount(int secondFreightAmount) {
            this.secondFreightAmount = secondFreightAmount;
        }

        public int getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(int freightAmount) {
            this.freightAmount = freightAmount;
        }

        public boolean isIsComment() {
            return isComment;
        }

        public void setIsComment(boolean isComment) {
            this.isComment = isComment;
        }

        public boolean isIsSiteMasterPayApply() {
            return isSiteMasterPayApply;
        }

        public void setIsSiteMasterPayApply(boolean isSiteMasterPayApply) {
            this.isSiteMasterPayApply = isSiteMasterPayApply;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getPayExpires() {
            return payExpires;
        }

        public void setPayExpires(int payExpires) {
            this.payExpires = payExpires;
        }

        public int getRecieveExpires() {
            return recieveExpires;
        }

        public void setRecieveExpires(int recieveExpires) {
            this.recieveExpires = recieveExpires;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getRecieverPhone() {
            return recieverPhone;
        }

        public void setRecieverPhone(String recieverPhone) {
            this.recieverPhone = recieverPhone;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(int refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getRefundStatusName() {
            return refundStatusName;
        }

        public void setRefundStatusName(String refundStatusName) {
            this.refundStatusName = refundStatusName;
        }

        public boolean isIsSiteOrder() {
            return isSiteOrder;
        }

        public void setIsSiteOrder(boolean isSiteOrder) {
            this.isSiteOrder = isSiteOrder;
        }

        public List<OrderItemBean> getOrderItem() {
            return orderItem;
        }

        public void setOrderItem(List<OrderItemBean> orderItem) {
            this.orderItem = orderItem;
        }

        public static class OrderItemBean {
            /**
             * goodsId : 0
             * goodsName : string
             * skuId : 0
             * imageUrl : string
             * quantity : 0
             * unitPrice : 0
             * specifications : string
             * properties : string
             * refundState : 0
             */

            private int goodsId;
            private String goodsName;
            private int skuId;
            private String imageUrl;
            private int quantity;
            private int unitPrice;
            private String specifications;
            private String properties;
            private int refundState;

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
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

            public int getRefundState() {
                return refundState;
            }

            public void setRefundState(int refundState) {
                this.refundState = refundState;
            }
        }
    }
}
