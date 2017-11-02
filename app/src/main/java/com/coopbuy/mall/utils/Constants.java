package com.coopbuy.mall.utils;

/**
 * Created by wangyu on 2017/4/12.
 */
public class Constants {
    //这是微信的参数配置
    public static final String APP_ID = "wxc2123433ae714376";
    /**
     * 是否是调试版本
     */
    public static boolean IS_DEBUG = true;

    public static final String TAG = "com.cd.coolbuy";

    /**
     * 渠道号
     */
    public static final String CHANNEL_ID = "CHANNEL_ID";


    /**
     * token值
     */
    public static final String TOKEN = "token";

    public static final String VERSION = "version";

    public static final String SALT = "f337c7eae1a7497892e90a17d52e4f6b";//接口访问服务端定义的加盐参数

    /**
     * 登录账户
     */
    public static final String LOGIN_ACCOUNT = "LOGIN_ACCOUNT";


    /**
     * //购物车商品数量    记录小红点
     */
    public static final String CAR_NUMBER = "CAR_NUMBER";


    /**
     * //消息数量    记录小红点
     */
    public static final String MESSAGE_NUMBER = "MESSAGE_NUMBER";

    /**
     * 别人分享给自己商品等，这个人的spokesmanCode
     */
    public static final String SHARE_SPOKESMAN_CODE = "share_spokesman_code";


    public static final String SEARCH_GOODS_NAME = "search_goods_name";


    /**
     * 进入我的订单某一项
     */
    public static final int ORDER_TYPE_ALL = 0;
    public static final int ORDER_TYPE_WAITPAY = 1;
    public static final int ORDER_TYPE_WAITSEND = 2;
    public static final int ORDER_TYPE_WAITCHARGE = 3;
    public static final int ORDER_TYPE_EVALUATION = 4;
    public static final int ORDER_TYPE_AFTERSALES = 5;

    /**
     * 订单状态
     */
    public static final int ORDER_STATE_ALL = 0; // 全部订单
    public static final int ORDER_STATE_WAIT_PAY = 1; // 待付款
    public static final int ORDER_STATE_WAIT_SEND = 2; // 待发货
    public static final int ORDER_STATE_WAIT_CHARGE = 3; // 待收货
    public static final int ORDER_STATE_CLOSED = 4; // 已关闭
    public static final int ORDER_STATE_DONE = 5; // 已完成
    public static final int ORDER_STATE_EVALUATION = 7; // 未评价

    public static final String ORDER_STATE_WAIT_PAY_STR = "待付款";
    public static final String ORDER_STATE_WAIT_SEND_STR = "待发货";
    public static final String ORDER_STATE_WAIT_CHARGE_STR = "待收货";
    public static final String ORDER_STATE_CLOSED_STR = "已关闭";
    public static final String ORDER_STATE_DONE_STR = "已完成";
    public static final String ORDER_STATE_EVALUATION_STR = "未评价";

    /**
     * 在订单详情页取消订单等操作，返回前一个页面，并刷新列表
     */
    public static final int REQUEST_CODE_FOR_OPERATE_ORDER = 0;
    public static final String RESULT_CLICK_POS = "click_pos";
    public static final String OPERATE_TYPE = "operate_type";
    public static final int OPERATE_TYPE_CANCEL = 0;
    public static final int OPERATE_TYPE_CONFIRM = 1;


    /**
     * 退款相关状态
     */
    public static final int REFUND_STATE_1 = 1; // 1 待商家审核
    public static final int REFUND_STATE_2 = 2; // 2 待买家寄货
    public static final int REFUND_STATE_3 = 3; // 3 待商家收货
    public static final int REFUND_STATE_4 = 4; // 4 商家拒绝
    public static final int REFUND_STATE_5 = 5; // 5 商家通过审核
    public static final int REFUND_STATE_6 = 6; // 6 待平台确认
    public static final int REFUND_STATE_7 = 7; // 7 退款成功

    public static final String REFUND_STATE_STR_1 = "待商家审核"; // 1 待商家审核
    public static final String REFUND_STATE_STR_2 = "待买家寄货"; // 2 待买家寄货
    public static final String REFUND_STATE_STR_3 = "待商家收货"; // 3 待商家收货
    public static final String REFUND_STATE_STR_4 = "商家拒绝"; // 4 商家拒绝
    public static final String REFUND_STATE_STR_5 = "商家通过审核"; // 5 商家通过审核
    public static final String REFUND_STATE_STR_6 = "待平台确认"; // 6 待平台确认
    public static final String REFUND_STATE_STR_7 = "退款成功"; // 7 退款成功


    public static final String REGISTER_TYPE = "register_type";
    public static final String FORGET_TYPE = "forget_type";
    public static final String CHANGE_TYPE = "change_type";
}
