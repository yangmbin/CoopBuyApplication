package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/20- 9:28
 */

public class MyCustomRequest implements Serializable {

    /**
     * keyword :
     * currentPage : 1
     */

    private String keyword;
    private int currentPage;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
