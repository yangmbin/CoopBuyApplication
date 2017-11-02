package com.coopbuy.mall.mypay.weixin;

import java.io.Serializable;

/**
 * @说明：
 * @创建人： niuniu
 * @创建时间： 2017/1/21 0021 17:21
 * @版本：v1.0
 * @修改人：
 * @修改时间：
 * @修改备注：
 * @作用：
 */

public class Info  implements Serializable {


    /**
     * appid : wx5840c960542202f7
     * partnerid : 1432325102
     * prepayid : wx20170122122522df6930d5390630858530
     * package : Sign=WXPay
     * noncestr : jMpnQkcOFZ03kHZP4us2ccuq6syCILXW
     * timestamp : 1485059123
     * sign : 43071D80380DF6321C2500623C07825E
     */

    private String appid;
    private String partnerid;
    private String prepayid;
    private String packageX;
    private String noncestr;
    private int timestamp;
    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
