package com.coopbuy.mall.ui.module.center.view;


import com.coopbuy.mall.api.reponse.OrderPayApplyResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * @author wangyu
 * @time 2017/8/10 0010 on 上午 11:39
 * @desc
 */
public interface NewPayWindow_View extends BaseView {

    /**
     * 提交订单给服务器 为支付准备
     */
    void submitOrder(OrderSubmitResponse orderSubmit, String payType);

    /**
     * 订单支付申请
     *
     * @param response
     */
    void orderPayApply(OrderPayApplyResponse response, String payType);

    /**
     * 可支付列表
     *
     * @param payList
     */
    void getPayTradeChannel(List<TradeChannelResponse> payList);
}
