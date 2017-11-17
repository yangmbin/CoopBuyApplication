package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/17- 14:43
 */

public class InComeReponse implements Serializable {

    /**
     * totalCount : 0
     * items : [{"userName":"string","orderId":"string","orderTime":"2017-11-17T01:01:43.989Z","productCount":0,"orderAmount":0,"freightAmount":0,"orderStatus":"string","commissionAmount":0,"commissionType":0}]
     */

    private int totalCount;
    private List<ItemsBean> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements Serializable {
        /**
         * userName : string
         * orderId : string
         * orderTime : 2017-11-17T01:01:43.989Z
         * productCount : 0
         * orderAmount : 0
         * freightAmount : 0
         * orderStatus : string
         * commissionAmount : 0
         * commissionType : 0
         */

        private String userName;
        private String orderId;
        private String orderTime;
        private int productCount;
        private int orderAmount;
        private int freightAmount;
        private String orderStatus;
        private int commissionAmount;
        private int commissionType;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public int getProductCount() {
            return productCount;
        }

        public void setProductCount(int productCount) {
            this.productCount = productCount;
        }

        public int getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(int orderAmount) {
            this.orderAmount = orderAmount;
        }

        public int getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(int freightAmount) {
            this.freightAmount = freightAmount;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getCommissionAmount() {
            return commissionAmount;
        }

        public void setCommissionAmount(int commissionAmount) {
            this.commissionAmount = commissionAmount;
        }

        public int getCommissionType() {
            return commissionType;
        }

        public void setCommissionType(int commissionType) {
            this.commissionType = commissionType;
        }
    }
}
