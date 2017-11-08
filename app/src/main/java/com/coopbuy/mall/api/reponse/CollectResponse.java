package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/7- 9:23
 */

public class CollectResponse implements Serializable {

    /**
     * currentMaxPublishCount : 0
     * canPublish : true
     * nextPublishSurplusTime : string
     * currentSelectedProductCount : 0
     * totalCount : 0
     * items : [{"shopId":0,"skuId":0,"productName":"string","productImageUrl":"string","unitPrice":0,"specifications":"string","properties":"string","sales":0,"selected":true}]
     */

    private int currentMaxPublishCount;
    private boolean canPublish;
    private double nextPublishSurplusTime;
    private int currentSelectedProductCount;
    private int totalCount;
    private List<ItemsBean> items;

    public int getCurrentMaxPublishCount() {
        return currentMaxPublishCount;
    }

    public void setCurrentMaxPublishCount(int currentMaxPublishCount) {
        this.currentMaxPublishCount = currentMaxPublishCount;
    }

    public boolean isCanPublish() {
        return canPublish;
    }

    public void setCanPublish(boolean canPublish) {
        this.canPublish = canPublish;
    }

    public double getNextPublishSurplusTime() {
        return nextPublishSurplusTime;
    }

    public void setNextPublishSurplusTime(double nextPublishSurplusTime) {
        this.nextPublishSurplusTime = nextPublishSurplusTime;
    }

    public int getCurrentSelectedProductCount() {
        return currentSelectedProductCount;
    }

    public void setCurrentSelectedProductCount(int currentSelectedProductCount) {
        this.currentSelectedProductCount = currentSelectedProductCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements Serializable {
        /**
         * shopId : 0
         * skuId : 0
         * productName : string
         * productImageUrl : string
         * unitPrice : 0
         * specifications : string
         * properties : string
         * sales : 0
         * selected : true
         */

        private int shopId;
        private int skuId;
        private String productName;
        private String productImageUrl;
        private int unitPrice;
        private String specifications;
        private String properties;
        private int sales;
        private boolean selected;
        private int currentMaxPublishCount;
        private boolean canPublish;
        private int currentSelectedProductCount;

        public int getCurrentMaxPublishCount() {
            return currentMaxPublishCount;
        }

        public void setCurrentMaxPublishCount(int currentMaxPublishCount) {
            this.currentMaxPublishCount = currentMaxPublishCount;
        }

        public boolean isCanPublish() {
            return canPublish;
        }

        public void setCanPublish(boolean canPublish) {
            this.canPublish = canPublish;
        }

        public int getCurrentSelectedProductCount() {
            return currentSelectedProductCount;
        }

        public void setCurrentSelectedProductCount(int currentSelectedProductCount) {
            this.currentSelectedProductCount = currentSelectedProductCount;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductImageUrl() {
            return productImageUrl;
        }

        public void setProductImageUrl(String productImageUrl) {
            this.productImageUrl = productImageUrl;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public String getProperties() {
            return properties;
        }

        public void setProperties(String properties) {
            this.properties = properties;
        }

        public int getSales() {
            return sales;
        }

        public void setSales(int sales) {
            this.sales = sales;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
