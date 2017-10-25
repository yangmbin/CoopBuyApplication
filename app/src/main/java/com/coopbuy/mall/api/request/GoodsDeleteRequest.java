package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/25- 16:08
 */

public class GoodsDeleteRequest implements Serializable {

    private List<Integer> skuIds;

    public List<Integer> getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(List<Integer> skuIds) {
        this.skuIds = skuIds;
    }
}
