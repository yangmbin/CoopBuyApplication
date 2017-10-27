package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/10/26- 13:56
 */

public class OrderBuildResponse implements Serializable {

    /**
     * shops : [{"shopId":54,"shopName":"奈儿斯服饰专营店","shopLogoUrl":"","totoalAmount":79,"hasInvoice":false,"freightAmount":0,"products":[{"productId":766,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","skuId":6305,"imageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","quantity":1,"unitPrice":79,"specifications":"规格:XXL","properties":"属性:蓝色"}]}]
     * allTotalAmount : 79
     * totalFreightAmount : 0
     * address : {"addressId":22307,"customerName":"牛","address":"对不对不是吧","phone":"18286888293","isDefault":true,"createdTime":"2017-10-23 09:09:14","regionId":110101001001,"regionFullName":"北京市,市辖区,东城区,东华门街道办事处,多福巷社区居委会","regionFullId":"110000000000,110100000000,110101000000,110101001000,110101001001","stationUserId":null,"siteId":null,"siteName":null,"hasBindSite":false}
     */

    private int allTotalAmount;
    private int totalFreightAmount;
    private AddressBean address;
    private List<ShopsBean> shops;

    public int getAllTotalAmount() {
        return allTotalAmount;
    }

    public void setAllTotalAmount(int allTotalAmount) {
        this.allTotalAmount = allTotalAmount;
    }

    public int getTotalFreightAmount() {
        return totalFreightAmount;
    }

    public void setTotalFreightAmount(int totalFreightAmount) {
        this.totalFreightAmount = totalFreightAmount;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public List<ShopsBean> getShops() {
        return shops;
    }

    public void setShops(List<ShopsBean> shops) {
        this.shops = shops;
    }

    public static class AddressBean {
        /**
         * addressId : 22307
         * customerName : 牛
         * address : 对不对不是吧
         * phone : 18286888293
         * isDefault : true
         * createdTime : 2017-10-23 09:09:14
         * regionId : 110101001001
         * regionFullName : 北京市,市辖区,东城区,东华门街道办事处,多福巷社区居委会
         * regionFullId : 110000000000,110100000000,110101000000,110101001000,110101001001
         * stationUserId : null
         * siteId : null
         * siteName : null
         * hasBindSite : false
         */

        private int addressId;
        private String customerName;
        private String address;
        private String phone;
        private boolean isDefault;
        private String createdTime;
        private long regionId;
        private String regionFullName;
        private String regionFullId;
        private Object stationUserId;
        private Object siteId;
        private Object siteName;
        private boolean hasBindSite;

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public boolean isIsDefault() {
            return isDefault;
        }

        public void setIsDefault(boolean isDefault) {
            this.isDefault = isDefault;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public long getRegionId() {
            return regionId;
        }

        public void setRegionId(long regionId) {
            this.regionId = regionId;
        }

        public String getRegionFullName() {
            return regionFullName;
        }

        public void setRegionFullName(String regionFullName) {
            this.regionFullName = regionFullName;
        }

        public String getRegionFullId() {
            return regionFullId;
        }

        public void setRegionFullId(String regionFullId) {
            this.regionFullId = regionFullId;
        }

        public Object getStationUserId() {
            return stationUserId;
        }

        public void setStationUserId(Object stationUserId) {
            this.stationUserId = stationUserId;
        }

        public Object getSiteId() {
            return siteId;
        }

        public void setSiteId(Object siteId) {
            this.siteId = siteId;
        }

        public Object getSiteName() {
            return siteName;
        }

        public void setSiteName(Object siteName) {
            this.siteName = siteName;
        }

        public boolean isHasBindSite() {
            return hasBindSite;
        }

        public void setHasBindSite(boolean hasBindSite) {
            this.hasBindSite = hasBindSite;
        }
    }

    public static class ShopsBean implements Serializable{
        /**
         * shopId : 54
         * shopName : 奈儿斯服饰专营店
         * shopLogoUrl :
         * totoalAmount : 79
         * hasInvoice : false
         * freightAmount : 0
         * products : [{"productId":766,"productName":"维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL","skuId":6305,"imageUrl":"https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg","quantity":1,"unitPrice":79,"specifications":"规格:XXL","properties":"属性:蓝色"}]
         */

        private int shopId;
        private String shopName;
        private String shopLogoUrl;
        private int totoalAmount;
        private boolean hasInvoice;
        private int freightAmount;
        private List<ProductsBean> products;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopLogoUrl() {
            return shopLogoUrl;
        }

        public void setShopLogoUrl(String shopLogoUrl) {
            this.shopLogoUrl = shopLogoUrl;
        }

        public int getTotoalAmount() {
            return totoalAmount;
        }

        public void setTotoalAmount(int totoalAmount) {
            this.totoalAmount = totoalAmount;
        }

        public boolean isHasInvoice() {
            return hasInvoice;
        }

        public void setHasInvoice(boolean hasInvoice) {
            this.hasInvoice = hasInvoice;
        }

        public int getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(int freightAmount) {
            this.freightAmount = freightAmount;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean implements Serializable {
            /**
             * productId : 766
             * productName : 维可蔓2017春季新品长袖T恤女韩版V领蕾丝衫修身打底衫 酒红色 XXXL
             * skuId : 6305
             * imageUrl : https://oss.coopbuy.com/shop/images/7e5a9d1c-bfd3-4662-998f-602c9868f56a.jpg
             * quantity : 1
             * unitPrice : 79
             * specifications : 规格:XXL
             * properties : 属性:蓝色
             */

            private int productId;
            private String productName;
            private int skuId;
            private String imageUrl;
            private int quantity;
            private int unitPrice;
            private String specifications;
            private String properties;
            /**
             * 店铺id
             */
            private int shopId;
            /**
             * 店铺名
             */
            private String shopName;
            /**
             * 运费
             */
            private double freight;
            /**
             * 是否支持开发票
             */
            private boolean isSupportInvoice;
            private int isFirst = 2;
            //判断最后一个个 显示留言框 只有一个也是最后一个
            private String messgae;
            /**
             * 是不是最最后一个
             */
            private int isend;
            /**
             * 发票是否显示 选中状态
             */
            private String receipt;
            private boolean isReceipt;//是否可开发票

            private double orderTotalPayAmount;

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public double getFreight() {
                return freight;
            }

            public void setFreight(double freight) {
                this.freight = freight;
            }

            public boolean isSupportInvoice() {
                return isSupportInvoice;
            }

            public void setSupportInvoice(boolean supportInvoice) {
                isSupportInvoice = supportInvoice;
            }

            public int getIsFirst() {
                return isFirst;
            }

            public void setIsFirst(int isFirst) {
                this.isFirst = isFirst;
            }

            public String getMessgae() {
                return messgae;
            }

            public void setMessgae(String messgae) {
                this.messgae = messgae;
            }

            public int getIsend() {
                return isend;
            }

            public void setIsend(int isend) {
                this.isend = isend;
            }

            public String getReceipt() {
                return receipt;
            }

            public void setReceipt(String receipt) {
                this.receipt = receipt;
            }

            public boolean isReceipt() {
                return isReceipt;
            }

            public void setReceipt(boolean receipt) {
                isReceipt = receipt;
            }

            public double getOrderTotalPayAmount() {
                return orderTotalPayAmount;
            }

            public void setOrderTotalPayAmount(double orderTotalPayAmount) {
                this.orderTotalPayAmount = orderTotalPayAmount;
            }

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
        }
    }
}
