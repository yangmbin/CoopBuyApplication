package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 16:37
 * @content
 */
public class NewUserGoodsOrderRequest implements Serializable {

    /**
     * remark :
     * hasInvoice : false
     * invoiceTitle : null
     * skus : [{"skuId":2256,"quantity":4}]
     * shoppingAddressId : 6080
     */

    private String remark;
    private boolean hasInvoice;
    private Object invoiceTitle;
    private int shoppingAddressId;
    private List<SkusBean> skus;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(boolean hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    public Object getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(Object invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public int getShoppingAddressId() {
        return shoppingAddressId;
    }

    public void setShoppingAddressId(int shoppingAddressId) {
        this.shoppingAddressId = shoppingAddressId;
    }

    public List<SkusBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusBean> skus) {
        this.skus = skus;
    }

    public static class SkusBean {
        /**
         * skuId : 2256
         * quantity : 4
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
