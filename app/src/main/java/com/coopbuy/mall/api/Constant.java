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
     * 首页数据
     */
    public static final String HOMO_PAGE_DATA = "api/services/app/pageBuildUser/GetPageData";
    /**
     * 商品分类
     */
    public static final String COTEGORYS = "api/services/app/goodsCategoryCustomer/GetAllCategorys";

    /**
     * 主机地址
     */
//    public static final String SERVER_URL = "http://dev.guinong.com:8858/";
    public static final String SERVER_URL = "https://shop.coopbuy.com/";

    //  public static final String SERVER_URL_NEW = "http://192.168.1.56:8003/";
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
     * 重置密码短信接口
     */
    public static final String SMSCODE_UPDATE = "api/services/app/verifyCode/SendUpdatePasswordCode";
    /**
     * 更新密码   忘记密码  和修改密码一样的接口
     */
    public static final String UPDATEPASSWORD = "api/services/app/member/UpdatePassword";
    /**
     * 注册
     */
    public static final String REGISTER = "api/services/app/member/Register";
    /**
     * 个人中心数据
     */
    public static final String USERCENTERINFO = "api/services/app/member/UserCenterInfo";
    /**
     * 地址信息
     */
    public static final String ADDRESSLIST = "api/services/app/shippingAddress/List";
    /**
     * 添加地址
     */
    public static final String ADDADDRESSS = "api/services/app/shippingAddress/Add";
    /**
     * 修改地址
     */
    public static final String UPDATE = "api/services/app/shippingAddress/Update";
    /**
     * 设置默认地址
     */
    public static final String SETDEFAULT = "api/services/app/shippingAddress/SetDefault";
    /**
     * 删除地址
     */
    public static final String REMOVE = "api/services/app/shippingAddress/Remove";
    /**
     * 得到省市区数据
     */
    public static final String PROVINCES = "api/services/app/region/Provinces";
    /**
     * 得到省市区数据
     */
    public static final String CHILD_PROVINCES = "api/services/app/region/List";
    /**
     * 获取站点 站长 助理数据
     */
    public static final String FIND_LIST_BY_REGION = "api/services/app/station/FindListByRegion";
    /**
     * 购物车数据
     */
    public static final String SHOPCART_DATA = "api/services/app/shoppingCart/List";
    /**
     * 更新商品的数量 sku
     */
    public static final String UPDATEPRODUCT = "api/services/app/shoppingCart/UpdateProduct";
    /**
     * 删除商品
     */
    public static final String REMOVEPRODUCT = "api/services/app/shoppingCart/RemoveProduct";
    /**
     * 订单结算
     */
    public static final String SETTLEMENT = "api/services/app/shoppingCart/Settlement";
    /**
     * 店铺收藏
     */
    public static final String PAGESHOPLIST = "api/services/app/favorite/PageShopList";
    /**
     * 店铺取消收藏
     */
    public static final String CANCELSHOP = "api/services/app/favorite/CancelShop";

    /**
     * 足迹
     */
    public static final String FOOTMARKPAGELIST = "api/services/app/browseHistory/PageList";


    /**
     * 保存cookie
     */
    public static final String COOKIE = "set_cookie";


    // ----------------------------------------新下行----------------------------------------

    public static final String GET_CATEGORY_DATA = "api/services/app/category/List";
    public static final String GET_SKU_DETAIL = "api/services/app/product/SkuDetail";
    public static final String GET_DESCRIPTION = "api/services/app/product/Description";
    public static final String GET_SKU_INFO_LIST = "api/services/app/product/SkuInfoList";
    public static final String FIND_SKU_INFO = "api/services/app/product/FindSkuInfo";
    public static final String ORDER_LIST = "api/services/app/order/List";
    public static final String ORDER_DETAIL = "api/services/app/order/DetailInfo";
    public static final String DEFAULT_ADDRESS = "api/services/app/shippingAddress/FindDefault";
    public static final String CALCULATE_FREIGHT = "api/services/app/freight/Calculation";
    public static final String UPLOAD_IMAGE = "api/services/app/upload/Image";
    public static final String DELETE_ORDER = "api/services/app/order/Remove";
    public static final String CANCEL_ORDER = "api/services/app/order/Cancel";
    public static final String FIND_EXPRESS_INFO = "api/services/app/order/FindExpressInfo";

}
