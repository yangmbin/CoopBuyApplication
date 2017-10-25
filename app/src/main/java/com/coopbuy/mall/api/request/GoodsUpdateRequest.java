package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/25- 15:17
 */

public class GoodsUpdateRequest implements Serializable {

    private List<SkuIdsBean> skuIds;

    public List<SkuIdsBean> getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(List<SkuIdsBean> skuIds) {
        this.skuIds = skuIds;
    }

    public static class SkuIdsBean implements Serializable {
        /**
         * newSkuId : 0
         * skuId : 0
         * quantity : 0
         */

        private int newSkuId;
        private int skuId;
        private int quantity;

        public int getNewSkuId() {
            return newSkuId;
        }

        public void setNewSkuId(int newSkuId) {
            this.newSkuId = newSkuId;
        }

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
