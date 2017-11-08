package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/10/31 17:25
 */
public class AddToCartRequest implements Serializable {

    private List<SkusBean> skus;

    public List<SkusBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusBean> skus) {
        this.skus = skus;
    }

    public static class SkusBean {
        /**
         * skuId : 0
         * quantity : 0
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
