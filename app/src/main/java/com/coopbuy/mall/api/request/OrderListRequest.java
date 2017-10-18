package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/17 18:27
 */
public class OrderListRequest implements Serializable {

    /**
     * status : 0
     * currentPage : 1
     */

    private int status;
    private int currentPage;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
