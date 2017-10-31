package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/10/27- 16:53
 */

public class ShopCurrentPageRequest implements Serializable {

    /**
     * currentPage : 1
     */

    private int currentPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
