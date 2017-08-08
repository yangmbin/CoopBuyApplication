package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/8 0008 13:59
 * @content
 */
public class GetDefaultAddressResponse implements Serializable {

    /**
     * id : 6080
     * memberId : 14653
     * customerName : 牛
     * address : 发广告
     * phone : 18286859858
     * isDefault : true
     * siteId : 0
     * siteName : null
     * regionId : 110102010001
     * regionFullId : null
     * regionFullName : 北京市,市辖区,西城区,德胜街道办事处,石油社区居委会
     * nameUsedBefore : null
     * stationUserId : null
     * stationUserName : null
     * hasBindSite : false
     */

    private int id;
    private int memberId;
    private String customerName;
    private String address;
    private String phone;
    private boolean isDefault;
    private int siteId;
    private String siteName;
    private long regionId;
    private String regionFullId;
    private String regionFullName;
    private String nameUsedBefore;
    private String stationUserId;
    private String stationUserName;
    private boolean hasBindSite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionFullId() {
        return regionFullId;
    }

    public void setRegionFullId(String regionFullId) {
        this.regionFullId = regionFullId;
    }

    public String getRegionFullName() {
        return regionFullName;
    }

    public void setRegionFullName(String regionFullName) {
        this.regionFullName = regionFullName;
    }

    public String getNameUsedBefore() {
        return nameUsedBefore;
    }

    public void setNameUsedBefore(String nameUsedBefore) {
        this.nameUsedBefore = nameUsedBefore;
    }

    public String getStationUserId() {
        return stationUserId;
    }

    public void setStationUserId(String stationUserId) {
        this.stationUserId = stationUserId;
    }

    public String getStationUserName() {
        return stationUserName;
    }

    public void setStationUserName(String stationUserName) {
        this.stationUserName = stationUserName;
    }

    public boolean isHasBindSite() {
        return hasBindSite;
    }

    public void setHasBindSite(boolean hasBindSite) {
        this.hasBindSite = hasBindSite;
    }
}
