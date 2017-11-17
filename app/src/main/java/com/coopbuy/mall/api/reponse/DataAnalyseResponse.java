package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/17- 13:54
 */

public class DataAnalyseResponse implements Serializable {

    /**
     * currentCommissionAmount : 0
     * totalCommissionAmount : 0
     * estimateCommissionAmount : 0
     * nextSettlementBookDate : string
     * lastSettleBookInfo : {"totalBookAmount":0,"bookDate":"string","tip":"string","bookStatus":"string"}
     */

    private int currentCommissionAmount;
    private int totalCommissionAmount;
    private int estimateCommissionAmount;
    private String nextSettlementBookDate;
    private LastSettleBookInfoBean lastSettleBookInfo;

    public int getCurrentCommissionAmount() {
        return currentCommissionAmount;
    }

    public void setCurrentCommissionAmount(int currentCommissionAmount) {
        this.currentCommissionAmount = currentCommissionAmount;
    }

    public int getTotalCommissionAmount() {
        return totalCommissionAmount;
    }

    public void setTotalCommissionAmount(int totalCommissionAmount) {
        this.totalCommissionAmount = totalCommissionAmount;
    }

    public int getEstimateCommissionAmount() {
        return estimateCommissionAmount;
    }

    public void setEstimateCommissionAmount(int estimateCommissionAmount) {
        this.estimateCommissionAmount = estimateCommissionAmount;
    }

    public String getNextSettlementBookDate() {
        return nextSettlementBookDate;
    }

    public void setNextSettlementBookDate(String nextSettlementBookDate) {
        this.nextSettlementBookDate = nextSettlementBookDate;
    }

    public LastSettleBookInfoBean getLastSettleBookInfo() {
        return lastSettleBookInfo;
    }

    public void setLastSettleBookInfo(LastSettleBookInfoBean lastSettleBookInfo) {
        this.lastSettleBookInfo = lastSettleBookInfo;
    }

    public static class LastSettleBookInfoBean implements Serializable {
        /**
         * totalBookAmount : 0
         * bookDate : string
         * tip : string
         * bookStatus : string
         */

        private int totalBookAmount;
        private String bookDate;
        private String tip;
        private String bookStatus;

        public int getTotalBookAmount() {
            return totalBookAmount;
        }

        public void setTotalBookAmount(int totalBookAmount) {
            this.totalBookAmount = totalBookAmount;
        }

        public String getBookDate() {
            return bookDate;
        }

        public void setBookDate(String bookDate) {
            this.bookDate = bookDate;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public String getBookStatus() {
            return bookStatus;
        }

        public void setBookStatus(String bookStatus) {
            this.bookStatus = bookStatus;
        }
    }
}
