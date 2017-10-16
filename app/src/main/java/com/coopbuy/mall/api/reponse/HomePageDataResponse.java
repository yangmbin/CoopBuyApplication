package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/7 0007 9:19
 * @content
 */
public class HomePageDataResponse implements Serializable {

    private String name;
    private String pageKey;
    private int id;
    private List<FloorsBean> floors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FloorsBean> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorsBean> floors) {
        this.floors = floors;
    }

    public static class FloorsBean {
        /**
         * name : 首页Banner
         * floorKey : 首页Banner
         * templateKey : banner-slider-2
         * sort : 0
         * titleImage :
         * bottomImage :
         * floorItems : [{"name":"好买严选","type":5,"objectId":35,"objectData":null,"imageUrl":"/admin/images/94f997b4-98bc-435c-8eec-d6ee512c859a.jpg","extendData":"","sort":2}]
         */

        private String name;
        private String floorKey;
        private String templateKey;
        private int sort;
        private String titleImage;
        private String bottomImage;
        private List<FloorItemsBean> floorItems;

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

        public List<FloorItemsBean> getFloorItems() {
            return floorItems;
        }

        public void setFloorItems(List<FloorItemsBean> floorItems) {
            this.floorItems = floorItems;
        }

        public static class ObjectData {
            private String goodsName;
            private String promotionDesc;
            private String imageUrl;
            private int sellingPrice;
            private int sellingNumber;

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getPromotionDesc() {
                return promotionDesc;
            }

            public void setPromotionDesc(String promotionDesc) {
                this.promotionDesc = promotionDesc;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getSellingPrice() {
                return sellingPrice;
            }

            public void setSellingPrice(int sellingPrice) {
                this.sellingPrice = sellingPrice;
            }

            public int getSellingNumber() {
                return sellingNumber;
            }

            public void setSellingNumber(int sellingNumber) {
                this.sellingNumber = sellingNumber;
            }
        }

        public static class FloorItemsBean {
            /**
             * name : 好买严选
             * type : 5
             * objectId : 35
             * objectData : null
             * imageUrl : /admin/images/94f997b4-98bc-435c-8eec-d6ee512c859a.jpg
             * extendData :
             * sort : 2
             */

            private String name;
            private int type;
            private int objectId;
            private ObjectData objectData;
            private String imageUrl;

            private int sort;

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

            public ObjectData getObjectData() {
                return objectData;
            }

            public void setObjectData(ObjectData objectData) {
                this.objectData = objectData;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }


            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }
    }
}