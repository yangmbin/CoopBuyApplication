package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * Created by niu on 2017/10/27- 17:29
 */

public class ShopSotreCancelRequest implements Serializable {

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
