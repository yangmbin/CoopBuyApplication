package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/21- 14:53
 */

public class CustomOrderReponse implements Serializable {

    /**
     * lieuPayCount : 0
     * totalCount : 0
     * items : [{"orderId":"1709158360869594","consignerName":"郭春华","consignerTel":"18926475276","createTime":"2017-09-15 15:52:33","totalAmount":89,"freightAmount":10,"orderAmount":99,"totalProductCount":1,"closeTime":"22时50分","orderSataus":"已取消","canFindExpressInfo":false,"canViewOrderInfo":true,"canTelConsigner":true}]
     */

    private int lieuPayCount;
    private int totalCount;
    private List<ItemsBean> items;

    public int getLieuPayCount() {
        return lieuPayCount;
    }

    public void setLieuPayCount(int lieuPayCount) {
        this.lieuPayCount = lieuPayCount;
    }

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
         * orderId : 1709158360869594
         * consignerName : 郭春华
         * consignerTel : 18926475276
         * createTime : 2017-09-15 15:52:33
         * totalAmount : 89
         * freightAmount : 10
         * orderAmount : 99
         * totalProductCount : 1
         * closeTime : 22时50分
         * orderSataus : 已取消
         * canFindExpressInfo : false
         * canViewOrderInfo : true
         * canTelConsigner : true
         */

        private String orderId;
        private String consignerName;
        private String consignerTel;
        private String createTime;
        private int totalAmount;
        private int freightAmount;
        private int orderAmount;
        private int totalProductCount;
        private String closeTime;
        private String orderSataus;
        private boolean canFindExpressInfo;
        private boolean canViewOrderInfo;
        private boolean canTelConsigner;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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

        public int getTotalProductCount() {
            return totalProductCount;
        }

        public void setTotalProductCount(int totalProductCount) {
            this.totalProductCount = totalProductCount;
        }

        public String getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(String closeTime) {
            this.closeTime = closeTime;
        }

        public String getOrderSataus() {
            return orderSataus;
        }

        public void setOrderSataus(String orderSataus) {
            this.orderSataus = orderSataus;
        }

        public boolean isCanFindExpressInfo() {
            return canFindExpressInfo;
        }

        public void setCanFindExpressInfo(boolean canFindExpressInfo) {
            this.canFindExpressInfo = canFindExpressInfo;
        }

        public boolean isCanViewOrderInfo() {
            return canViewOrderInfo;
        }

        public void setCanViewOrderInfo(boolean canViewOrderInfo) {
            this.canViewOrderInfo = canViewOrderInfo;
        }

        public boolean isCanTelConsigner() {
            return canTelConsigner;
        }

        public void setCanTelConsigner(boolean canTelConsigner) {
            this.canTelConsigner = canTelConsigner;
        }
    }
}
