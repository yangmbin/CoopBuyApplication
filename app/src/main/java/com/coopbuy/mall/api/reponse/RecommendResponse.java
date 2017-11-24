package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/24- 15:06
 */

public class RecommendResponse implements Serializable {

    /**
     * time : 2017-11-24
     * products : [{"skuId":6526,"productName":"维可蔓长袖连衣裙2017春装新款韩版修身显瘦雪纺袖拼接下摆开叉包臀打底连衣裙 墨绿色 XL","productImageUrl":"https://oss.coopbuy.com/shop/images/f5256095-60c7-4b04-821b-6f40859a0b06.jpg","unitPrice":128,"specifications":"规格:XL","properties":"属性:墨绿色","salesNumber":0},{"skuId":111,"productName":"【十八子作】锻打木柄厨片刀切片刀厨师用刀不锈钢菜刀厨刀 P1大号(厨师专用)","productImageUrl":"https://oss.coopbuy.com/shop/images/048888d9-afb3-4e5b-9545-adf110de3f6e.jpg","unitPrice":133,"specifications":"","properties":"属性:P2小号","salesNumber":0},{"skuId":589,"productName":"歌诺瑞丝2017春季女装新款韩版宽松显瘦V领T恤女9925","productImageUrl":"https://oss.coopbuy.com/shop/images/58496375-eb75-4fe1-95af-b6051ef4f8a9.jpg","unitPrice":69.9,"specifications":"规格:XL","properties":"属性:白色","salesNumber":0},{"skuId":375,"productName":"【十八子作】流光潜舰五铬钢套刀多功能厨房刀具套装 S1021七件套","productImageUrl":"https://oss.coopbuy.com/shop/images/6127dfc7-d266-4b21-a75d-0cedaea2dd4c.jpg","unitPrice":0.01,"specifications":"","properties":"","salesNumber":13}]
     */

    private String time;
    private List<ProductsBean> products;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean implements Serializable {
        /**
         * skuId : 6526
         * productName : 维可蔓长袖连衣裙2017春装新款韩版修身显瘦雪纺袖拼接下摆开叉包臀打底连衣裙 墨绿色 XL
         * productImageUrl : https://oss.coopbuy.com/shop/images/f5256095-60c7-4b04-821b-6f40859a0b06.jpg
         * unitPrice : 128
         * specifications : 规格:XL
         * properties : 属性:墨绿色
         * salesNumber : 0
         */

        private int skuId;
        private String productName;
        private String productImageUrl;
        private int unitPrice;
        private String specifications;
        private String properties;
        private int salesNumber;
        private String time;
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
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

        public String getProductImageUrl() {
            return productImageUrl;
        }

        public void setProductImageUrl(String productImageUrl) {
            this.productImageUrl = productImageUrl;
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

        public int getSalesNumber() {
            return salesNumber;
        }

        public void setSalesNumber(int salesNumber) {
            this.salesNumber = salesNumber;
        }
    }
}
