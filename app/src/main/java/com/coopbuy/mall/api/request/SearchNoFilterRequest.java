package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/10/31 17:25
 */
public class SearchNoFilterRequest implements Serializable {

    /**
     * searchKeyword : string
     * currentPage : 0
     * orderMode : 0
     */

    private String searchKeyword;
    private int currentPage;
    private int orderMode;

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
}
