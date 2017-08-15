package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/14 0014 14:26
 * @content
 */
public class BindToStationRequest implements Serializable{

    /**
     * stationId : 0
     * stationUserId : 0
     * populizeStationUserId : 0
     * customerName : string
     * mobilePhone : string
     * nameUsedBefore : string
     * sex : string
     * identityCode : string
     * dateOfBirth : 2017-08-11T00:47:08.492Z
     * address : string
     */

    private int stationId;
    private int stationUserId;
    private int populizeStationUserId;
    private String customerName;
    private String mobilePhone;
    private String nameUsedBefore;
    private String sex;
    private String identityCode;
    private String dateOfBirth;
    private String address;

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(int stationUserId) {
        this.stationUserId = stationUserId;
    }

    public int getPopulizeStationUserId() {
        return populizeStationUserId;
    }

    public void setPopulizeStationUserId(int populizeStationUserId) {
        this.populizeStationUserId = populizeStationUserId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNameUsedBefore() {
        return nameUsedBefore;
    }

    public void setNameUsedBefore(String nameUsedBefore) {
        this.nameUsedBefore = nameUsedBefore;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
