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
     * 主机地址
     */
//    public static final String SERVER_URL = "http://dev.guinong.com:8858/";
    public static final String SERVER_URL = "https://shop.coopbuy.com/";

    //    public static final String SERVER_URL_NEW = "http://192.168.1.56:9898/";
    public static final String SERVER_URL_NEW = "http://dev.guinong.com:8860/";
//    public static final String SERVER_URL_NEW = "http://192.168.1.56:9898/";


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
     * 可支付列表
     */
    public static final String ENABLEDLIST = "api/services/app/payment/EnabledList";
    /**
     * 支付参数的
     */
    public static final String APPAPPLY = "api/services/app/payment/AppApply";
    /**
     * 订单结算
     */
    public static final String SETTLEMENT = "api/services/app/shoppingCart/Settlement";
    /**
     * 订单提交
     */
    public static final String SUBMIT = "api/services/app/order/Submit";
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
     * 删除足迹
     */
    public static final String REMOVE_FOOTMARK = "api/services/app/browseHistory/Remove";
    /**
     * 建议
     */
    public static final String NEWSUGGEST = "api/services/app/suggest/NewSuggest";
    /**
     * 电话充值列表
     */
    public static final String MOBILECARDLIST = "api/services/app/prepaid/MobileCardList";
    /**
     * 电话归属地查询
     */
    public static final String CHECKPHONE = "api/services/app/prepaid/CheckPhone";
    /**
     * 话费订单提交
     */
    public static final String SUBMITORDER = "api/services/app/prepaid/SubmitOrder";
    /**
     * 站长推荐列表
     */
    public static final String RECOMMENDPRODUCTS = "api/services/app/station/RecommendProducts";
    /**
     * 更新站长推荐的商品是否选中
     */
    public static final String UPDATESELECTSTATUS = "api/services/app/station/UpdateSelectStatus";
    /**
     * 发布商品
     */
    public static final String PUBLISHPRODUCT = "api/services/app/station/PublishProduct";
    /**
     * 移除发布的商品
     */
    public static final String REMOVEFAVORITESKU = "api/services/app/station/RemoveFavoriteSku";
    /**
     * 站长数据军师数据
     */
    public static final String SETTLEMENTCENTER = "api/services/app/station/SettlementCenter";
    /**
     * 预计收益
     */
    public static final String ESTIMATECOMMISSIONLIST = "api/services/app/station/EstimateCommissionList";
    /**
     * 预计收益
     */
    public static final String SETTLEMENTBOOKLIST = "api/services/app/station/SettlementBookList";
    /**
     * 我的客户
     */
    public static final String CUSTOMERS = "api/services/app/station/Customers";
    /**
     * 添加站长客户
     */
    public static final String ADDCUSTOMER = "api/services/app/station/AddCustomer";
    /**
     * 更新站长客户
     */
    public static final String UPDATECUSTOMER = "api/services/app/station/UpdateCustomer";
    /**
     * 代付申请列表
     */
    public static final String LIEUPAYAPPLYLIST = "api/services/app/station/LieuPayApplyList";
    /**
     * 代付申请订单详情
     */
    public static final String LIEUPAYDETAILINFO = "api/services/app/station/LieuPayDetailInfo";
    /**
     * 客户订单列表
     */
    public static final String CUSTOMERORDERS = "api/services/app/station/CustomerOrders";
    /**
     * 客户订单详情
     */
    public static final String CUSTOMERORDERDETAIL = "api/services/app/station/CustomerOrderDetail";
    /**
     * 消息中心
     */
    public static final String GROUPLIST = "api/services/app/message/GroupList";
    /**
     * 系统消息数据
     */
    public static final String LIST = "api/services/app/message/List";
    /**
     * 消息已读 单个
     */
    public static final String READ = "api/services/app/message/Read";
    /**
     * 消息已读 全部
     */
    public static final String READALL = "api/services/app/message/ReadAll";


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
    public static final String UPLOAD_IMAGE = "api/UploadImage";
    public static final String DELETE_ORDER = "api/services/app/order/Remove";
    public static final String CANCEL_ORDER = "api/services/app/order/Cancel";
    public static final String FIND_EXPRESS_INFO = "api/services/app/order/FindExpressInfo";
    public static final String ADD_TO_CART = "api/services/app/shoppingCart/AddProduct";
    public static final String ADD_FAVORITE = "api/services/app/station/FavoriteSkuInfo";
    public static final String REMOVE_FAVORITE = "api/services/app/station/RemoveFavoriteSku";
    public static final String DELAY_RECEIPT = "api/services/app/order/DelayedReceipt";
    public static final String RECEIPT = "api/services/app/order/Receipt";
    public static final String REMIND_SHIPMENT = "api/services/app/order/RemindShop";
    public static final String GET_AFTER_SALES_LIST = "api/services/app/refund/List";
    public static final String GET_AFTER_SALES_DETAIL = "api/services/app/refund/DetailInfo";
    public static final String BEFORE_APPLY_REFUND = "api/services/app/refund/FindApplyInfo";
    public static final String APPLY_REFUND = "api/services/app/refund/Apply";
    public static final String REAPPLY_REFUND = "api/services/app/refund/ReApply";
    public static final String CANCEL_APPLY_REFUND = "api/services/app/refund/Cancel";
    public static final String SHIPPING_COMPANY_LIST = "api/services/app/shipper/List";
    public static final String SEND_GOODS = "api/services/app/refund/UpdateAddress";
    public static final String REFUND_EXPRESS_INFO = "api/services/app/refund/FindExpressInfo";
    public static final String GET_CART_QUANTITY = "api/services/app/shoppingCart/FindCartQuantity";
    public static final String ADD_SHOP_FAVORITE = "api/services/app/favorite/ShopInfo";
    public static final String REMOVE_SHOP_FAVORITE = "api/services/app/favorite/CancelShop";
    public static final String GET_SEARCH_RESULT = "api/services/app/product/Search";
    public static final String GET_SHOP_DETAIL = "api/services/app/shop/Home";
}
