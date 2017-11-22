package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/22- 11:05
 */

public class SystemMegResponse implements Serializable {

    /**
     * totalCount : 0
     * items : [{"title":"string","content":"string","coverImage":"string","messageType":0,"sendTime":"2017-11-22T02:50:36.346Z","isRead":true,"item":{"orderId":"string","refundNo":"string","waybillNo":"string","shippingCompany":"string","companyCode":"string","skuId":0,"productName":"string","productImageUrl":"string","specifications":"string","properties":"string"}}]
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

    public static class ItemsBean implements Serializable {
        /**
         * title : string
         * content : string
         * coverImage : string
         * messageType : 0
         * sendTime : 2017-11-22T02:50:36.346Z
         * isRead : true
         * item : {"orderId":"string","refundNo":"string","waybillNo":"string","shippingCompany":"string","companyCode":"string","skuId":0,"productName":"string","productImageUrl":"string","specifications":"string","properties":"string"}
         */
        private int messageId;
        private String title;
        private String content;
        private String coverImage;
        private int messageType;
        private String sendTime;
        private boolean isRead;
        private ItemBean item;

        public int getMessageId() {
            return messageId;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public boolean isIsRead() {
            return isRead;
        }

        public void setIsRead(boolean isRead) {
            this.isRead = isRead;
        }

        public ItemBean getItem() {
            return item;
        }

        public void setItem(ItemBean item) {
            this.item = item;
        }

        public static class ItemBean implements Serializable {
            /**
             * orderId : string
             * refundNo : string
             * waybillNo : string
             * shippingCompany : string
             * companyCode : string
             * skuId : 0
             * productName : string
             * productImageUrl : string
             * specifications : string
             * properties : string
             */

            private String orderId;
            private String refundNo;
            private String waybillNo;
            private String shippingCompany;
            private String companyCode;
            private int skuId;
            private String productName;
            private String productImageUrl;
            private String specifications;
            private String properties;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getRefundNo() {
                return refundNo;
            }

            public void setRefundNo(String refundNo) {
                this.refundNo = refundNo;
            }

            public String getWaybillNo() {
                return waybillNo;
            }

            public void setWaybillNo(String waybillNo) {
                this.waybillNo = waybillNo;
            }

            public String getShippingCompany() {
                return shippingCompany;
            }

            public void setShippingCompany(String shippingCompany) {
                this.shippingCompany = shippingCompany;
            }

            public String getCompanyCode() {
                return companyCode;
            }

            public void setCompanyCode(String companyCode) {
                this.companyCode = companyCode;
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
}
