package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 16:15
 * @content
 */
public class CartListResponse implements Serializable {

    private List<?> invalidGoodsList;
    private List<ShopListBean> shopList;

    public List<?> getInvalidGoodsList() {
        return invalidGoodsList;
    }

    public void setInvalidGoodsList(List<?> invalidGoodsList) {
        this.invalidGoodsList = invalidGoodsList;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class ShopListBean {
        /**
         * shopId : 33
         * shopName : 歌诺瑞丝官方旗舰店
         * goodsList : [{"goodsId":209,"goodsName":"歌诺瑞丝2017春季女装新款韩版宽松显瘦字母印花卫衣女9991","skuId":1318,"imageUrl":"/shop/images/8cf893e9-7852-40c9-a665-ed7201fb26e2.jpg","quantity":1,"unitPrice":79,"specifications":"规格：L","properties":"属性：蓝色"}]
         */

        private int shopId;
        private String shopName;
        private List<GoodsListBean> goodsList;

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

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            /**
             * goodsId : 209
             * goodsName : 歌诺瑞丝2017春季女装新款韩版宽松显瘦字母印花卫衣女9991
             * skuId : 1318
             * imageUrl : /shop/images/8cf893e9-7852-40c9-a665-ed7201fb26e2.jpg
             * quantity : 1
             * unitPrice : 79
             * specifications : 规格：L
             * properties : 属性：蓝色
             */

            private int goodsId;
            private String goodsName;
            private int skuId;
            private String imageUrl;
            private int quantity;
            private int unitPrice;
            private String specifications;
            private String properties;

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
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
}
