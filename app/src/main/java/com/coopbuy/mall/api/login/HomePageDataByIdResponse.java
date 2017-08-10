package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 13:50
 * @content
 */
public class HomePageDataByIdResponse implements Serializable {

    /**
     * "imageUrl":"/shop/images/1c7b4ac3-599e-4096-8e20-dc6b5277a0af.jpg","extendData":{},"sort":38},{"name":"（爆品池）夏季大码宽松白色V
     * id : 35
     */

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

        public static class FloorItemsBean {
            /**
             * name : （爆品池）新款夏季韩版时尚印花T恤中长款网纱裙两件套连衣裙
             * type : 0
             * objectId : 2354
             * objectData : {"goodsName":"（爆品池）新款夏季韩版时尚印花T恤中长款网纱裙两件套连衣裙","promotionDesc":"","sellingPrice":79,"imageUrl":"/shop/images/ba58178c-b4ca-4310-8e52-2623a38c8ad7.jpg","sellingNumber":0}
             * imageUrl : /shop/images/ba58178c-b4ca-4310-8e52-2623a38c8ad7.jpg
             * extendData : {}
             * sort : 0
             */

            private String name;
            private int type;
            private int objectId;
            private ObjectDataBean objectData;
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

            public ObjectDataBean getObjectData() {
                return objectData;
            }

            public void setObjectData(ObjectDataBean objectData) {
                this.objectData = objectData;
            }

            public static class ObjectDataBean {

                /**
                 * goodsName : （爆品池）新款夏季韩版时尚印花T恤中长款网纱裙两件套连衣裙
                 * promotionDesc :
                 * sellingPrice : 79
                 * imageUrl : /shop/images/ba58178c-b4ca-4310-8e52-2623a38c8ad7.jpg
                 * sellingNumber : 0
                 */

                private String goodsName;
                private String promotionDesc;
                private int sellingPrice;
                private String imageUrl;
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

                public int getSellingPrice() {
                    return sellingPrice;
                }

                public void setSellingPrice(int sellingPrice) {
                    this.sellingPrice = sellingPrice;
                }

                public String getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public int getSellingNumber() {
                    return sellingNumber;
                }

                public void setSellingNumber(int sellingNumber) {
                    this.sellingNumber = sellingNumber;
                }
            }

            public static class ExtendDataBean {
            }
        }
    }
}
