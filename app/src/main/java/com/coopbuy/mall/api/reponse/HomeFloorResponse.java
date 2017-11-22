package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/11/22 17:22
 */
public class HomeFloorResponse implements Serializable {

    /**
     * id : 20304
     * pageId : 10073
     * name : 三列商品
     * floorKey : 三列商品
     * templateKey : template-product-list-1
     * desc :
     * sort : 3
     * titleImage :
     * bottomImage :
     * isShowTitle : false
     * floorItems : [{"id":29,"floorId":20304,"name":"珍真羊中老年女装春秋打底衫妈妈装七分袖T恤蕾丝镶钻针织衫女大码显瘦品牌女装","type":0,"objectId":43,"imageUrl":"https://oss.coopbuy.com/shop/images/9cb727fc-bcd0-48f1-80ff-e13779bd1eb0.jpg","extendData":null,"sort":6,"skuId":43,"salesNumber":2,"unitPrice":118,"specifications":"","properties":""},{"id":30,"floorId":20304,"name":"贵人鸟正品运动裤长裤收脚2017春秋季新款男士休闲裤青少年收脚卫裤小脚裤","type":0,"objectId":22,"imageUrl":"https://oss.coopbuy.com/shop/images/34f65096-72ed-44c7-8cb0-7a23e1028447.jpg","extendData":null,"sort":7,"skuId":22,"salesNumber":0,"unitPrice":139,"specifications":"规格:4XL","properties":"属性:黑色"},{"id":31,"floorId":20304,"name":"【十八子作】飘逸套刀厨房刀具套装 S2911七件套","type":0,"objectId":21,"imageUrl":"https://oss.coopbuy.com/shop/images/3fd58e02-3d2b-400d-bc0d-6a50b0be174f.jpg","extendData":null,"sort":8,"skuId":21,"salesNumber":0,"unitPrice":399,"specifications":"","properties":""}]
     */

    private int id;
    private int pageId;
    private String name;
    private String floorKey;
    private String templateKey;
    private String desc;
    private int sort;
    private String titleImage;
    private String bottomImage;
    private boolean isShowTitle;
    private List<FloorItemsBean> floorItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloorKey() {
        return floorKey;
    }

    public void setFloorKey(String floorKey) {
        this.floorKey = floorKey;
    }

    public String getTemplateKey() {
        return templateKey;
    }

    public void setTemplateKey(String templateKey) {
        this.templateKey = templateKey;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getBottomImage() {
        return bottomImage;
    }

    public void setBottomImage(String bottomImage) {
        this.bottomImage = bottomImage;
    }

    public boolean isIsShowTitle() {
        return isShowTitle;
    }

    public void setIsShowTitle(boolean isShowTitle) {
        this.isShowTitle = isShowTitle;
    }

    public List<FloorItemsBean> getFloorItems() {
        return floorItems;
    }

    public void setFloorItems(List<FloorItemsBean> floorItems) {
        this.floorItems = floorItems;
    }

    public static class FloorItemsBean {
        /**
         * id : 29
         * floorId : 20304
         * name : 珍真羊中老年女装春秋打底衫妈妈装七分袖T恤蕾丝镶钻针织衫女大码显瘦品牌女装
         * type : 0
         * objectId : 43
         * imageUrl : https://oss.coopbuy.com/shop/images/9cb727fc-bcd0-48f1-80ff-e13779bd1eb0.jpg
         * extendData : null
         * sort : 6
         * skuId : 43
         * salesNumber : 2
         * unitPrice : 118.0
         * specifications :
         * properties :
         */

        private int id;
        private int floorId;
        private String name;
        private int type;
        private int objectId;
        private String imageUrl;
        private Object extendData;
        private int sort;
        private int skuId;
        private int salesNumber;
        private double unitPrice;
        private String specifications;
        private String properties;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFloorId() {
            return floorId;
        }

        public void setFloorId(int floorId) {
            this.floorId = floorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getObjectId() {
            return objectId;
        }

        public void setObjectId(int objectId) {
            this.objectId = objectId;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getExtendData() {
            return extendData;
        }

        public void setExtendData(Object extendData) {
            this.extendData = extendData;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public int getSalesNumber() {
            return salesNumber;
        }

        public void setSalesNumber(int salesNumber) {
            this.salesNumber = salesNumber;
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