package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 10:57
 * @content
 */
public class GetHeplCenterContentRequest implements Serializable {

    /**
     * categoryKey : HelpCenter
     * currentPage : 1
     */

    private String categoryKey;
    private int currentPage;

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
