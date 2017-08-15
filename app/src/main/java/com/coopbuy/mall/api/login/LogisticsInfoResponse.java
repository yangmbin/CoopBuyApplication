package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 14:03
 * @content
 */
public class LogisticsInfoResponse implements Serializable{

    /**
     * orderId : string
     * logistics : string
     * waybillNo : string
     * state : 0
     * traces : [{"acceptTime":"string","acceptStation":"string","remark":"string"}]
     */

    private String orderId;
    private String logistics;
    private String waybillNo;
    private int state;
    private List<TracesBean> traces;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<TracesBean> getTraces() {
        return traces;
    }

    public void setTraces(List<TracesBean> traces) {
        this.traces = traces;
    }

    public static class TracesBean {
        /**
         * acceptTime : string
         * acceptStation : string
         * remark : string
         */

        private String acceptTime;
        private String acceptStation;
        private String remark;

        public String getAcceptTime() {
            return acceptTime;
        }

        public void setAcceptTime(String acceptTime) {
            this.acceptTime = acceptTime;
        }

        public String getAcceptStation() {
            return acceptStation;
        }

        public void setAcceptStation(String acceptStation) {
            this.acceptStation = acceptStation;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
