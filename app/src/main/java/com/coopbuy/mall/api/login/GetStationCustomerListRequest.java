package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:30
 * @content
 */
public class GetStationCustomerListRequest implements Serializable{

    /**
     * currentPage : 0
     * keyword : string
     */

    private int currentPage;
    private String keyword;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
