package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/10/17 0017 10:40
 * @content
 */
public class UserCenterInfoResponse implements Serializable {

    /**
     * userInfo : {"isStationUser":true,"stationUserRoleId":0,"stationUserRoleName":"string","userId":0,"userName":"string","nick":"string","headPortraitPath":"string","phone":"string","sex":0,"email":"string","birthday":"2017-10-17T01:22:17.954Z","createdTime":"2017-10-17T01:22:17.954Z","lastLoginDate":"2017-10-17T01:22:17.954Z"}
     * festivalImageUrl : string
     * cartProductCount : 0
     * favoriteShopCount : 0
     * browseProductCount : 0
     * waitPayOrderCount : 0
     * waitShipmentOrderCount : 0
     * waitReceiptOrderCount : 0
     * afterSalesCount : 0
     */

    private UserInfoBean userInfo;
    private String festivalImageUrl;
    private int cartProductCount;
    private int favoriteShopCount;
    private int browseProductCount;
    private int waitPayOrderCount;
    private int waitShipmentOrderCount;
    private int waitReceiptOrderCount;
    private int afterSalesCount;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public String getFestivalImageUrl() {
        return festivalImageUrl;
    }

    public void setFestivalImageUrl(String festivalImageUrl) {
        this.festivalImageUrl = festivalImageUrl;
    }

    public int getCartProductCount() {
        return cartProductCount;
    }

    public void setCartProductCount(int cartProductCount) {
        this.cartProductCount = cartProductCount;
    }

    public int getFavoriteShopCount() {
        return favoriteShopCount;
    }

    public void setFavoriteShopCount(int favoriteShopCount) {
        this.favoriteShopCount = favoriteShopCount;
    }

    public int getBrowseProductCount() {
        return browseProductCount;
    }

    public void setBrowseProductCount(int browseProductCount) {
        this.browseProductCount = browseProductCount;
    }

    public int getWaitPayOrderCount() {
        return waitPayOrderCount;
    }

    public void setWaitPayOrderCount(int waitPayOrderCount) {
        this.waitPayOrderCount = waitPayOrderCount;
    }

    public int getWaitShipmentOrderCount() {
        return waitShipmentOrderCount;
    }

    public void setWaitShipmentOrderCount(int waitShipmentOrderCount) {
        this.waitShipmentOrderCount = waitShipmentOrderCount;
    }

    public int getWaitReceiptOrderCount() {
        return waitReceiptOrderCount;
    }

    public void setWaitReceiptOrderCount(int waitReceiptOrderCount) {
        this.waitReceiptOrderCount = waitReceiptOrderCount;
    }

    public int getAfterSalesCount() {
        return afterSalesCount;
    }

    public void setAfterSalesCount(int afterSalesCount) {
        this.afterSalesCount = afterSalesCount;
    }

    public static class UserInfoBean implements Serializable {
        /**
         * isStationUser : true
         * stationUserRoleId : 0
         * stationUserRoleName : string
         * userId : 0
         * userName : string
         * nick : string
         * headPortraitPath : string
         * phone : string
         * sex : 0
         * email : string
         * birthday : 2017-10-17T01:22:17.954Z
         * createdTime : 2017-10-17T01:22:17.954Z
         * lastLoginDate : 2017-10-17T01:22:17.954Z
         */

        private boolean isStationUser;
        private int stationUserRoleId;
        private String stationUserRoleName;
        private int userId;
        private String userName;
        private String nick;
        private String headPortraitPath;
        private String phone;
        private int sex;
        private String email;
        private String birthday;
        private String createdTime;
        private String lastLoginDate;

        public boolean isIsStationUser() {
            return isStationUser;
        }

        public void setIsStationUser(boolean isStationUser) {
            this.isStationUser = isStationUser;
        }

        public int getStationUserRoleId() {
            return stationUserRoleId;
        }

        public void setStationUserRoleId(int stationUserRoleId) {
            this.stationUserRoleId = stationUserRoleId;
        }

        public String getStationUserRoleName() {
            return stationUserRoleName;
        }

        public void setStationUserRoleName(String stationUserRoleName) {
            this.stationUserRoleName = stationUserRoleName;
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

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getHeadPortraitPath() {
            return headPortraitPath;
        }

        public void setHeadPortraitPath(String headPortraitPath) {
            this.headPortraitPath = headPortraitPath;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getLastLoginDate() {
            return lastLoginDate;
        }

        public void setLastLoginDate(String lastLoginDate) {
            this.lastLoginDate = lastLoginDate;
        }
    }
}
