package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/26- 13:56
 */

public class OrderBuildRequest implements Serializable {

    /**
     * skus : [{"skuId":6305,"quantity":1}]
     * addressId : 0
     */

    private int addressId;
    private List<SkusBean> skus;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public List<SkusBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusBean> skus) {
        this.skus = skus;
    }

    public static class SkusBean implements Serializable {
        /**
         * skuId : 6305
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
