package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/24- 14:34
 */

public class ShopCartReponse implements Serializable {
    private List<ShopsBean> shops;
    private List<InvalidProductsBean> invalidProducts;

    public List<ShopsBean> getShops() {
        return shops;
    }

    public void setShops(List<ShopsBean> shops) {
        this.shops = shops;
    }

    public List<InvalidProductsBean> getInvalidProducts() {
        return invalidProducts;
    }

    public void setInvalidProducts(List<InvalidProductsBean> invalidProducts) {
        this.invalidProducts = invalidProducts;
    }

    public static class ShopsBean implements Serializable {
        /**
         * shopId : 27
         * shopName : 生活日用专营店
         * shopLogoUrl :
         * products : [{"productId":97,"productName":"【十八子作】流光潜舰五铬钢套刀多功能厨房刀具套装 S1021七件套","skuId":375,"imageUrl":"https://oss.coopbuy.com/shop/images/6127dfc7-d266-4b21-a75d-0cedaea2dd4c.jpg","quantity":1,"unitPrice":768,"createTime":"2017-10-24 10:13:21","specifications":"","properties":""},{"productId":56,"productName":"十八子作2代升级版厨师斩切两用不锈钢菜刀厨刀 02中号通用","skuId":210,"imageUrl":"https://oss.coopbuy.com/shop/images/72054f41-3171-4c2b-bdf3-ab32c059c139.jpg","quantity":1,"unitPrice":76,"createTime":"2017-10-24 10:13:57","specifications":"属性:01大号","properties":""},{"productId":61,"productName":"十八子作实惠2002套刀多功能厨房刀具套装 S2213七件套","skuId":221,"imageUrl":"https://oss.coopbuy.com/shop/images/5a9f313a-e8d1-4b89-9409-ed647b9915b6.jpg","quantity":1,"unitPrice":325,"createTime":"2017-10-24 10:14:11","specifications":"","properties":""}]
         */

        private int shopId;
        private String shopName;
        private String shopLogoUrl;
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

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean implements Serializable {
            public static final int TYPE_TITLE=1;
            public static final int TYPE_NROMAL=2;
            public static final int TYPE_HEADER=3;
            /**
             * productId : 97
             * productName : 【十八子作】流光潜舰五铬钢套刀多功能厨房刀具套装 S1021七件套
             * skuId : 375
             * imageUrl : https://oss.coopbuy.com/shop/images/6127dfc7-d266-4b21-a75d-0cedaea2dd4c.jpg
             * quantity : 1
             * unitPrice : 768
             * createTime : 2017-10-24 10:13:21
             * specifications :
             * properties :
             */
            //使用店铺的id  属于店铺的 新加的
            private int shopId;
            private String shopName;
            private int type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            private int productId;
            private String productName;
            private int skuId;
            private String imageUrl;
            private int quantity;
            private int unitPrice;
            private String createTime;
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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

    public static class InvalidProductsBean implements Serializable {
        /**
         * shopId : 30
         * shopName : 红利贵人鸟专卖店
         * shopLogoUrl :
         * products : [{"productId":111,"productName":"贵人鸟正品男鞋2016秋冬季新款男子复古鞋气垫减震时尚休闲鞋运动鞋","skuId":434,"imageUrl":"https://oss.coopbuy.com/Content/images/photo_icon.png","quantity":1,"unitPrice":169,"createTime":"2017-10-24 10:14:29","specifications":"属性:-2典雅灰/银色","properties":"规格:39"}]
         */

        private int shopId;
        private String shopName;
        private String shopLogoUrl;
        private List<ProductsBeanX> products;

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

        public List<ProductsBeanX> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBeanX> products) {
            this.products = products;
        }

        public static class ProductsBeanX implements Serializable {
            /**
             * productId : 111
             * productName : 贵人鸟正品男鞋2016秋冬季新款男子复古鞋气垫减震时尚休闲鞋运动鞋
             * skuId : 434
             * imageUrl : https://oss.coopbuy.com/Content/images/photo_icon.png
             * quantity : 1
             * unitPrice : 169
             * createTime : 2017-10-24 10:14:29
             * specifications : 属性:-2典雅灰/银色
             * properties : 规格:39
             */

            private int productId;
            private String productName;
            private int skuId;
            private String imageUrl;
            private int quantity;
            private int unitPrice;
            private String createTime;
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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
