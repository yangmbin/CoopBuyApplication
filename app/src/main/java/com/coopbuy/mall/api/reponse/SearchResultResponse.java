package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class SearchResultResponse implements Serializable {

    /**
     * result : {"totalRows":53,"startRow":0,"pageSize":20,"pageCount":3,"currentPage":1,"maxScore":null,"items":[{"productId":3204,"productName":"（爆品池）酒厂自营习酒53度方品习酒500ml","skuId":31622,"sellingPrice":109,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/01774ef8-e9a6-4438-a9ab-b566921593a3.jpg","pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL"},{"productId":3110,"productName":"酒厂自营习酒53度老习酒500ml*1瓶 酱香酒","skuId":31026,"sellingPrice":128,"sellingNumber":14,"imageUrl":"https://oss.coopbuy.com/shop/images/ca711ade-3a00-4744-b8a6-99a7a30e1910.jpg"},{"productId":3227,"productName":"（爆品池）云的/呢喃杨梅青梅酒果味水果酒男女士梅子酒5度低度甜酒 2支","skuId":31878,"sellingPrice":38.6,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/c9d40e14-3e8d-4db1-8344-e0af981693cc.jpg"},{"productId":3224,"productName":"（爆品池）醉梦红酒 法国原瓶进口红酒双支歌瑞安干红葡萄酒送醒酒器酒杯","skuId":31875,"sellingPrice":49.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/9a4f168d-42aa-492c-a052-973eeaf19698.jpg"},{"productId":3223,"productName":"（爆品池）法国原瓶进口红酒礼盒罗莎庄园心醉红葡萄酒送礼2支礼盒装750ml*2","skuId":31785,"sellingPrice":99,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/627a2e30-e262-4d84-bb29-5b8689e915e3.jpg"},{"productId":3225,"productName":"（爆品池）法国正品红酒原瓶原装进口红酒罗莎乐贝干红葡萄酒红酒整箱6支装","skuId":31876,"sellingPrice":119.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/14795b34-402f-4453-b8ea-17c5641bcb28.jpg"},{"productId":3210,"productName":"（爆品池）国产原浆酒封印5L桶装泡药散酒贵州53度高梁纯粮食高度酱香型白酒 ","skuId":31659,"sellingPrice":149,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/e458f130-9eeb-443a-82f1-b4634721e114.jpg"},{"productId":3203,"productName":"（爆品池）江小白深夜食堂同款酒国产白酒粮食高粱酒清香型40度150mL*6瓶","skuId":31597,"sellingPrice":119,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/830d5397-edcc-4892-bfa1-e510b9a3ebf8.jpg"},{"productId":3202,"productName":"（爆品池）江小白深夜食堂同款酒国产高粱白酒粮食酒小酒45度100ml*6瓶箱装","skuId":31596,"sellingPrice":99,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/86ceab4a-b528-405b-8c22-91d5814c12b6.jpg"},{"productId":766,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","skuId":6303,"pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL","sellingPrice":79,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg"},{"productId":988,"productName":"维可蔓衬衫女2017夏装新款女装韩版休闲百搭白色短袖衬衣女 酒红色 L","skuId":9499,"pricePropertyValue":"酒红","priceSpecificationsValue":"XXXL","sellingPrice":88,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/74f5022e-4deb-4e74-aa57-bea0799548c9.jpg"},{"productId":586,"productName":"维可蔓连衣裙长袖2017连衣裙长袖2017春装新款修身显瘦下摆开叉蕾丝袖拼接包臀打底裙 酒红色 XL","skuId":4739,"pricePropertyValue":"酒红色","priceSpecificationsValue":"S","sellingPrice":128,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/93d8a5d8-930f-47f8-87cb-2c662a6549ff.jpg"},{"productId":598,"productName":"维可蔓雪纺衫女2017春装新品宽松显瘦收腰上衣百搭修身长袖T恤打底衫 酒红色 M","skuId":4801,"pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL","sellingPrice":95,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/07e7a320-e9b1-4879-b053-b1ea0a036c28.jpg"},{"productId":1178,"productName":"珍真羊zhenzhenyang 妈妈外套春秋新款中老年女装中长款长袖开衫大码显瘦品牌女装上衣酒红2X","skuId":12047,"pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL","sellingPrice":218,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/6e26f5bf-c50f-4e62-99ce-6984c6ba0cf6.jpg"},{"productId":3230,"productName":"（爆品池）送2个香槟杯 女士型红酒双支白起泡气泡酒半甜型果酒葡萄酒2支装","skuId":31881,"sellingPrice":59.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/edf93bb0-f5cd-4a00-8ce5-4fe9060e56e0.jpg"},{"productId":3206,"productName":"（爆品池）甜酒酿农家自酿糯米酒正宗原浆米酒汁客家娘酒月子米酒水黄酒特产","skuId":31651,"sellingPrice":39.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/f69adaa9-3e9f-4fa8-a833-86b13019606d.jpg"},{"productId":3207,"productName":"（爆品池）窝窝酒酿醪糟米酒糯米酒酿蛋农家自酿月子酒水产后瓶四川特产608g","skuId":31652,"sellingPrice":25.8,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/1f2b62b4-86f7-4200-83eb-8a2fe9a484ed.jpg"},{"productId":3228,"productName":"（爆品池）RIO锐澳3.8度微醺炫彩鸡尾酒套餐预调酒275ml*6支瓶套装果酒洋酒","skuId":31879,"sellingPrice":75,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/660c5156-483c-4534-ad9d-765d1c377d30.jpg"},{"productId":3209,"productName":"（爆品池）贵州纯粮食53°原浆酒高度酱香型白酒 桶装5000ml自酿高粱散酒","skuId":31658,"sellingPrice":128,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/e112fe77-7229-427b-bde6-db4745ba3c00.jpg"},{"productId":1260,"productName":"2017夏装新款棉质短袖圆领T恤女欧洲站休闲宽松大码打底衫体恤酒红色M","skuId":13295,"pricePropertyValue":"黑色","priceSpecificationsValue":"XXL","sellingPrice":19.9,"sellingNumber":3,"imageUrl":"https://oss.coopbuy.com/shop/images/986cc8dc-7121-4835-bf24-b9a75ae01d4e.jpg"}]}
     * facetResults : [{"statistics":[{"name":" 白酒","friendlyName":" 白酒","count":7},{"name":" 女士裙装","friendlyName":" 女士裙装","count":6},{"name":" 女士T恤","friendlyName":" 女士T恤","count":5},{"name":" 女士休闲装","friendlyName":" 女士休闲装","count":4},{"name":" 妈妈鞋","friendlyName":" 妈妈鞋","count":4},{"name":" 洋酒","friendlyName":" 洋酒","count":4},{"name":" 乒羽网鞋","friendlyName":" 乒羽网鞋","count":3},{"name":" 男士西装","friendlyName":" 男士西装","count":3},{"name":" 葡萄酒","friendlyName":" 葡萄酒","count":3},{"name":" 衬衫","friendlyName":" 衬衫","count":3},{"name":"休闲装","friendlyName":"休闲装","count":3},{"name":" 黄酒养生酒","friendlyName":" 黄酒养生酒","count":2},{"name":" 卫衣外套","friendlyName":" 卫衣外套","count":1},{"name":" 大衣外套","friendlyName":" 大衣外套","count":1},{"name":" 女士衬衫","friendlyName":" 女士衬衫","count":1},{"name":" 抱枕靠垫","friendlyName":" 抱枕靠垫","count":1},{"name":" 炒锅","friendlyName":" 炒锅","count":1},{"name":" 针织衫","friendlyName":" 针织衫","count":1}],"name":"lastCategoryName","friendlyName":"三级分类","count":53}]
     * statistics : []
     * groups : []
     */

    private ResultBean result;
    private List<FacetResultsBean> facetResults;
    private List<?> statistics;
    private List<?> groups;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<FacetResultsBean> getFacetResults() {
        return facetResults;
    }

    public void setFacetResults(List<FacetResultsBean> facetResults) {
        this.facetResults = facetResults;
    }

    public List<?> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<?> statistics) {
        this.statistics = statistics;
    }

    public List<?> getGroups() {
        return groups;
    }

    public void setGroups(List<?> groups) {
        this.groups = groups;
    }

    public static class ResultBean {
        /**
         * totalRows : 53
         * startRow : 0
         * pageSize : 20
         * pageCount : 3
         * currentPage : 1
         * maxScore : null
         * items : [{"productId":3204,"productName":"（爆品池）酒厂自营习酒53度方品习酒500ml","skuId":31622,"sellingPrice":109,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/01774ef8-e9a6-4438-a9ab-b566921593a3.jpg"},{"productId":3110,"productName":"酒厂自营习酒53度老习酒500ml*1瓶 酱香酒","skuId":31026,"sellingPrice":128,"sellingNumber":14,"imageUrl":"https://oss.coopbuy.com/shop/images/ca711ade-3a00-4744-b8a6-99a7a30e1910.jpg"},{"productId":3227,"productName":"（爆品池）云的/呢喃杨梅青梅酒果味水果酒男女士梅子酒5度低度甜酒 2支","skuId":31878,"sellingPrice":38.6,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/c9d40e14-3e8d-4db1-8344-e0af981693cc.jpg"},{"productId":3224,"productName":"（爆品池）醉梦红酒 法国原瓶进口红酒双支歌瑞安干红葡萄酒送醒酒器酒杯","skuId":31875,"sellingPrice":49.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/9a4f168d-42aa-492c-a052-973eeaf19698.jpg"},{"productId":3223,"productName":"（爆品池）法国原瓶进口红酒礼盒罗莎庄园心醉红葡萄酒送礼2支礼盒装750ml*2","skuId":31785,"sellingPrice":99,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/627a2e30-e262-4d84-bb29-5b8689e915e3.jpg"},{"productId":3225,"productName":"（爆品池）法国正品红酒原瓶原装进口红酒罗莎乐贝干红葡萄酒红酒整箱6支装","skuId":31876,"sellingPrice":119.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/14795b34-402f-4453-b8ea-17c5641bcb28.jpg"},{"productId":3210,"productName":"（爆品池）国产原浆酒封印5L桶装泡药散酒贵州53度高梁纯粮食高度酱香型白酒 ","skuId":31659,"sellingPrice":149,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/e458f130-9eeb-443a-82f1-b4634721e114.jpg"},{"productId":3203,"productName":"（爆品池）江小白深夜食堂同款酒国产白酒粮食高粱酒清香型40度150mL*6瓶","skuId":31597,"sellingPrice":119,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/830d5397-edcc-4892-bfa1-e510b9a3ebf8.jpg"},{"productId":3202,"productName":"（爆品池）江小白深夜食堂同款酒国产高粱白酒粮食酒小酒45度100ml*6瓶箱装","skuId":31596,"sellingPrice":99,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/86ceab4a-b528-405b-8c22-91d5814c12b6.jpg"},{"productId":766,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","skuId":6303,"pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL","sellingPrice":79,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg"},{"productId":988,"productName":"维可蔓衬衫女2017夏装新款女装韩版休闲百搭白色短袖衬衣女 酒红色 L","skuId":9499,"pricePropertyValue":"酒红","priceSpecificationsValue":"XXXL","sellingPrice":88,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/74f5022e-4deb-4e74-aa57-bea0799548c9.jpg"},{"productId":586,"productName":"维可蔓连衣裙长袖2017连衣裙长袖2017春装新款修身显瘦下摆开叉蕾丝袖拼接包臀打底裙 酒红色 XL","skuId":4739,"pricePropertyValue":"酒红色","priceSpecificationsValue":"S","sellingPrice":128,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/93d8a5d8-930f-47f8-87cb-2c662a6549ff.jpg"},{"productId":598,"productName":"维可蔓雪纺衫女2017春装新品宽松显瘦收腰上衣百搭修身长袖T恤打底衫 酒红色 M","skuId":4801,"pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL","sellingPrice":95,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/07e7a320-e9b1-4879-b053-b1ea0a036c28.jpg"},{"productId":1178,"productName":"珍真羊zhenzhenyang 妈妈外套春秋新款中老年女装中长款长袖开衫大码显瘦品牌女装上衣酒红2X","skuId":12047,"pricePropertyValue":"酒红色","priceSpecificationsValue":"XXL","sellingPrice":218,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/6e26f5bf-c50f-4e62-99ce-6984c6ba0cf6.jpg"},{"productId":3230,"productName":"（爆品池）送2个香槟杯 女士型红酒双支白起泡气泡酒半甜型果酒葡萄酒2支装","skuId":31881,"sellingPrice":59.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/edf93bb0-f5cd-4a00-8ce5-4fe9060e56e0.jpg"},{"productId":3206,"productName":"（爆品池）甜酒酿农家自酿糯米酒正宗原浆米酒汁客家娘酒月子米酒水黄酒特产","skuId":31651,"sellingPrice":39.9,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/f69adaa9-3e9f-4fa8-a833-86b13019606d.jpg"},{"productId":3207,"productName":"（爆品池）窝窝酒酿醪糟米酒糯米酒酿蛋农家自酿月子酒水产后瓶四川特产608g","skuId":31652,"sellingPrice":25.8,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/1f2b62b4-86f7-4200-83eb-8a2fe9a484ed.jpg"},{"productId":3228,"productName":"（爆品池）RIO锐澳3.8度微醺炫彩鸡尾酒套餐预调酒275ml*6支瓶套装果酒洋酒","skuId":31879,"sellingPrice":75,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/660c5156-483c-4534-ad9d-765d1c377d30.jpg"},{"productId":3209,"productName":"（爆品池）贵州纯粮食53°原浆酒高度酱香型白酒 桶装5000ml自酿高粱散酒","skuId":31658,"sellingPrice":128,"sellingNumber":0,"imageUrl":"https://oss.coopbuy.com/shop/images/e112fe77-7229-427b-bde6-db4745ba3c00.jpg"},{"productId":1260,"productName":"2017夏装新款棉质短袖圆领T恤女欧洲站休闲宽松大码打底衫体恤酒红色M","skuId":13295,"pricePropertyValue":"黑色","priceSpecificationsValue":"XXL","sellingPrice":19.9,"sellingNumber":3,"imageUrl":"https://oss.coopbuy.com/shop/images/986cc8dc-7121-4835-bf24-b9a75ae01d4e.jpg"}]
         */

        private int totalRows;
        private int startRow;
        private int pageSize;
        private int pageCount;
        private int currentPage;
        private Object maxScore;
        private List<ItemsBean> items;

        public int getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(int totalRows) {
            this.totalRows = totalRows;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public Object getMaxScore() {
            return maxScore;
        }

        public void setMaxScore(Object maxScore) {
            this.maxScore = maxScore;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * productId : 3204
             * productName : （爆品池）酒厂自营习酒53度方品习酒500ml
             * skuId : 31622
             * sellingPrice : 109.0
             * sellingNumber : 0
             * imageUrl : https://oss.coopbuy.com/shop/images/01774ef8-e9a6-4438-a9ab-b566921593a3.jpg
             * pricePropertyValue : 酒红色
             * priceSpecificationsValue : XXL
             */

            private int productId;
            private String productName;
            private int skuId;
            private double sellingPrice;
            private int sellingNumber;
            private String imageUrl;
            private String pricePropertyValue;
            private String priceSpecificationsValue;

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

            public double getSellingPrice() {
                return sellingPrice;
            }

            public void setSellingPrice(double sellingPrice) {
                this.sellingPrice = sellingPrice;
            }

            public int getSellingNumber() {
                return sellingNumber;
            }

            public void setSellingNumber(int sellingNumber) {
                this.sellingNumber = sellingNumber;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
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
        }
    }

    public static class FacetResultsBean {
        /**
         * statistics : [{"name":" 白酒","friendlyName":" 白酒","count":7},{"name":" 女士裙装","friendlyName":" 女士裙装","count":6},{"name":" 女士T恤","friendlyName":" 女士T恤","count":5},{"name":" 女士休闲装","friendlyName":" 女士休闲装","count":4},{"name":" 妈妈鞋","friendlyName":" 妈妈鞋","count":4},{"name":" 洋酒","friendlyName":" 洋酒","count":4},{"name":" 乒羽网鞋","friendlyName":" 乒羽网鞋","count":3},{"name":" 男士西装","friendlyName":" 男士西装","count":3},{"name":" 葡萄酒","friendlyName":" 葡萄酒","count":3},{"name":" 衬衫","friendlyName":" 衬衫","count":3},{"name":"休闲装","friendlyName":"休闲装","count":3},{"name":" 黄酒养生酒","friendlyName":" 黄酒养生酒","count":2},{"name":" 卫衣外套","friendlyName":" 卫衣外套","count":1},{"name":" 大衣外套","friendlyName":" 大衣外套","count":1},{"name":" 女士衬衫","friendlyName":" 女士衬衫","count":1},{"name":" 抱枕靠垫","friendlyName":" 抱枕靠垫","count":1},{"name":" 炒锅","friendlyName":" 炒锅","count":1},{"name":" 针织衫","friendlyName":" 针织衫","count":1}]
         * name : lastCategoryName
         * friendlyName : 三级分类
         * count : 53
         */

        private String name;
        private String friendlyName;
        private int count;
        private List<StatisticsBean> statistics;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFriendlyName() {
            return friendlyName;
        }

        public void setFriendlyName(String friendlyName) {
            this.friendlyName = friendlyName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<StatisticsBean> getStatistics() {
            return statistics;
        }

        public void setStatistics(List<StatisticsBean> statistics) {
            this.statistics = statistics;
        }

        public static class StatisticsBean {
            /**
             * name :  白酒
             * friendlyName :  白酒
             * count : 7
             */

            private String name;
            private String friendlyName;
            private int count;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFriendlyName() {
                return friendlyName;
            }

            public void setFriendlyName(String friendlyName) {
                this.friendlyName = friendlyName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
