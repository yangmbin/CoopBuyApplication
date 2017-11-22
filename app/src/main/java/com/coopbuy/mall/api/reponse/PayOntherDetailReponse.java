package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * Created by niu on 2017/11/21- 9:54
 */

public class PayOntherDetailReponse implements Serializable
{

    /**
     * tip : string
     * consignerTel : string
     * consignerName : string
     * applyAmount : 0
     * orderTime : 2017-11-21T01:48:51.747Z
     * applyTime : 2017-11-21T01:48:51.747Z
     * orderId : string
     * address : string
     * closeTimeTip : string
     * canCancelApply : true
     * canPayment : true
     * status : 0
     * statusName : string
     */

    private String tip;
    private String consignerTel;
    private String consignerName;
    private int applyAmount;
    private String orderTime;
    private String applyTime;
    private String orderId;
    private String address;
    private String closeTimeTip;
    private boolean canCancelApply;
    private boolean canPayment;
    private int status;
    private String statusName;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getConsignerTel() {
        return consignerTel;
    }

    public void setConsignerTel(String consignerTel) {
        this.consignerTel = consignerTel;
    }

    public String getConsignerName() {
        return consignerName;
    }

    public void setConsignerName(String consignerName) {
        this.consignerName = consignerName;
    }

    public int getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(int applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCloseTimeTip() {
        return closeTimeTip;
    }

    public void setCloseTimeTip(String closeTimeTip) {
        this.closeTimeTip = closeTimeTip;
    }

    public boolean isCanCancelApply() {
        return canCancelApply;
    }

    public void setCanCancelApply(boolean canCancelApply) {
        this.canCancelApply = canCancelApply;
    }

    public boolean isCanPayment() {
        return canPayment;
    }

    public void setCanPayment(boolean canPayment) {
        this.canPayment = canPayment;
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
}
