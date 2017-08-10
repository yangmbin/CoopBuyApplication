package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 9:19
 * @content
 */
public class GoodsDetailInfoResponse implements Serializable{


    /**
     * shopId : 90
     * categoryId : 443
     * categoryPath : 377/383/443
     * goodsName : （爆品池）新款夏季韩版时尚印花T恤中长款网纱裙两件套连衣裙
     * goodsCode :  LSZ402
     * brandName :  LSZ402
     * modelName :  LSZ402
     * promotionDesc :
     * packingDetailedList : 原厂包装
     * measureUnit : 件
     * weight : 0
     * volume : 0
     * inventoryQuantity : 800
     * referencePrice : 0
     * sellingPrice : 79
     * minSellingPrice : 79
     * maxSellingPrice : 79
     * imageUrl : /shop/images/ba58178c-b4ca-4310-8e52-2623a38c8ad7.jpg
     * webDescription :
     * appDescription : &lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/c6ac475e-cd2d-45d7-9cf8-fb9a33dfbf59.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_001.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/e9786831-bc20-4058-9be5-89d73e332f89.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_002.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/a6111393-761e-450c-a3ba-b7bdd93fee80.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_003.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/537430d9-c926-4c2c-9a13-ead089ebb013.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_004.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/29c4154b-2a9e-4a07-9188-8d44ed2ecdf8.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_005.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/acfa77ee-038d-4699-b3a2-0edd2bc54fa4.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_006.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/105c665c-8bb0-4457-89d3-a2c4e820cdeb.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_007.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/2cb22b2e-5e54-4c66-ae7c-0fa3e8bd1bba.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_008.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/4a488510-878b-427a-881e-8b9aed4acac3.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_009.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/eefb0fc4-5d1c-4548-be43-0d7c194f89b7.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_010.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/a51c74d3-858e-4dd7-9481-214c022ac36a.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_011.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/f1786976-5de4-44db-a617-2c7d78b1a2e2.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_012.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/9e54a80e-fe67-437e-80cc-8ddc841762d2.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_013.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/26193a21-31ea-4adb-876b-57bc6b66a9af.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_014.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/291454a2-c67e-4113-aac9-db14c2dba2a2.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_015.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/175e2621-88fc-4ff8-95b1-aeef1e27a769.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_016.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/2c7c129e-da47-4792-a27a-8e9022951ef2.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_017.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/15a9b511-a724-40eb-b919-83029a6f1bc9.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_018.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/1259f3f3-7c0a-4251-a8b3-8a58be47be16.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_019.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;https://oss.coopbuy.com/shop/images/goods/4630937c-3ea2-4e44-9f87-9727e94d0199.jpg&quot; style=&quot;&quot; title=&quot;20170712_113833_020.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
     * sellingNumber : 0
     * pricePropertyName : 属性
     * priceSpecificationsName : 规格
     * status : 3
     * images : [{"goodsId":2354,"sortId":0,"imageName":"商品图片","imageUrl":"/shop/images/ba58178c-b4ca-4310-8e52-2623a38c8ad7.jpg","id":13652},{"goodsId":2354,"sortId":1,"imageName":"商品图片","imageUrl":"/shop/images/0cb75c8e-ea15-493f-ae24-272930292e4f.jpg","id":13653},{"goodsId":2354,"sortId":2,"imageName":"商品图片","imageUrl":"/shop/images/2d920146-39bf-4cbe-ba0f-ebefc48572c3.jpg","id":13654},{"goodsId":2354,"sortId":3,"imageName":"商品图片","imageUrl":"/shop/images/c2a8567f-8b5d-452e-b971-ef679eaca50b.jpg","id":13655},{"goodsId":2354,"sortId":4,"imageName":"商品图片","imageUrl":"/shop/images/c9484229-d7b4-4596-9219-05b11ae2e543.jpg","id":13656}]
     * properties : []
     * skus : [{"goodsId":2354,"sortId":0,"pricePropertyValue":"S","priceSpecificationsValue":"藏青色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22501},{"goodsId":2354,"sortId":1,"pricePropertyValue":"M","priceSpecificationsValue":"藏青色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22500},{"goodsId":2354,"sortId":2,"pricePropertyValue":"L","priceSpecificationsValue":"藏青色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22499},{"goodsId":2354,"sortId":3,"pricePropertyValue":"XL","priceSpecificationsValue":"藏青色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22498},{"goodsId":2354,"sortId":4,"pricePropertyValue":"S","priceSpecificationsValue":"驼色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22497},{"goodsId":2354,"sortId":5,"pricePropertyValue":"M","priceSpecificationsValue":"驼色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22496},{"goodsId":2354,"sortId":6,"pricePropertyValue":"L","priceSpecificationsValue":"驼色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22495},{"goodsId":2354,"sortId":7,"pricePropertyValue":"XL","priceSpecificationsValue":"驼色","sellingPrice":79,"inventoryQuantity":100,"goodsCode":"","imageUrl":"/Content/images/photo_icon.png","id":22494}]
     * id : 2354
     */

    private int shopId;
    private int categoryId;
    private String categoryPath;
    private String goodsName;
    private String goodsCode;
    private String brandName;
    private String modelName;
    private String promotionDesc;
    private String packingDetailedList;
    private String measureUnit;
    private int weight;
    private int volume;
    private int inventoryQuantity;
    private int referencePrice;
    private int sellingPrice;
    private int minSellingPrice;
    private int maxSellingPrice;
    private String imageUrl;
    private String webDescription;
    private String appDescription;
    private int sellingNumber;
    private String pricePropertyName;
    private String priceSpecificationsName;
    private int status;
    private int id;
    private List<ImagesBean> images;
    private List<?> properties;
    private List<SkusBean> skus;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }

    public String getPackingDetailedList() {
        return packingDetailedList;
    }

    public void setPackingDetailedList(String packingDetailedList) {
        this.packingDetailedList = packingDetailedList;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public int getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(int referencePrice) {
        this.referencePrice = referencePrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getMinSellingPrice() {
        return minSellingPrice;
    }

    public void setMinSellingPrice(int minSellingPrice) {
        this.minSellingPrice = minSellingPrice;
    }

    public int getMaxSellingPrice() {
        return maxSellingPrice;
    }

    public void setMaxSellingPrice(int maxSellingPrice) {
        this.maxSellingPrice = maxSellingPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebDescription() {
        return webDescription;
    }

    public void setWebDescription(String webDescription) {
        this.webDescription = webDescription;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public int getSellingNumber() {
        return sellingNumber;
    }

    public void setSellingNumber(int sellingNumber) {
        this.sellingNumber = sellingNumber;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public List<?> getProperties() {
        return properties;
    }

    public void setProperties(List<?> properties) {
        this.properties = properties;
    }

    public List<SkusBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusBean> skus) {
        this.skus = skus;
    }

    public static class ImagesBean {
        /**
         * goodsId : 2354
         * sortId : 0
         * imageName : 商品图片
         * imageUrl : /shop/images/ba58178c-b4ca-4310-8e52-2623a38c8ad7.jpg
         * id : 13652
         */

        private int goodsId;
        private int sortId;
        private String imageName;
        private String imageUrl;
        private int id;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getSortId() {
            return sortId;
        }

        public void setSortId(int sortId) {
            this.sortId = sortId;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class SkusBean {
        /**
         * goodsId : 2354
         * sortId : 0
         * pricePropertyValue : S
         * priceSpecificationsValue : 藏青色
         * sellingPrice : 79
         * inventoryQuantity : 100
         * goodsCode :
         * imageUrl : /Content/images/photo_icon.png
         * id : 22501
         */

        private int goodsId;
        private int sortId;
        private String pricePropertyValue;
        private String priceSpecificationsValue;
        private int sellingPrice;
        private int inventoryQuantity;
        private String goodsCode;
        private String imageUrl;
        private int id;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getSortId() {
            return sortId;
        }

        public void setSortId(int sortId) {
            this.sortId = sortId;
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

        public int getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(int sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public int getInventoryQuantity() {
            return inventoryQuantity;
        }

        public void setInventoryQuantity(int inventoryQuantity) {
            this.inventoryQuantity = inventoryQuantity;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
