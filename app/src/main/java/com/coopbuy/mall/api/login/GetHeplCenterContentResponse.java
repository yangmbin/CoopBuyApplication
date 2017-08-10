package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 10:58
 * @content
 */
public class GetHeplCenterContentResponse implements Serializable {

    /**
     * rowCount : 1
     * pageCount : 1
     * currentPage : 1
     * pageSize : 10
     * items : [{"title":"退货流程","statu":2,"publishTime":"2017-04-06 00:00:00","id":2}]
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
         * title : 退货流程
         * statu : 2
         * publishTime : 2017-04-06 00:00:00
         * id : 2
         */

        private String title;
        private int statu;
        private String publishTime;
        private int id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getStatu() {
            return statu;
        }

        public void setStatu(int statu) {
            this.statu = statu;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
