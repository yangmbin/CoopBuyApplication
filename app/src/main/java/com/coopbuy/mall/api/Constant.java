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
    /**
     * 图片地址
     */
    public static final String IMAGE_SERVER_URL = "http://oss.coopbuy.com";
    /**
     * 登录
     */
    public static final String LOGIN = "Home/AppLogin";
    /**
     * 图形验证码
     */
    public static final String LOGIN_IMAGECODE = "api/services/app/member/GetCheckCodeByObject";
    /**
     * 获取短信验证码
     */
    public static final String LOGIN_SEDN_SMS_CODE = "api/services/app/member/SendSmsActivationCode";
    /**
     * 注册用户
     */
    public static final String LOGIN_REGISTER = "api/services/app/member/RegistMember";
    /**
     * 忘记密码   获取短信验证码
     */
    public static final String LOGIN_SME_RESTPASSWORD_GET_CODE = "api/services/app/member/SmsResetPassword";
    /**
     * 忘记密码   获取短信验证码后 请求修改
     */
    public static final String LOGIN_SME_RESTPASSWORD = "api/services/app/member/SmsResetUpdatePassword";
    /**
     * 退出登录  单独地址
     */
    public static final String LOGIN_QUIT = "https://shop.coopbuy.com/Home/AppLogOff";
    /**
     * 商品分类
     */
    public static final String COTEGORYS = "api/services/app/goodsCategoryCustomer/GetAllCategorys";

    /**
     * 首页数据
     */
    public static final String HOMO_PAGE_DATA = "api/services/app/pageBuildUser/GetPageData";
    /**
     * 获取站长推荐商品 固定3个
     */
    public static final String GET_STATION_RECOMMEND = "api/services/app/station/GetStationRecommend";
    /**
     * 首页banner图点击进入 首页点击（圆形图标）数据
     */
    public static final String GET_PAGE_DATA_BYID = "api/services/app/pageBuildUser/GetPageDataById";
    /**
     * 获取默认收货地址
     */
    public static final String GET_DEFALUT_SHIPPING_ADDRESS = "api/services/app/member/GetDefalutShippingAddress";
    /**
     * 获取用户收货地址列表
     */
    public static final String GET_SHIPPING_ADDRESS_LIST = "api/services/app/member/GetShippingAddressList";
    /**
     * 获取行政区数
     */
    public static final String GET_REGIONS = "api/services/app/memberRegion/GetRegions";
    /**
     * 根据区域id获取名称
     */
    public static final String GET_REGIONS_BY_PARENTID = "api/services/app/memberRegion/GetRegionsByParentId";
    /**
     * 通过行政区域id获取站长列表信息
     */
    public static final String GET_STATION_LIST_BY_REGIONID = "api/services/app/station/GetStationListByRegionId";
    /**
     * 新建收货地址
     */
    public static final String CREATE_SHIPPING_ADDRESS = "api/services/app/member/CreateShippingAddress";
    /**
     * 删除收货地址
     */
    public static final String DELETE_SHIPPING_ADDRESS = "api/services/app/member/DeleteShippingAddress";
    /**
     * 修改收货地址
     */
    public static final String MOBIFY_SHIPPING_ADDRESS = "api/services/app/member/MobifyShippingAddress";
    /**
     * 设置默认收货地址
     */
    public static final String SET_DEFAULT_SHIPPING_ADDRESS = "api/services/app/member/SetDefaultShippingAddress";
    /**
     * 代付款 待处理 付款数量
     */
    public static final String QUANTITY = "api/services/app/userShoppingCart/Quantity";

    /**
     * 商品详情添加商品到购物车
     */
    public static final String ADD_GOODS = "api/services/app/userShoppingCart/AddGoods";
    /**
     * 购物车列表
     */
    public static final String CART_LIST = "api/services/app/userShoppingCart/List";
    /**
     * 购物车商品数量更新
     */
    public static final String UPDATE_GOODS_QUANTITY = "api/services/app/userShoppingCart/UpdateGoodsQuantity";
    /**
     * 购物车商品删除
     */
    public static final String REMOVE_GOODS = "api/services/app/userShoppingCart/RemoveGoods";
    /**
     * 购物车提交订单 订单确认
     */
    public static final String ORDER_CONFIRM = "api/services/app/userGoodsOrder/Confirm";
    /**
     * 购物车订单确认 商品运费 同时也是修改数量的接口
     */
    public static final String GET_ORDER_FREIGHT = "api/services/app/goods/GetOrderFreight";
    /**
     * 购物车订单提交  创建新订单
     */
    public static final String NEW_GOODS_ORDER = "api/services/app/userGoodsOrder/New";
    /**
     * 商品详情描述
     */
    public static final String GET_GOODS_DESC = "api/services/app/goods/GetGoodsDesc";
    /**
     * 用户商品详情获取商品信息
     */
    public static final String GET_GOODS_INFOBYID = "api/services/app/goods/GetGoodsInfoById";
    /**
     * 获取店铺信息
     */
    public static final String GET_SHOP_BYID = "api/services/app/shopForUser/GetShopById";
    /**
     * 得到最新评论
     */
    public static final String GET_NEW_COMMENT = "api/services/app/goodsComment/GetNewComment";
    /**
     * 单个商品运费
     */
    public static final String GET_GOODS_FREIGHT = "api/services/app/goods/GetGoodsFreight";
    /**
     * App更新 注意单独的接口
     */
    public static final String APP_VERSION = "https://shop.coopbuy.com/AppUpdate/Version";
    /**
     * 话费充值
     */
    public static final String MOBILE_CART_LIST = "api/services/app/userMobileOrder/CartList";
    /**
     * 支付通道申请
     */
    public static final String PAY_APPLY_AND_CHANNEL = "api/services/app/userPay/PayApplyAndChannel";
    /**
     * 订单确认
     */
    public static final String PAY_CONFIRM = "api/services/app/userOrder/PayConfirm";
    /**
     * 创建话费订单
     */
    public static final String NEW_MOBILER_ORDER = "api/services/app/userMobileOrder/New";
    /**
     * 获取各订单数量
     */
    public static final String ORDER_QUANTITY = "api/services/app/userOrder/OrderQuantity";

    /**
     * 订单列表
     */
    public static final String ORDER_ALL_LIST = "api/services/app/userOrder/AllList";
    /**
     * 代付款订单
     */
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
     * 订单详情
     */
    public static final String ORDER_DETAIL = "api/services/app/userOrder/Detail";
    /**
     * 帮助中心
     */
    public static final String GET_TEXT_CONTENT_LIST = "api/services/app/textContent/GetTextContentList";
    /**
     * 退货流程
     */
    public static final String GET_TEXT_CONTENT = "api/services/app/textContent/GetTextContent";
    /**
     * 网站订单
     */
    public static final String NET_ORDER = "api/Order";
    /**
     * 获取用户信息
     */
    public static final String GET_MEMBER_INFO = "api/services/app/member/GetMemberInfo";
    /**
     * 修改用户昵称 修改性别 传入字段不一样修改
     */
    public static final String MOBIFY_MEMBER = "api/services/app/member/MobifyMember";
    /**
     * 意见反馈
     */
    public static final String POST_SUGGEST = "api/services/app/appSuggest/PostSuggest";

    /**
     *  以下为后续接口添加  没有通过抓包的api
     */


    /**
     * 商品搜索接口
     */
    public static final String SEARCH_GOODS = "api/services/app/goods/SearchGoods";
    /**
     * 获取活动页面N
     */
    public static final String GET_ACTIVE_PAGEDATA_BYID = "api/services/app/pageBuildUser/GetActivePageDataById";
    /**
     * 获取sku库N
     */
    public static final String GET_SKU_STOCK = "api/services/app/goods/GetSkuStock";
    /**
     * 设置用户头像N
     */
    public static final String SET_HEAD_PORTRAIT = "api/services/app/member/SetHeadPortrait";
    /**
     * 添加商品评论N
     */
    public static final String ADD_GOODS_COMMENT = "api/services/app/goodsComment/AddGoodsComment";
    /**
     * 通过商品id得到评论列表
     */
    public static final String GET_GOODS_COMMENT_LIST = "api/services/app/goodsComment/GetGoodsCommentList";
    /**
     * 追加评论N
     */
    public static final String APPEND_COMMENT = "api/services/app/goodsComment/AppendComment";
    /**
     * 银行卡列表N
     */
    public static final String BANK_CARD_LIST = "api/services/app/userMercharnt/BankCardList";
    /**
     * 银行卡绑定申请N
     */
    public static final String BANK_CARD_BIND_APPLY = "api/services/app/userMercharnt/BankCardBindApply";
    /**
     * 银行卡绑定N
     */
    public static final String BANK_CARD_BIND = "api/services/app/userMercharnt/BankCardBind";
    /**
     * 充值查询N
     */
    public static final String QUERY_CART = "api/services/app/userMobileOrder/QueryCart";
    /**
     * 支付应用申请N
     */
    public static final String PAY_APPLY = "api/services/app/userPay/PayApply";

    /**
     * 协议支付N
     */
    public static final String PROTOCOL_PAY = "api/services/app/userPay/Pay";
    /**
     * 订单删除N
     */
    public static final String ORDER_DELETE = "api/services/app/userOrder/Delete";
    /**
     * 订单取消N
     */
    public static final String ORDER_CANCEL = "api/services/app/userOrder/Cancel";
    /**
     * 签收订单N
     */
    public static final String RECEIVE_OREDER = "api/services/app/userGoodsOrder/Receive";
    /**
     * 延迟收货N
     */
    public static final String DELAYED_RECEIVE = "api/services/app/userGoodsOrder/DelayedReceive";
    /**
     * 获取订单物流信息N
     */
    public static final String LOGISTICS_INFO = "api/services/app/userGoodsOrder/LogisticsInfo";
    /**
     * 新售后申请N
     */
    public static final String NEW_APPLY = "api/services/app/userRefund/NewApply";
    /**
     * 更改售后申请N
     */
    public static final String UPDATE_APPLY = "api/services/app/userRefund/UpdateApply";
    /**
     * 添加退货信息N
     */
    public static final String NEW_RETURN_GOODS = "api/services/app/userRefund/NewReturnGoods";
    /**
     * 退款售后列表N
     */
    public static final String REFUND_LIST = "api/services/app/userRefund/RefundList";
    /**
     * 退款售后明细N
     */
    public static final String REFUND_DETAIL = "api/services/app/userRefund/RefundDetail";
    /**
     * 退款申请确定N
     */
    public static final String APPLY_REFUND_CONFIRM = "api/services/app/userRefund/ApplyConfirm";
    /**
     * 获取分类中首条文本内容信息
     */
    public static final String GET_FIRST_TEXT_CONTENT = "api/services/app/textContent/GetFirstTextContent";
    /**
     * 站长代付申请N
     */
    public static final String USER_APPLY = "api/services/app/orderPayApply/UserApply";
    /**
     * 拒绝代付N
     */
    public static final String REFUSE_APPLY = "api/services/app/orderPayApply/RefuseApply";
    /**
     * 代付款得到申请列表N
     */
    public static final String WAIT_PAY_ORDER_APPLY_LIST = "api/services/app/orderPayApply/WaitPayOrderApplyList";
    /**
     * 获取申请详细信息N
     */
    public static final String PAY_APPLY_DETAIL = "api/services/app/orderPayApply/PayApplyDetail";
    /**
     * 待处理代付数量获取N
     */
    public static final String PAY_APPLY_QUANTITY = "api/services/app/orderPayApply/PayApplyQuantity";
    /**
     * 用户收货相关信息，若存在记录则进行收货信息更新N
     */
    public static final String BIND_TO_STATION = "api/services/app/station/BindToStation";
    /**
     * 站点用户获取我的站点信息N
     */
    public static final String GET_MYSTATION_INFO = "api/services/app/station/GetMyStationInfo";
    /**
     * 获取当前站长用户所在站点的客户列表N
     */
    public static final String GET_STATION_CUSTOMER_LIST = "api/services/app/station/GetStationCustomerList";
    /**
     * 站点用户添加站点客户N
     */
    public static final String ADD_NEW_STATION_CUSTOMER = "api/services/app/station/AddNewStationCustomer";
    /**
     * 获取站点客户信息N
     */
    public static final String GET_STATION_CUSTOMER = "api/services/app/station/GetStationCustomer";
    /**
     * 更新站点客户信息N
     */
    public static final String UPDATE_STATION_CUSTOMER = "api/services/app/station/UpdateStationCustomer";
    /**
     * 添加商品至站长推荐N
     */
    public static final String ADD_RECOMMEND = "api/services/app/station/AddRecommend";
    /**
     * 得到站点信息和站点联系人信息N
     */
    public static final String GET_STATION_CODE_ITEM = "api/services/app/station/GetStationCodeItem";
    /**
     * 站长客户订单列表N
     */
    public static final String STATION_LIST = "api/services/app/userOrder/StationList";
    /**
     * 保存cookie
     */
    public static final String COOKIE = "set_cookie";

}
