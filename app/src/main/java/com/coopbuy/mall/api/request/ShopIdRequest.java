package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 15:39
 */
public class ShopIdRequest implements Serializable {

    /**
     * shopId : 0
     */

    private int shopId;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
