package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/17 0017 20:20
 * @content
 */
public class AddressInfoResponse implements Serializable {

    /**
     * addressId : 0
     * userName : string
     * tel : string
     * regionName : string
     * address : string
     * isDefault : true
     * hasBindStation : true
     * stationRegionName : string
     * stationName : string
     * stationUserName : string
     */

    private int addressId;
    private String userName;
    private String tel;
    private String regionName;
    private String address;
    private boolean isDefault;
    private boolean hasBindStation;
    private String stationRegionName;
    private String stationName;
    private String stationUserName;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean isHasBindStation() {
        return hasBindStation;
    }

    public void setHasBindStation(boolean hasBindStation) {
        this.hasBindStation = hasBindStation;
    }

    public String getStationRegionName() {
        return stationRegionName;
    }

    public void setStationRegionName(String stationRegionName) {
        this.stationRegionName = stationRegionName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationUserName() {
        return stationUserName;
    }

    public void setStationUserName(String stationUserName) {
        this.stationUserName = stationUserName;
    }
}
