package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 10:45
 * @content
 */
public class GetActivePageDataResponse  implements Serializable{

    /**
     * name : string
     * items : [{"goodsId":"string","imgPath":"string","limCount":0}]
     */

    private String name;
    private List<ItemsBean> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * goodsId : string
         * imgPath : string
         * limCount : 0
         */

        private String goodsId;
        private String imgPath;
        private int limCount;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public int getLimCount() {
            return limCount;
        }

        public void setLimCount(int limCount) {
            this.limCount = limCount;
        }
    }
}
