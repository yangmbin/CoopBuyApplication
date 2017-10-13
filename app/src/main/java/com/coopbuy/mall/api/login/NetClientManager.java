package com.coopbuy.mall.api.login;

import com.coopbuy.mall.api.BaseApiClient;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.login.LoginRequest;
import com.coopbuy.mall.api.login.login.LoginResponse;
import com.google.gson.reflect.TypeToken;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/1 0001 14:09
 * @content 这里是登录相关api
 */
public class NetClientManager extends BaseApiClient {
    public NetClientManager() {
        this.setUnitTest(false);
    }

    /**
     * 登录接口调用
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
   /* public IAsyncRequestState LoginRequest(com.coopbuy.mall.api.login.login.LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN, request, callback, userState);
    }*/
/* public IAsyncRequestState Login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiGetRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN, request, callback, userState);
    }*/


    /**
     * 商品分类
     *
     * @param callback
     * @param usetState
     * @return
     */
    public IAsyncRequestState getCategorys(IAsyncResultCallback<List<CategorysResponse>> callback, Object usetState) {
        return apiPostRequest(new TypeToken<List<CategorysResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.COTEGORYS, callback, usetState);
    }

    /**
     * 登录图形验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getImageCode(ImageCodeRequest request, IAsyncResultCallback<ImageCodeResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ImageCodeResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN_IMAGECODE, request, callback, userState);
    }

    /**
     * 获取短信验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState senSmsCode(SendSmsCodeRequest request, IAsyncResultCallback<SendSmsCodeResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SendSmsCodeResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN_SEDN_SMS_CODE, request, callback, userState);
    }

    /**
     * 获取短信验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState smsResetPasswordGetCode(SmsResetPasswordGetCodeRequest request, IAsyncResultCallback<SmsResetPasswordGetCodeResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SmsResetPasswordGetCodeResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN_SME_RESTPASSWORD_GET_CODE, request, callback, userState);
    }

    /**
     * 根据短信验证码 新密码 修改密码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState smsResetPassword(SmsResetPasswordRequest request, IAsyncResultCallback<SmsResetPasswordResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SmsResetPasswordResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN_SME_RESTPASSWORD, request, callback, userState);
    }

    /**
     * 注册用户
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState register(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<RegisterResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN_REGISTER, request, callback, userState);
    }

    /**
     * 退出登录
     * 该接口是单独的
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState quitUser(IAsyncResultCallback<LoginQuitRespsonse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginQuitRespsonse>() {
        }.getType(), Constant.LOGIN_QUIT, callback, userState);
    }

    /**
     * 首页数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<HomePageDataResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.HOMO_PAGE_DATA, request, callback, userState);
    }

    /**
     * 获得站长推荐的商品
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getStationRecommend(IAsyncResultCallback<List<GetStationRecommendResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<HomePageDataResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_STATION_RECOMMEND, callback, userState);
    }

    /**
     * 首页banner图点击进入
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<HomePageDataByIdResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_PAGE_DATA_BYID, request, callback, userState);
    }

    /**
     * 获得默认收货地址
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDefalutAddress(IAsyncResultCallback<GetDefaultAddressResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetDefaultAddressResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_DEFALUT_SHIPPING_ADDRESS, callback, userState);
    }

    /**
     * 获取收货地址列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDefalutAddressList(IAsyncResultCallback<List<GetDefaultAddressResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<GetDefaultAddressResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_SHIPPING_ADDRESS_LIST, callback, userState);
    }

    /**
     * 获取行政区数
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getRegions(IAsyncResultCallback<List<RegionsResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<RegionsResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_REGIONS, callback, userState);
    }

    /**
     * 根据区域id获取名称
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getRegionsByParentId(RegionsByParentIdRequest request, IAsyncResultCallback<List<RegionsByParentIdResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<RegionsByParentIdResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_REGIONS_BY_PARENTID, request, callback, userState);
    }

    /**
     * 通过行政区域id获取站长列表信息
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getRegionsStationByParentId(StationListByRegionIdRequest request, IAsyncResultCallback<StationListByRegionIdResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<StationListByRegionIdResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_STATION_LIST_BY_REGIONID, request, callback, userState);
    }

    /**
     * 新建收货地址 这里有个问题  服务器最外层的success 应该的表示的是请求成功  不应该是接口访问处理的结果是什么 所以这里的结果又问题
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState createShipAddress(CreateShipAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.CREATE_SHIPPING_ADDRESS, request, callback, userState);
    }

    /**
     * 删除收货地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState deleteShipAddress(DeleteShipAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.DELETE_SHIPPING_ADDRESS, request, callback, userState);
    }

    /**
     * 修改收货地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState mobifyShipAddress(MobifyShipAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.MOBIFY_SHIPPING_ADDRESS, request, callback, userState);
    }

    /**
     * 设置默认地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState setDefaultShipAddress(SetDefaultAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.SET_DEFAULT_SHIPPING_ADDRESS, request, callback, userState);
    }

    /**
     * 代付款 待处理 付款数量
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getQuantityNumber(IAsyncResultCallback<QuantityResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<QuantityResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.QUANTITY, callback, userState);
    }

    /**
     * 商品详情添加商品到购物车
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addGoods(AddGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ADD_GOODS, request, callback, userState);
    }

    /**
     * 购物车列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCartList(IAsyncResultCallback<CartListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<CartListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.CART_LIST, callback, userState);
    }

    /**
     * 更新购物车的数量
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updateGoodsQuantity(UpdateGoodsQuantityRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.UPDATE_GOODS_QUANTITY, request, callback, userState);
    }

    /**
     * 购物车商品删除
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState removeGoods(RemoveGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.REMOVE_GOODS, request, callback, userState);
    }

    /**
     * 购物车提交订单 订单确认
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState orderConfirm(OrderConfirmRequest request, IAsyncResultCallback<OrderConfirmResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderConfirmResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ORDER_CONFIRM, request, callback, userState);
    }

    /**
     * 购物车订单确认 商品运费 同时也是修改数量的接口
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderFreightAndUpdateOrderCounts(OrderFreightRequest request, IAsyncResultCallback<OrderFreightResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderFreightResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_ORDER_FREIGHT, request, callback, userState);
    }

    /**
     * 购物车订单提交  创建新订单  注意这里只能生产一个商家的店铺的商品 不能是多家的商品 订单生成
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState newUserGoodsOrder(NewUserGoodsOrderRequest request, IAsyncResultCallback<NewUserGoodsOrderresponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<NewUserGoodsOrderresponse>() {
        }.getType(), Constant.SERVER_URL + Constant.NEW_GOODS_ORDER, request, callback, userState);
    }

    /**
     * 商品详情描述  图片描述  请求都是id 用一个
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState goodsDetailImage(GoodsDetailRequest request, IAsyncResultCallback<GoodsDetailDescResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GoodsDetailDescResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_GOODS_DESC, request, callback, userState);
    }

    /**
     * 商品详情描述 信息描述
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState goodsDeatailInfo(GoodsDetailRequest request, IAsyncResultCallback<GoodsDetailInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GoodsDetailInfoResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_GOODS_INFOBYID, request, callback, userState);
    }

    /**
     * 获取店铺信息
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */

    public IAsyncRequestState getShopInfo(GetShopIdRequest request, IAsyncResultCallback<GetShopIdResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetShopIdResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_SHOP_BYID, request, callback, userState);
    }

    /**
     * 得到最新评论
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getNetComment(GetNewCommentRequest request, IAsyncResultCallback<GetNewCommentResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetNewCommentResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_NEW_COMMENT, request, callback, userState);
    }

    /**
     * 单个商品运费
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getGoodsFreight(GetGoodsFreightRequest request, IAsyncResultCallback<GetGoodsFreightResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetGoodsFreightResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_GOODS_FREIGHT, request, callback, userState);
    }

    /**
     * 获取app更新状态
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getAppNewVersion(IAsyncResultCallback<AppNewVersionResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<AppNewVersionResponse>() {
        }.getType(), Constant.APP_VERSION, callback, userState);
    }

    /**
     * 电话 充值  的列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMobileOrderList(IAsyncResultCallback<MobileOrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<MobileOrderListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.MOBILE_CART_LIST, callback, userState);
    }

    /**
     * 支付通道申请
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPayApplyAndChannel(PayApplyAndChannelRequest request, IAsyncResultCallback<PayApplyAndChannelResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<PayApplyAndChannelResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.PAY_APPLY_AND_CHANNEL, request, callback, userState);
    }

    /**
     * 电话充值 订单确认 注意和购物车的订单不一样
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState mobifyOrderPayComfirm(MobifyOrderPayConfirmRequest request, IAsyncResultCallback<MobifyOrderPayConfirmResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<MobifyOrderPayConfirmResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.PAY_CONFIRM, request, callback, userState);
    }

    /**
     * 创建话费的订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState createMobileOrder(CreateMobileOrderRequest request, IAsyncResultCallback<CreateMobileOrderResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<CreateMobileOrderResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.NEW_MOBILER_ORDER, request, callback, userState);
    }

    /**
     * 获取各订单数量
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderQuantityNumber(IAsyncResultCallback<GetOrderQuantityResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetOrderQuantityResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ORDER_QUANTITY, callback, userState);
    }

    /**
     * 订单列表  所有的请求参数 和响应是一样的  只是请求的参数不一样
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderAllList(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetOrderListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ORDER_ALL_LIST, request, callback, userState);
    }

    /**
     * 代付款订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderListWaitForPayment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetOrderListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.WAIT_FOR_PAYMENT_LIST, request, callback, userState);
    }

    /**
     * 待发货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderListWaitForDispatch(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetOrderListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.WAIT_FOR_DISPATCH_LIST, request, callback, userState);
    }

    /**
     * 待收货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderListWaitForReceive(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetOrderListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.WAIT_FOR_RECEIVE_LIST, request, callback, userState);
    }

    /**
     * 待评价
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderListWaitForComment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetOrderListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.WAIT_FOR_COMMENT_LIST, request, callback, userState);
    }

    /**
     * 订单详情
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderDetail(OrderDetailRequest request, IAsyncResultCallback<OrderDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderDetailResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ORDER_DETAIL, request, callback, userState);
    }

    /**
     * 帮助中心
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getHeplCenter(GetHelpCenterContentRequest request, IAsyncResultCallback<GetHeplCenterContentResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetHeplCenterContentResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_TEXT_CONTENT_LIST, request, callback, userState);
    }

    /**
     * 退货流程
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getTextContent(GetTextContentRequest request, IAsyncResultCallback<GetTextCOntentResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetTextCOntentResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_TEXT_CONTENT, request, callback, userState);
    }

    /**
     * 网站订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getNetOrder(NetOrderRequest request, IAsyncResultCallback<NetOrderResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<NetOrderResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.NET_ORDER, request, callback, userState);
    }


    /**
     * 获取用户信息
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMemberInfo(IAsyncResultCallback<GetMemberInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetMemberInfoResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_MEMBER_INFO, callback, userState);
    }

    /**
     * 修改用户信息 性别  昵称 等 修改那个字段就传那个字段
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updateMobifyMember(MobifyMemberRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.MOBIFY_MEMBER, request, callback, userState);
    }

    /**
     * 意见反馈
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState postSuggest(PostSuggestRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.POST_SUGGEST, request, callback, userState);
    }

    /**
     * 2017年8月9日11:46:17 告一个段落 这写了 还没有测试 搞这个搞了一天  还不算文档api编写
     */
    /**
     * 获取活动页面N
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getActivePageDataById(IAsyncResultCallback<List<GetActivePageDataResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<GetActivePageDataResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_ACTIVE_PAGEDATA_BYID, callback, userState);
    }

    /**
     * 获取sku库N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSkuStock(GetSkuStockRequest request, IAsyncResultCallback<GetSkuStockResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetSkuStockResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_SKU_STOCK, request, callback, userState);
    }


    /**
     * 设置用户头像N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState setHeadPortraitResuest(SetHeadPortraitResuest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.SET_HEAD_PORTRAIT, request, callback, userState);
    }

    /**
     * 添加商品评论N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addGoodsComment(AddGoodsCommentRequest request, IAsyncResultCallback<AddGoodsCommentResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<AddGoodsCommentResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ADD_GOODS_COMMENT, request, callback, userState);
    }

    /**
     * 通过商品id得到评论列表N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getGoodsCommentList(GetGoodsCommentListRequest request, IAsyncResultCallback<GetGoodsCommentListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetGoodsCommentListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_GOODS_COMMENT_LIST, request, callback, userState);
    }

    /**
     * 追加评论N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState appendComment(AppendCommentRequest request, IAsyncResultCallback<AppendCommentResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<AppendCommentResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.APPEND_COMMENT, request, callback, userState);
    }

    /**
     * 银行卡列表N
     *
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bankCardList(IAsyncResultCallback<List<BankCardListResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<BankCardListResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.BANK_CARD_LIST, callback, userState);
    }

    /**
     * 银行卡绑定申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bankCardBindApply(BankCardBindApplyRequest request, IAsyncResultCallback<BankCardBindApplyResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<BankCardBindApplyResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.BANK_CARD_BIND_APPLY, request, callback, userState);
    }

    /**
     * 银行卡绑定N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bankCardBind(BankCardBindRequest request, IAsyncResultCallback<BankCardBindResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<BankCardBindResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.BANK_CARD_BIND, request, callback, userState);
    }

    /**
     * 支付应用申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState payApply(PayApplyRequest request, IAsyncResultCallback<PayApplyResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<PayApplyResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.PAY_APPLY, request, callback, userState);
    }

    /**
     * 协议支付N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState protocolPay(ProtocolRequest request, IAsyncResultCallback<ProtocolResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ProtocolResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.PROTOCOL_PAY, request, callback, userState);
    }

    /**
     * 充值查询N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState queryCart(QueryCartRequest request, IAsyncResultCallback<QueryCartResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<QueryCartResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.QUERY_CART, request, callback, userState);
    }

    /**
     * 订单删除N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState orderDelete(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ORDER_DELETE, request, callback, userState);
    }

    /**
     * 订单取消N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState orderCancel(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ORDER_CANCEL, request, callback, userState);
    }

    /**
     * 签收订单N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState receiveOreder(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.RECEIVE_OREDER, request, callback, userState);
    }

    /**
     * 延迟收货N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState delayedReceive(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.DELAYED_RECEIVE, request, callback, userState);
    }

    /**
     * 获取订单物流信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState logisticsInfo(OrderIdOperateRequest request, IAsyncResultCallback<LogisticsInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LogisticsInfoResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGISTICS_INFO, request, callback, userState);
    }

    /**
     * 新售后申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState newApply(NewApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.NEW_APPLY, request, callback, userState);
    }

    /**
     * 更改售后申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState updateApply(UpdateApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.UPDATE_APPLY, request, callback, userState);
    }

    /**
     * 添加退货信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState newReturnGoods(NewReturnGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.NEW_RETURN_GOODS, request, callback, userState);
    }

    /**
     * 退款售后列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState refundList(RefundListRequest request, IAsyncResultCallback<RefundListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<RefundListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.REFUND_LIST, request, callback, userState);
    }

    /**
     * 退款售后明细N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState refundDetail(RefundDetailRequest request, IAsyncResultCallback<RefundDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<RefundDetailResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.REFUND_DETAIL, request, callback, userState);
    }

    /**
     * 退款申请确定N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState applyRefundConfirm(ApplyRefundConfirmRequest request, IAsyncResultCallback<ApplyRefundConfirmResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ApplyRefundConfirmResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.APPLY_REFUND_CONFIRM, request, callback, userState);
    }

    /**
     * 获取分类中首条文本内容信息
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getFirstTextContent(GetFirstTextContentRequest request, IAsyncResultCallback<GetFirstTextContentResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetFirstTextContentResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_FIRST_TEXT_CONTENT, request, callback, userState);
    }

    /**
     * 站长代付申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState userApply(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.USER_APPLY, request, callback, userState);
    }

    /**
     * 拒绝代付N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState rRefuseApply(RefuseApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.REFUSE_APPLY, request, callback, userState);
    }

    /**
     * 代付款得到申请列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState waitPayOrderApplyList(WaitPayOrderApplyListRequest request, IAsyncResultCallback<WaitPayOrderApplyListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<WaitPayOrderApplyListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.WAIT_PAY_ORDER_APPLY_LIST, request, callback, userState);
    }

    /**
     * 获取申请详细信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState payApplyDetail(OperateIdRequest request, IAsyncResultCallback<PayApplyDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<PayApplyDetailResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.PAY_APPLY_DETAIL, request, callback, userState);
    }

    /**
     * 待处理代付数量获取N
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState payApplyQuantity(IAsyncResultCallback<PayApplyQuantityResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<PayApplyQuantityResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.PAY_APPLY_QUANTITY, callback, userState);
    }


    /**
     * 用户收货相关信息，若存在记录则进行收货信息更新N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bindToStation(BindToStationRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.BIND_TO_STATION, request, callback, userState);
    }

    /**
     * 站点用户获取我的站点信息N
     *
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getMyStationInfo(IAsyncResultCallback<GetMyStationInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetMyStationInfoResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_MYSTATION_INFO, callback, userState);
    }

    /**
     * 获取当前站长用户所在站点的客户列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getStationCustomerList(GetStationCustomerListRequest request, IAsyncResultCallback<GetStationCustomerListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetStationCustomerListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_STATION_CUSTOMER_LIST, request, callback, userState);
    }

    /**
     * 站点用户添加站点客户N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addNewStationCustomer(AddNewStationCustomerRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ADD_NEW_STATION_CUSTOMER, request, callback, userState);
    }

    /**
     * 获取站点客户信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getStationCustomer(OperateIdRequest request, IAsyncResultCallback<GetStationCustomerResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetStationCustomerResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_STATION_CUSTOMER, request, callback, userState);
    }

    /**
     * 更新站点客户信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState updateStationCustomer(UpdateStationCustomerRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.UPDATE_STATION_CUSTOMER, request, callback, userState);
    }

    /**
     * 添加商品至站长推荐N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState addRecommend(AddRecommendRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OperateSuccessResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.ADD_RECOMMEND, request, callback, userState);
    }

    /**
     * 得到站点信息和站点联系人信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getStationCodeItem(GetStationCodeItemRequest request, IAsyncResultCallback<GetStationCodeItemResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<GetStationCodeItemResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_STATION_CODE_ITEM, request, callback, userState);
    }

    /**
     * 站长客户订单列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState stationList(StationListRequest request, IAsyncResultCallback<StationListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<StationListResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.STATION_LIST, request, callback, userState);
    }









//    新下行  以前写的没有用了  暂时不删除

    public IAsyncRequestState login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.LOGIN, request, callback, userState);
    }


}
