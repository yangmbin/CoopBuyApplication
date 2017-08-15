package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 11:00
 * @content
 */
public class GetGoodsCommentListRequest implements Serializable {

    /**
     * currentPage : 0
     * productId : 0
     */

    private int currentPage;
    private int productId;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
