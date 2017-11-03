package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class AfterSalesResponse implements Serializable {

    /**
     * totalCount : 3
     * items : [{"applyNo":"201709148209206","shopId":90,"shopName":"贵农严选","statusName":"仅退款 待商家审核","status":1,"totalRefundAmount":7.8,"totalProductCount":1,"isNeedReturnGoods":false,"products":[{"skuId":32600,"productName":"（爆品池）正宗宇仔大刀肉辣条8090后儿时怀旧麻辣味零食品重庆风味休闲小吃","productImageUrl":"https://oss.coopbuy.com/shop/images/3ad62055-57f1-4ef0-b6db-48d323b2b239.jpg","quantity":1,"unitPrice":7.8,"specifications":"","properties":""}]}]
     */

    private int totalCount;
    private List<ItemsBean> items;

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

    public static class ItemsBean {
        /**
         * applyNo : 201709148209206
         * shopId : 90
         * shopName : 贵农严选
         * statusName : 仅退款 待商家审核
         * status : 1
         * totalRefundAmount : 7.8
         * totalProductCount : 1
         * isNeedReturnGoods : false
         * products : [{"skuId":32600,"productName":"（爆品池）正宗宇仔大刀肉辣条8090后儿时怀旧麻辣味零食品重庆风味休闲小吃","productImageUrl":"https://oss.coopbuy.com/shop/images/3ad62055-57f1-4ef0-b6db-48d323b2b239.jpg","quantity":1,"unitPrice":7.8,"specifications":"","properties":""}]
         */

        private String applyNo;
        private int shopId;
        private String shopName;
        private String statusName;
        private int status;
        private double totalRefundAmount;
        private int totalProductCount;
        private boolean isNeedReturnGoods;
        private List<ProductsBean> products;

        public String getApplyNo() {
            return applyNo;
        }

        public void setApplyNo(String applyNo) {
            this.applyNo = applyNo;
        }

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

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getTotalRefundAmount() {
            return totalRefundAmount;
        }

        public void setTotalRefundAmount(double totalRefundAmount) {
            this.totalRefundAmount = totalRefundAmount;
        }

        public int getTotalProductCount() {
            return totalProductCount;
        }

        public void setTotalProductCount(int totalProductCount) {
            this.totalProductCount = totalProductCount;
        }

        public boolean isIsNeedReturnGoods() {
            return isNeedReturnGoods;
        }

        public void setIsNeedReturnGoods(boolean isNeedReturnGoods) {
            this.isNeedReturnGoods = isNeedReturnGoods;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * skuId : 32600
             * productName : （爆品池）正宗宇仔大刀肉辣条8090后儿时怀旧麻辣味零食品重庆风味休闲小吃
             * productImageUrl : https://oss.coopbuy.com/shop/images/3ad62055-57f1-4ef0-b6db-48d323b2b239.jpg
             * quantity : 1
             * unitPrice : 7.8
             * specifications :
             * properties :
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
}
