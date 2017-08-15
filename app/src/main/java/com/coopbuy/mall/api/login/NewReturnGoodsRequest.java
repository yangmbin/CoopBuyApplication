package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 14:07
 * @content
 */
public class NewReturnGoodsRequest implements Serializable{

    /**
     * applyId : string
     * explain : string
     * voucherImageUrls : ["string"]
     * logisticsName : string
     * waybillNo : string
     */

    private String applyId;
    private String explain;
    private String logisticsName;
    private String waybillNo;
    private List<String> voucherImageUrls;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public List<String> getVoucherImageUrls() {
        return voucherImageUrls;
    }

    public void setVoucherImageUrls(List<String> voucherImageUrls) {
        this.voucherImageUrls = voucherImageUrls;
    }
}
