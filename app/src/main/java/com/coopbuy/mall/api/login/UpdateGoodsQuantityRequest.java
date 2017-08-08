package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 16:25
 * @content
 */
public class UpdateGoodsQuantityRequest implements Serializable {

    /**
     * skuId : 1318
     * quantity : 2
     */

    private int skuId;
    private int quantity;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
