package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:25
 * @content
 */
public class PayApplyDetailResponse implements Serializable
{
    /**
     * payTime : 2017-08-11T00:47:08.463Z
     * revoveryTime : 2017-08-11T00:47:08.463Z
     * id : 0
     * orderId : string
     * applyTime : 2017-08-11T00:47:08.463Z
     * applyStatus : 0
     * applyStatusName : string
     * payableAmount : 0
     * userId : 0
     * userName : string
     * userPhone : string
     */

    private String payTime;
    private String revoveryTime;
    private int id;
    private String orderId;
    private String applyTime;
    private int applyStatus;
    private String applyStatusName;
    private int payableAmount;
    private int userId;
    private String userName;
    private String userPhone;

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getRevoveryTime() {
        return revoveryTime;
    }

    public void setRevoveryTime(String revoveryTime) {
        this.revoveryTime = revoveryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
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

    public int getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(int payableAmount) {
        this.payableAmount = payableAmount;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
