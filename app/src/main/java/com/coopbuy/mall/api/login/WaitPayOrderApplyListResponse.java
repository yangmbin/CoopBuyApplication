package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 14:21
 * @content
 */
public class WaitPayOrderApplyListResponse implements Serializable{

    /**
     * rowCount : 0
     * pageCount : 0
     * currentPage : 0
     * pageSize : 0
     * items : [{"id":0,"orderId":"string","applyTime":"2017-08-14T00:40:35.722Z","applyStatus":0,"applyStatusName":"string","payableAmount":0,"userId":0,"userName":"string","userPhone":"string"}]
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
         * id : 0
         * orderId : string
         * applyTime : 2017-08-14T00:40:35.722Z
         * applyStatus : 0
         * applyStatusName : string
         * payableAmount : 0
         * userId : 0
         * userName : string
         * userPhone : string
         */

        private int id;
        private String orderId;
        private String applyTime;
        private int applyStatus;
        private String applyStatusName;
        private int payableAmount;
        private int userId;
        private String userName;
        private String userPhone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public int getApplyStatus() {
            return applyStatus;
        }

        public void setApplyStatus(int applyStatus) {
            this.applyStatus = applyStatus;
        }

        public String getApplyStatusName() {
            return applyStatusName;
        }

        public void setApplyStatusName(String applyStatusName) {
            this.applyStatusName = applyStatusName;
        }

        public int getPayableAmount() {
            return payableAmount;
        }

        public void setPayableAmount(int payableAmount) {
            this.payableAmount = payableAmount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }
    }
}
