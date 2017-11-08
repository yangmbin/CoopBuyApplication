package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:45
 */
public class SkuIdRequest implements Serializable {

    /**
     * skuId : 0
     */

    private int skuId;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }
}
