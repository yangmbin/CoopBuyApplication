package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/10/27 16:45
 */
public class ExpressInfoResponse implements Serializable {

    /**
     * orderId : string
     * waybillNo : string
     * shippingCompany : string
     * productImageUrl : string
     * statusName : string
     * status : 0
     * nodes : [{"acceptTime":"string","acceptStation":"string","remark":"string"}]
     */

    private String orderId;
    private String waybillNo;
    private String shippingCompany;
    private String productImageUrl;
    private String statusName;
    private int status;
    private List<NodesBean> nodes;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<NodesBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesBean> nodes) {
        this.nodes = nodes;
    }

    public static class NodesBean {
        /**
         * acceptTime : string
         * acceptStation : string
         * remark : string
         */

        private String acceptTime;
        private String acceptStation;
        private String remark;

        public String getAcceptTime() {
            return acceptTime;
        }

        public void setAcceptTime(String acceptTime) {
            this.acceptTime = acceptTime;
        }

        public String getAcceptStation() {
            return acceptStation;
        }

        public void setAcceptStation(String acceptStation) {
            this.acceptStation = acceptStation;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
