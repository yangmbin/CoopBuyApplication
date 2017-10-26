package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/26- 13:56
 */

public class OrderBuildResponse implements Serializable {

    /**
     * shopId : 0
     * shopName : string
     * shopLogoUrl : string
     * totoalAmount : 0
     * hasInvoice : true
     * products : [{"productId":0,"productName":"string","skuId":0,"imageUrl":"string","quantity":0,"unitPrice":0,"specifications":"string","properties":"string"}]
     */

    private int shopId;
    private String shopName;
    private String shopLogoUrl;
    private int totoalAmount;
    private boolean hasInvoice;
    private List<ProductsBean> products;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLogoUrl() {
        return shopLogoUrl;
    }

    public void setShopLogoUrl(String shopLogoUrl) {
        this.shopLogoUrl = shopLogoUrl;
    }

    public int getTotoalAmount() {
        return totoalAmount;
    }

    public void setTotoalAmount(int totoalAmount) {
        this.totoalAmount = totoalAmount;
    }

    public boolean isHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(boolean hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean {
        /**
         * productId : 0
         * productName : string
         * skuId : 0
         * imageUrl : string
         * quantity : 0
         * unitPrice : 0
         * specifications : string
         * properties : string
         */

        private int productId;
        private String productName;
        private int skuId;
        private String imageUrl;
        private int quantity;
        private int unitPrice;
        private String specifications;
        private String properties;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
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
    }
}
