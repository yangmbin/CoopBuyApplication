package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/27- 16:54
 */

public class ShopStoreReponse implements Serializable {

    /**
     * totalCount : 2
     * items : [{"shopName":"美厨厨具旗舰店","createTime":"2017-10-27 16:04:18","shopId":29,"logoImageUrl":""},{"shopName":"生活日用专营店","createTime":"2017-10-27 16:04:14","shopId":27,"logoImageUrl":""}]
     */

    private int totalCount;
    private List<ItemsBean> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean  implements Serializable{
        /**
         * shopName : 美厨厨具旗舰店
         * createTime : 2017-10-27 16:04:18
         * shopId : 29
         * logoImageUrl :
         */

        private String shopName;
        private String createTime;
        private int shopId;
        private String logoImageUrl;

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getLogoImageUrl() {
            return logoImageUrl;
        }

        public void setLogoImageUrl(String logoImageUrl) {
            this.logoImageUrl = logoImageUrl;
        }
    }
}
