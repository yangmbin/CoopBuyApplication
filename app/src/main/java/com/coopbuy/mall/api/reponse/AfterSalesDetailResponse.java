package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class AfterSalesDetailResponse implements Serializable {

    /**
     * tradeNode : [{"text":"退款申请已经提交，等待商家审核","time":"2017-11-03:14:42:50","remark":"若长时间未通过，请联系商家进行协商"}]
     * products : [{"skuId":16,"productName":"测试商品1","productImageUrl":"https://oss.coopbuy.com/Content/images/photo_icon.png","quantity":1,"unitPrice":0.1,"specifications":"","properties":""}]
     * applyNodes : [{"text":"用户申请退款","time":"2017-09-14:10:38:04","remark":""}]
     * reason : 空包裹
     * explain : 哈哈哈哈
     * applyTime : 2017-09-14 10:38:04
     * applyAmount : 0.1
     * status : 1
     * statusName : 待商家审核
     * auditorRemark :
     * applyQuantity : 1
     * finishTime :
     * address :
     * consignerName : 商家
     * consignerTel : 13366668888
     * applyNo : 201709142424081
     * canReApply : false
     * canCancelApply : true
     * canUpdateReturnGoods : false
     * waybillNo :
     * shippingCompany :
     * companyCode :
     * cargoInfo : {"text":"","time":""}
     */

    private String reason;
    private String explain;
    private String applyTime;
    private double applyAmount;
    private int status;
    private String statusName;
    private String auditorRemark;
    private int applyQuantity;
    private String finishTime;
    private String address;
    private String consignerName;
    private String consignerTel;
    private String applyNo;
    private boolean canReApply;
    private boolean canCancelApply;
    private boolean canUpdateReturnGoods;
    private String waybillNo;
    private String shippingCompany;
    private String companyCode;
    private CargoInfoBean cargoInfo;
    private String shopName;
    private List<TradeNodeBean> tradeNode;
    private List<ProductsBean> products;
    private List<ApplyNodesBean> applyNodes;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAuditorRemark() {
        return auditorRemark;
    }

    public void setAuditorRemark(String auditorRemark) {
        this.auditorRemark = auditorRemark;
    }

    public int getApplyQuantity() {
        return applyQuantity;
    }

    public void setApplyQuantity(int applyQuantity) {
        this.applyQuantity = applyQuantity;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignerName() {
        return consignerName;
    }

    public void setConsignerName(String consignerName) {
        this.consignerName = consignerName;
    }

    public String getConsignerTel() {
        return consignerTel;
    }

    public void setConsignerTel(String consignerTel) {
        this.consignerTel = consignerTel;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public boolean isCanReApply() {
        return canReApply;
    }

    public void setCanReApply(boolean canReApply) {
        this.canReApply = canReApply;
    }

    public boolean isCanCancelApply() {
        return canCancelApply;
    }

    public void setCanCancelApply(boolean canCancelApply) {
        this.canCancelApply = canCancelApply;
    }

    public boolean isCanUpdateReturnGoods() {
        return canUpdateReturnGoods;
    }

    public void setCanUpdateReturnGoods(boolean canUpdateReturnGoods) {
        this.canUpdateReturnGoods = canUpdateReturnGoods;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public CargoInfoBean getCargoInfo() {
        return cargoInfo;
    }

    public void setCargoInfo(CargoInfoBean cargoInfo) {
        this.cargoInfo = cargoInfo;
    }

    public List<TradeNodeBean> getTradeNode() {
        return tradeNode;
    }

    public void setTradeNode(List<TradeNodeBean> tradeNode) {
        this.tradeNode = tradeNode;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public List<ApplyNodesBean> getApplyNodes() {
        return applyNodes;
    }

    public void setApplyNodes(List<ApplyNodesBean> applyNodes) {
        this.applyNodes = applyNodes;
    }

    public static class CargoInfoBean {
        /**
         * text :
         * time :
         */

        private String text;
        private String time;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class TradeNodeBean {
        /**
         * text : 退款申请已经提交，等待商家审核
         * time : 2017-11-03:14:42:50
         * remark : 若长时间未通过，请联系商家进行协商
         */

        private String text;
        private String time;
        private String remark;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public static class ProductsBean {
        /**
         * skuId : 16
         * productName : 测试商品1
         * productImageUrl : https://oss.coopbuy.com/Content/images/photo_icon.png
         * quantity : 1
         * unitPrice : 0.1
         * specifications :
         * properties :
         */

        private int skuId;
        private String productName;
        private String productImageUrl;
        private int quantity;
        private double unitPrice;
        private String specifications;
        private String properties;

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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
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

    public static class ApplyNodesBean {
        /**
         * text : 用户申请退款
         * time : 2017-09-14:10:38:04
         * remark :
         */

        private String text;
        private String time;
        private String remark;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
