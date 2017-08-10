package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 11:30
 * @content
 */
public class GetMemberInfoResponse implements Serializable {

    /**
     * defaultShippingAddress : {"id":0,"memberId":0,"customerName":"string","address":"string","phone":"string","isDefault":true,"siteId":0,"siteName":"string","regionId":0,"regionFullId":"string","regionFullName":"string","nameUsedBefore":"string","stationUserId":0,"stationUserName":"string","hasBindSite":true}
     * id : 0
     * userName : string
     * nick : string
     * phone : string
     * email : string
     * idCard : string
     * headPortraitPath : string
     * sex : 0
     * isMaster : true
     * isMasterAssistant : true
     */

    private DefaultShippingAddressBean defaultShippingAddress;
    private int id;
    private String userName;
    private String nick;
    private String phone;
    private String email;
    private String idCard;
    private String headPortraitPath;
    private int sex;
    private boolean isMaster;
    private boolean isMasterAssistant;

    public DefaultShippingAddressBean getDefaultShippingAddress() {
        return defaultShippingAddress;
    }

    public void setDefaultShippingAddress(DefaultShippingAddressBean defaultShippingAddress) {
        this.defaultShippingAddress = defaultShippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getHeadPortraitPath() {
        return headPortraitPath;
    }

    public void setHeadPortraitPath(String headPortraitPath) {
        this.headPortraitPath = headPortraitPath;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isIsMaster() {
        return isMaster;
    }

    public void setIsMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }

    public boolean isIsMasterAssistant() {
        return isMasterAssistant;
    }

    public void setIsMasterAssistant(boolean isMasterAssistant) {
        this.isMasterAssistant = isMasterAssistant;
    }

    public static class DefaultShippingAddressBean {
        /**
         * id : 0
         * memberId : 0
         * customerName : string
         * address : string
         * phone : string
         * isDefault : true
         * siteId : 0
         * siteName : string
         * regionId : 0
         * regionFullId : string
         * regionFullName : string
         * nameUsedBefore : string
         * stationUserId : 0
         * stationUserName : string
         * hasBindSite : true
         */

        private int id;
        private int memberId;
        private String customerName;
        private String address;
        private String phone;
        private boolean isDefault;
        private int siteId;
        private String siteName;
        private int regionId;
        private String regionFullId;
        private String regionFullName;
        private String nameUsedBefore;
        private int stationUserId;
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

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
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

        public int getStationUserId() {
            return stationUserId;
        }

        public void setStationUserId(int stationUserId) {
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
}
