package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 9:39
 * @content
 */
public class GetGoodsFreightRequest implements Serializable {

    /**
     * goodsId : 2354
     * regionId : 110102010001
     */

    private int goodsId;
    private String regionId;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}
