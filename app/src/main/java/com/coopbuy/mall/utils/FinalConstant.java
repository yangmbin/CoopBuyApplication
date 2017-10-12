package com.coopbuy.mall.utils;

/**
 * @author lw
 * @time 2017/8/24.
 * @desc
 */
public class FinalConstant {



    public static final  String  isFristOpen= "isFristOpen";//是否第一次打开app

    //登录类型
    public static final int login_type_normal = 10001;//正常跳转
    public static final int login_type_main_shopcar = 10002;//跳转至购物车
    public static final int login_type_to_activity = 10003;//跳转至相应的activity
    public static final int login_type_to_orderActivity = 10004;//跳转至订单activity
    public static final int login_type_to_meCenter = 10005;//跳转至个人中心


        //引导页是否打开过
    public static final String FRISTGUIDE = "fristguide";

//用户信息
    public static final String id = "id";
    public static final String userName = "userName";
    public static final String email = "email";
    public static final String topRegionId = "topRegionId";
    public static final String regionId = "regionId";
    public static final String cellPhone = "cellPhone";
    public static final String qq = "qq";
    public static final String nick = "nick";
    public static final String photo = "photo";
    public static final String isBindPhoneNumber = "isBindPhoneNumber";
    public static final String sex = "sex";
    public static final String ticket = "ticket";
    public static final String thirdPartyName = "thirdPartyName";
    public static final String is_login = "is_login";
    public static final String isThirdPartyLogin = "isThirdPartyLogin";



    //订单数量
    public static final String waitPayCount = "waitPayCount";//待付款
    public static final String waitDeliveryCount = "waitDeliveryCount";//待发货
    public static final String waitReceiptCount = "waitReceiptCount";//待收货
    public static final String waitEvaluationCount = "waitEvaluationCount";//待评价
    public static final String afterSaleCount = "afterSaleCount";//售后
    //收藏数量
    public static final String myMessageCount = "myMessageCount";//
    public static final String skuFavoritesCount = "skuFavoritesCount";//
    public static final String shopFavoritesCount = "shopFavoritesCount";//
    public static final String myHistoryVisite = "myHistoryVisite";//
    public static final String venueFavoritesCount = "venueFavoritesCount";//
}
