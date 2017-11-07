package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 15:41
 */
public class BeforeApplyRefundResponse implements Serializable {

    /**
     * products : [{"skuId":0,"productName":"string","productImageUrl":"string","quantity":0,"unitPrice":0,"specifications":"string","properties":"string"}]
     * canReturnProduct : true
     * refundAmount : 0.0
     * refundReasons : ["string"]
     */

    private boolean canReturnProduct;
    private double refundAmount;
    private List<ProductsBean> products;
    private List<String> refundReasons;

    public boolean isCanReturnProduct() {
        return canReturnProduct;
    }

    public void setCanReturnProduct(boolean canReturnProduct) {
        this.canReturnProduct = canReturnProduct;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public List<String> getRefundReasons() {
        return refundReasons;
    }

    public void setRefundReasons(List<String> refundReasons) {
        this.refundReasons = refundReasons;
    }

    public static class ProductsBean {
        /**
         * skuId : 0
         * productName : string
         * productImageUrl : string
         * quantity : 0
         * unitPrice : 0.0
         * specifications : string
         * properties : string
         */

        private int skuId;
        private String productName;
        private String productImageUrl;
        private int quantity;
        private double unitPrice;
        private String specifications;
        private String properties;

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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
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
