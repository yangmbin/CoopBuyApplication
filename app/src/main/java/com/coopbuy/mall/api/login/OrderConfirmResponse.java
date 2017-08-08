package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 16:31
 * @content
 */
public class OrderConfirmResponse implements Serializable {

    /**
     * sellerId : 56
     * sellerName : 爱窝家居用品专门店
     * hasInvoice : false
     * goods : [{"goodsId":333,"goodsName":"爱奇屋 丽尚保温杯AI-DS11A 430ml","skuId":2256,"imageUrl":"/shop/images/4380ea83-0c8f-4d2c-876e-fefc89333f1c.jpg","quantity":1,"unitPrice":149,"properties":null,"specifications":null}]
     */

    private int sellerId;
    private String sellerName;
    private boolean hasInvoice;
    private List<GoodsBean> goods;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(boolean hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * goodsId : 333
         * goodsName : 爱奇屋 丽尚保温杯AI-DS11A 430ml
         * skuId : 2256
         * imageUrl : /shop/images/4380ea83-0c8f-4d2c-876e-fefc89333f1c.jpg
         * quantity : 1
         * unitPrice : 149
         * properties : null
         * specifications : null
         */

        private int goodsId;
        private String goodsName;
        private int skuId;
        private String imageUrl;
        private int quantity;
        private int unitPrice;
        private Object properties;
        private Object specifications;

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

        public Object getProperties() {
            return properties;
        }

        public void setProperties(Object properties) {
            this.properties = properties;
        }

        public Object getSpecifications() {
            return specifications;
        }

        public void setSpecifications(Object specifications) {
            this.specifications = specifications;
        }
    }
}
