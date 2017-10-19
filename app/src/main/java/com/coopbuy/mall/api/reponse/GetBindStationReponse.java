package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/10/19 0019 15:04
 * @content
 */
public class GetBindStationReponse implements Serializable {

    /**
     * sstationName : 炉山社区1电商服务站
     * stationId : 368
     * stationUsers : [{"stationUserId":272,"stationUserName":"陈凯","isStationMaster":true}]
     */

    private String sstationName;
    private int stationId;
    private List<StationUsersBean> stationUsers;

    public String getSstationName() {
        return sstationName;
    }

    public void setSstationName(String sstationName) {
        this.sstationName = sstationName;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public List<StationUsersBean> getStationUsers() {
        return stationUsers;
    }

    public void setStationUsers(List<StationUsersBean> stationUsers) {
        this.stationUsers = stationUsers;
    }

    public static class StationUsersBean implements Serializable {
        /**
         * stationUserId : 272
         * stationUserName : 陈凯
         * isStationMaster : true
         */

        private int stationUserId;
        private String stationUserName;
        private boolean isStationMaster;
        private boolean isSelect;
        private int stationId;

        public int getStationId() {
            return stationId;
        }

        public void setStationId(int stationId) {
            this.stationId = stationId;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
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

        public boolean isIsStationMaster() {
            return isStationMaster;
        }

        public void setIsStationMaster(boolean isStationMaster) {
            this.isStationMaster = isStationMaster;
        }
    }
}
