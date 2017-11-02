package com.coopbuy.mall.mypay;

/**
 * @author csn
 * @date 2017/5/18 0018 10:49
 * @content
 */
public interface PayListener {

    /**
     * 支付宝支付成功
     */
    void aliPaySuccess();

    /**
     * 支付宝支付失败
     */
    void aliPayFail();

    /**
     * 支付宝授权成功
     */
    void aliAuthSuccess();

    /**
     * 支付宝授权失败
     */
    void aliAuthFail();

    /**
     * 微信成功
     */
    void wechatPaySuccess();

    /**
     * 微信失败
     */
    void wechatPayFail();
}
