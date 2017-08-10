package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 9:59
 * @content
 */
public class PayApplyAndChannelResponse implements Serializable {

    /**
     * callType : 1
     * payParams : _input_charset=utf8&body=%e8%b4%b5%e5%b7%9e%e7%a7%bb%e5%8a%a8%e8%af%9d%e8%b4%b910%e5%85%83&it_b_pay=1431m&notify_url=https%3a%2f%2fpay.guinong.com%2fNotify%2fAliPay%2fOrderPay&out_trade_no=20170807134056020652&partner=2088621785432459&payment_type=1&seller_id=2088621785432459&service=mobile.securitypay.pay&sign=Xw9zCYeD5pLLcXNIdIUTK4osgWzdhRY6gThwYhrWq6c4eU5%2b4BYR4r1Uw4sN7AHVt3wbTA3f7ZZX4lAFK5h4wxVe1L4aYRr5zMjWvINvalelw0eJcjnsj60J7q7x90mZXSht5V3kJnVY1j2w7wr0OorkezdXoE0%2bmjrSj1XEE3M%3d&sign_type=RSA&subject=%e5%85%85%e5%80%bc%e8%ae%a2%e5%8d%95&total_fee=10.00
     * payUrl :
     * payId :
     * payAmount : 10
     */

    private int callType;
    private String payParams;
    private String payUrl;
    private String payId;
    private int payAmount;

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public String getPayParams() {
        return payParams;
    }

    public void setPayParams(String payParams) {
        this.payParams = payParams;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }
}
