package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 16:27
 * @content
 */
public class RemoveGoodsRequest implements Serializable {

    private List<Integer> skuId;

    public List<Integer> getSkuId() {
        return skuId;
    }

    public void setSkuId(List<Integer> skuId) {
        this.skuId = skuId;
    }
}
