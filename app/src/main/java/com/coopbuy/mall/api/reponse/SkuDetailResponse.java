package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 15:41
 */
public class SkuDetailResponse implements Serializable {

    /**
     * productId : 97
     * images : ["https://oss.coopbuy.com/shop/images/6127dfc7-d266-4b21-a75d-0cedaea2dd4c.jpg"]
     * title : 【十八子作】流光潜舰五铬钢套刀多功能厨房刀具套装 S1021七件套
     * salesVolume : 0
     * isSelfSupport : false
     * pricePropertyName : 属性
     * priceSpecificationsName : 规格
     * skuInfo : {"skuId":375,"pricePropertyValue":"","priceSpecificationsValue":"","costPrice":0,"sellingPrice":768,"stock":500,"goodsCode":"","imageUrl":""}
     * shopInfo : {"shopId":27,"shopName":"生活日用专营店","imageUrl":"","productCount":43,"numberOfCollectors":0}
     * propertie : [{"propertyName":"分类","propertyValue":"菜刀"},{"propertyName":"产品产地","propertyValue":"中国大陆"},{"propertyName":"材质","propertyValue":"其它"}]
     */

    private int productId;
    private String title;
    private int salesVolume;
    private boolean isSelfSupport;
    private String pricePropertyName;
    private String priceSpecificationsName;
    private SkuInfoBean skuInfo;
    private ShopInfoBean shopInfo;
    private List<String> images;
    private List<PropertieBean> propertie;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public boolean isIsSelfSupport() {
        return isSelfSupport;
    }

    public void setIsSelfSupport(boolean isSelfSupport) {
        this.isSelfSupport = isSelfSupport;
    }

    public String getPricePropertyName() {
        return pricePropertyName;
    }

    public void setPricePropertyName(String pricePropertyName) {
        this.pricePropertyName = pricePropertyName;
    }

    public String getPriceSpecificationsName() {
        return priceSpecificationsName;
    }

    public void setPriceSpecificationsName(String priceSpecificationsName) {
        this.priceSpecificationsName = priceSpecificationsName;
    }

    public SkuInfoBean getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(SkuInfoBean skuInfo) {
        this.skuInfo = skuInfo;
    }

    public ShopInfoBean getShopInfo() {
        return shopInfo;
    }

    public void setShopInfo(ShopInfoBean shopInfo) {
        this.shopInfo = shopInfo;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<PropertieBean> getPropertie() {
        return propertie;
    }

    public void setPropertie(List<PropertieBean> propertie) {
        this.propertie = propertie;
    }

    public static class SkuInfoBean {
        /**
         * skuId : 375
         * pricePropertyValue :
         * priceSpecificationsValue :
         * costPrice : 0
         * sellingPrice : 768
         * stock : 500
         * goodsCode :
         * imageUrl :
         */

        private int skuId;
        private String pricePropertyValue;
        private String priceSpecificationsValue;
        private int costPrice;
        private int sellingPrice;
        private int stock;
        private String goodsCode;
        private String imageUrl;

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public String getPricePropertyValue() {
            return pricePropertyValue;
        }

        public void setPricePropertyValue(String pricePropertyValue) {
            this.pricePropertyValue = pricePropertyValue;
        }

        public String getPriceSpecificationsValue() {
            return priceSpecificationsValue;
        }

        public void setPriceSpecificationsValue(String priceSpecificationsValue) {
            this.priceSpecificationsValue = priceSpecificationsValue;
        }

        public int getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(int costPrice) {
            this.costPrice = costPrice;
        }

        public int getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(int sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class ShopInfoBean {
        /**
         * shopId : 27
         * shopName : 生活日用专营店
         * imageUrl :
         * productCount : 43
         * numberOfCollectors : 0
         */

        private int shopId;
        private String shopName;
        private String imageUrl;
        private int productCount;
        private int numberOfCollectors;

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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getProductCount() {
            return productCount;
        }

        public void setProductCount(int productCount) {
            this.productCount = productCount;
        }

        public int getNumberOfCollectors() {
            return numberOfCollectors;
        }

        public void setNumberOfCollectors(int numberOfCollectors) {
            this.numberOfCollectors = numberOfCollectors;
        }
    }

    public static class PropertieBean {
        /**
         * propertyName : 分类
         * propertyValue : 菜刀
         */

        private String propertyName;
        private String propertyValue;

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getPropertyValue() {
            return propertyValue;
        }

        public void setPropertyValue(String propertyValue) {
            this.propertyValue = propertyValue;
        }
    }
}
