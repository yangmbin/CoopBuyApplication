package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/21- 14:53
 */

public class CustomOrderDetailReponse implements Serializable {

    /**
     * orderId : string
     * orderStatus : 0
     * orderStatusName : string
     * freightAmount : 0
     * totalAmount : 0
     * orderAmount : 0
     * consignerName : string
     * consignerTel : string
     * consignerAddress : string
     * regionId : 0
     * regionName : string
     * createTime : 2017-11-21T01:48:51.736Z
     * paymentTime : 2017-11-21T01:48:51.736Z
     * shipmentTime : 2017-11-21T01:48:51.736Z
     * cargoInfo : {"text":"string","time":"string"}
     */

    private String orderId;
    private int orderStatus;
    private String orderStatusName;
    private int freightAmount;
    private int totalAmount;
    private int orderAmount;
    private String consignerName;
    private String consignerTel;
    private String consignerAddress;
    private int regionId;
    private String regionName;
    private String createTime;
    private String paymentTime;
    private String shipmentTime;
    private CargoInfoBean cargoInfo;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public int getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(int freightAmount) {
        this.freightAmount = freightAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
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

    public String getConsignerAddress() {
        return consignerAddress;
    }

    public void setConsignerAddress(String consignerAddress) {
        this.consignerAddress = consignerAddress;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(String shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    public CargoInfoBean getCargoInfo() {
        return cargoInfo;
    }

    public void setCargoInfo(CargoInfoBean cargoInfo) {
        this.cargoInfo = cargoInfo;
    }

    public static class CargoInfoBean implements Serializable {
        /**
         * text : string
         * time : string
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
}
