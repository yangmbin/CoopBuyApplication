package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/9 0009 11:44
 * @content
 */
public class NetOrderResponse implements Serializable {

    /**
     * rowCount : 0
     * pageCount : 0
     * currentPage : 0
     * pageSize : 0
     * items : [{"id":0,"orderDate":"2017-08-09T01:41:09.558Z","statusName":"string","shopName":"string","userId":0,"userName":"string","freight":0,"productTotalAmount":0,"orderItems":[{"sku":"string","quantity":0,"salePrice":0,"productName":"string","color":"string","size":"string","version":"string","thumbnailsUrl":"string"}]}]
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
         * id : 0
         * orderDate : 2017-08-09T01:41:09.558Z
         * statusName : string
         * shopName : string
         * userId : 0
         * userName : string
         * freight : 0
         * productTotalAmount : 0
         * orderItems : [{"sku":"string","quantity":0,"salePrice":0,"productName":"string","color":"string","size":"string","version":"string","thumbnailsUrl":"string"}]
         */

        private int id;
        private String orderDate;
        private String statusName;
        private String shopName;
        private int userId;
        private String userName;
        private int freight;
        private int productTotalAmount;
        private List<OrderItemsBean> orderItems;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public int getProductTotalAmount() {
            return productTotalAmount;
        }

        public void setProductTotalAmount(int productTotalAmount) {
            this.productTotalAmount = productTotalAmount;
        }

        public List<OrderItemsBean> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItemsBean> orderItems) {
            this.orderItems = orderItems;
        }

        public static class OrderItemsBean {
            /**
             * sku : string
             * quantity : 0
             * salePrice : 0
             * productName : string
             * color : string
             * size : string
             * version : string
             * thumbnailsUrl : string
             */

            private String sku;
            private int quantity;
            private int salePrice;
            private String productName;
            private String color;
            private String size;
            private String version;
            private String thumbnailsUrl;

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(int salePrice) {
                this.salePrice = salePrice;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getThumbnailsUrl() {
                return thumbnailsUrl;
            }

            public void setThumbnailsUrl(String thumbnailsUrl) {
                this.thumbnailsUrl = thumbnailsUrl;
            }
        }
    }
}
