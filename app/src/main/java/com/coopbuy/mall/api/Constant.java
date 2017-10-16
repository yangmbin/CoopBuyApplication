package com.coopbuy.mall.api;

/**
 * @author csn
 * @date 2017/8/1 0001 14:04
 * @content
 */
public class Constant {
   /* public static final String HOST = "http://dev.guinong.com:8810/";
    public static final String login = "api/Login/GetUser";
    public static final String cart = "api/Cart/GetCartList";*/
    /**
     * 首页banner图点击进入 首页点击（圆形图标）数据
     */
    public static final String GET_PAGE_DATA_BYID = "api/services/app/pageBuildUser/GetPageDataById";
    /**
     * 订单详情
     */
    public static final String ORDER_DETAIL = "api/services/app/userOrder/Detail";
    /**
     * 首页数据
     */
    public static final String HOMO_PAGE_DATA = "api/services/app/pageBuildUser/GetPageData";
    public static final String WAIT_FOR_PAYMENT_LIST = "api/services/app/userOrder/WaitForPaymentList";
    /**
     * 待发货
     */
    public static final String WAIT_FOR_DISPATCH_LIST = "api/services/app/userOrder/WaitForDispatchList";
    /**
     * 待收货
     */
    public static final String WAIT_FOR_RECEIVE_LIST = "api/services/app/userOrder/WaitForReceiveList";
    /**
     * 待评价
     */
    public static final String WAIT_FOR_COMMENT_LIST = "api/services/app/userOrder/WaitForCommentList";
    /**
     * 订单列表
     */
    public static final String ORDER_ALL_LIST = "api/services/app/userOrder/AllList";
    /**
     * 商品分类
     */
    public static final String COTEGORYS = "api/services/app/goodsCategoryCustomer/GetAllCategorys";

    /**
     * 主机地址
     */
//    public static final String SERVER_URL = "http://dev.guinong.com:8858/";
    public static final String SERVER_URL = "https://shop.coopbuy.com/";
    public static final String SERVER_URL_NEW = "http://dev.guinong.com:8860/";
    /**
     * 图片地址
     */
    public static final String IMAGE_SERVER_URL = "http://oss.coopbuy.com";




    /**
     * 登录
     */
    public static final String LOGIN = "api/services/app/authorization/Login";
    /**
     * 图形验证码
     */
    public static final String IMAGE_CODE = "api/services/app/verifyCode/GetImageCode";
    /**
     * 退出
     */
    public static final String LOGOUT = "api/services/app/authorization/Logout";
    /**
     * 短信接口
     */
    public static final String SMSCODE = "api/services/app/verifyCode/SendRegisterCode";
    /**
     * 注册
     */
    public static final String REGISTER = "api/services/app/member/Register";






    /**
     * 保存cookie
     */
    public static final String COOKIE = "set_cookie";



    // ----------------------------------------新下行----------------------------------------

    public static final String GET_CATEGORY_DATA = "api/services/app/category/List";
    public static final String GET_SKU_DETAIL = "api/services/app/product/SkuDetail";
    public static final String GET_DESCRIPTION = "api/services/app/product/Description";

}
