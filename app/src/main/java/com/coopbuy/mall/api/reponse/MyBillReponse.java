package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/17- 15:52
 */

public class MyBillReponse implements Serializable {

    /**
     * totalCount : 0
     * items : [{"settlementName":"string","settlementStatus":"string","status":0,"bookAmount":0,"bookTime":"2017-11-17T07:17:29.443Z","totalOrderCount":0}]
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
         * settlementName : string
         * settlementStatus : string
         * status : 0
         * bookAmount : 0
         * bookTime : 2017-11-17T07:17:29.443Z
         * totalOrderCount : 0
         */

        private String settlementName;
        private String settlementStatus;
        private int status;
        private int bookAmount;
        private String bookTime;
        private int totalOrderCount;

        public String getSettlementName() {
            return settlementName;
        }

        public void setSettlementName(String settlementName) {
            this.settlementName = settlementName;
        }

        public String getSettlementStatus() {
            return settlementStatus;
        }

        public void setSettlementStatus(String settlementStatus) {
            this.settlementStatus = settlementStatus;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getBookAmount() {
            return bookAmount;
        }

        public void setBookAmount(int bookAmount) {
            this.bookAmount = bookAmount;
        }

        public String getBookTime() {
            return bookTime;
        }

        public void setBookTime(String bookTime) {
            this.bookTime = bookTime;
        }

        public int getTotalOrderCount() {
            return totalOrderCount;
        }

        public void setTotalOrderCount(int totalOrderCount) {
            this.totalOrderCount = totalOrderCount;
        }
    }
}
