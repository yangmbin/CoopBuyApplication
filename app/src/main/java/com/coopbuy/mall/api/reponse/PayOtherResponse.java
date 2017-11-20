package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/20- 18:39
 */

public class PayOtherResponse implements Serializable {

    /**
     * totalCount : 0
     * items : [{"orderId":"string","applyTime":"2017-11-20T01:11:11.170Z","consignerName":"string","consignerTel":"string","applyAmount":0,"canCancelApply":true,"canPayment":true}]
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
         * orderId : string
         * applyTime : 2017-11-20T01:11:11.170Z
         * consignerName : string
         * consignerTel : string
         * applyAmount : 0
         * canCancelApply : true
         * canPayment : true
         */

        private String orderId;
        private String applyTime;
        private String consignerName;
        private String consignerTel;
        private int applyAmount;
        private boolean canCancelApply;
        private boolean canPayment;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime;
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

        public int getApplyAmount() {
            return applyAmount;
        }

        public void setApplyAmount(int applyAmount) {
            this.applyAmount = applyAmount;
        }

        public boolean isCanCancelApply() {
            return canCancelApply;
        }

        public void setCanCancelApply(boolean canCancelApply) {
            this.canCancelApply = canCancelApply;
        }

        public boolean isCanPayment() {
            return canPayment;
        }

        public void setCanPayment(boolean canPayment) {
            this.canPayment = canPayment;
        }
    }
}
