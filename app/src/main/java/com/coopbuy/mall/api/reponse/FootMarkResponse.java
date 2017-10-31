package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/31- 9:30
 */

public class FootMarkResponse implements Serializable {

    /**
     * totalCount : 1
     * items : [{"date":"今天","products":[{"skuId":6305,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","salesPrice":79,"imageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","specification":"规格:XXL","property":"属性:蓝色"}]}]
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

    public static class ItemsBean implements Serializable {
        /**
         * date : 今天
         * products : [{"skuId":6305,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","salesPrice":79,"imageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","specification":"规格:XXL","property":"属性:蓝色"}]
         */

        private String date;
        private List<ProductsBean> products;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean implements Serializable {
            /**
             * skuId : 6305
             * productName : 维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL
             * salesPrice : 79
             * imageUrl : https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg
             * specification : 规格:XXL
             * property : 属性:蓝色
             */

            private int skuId;
            private String productName;
            private int salesPrice;
            private String imageUrl;
            private String specification;
            private String property;

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

            public int getSalesPrice() {
                return salesPrice;
            }

            public void setSalesPrice(int salesPrice) {
                this.salesPrice = salesPrice;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getSpecification() {
                return specification;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }
        }
    }
}
