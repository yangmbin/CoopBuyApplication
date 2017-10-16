package com.coopbuy.mall.api.request;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 15:39
 */
public class SkuDetailRequest implements Serializable {

    /**
     * skuId : 6305 375
     */

    private int skuId;

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }
}
