package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 14:09
 * @content
 */
public class RefundListResponse implements Serializable{

    /**
     * rowCount : 0
     * pageCount : 0
     * currentPage : 0
     * pageSize : 0
     * items : [{"id":"string","shopName":"string","goodsName":"string","imageUrl":"string","quantity":0,"unitPrice":0,"specifications":"string","properties":"string","amount":0,"isNeedReturnGoods":true,"applyStatus":0,"applyStatusName":"string"}]
     */

    private int rowCount;
    private int pageCount;
    private int currentPage;
    private int pageSize;
    private List<ItemsBean> items;

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : string
         * shopName : string
         * goodsName : string
         * imageUrl : string
         * quantity : 0
         * unitPrice : 0
         * specifications : string
         * properties : string
         * amount : 0
         * isNeedReturnGoods : true
         * applyStatus : 0
         * applyStatusName : string
         */

        private String id;
        private String shopName;
        private String goodsName;
        private String imageUrl;
        private int quantity;
        private int unitPrice;
        private String specifications;
        private String properties;
        private int amount;
        private boolean isNeedReturnGoods;
        private int applyStatus;
        private String applyStatusName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
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

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public boolean isIsNeedReturnGoods() {
            return isNeedReturnGoods;
        }

        public void setIsNeedReturnGoods(boolean isNeedReturnGoods) {
            this.isNeedReturnGoods = isNeedReturnGoods;
        }

        public int getApplyStatus() {
            return applyStatus;
        }

        public void setApplyStatus(int applyStatus) {
            this.applyStatus = applyStatus;
        }

        public String getApplyStatusName() {
            return applyStatusName;
        }

        public void setApplyStatusName(String applyStatusName) {
            this.applyStatusName = applyStatusName;
        }
    }
}
