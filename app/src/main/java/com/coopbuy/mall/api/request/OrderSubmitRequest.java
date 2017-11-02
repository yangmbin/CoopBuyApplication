package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/2- 10:41
 */

public class OrderSubmitRequest implements Serializable {

    /**
     * addressId : 0
     * customerId : 0
     * shops : [{"hasInvoice":true,"invoiceTitle":"string","remark":"string","skus":[{"skuId":0,"quantity":0}]}]
     */

    private int addressId;
    private int customerId;
    /**
     * 带参数到支付页面 商品总价格和数量
     */
    private String totalPrice;
    private int goodsCounts;
    private List<ShopsBean> shops;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getGoodsCounts() {

        return goodsCounts;
    }

    public void setGoodsCounts(int goodsCounts) {
        this.goodsCounts = goodsCounts;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<ShopsBean> getShops() {
        return shops;
    }

    public void setShops(List<ShopsBean> shops) {
        this.shops = shops;
    }

    public static class ShopsBean implements Serializable {
        /**
         * hasInvoice : true
         * invoiceTitle : string
         * remark : string
         * skus : [{"skuId":0,"quantity":0}]
         */

        private boolean hasInvoice;
        private String invoiceTitle;
        private String remark;
        private List<SkusBean> skus;

        public boolean isHasInvoice() {
            return hasInvoice;
        }

        public void setHasInvoice(boolean hasInvoice) {
            this.hasInvoice = hasInvoice;
        }

        public String getInvoiceTitle() {
            return invoiceTitle;
        }

        public void setInvoiceTitle(String invoiceTitle) {
            this.invoiceTitle = invoiceTitle;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public List<SkusBean> getSkus() {
            return skus;
        }

        public void setSkus(List<SkusBean> skus) {
            this.skus = skus;
        }

        public static class SkusBean implements Serializable {
            /**
             * skuId : 0
             * quantity : 0
             */

            private int skuId;
            private int quantity;

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }
    }
}
