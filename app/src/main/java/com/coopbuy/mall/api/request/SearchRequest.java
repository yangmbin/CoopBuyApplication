package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/10/31 17:25
 */
public class SearchRequest implements Serializable {

    /**
     * searchKeyword : string
     * currentPage : 0
     * filters : [{"fieldName":"string","value":"string"}]
     * orderMode : 0
     */

    private String searchKeyword;
    private int currentPage;
    private int orderMode;
    private List<FiltersBean> filters;

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(int orderMode) {
        this.orderMode = orderMode;
    }

    public List<FiltersBean> getFilters() {
        return filters;
    }

    public void setFilters(List<FiltersBean> filters) {
        this.filters = filters;
    }

    public static class FiltersBean {
        /**
         * fieldName : string
         * value : string
         */

        private String fieldName;
        private String value;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
