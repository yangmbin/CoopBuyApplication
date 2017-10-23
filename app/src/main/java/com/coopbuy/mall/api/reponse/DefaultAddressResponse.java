package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author ymb
 * Create at 2017/10/16 15:41
 */
public class DefaultAddressResponse implements Serializable {

    /**
     * userName : 王晶
     * address : 测试的下单
     * tel : 18302626270
     * isDefault : true
     * regionId : 520425102201
     * regionName : 贵州省,安顺市,紫云苗族布依族自治县,猴场镇,猴场村民委员会
     * stationUserId : 2078
     * stationId : 2755
     * stationName : 猴场镇候场村电商服务站
     * hasBindSite : true
     */

    private String userName;
    private String address;
    private String tel;
    private boolean isDefault;
    private long regionId;
    private String regionName;
    private int stationUserId;
    private int stationId;
    private String stationName;
    private boolean hasBindSite;
    private int addressId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(int stationUserId) {
        this.stationUserId = stationUserId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public boolean isHasBindSite() {
        return hasBindSite;
    }

    public void setHasBindSite(boolean hasBindSite) {
        this.hasBindSite = hasBindSite;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
