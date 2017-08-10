package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 16:33
 * @content
 */
public class OrderFreightRequest implements Serializable
{

    /**
     * skuItems : [{"skuId":2256,"quantity":1}]
     * regionId : 110102010001
     */

    private String regionId;
    private List<SkuItemsBean> skuItems;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public List<SkuItemsBean> getSkuItems() {
        return skuItems;
    }

    public void setSkuItems(List<SkuItemsBean> skuItems) {
        this.skuItems = skuItems;
    }

    public static class SkuItemsBean {
        /**
         * skuId : 2256
         * quantity : 1
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
}
