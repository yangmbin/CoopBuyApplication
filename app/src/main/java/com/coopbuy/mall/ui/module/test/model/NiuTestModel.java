package com.coopbuy.mall.ui.module.test.model;

import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.*;
import com.coopbuy.mall.base.BaseModel;
import com.google.gson.reflect.TypeToken;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 17:09
 * @content
 */
public class NiuTestModel implements BaseModel {
    LoginClient client = new LoginClient();

    public void login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        client.LoginRequest(request, callback, userState);
    }

    public void getImageCode(ImageCodeRequest request, IAsyncResultCallback<ImageCodeResponse> callback, Object userState) {
        client.getImageCode(request, callback, userState);
    }

    public void sendSmsCode(SendSmsCodeRequest request, IAsyncResultCallback<SendSmsCodeResponse> callback, Object userState) {
        client.senSmsCode(request, callback, userState);

    }

    public void smsResetPasswordGetCode(SmsResetPasswordGetCodeRequest request, IAsyncResultCallback<SmsResetPasswordGetCodeResponse> callback, Object userState) {
        client.smsResetPasswordGetCode(request, callback, userState);
    }

    public void smsResetPassword(SmsResetPasswordRequest request, IAsyncResultCallback<SmsResetPasswordResponse> callback, Object userState) {
        client.smsResetPassword(request, callback, userState);
    }

    public void registerUser(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        client.register(request, callback, userState);
    }

    public void loginQuit(IAsyncResultCallback<LoginQuitRespsonse> callback, Object userState) {
        client.quitUser(callback, userState);
    }

    public void homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        client.homePageData(request, callback, userState);
    }

    public void getCategorys(IAsyncResultCallback<List<CategorysResponse>> callback, Object userState) {
        client.getCategorys(callback, userState);
    }

    /**
     * 获得站长推荐的商品
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getStationRecommend(IAsyncResultCallback<List<GetStationRecommendResponse>> callback, Object userState) {
        client.getStationRecommend(callback, userState);
    }

    /**
     * 获取Banner详情
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
        client.getPageDataById(request, callback, userState);
    }

    /**
     * 获得默认收货地址
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getDefalutAddress(IAsyncResultCallback<GetDefaultAddressResponse> callback, Object userState) {
        client.getDefalutAddress(callback, userState);
    }

    /**
     * 获取收货地址列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getDefalutAddressList(IAsyncResultCallback<List<GetDefaultAddressResponse>> callback, Object userState) {
        client.getDefalutAddressList(callback, userState);
    }

    /**
     * 获取行政区数
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getRegions(IAsyncResultCallback<List<RegionsResponse>> callback, Object userState) {
        client.getRegions(callback, userState);
    }

    /**
     * 根据区域id获取名称
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getRegionsByParentId(RegionsByParentIdRequest request, IAsyncResultCallback<List<RegionsByParentIdResponse>> callback, Object userState) {
        client.getRegionsByParentId(request, callback, userState);
    }

    /**
     * 通过行政区域id获取站长列表信息
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getRegionsStationByParentId(StationListByRegionIdRequest request, IAsyncResultCallback<StationListByRegionIdResponse> callback, Object userState) {
        client.getRegionsStationByParentId(request, callback, userState);
    }

    /**
     * 新建收货地址 这里有个问题  服务器最外层的success 应该的表示的是请求成功  不应该是接口访问处理的结果是什么 所以这里的结果又问题
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void createShipAddress(CreateShipAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.createShipAddress(request, callback, userState);
    }

    /**
     * 删除收货地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void deleteShipAddress(DeleteShipAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.deleteShipAddress(request, callback, userState);
    }

    /**
     * 修改收货地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void mobifyShipAddress(MobifyShipAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.mobifyShipAddress(request, callback, userState);
    }

    /**
     * 设置默认地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void setDefaultShipAddress(SetDefaultAddressRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.setDefaultShipAddress(request, callback, userState);
    }

    /**
     * 代付款 待处理 付款数量
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getQuantityNumber(IAsyncResultCallback<QuantityResponse> callback, Object userState) {
        client.getQuantityNumber(callback, userState);
    }

    /**
     * 商品详情添加商品到购物车
     *
     * @param callback
     * @param userState
     * @return
     */
    public void addGoods(AddGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.addGoods(request, callback, userState);
    }

    /**
     * 购物车列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getCartList(IAsyncResultCallback<CartListResponse> callback, Object userState) {
        client.getCartList(callback, userState);
    }

    /**
     * 更新购物车的数量
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void updateGoodsQuantity(UpdateGoodsQuantityRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.updateGoodsQuantity(request, callback, userState);
    }

    /**
     * 购物车商品删除
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void removeGoods(RemoveGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.removeGoods(request, callback, userState);
    }

    /**
     * 购物车提交订单 订单确认
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void orderConfirm(OrderConfirmRequest request, IAsyncResultCallback<OrderConfirmResponse> callback, Object userState) {
        client.orderConfirm(request, callback, userState);
    }

    /**
     * 购物车订单确认 商品运费 同时也是修改数量的接口
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderFreightAndUpdateOrderCounts(OrderFreightRequest request, IAsyncResultCallback<OrderFreightResponse> callback, Object userState) {
        client.getOrderFreightAndUpdateOrderCounts(request, callback, userState);
    }

    /**
     * 购物车订单提交  创建新订单  注意这里只能生产一个商家的店铺的商品 不能是多家的商品 订单生成
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void newUserGoodsOrder(NewUserGoodsOrderRequest request, IAsyncResultCallback<NewUserGoodsOrderresponse> callback, Object userState) {
        client.newUserGoodsOrder(request, callback, userState);
    }

    /**
     * 商品详情描述  图片描述  请求都是id 用一个
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void goodsDetailImage(GoodsDetailRequest request, IAsyncResultCallback<GoodsDetailDescResponse> callback, Object userState) {
        client.goodsDetailImage(request, callback, userState);
    }

    /**
     * 商品详情描述 信息描述
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void goodsDeatailInfo(GoodsDetailRequest request, IAsyncResultCallback<GoodsDetailInfoResponse> callback, Object userState) {
        client.goodsDeatailInfo(request, callback, userState);
    }

    /**
     * 获取店铺信息
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */

    public void getShopInfo(GetShopIdRequest request, IAsyncResultCallback<GetShopIdResponse> callback, Object userState) {
        client.getShopInfo(request, callback, userState);
    }

    /**
     * 得到最新评论
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getNetComment(GetNewCommentRequest request, IAsyncResultCallback<GetNewCommentResponse> callback, Object userState) {
        client.getNetComment(request, callback, userState);
    }

    /**
     * 单个商品运费
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getGoodsFreight(GetGoodsFreightRequest request, IAsyncResultCallback<GetGoodsFreightResponse> callback, Object userState) {
        client.getGoodsFreight(request, callback, userState);
    }

    /**
     * 获取app更新状态
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getAppNewVersion(IAsyncResultCallback<AppNewVersionResponse> callback, Object userState) {
        client.getAppNewVersion(callback, userState);
    }

    /**
     * 电话 充值  的列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getMobileOrderList(IAsyncResultCallback<MobileOrderListResponse> callback, Object userState) {
        client.getMobileOrderList(callback, userState);
    }

    /**
     * 支付通道申请
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getPayApplyAndChannel(PayApplyAndChannelRequest request, IAsyncResultCallback<PayApplyAndChannelResponse> callback, Object userState) {
        client.getPayApplyAndChannel(request, callback, userState);
    }

    /**
     * 电话充值 订单确认 注意和购物车的订单不一样
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void mobifyOrderPayComfirm(MobifyOrderPayConfirmRequest request, IAsyncResultCallback<MobifyOrderPayConfirmResponse> callback, Object userState) {
        client.mobifyOrderPayComfirm(request, callback, userState);
    }

    /**
     * 创建话费的订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void createMobileOrder(CreateMobileOrderRequest request, IAsyncResultCallback<CreateMobileOrderResponse> callback, Object userState) {
        client.createMobileOrder(request, callback, userState);
    }

    /**
     * 获取各订单数量
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderQuantityNumber(IAsyncResultCallback<GetOrderQuantityResponse> callback, Object userState) {
        client.getOrderQuantityNumber(callback, userState);
    }

    /**
     * 订单列表  所有的请求参数 和响应是一样的  只是请求的参数不一样
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderAllList(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderAllList(request, callback, userState);
    }

    /**
     * 代付款订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderListWaitForPayment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForPayment(request, callback, userState);
    }

    /**
     * 待发货 待收货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderListWaitForReceive(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForReceive(request, callback, userState);
    }

    /**
     * 待发货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderListWaitForDispatch(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForDispatch(request, callback, userState);
    }

    /**
     * 待评价
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderListWaitForComment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForComment(request, callback, userState);
    }

    /**
     * 订单详情
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderDetail(OrderOperateRequest request, IAsyncResultCallback<OrderDetailResponse> callback, Object userState) {
        client.getOrderDetail(request, callback, userState);
    }

    /**
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getHeplCenter(GetHelpCenterContentRequest request, IAsyncResultCallback<GetHeplCenterContentResponse> callback, Object userState) {
        client.getHeplCenter(request, callback, userState);
    }

    /**
     * 退货流程
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getTextContent(GetTextContentRequest request, IAsyncResultCallback<GetTextCOntentResponse> callback, Object userState) {
        client.getTextContent(request, callback, userState);
    }

    /**
     * 网站订单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getNetOrder(NetOrderRequest request, IAsyncResultCallback<NetOrderResponse> callback, Object userState) {
        client.getNetOrder(request, callback, userState);
    }


    /**
     * 获取用户信息
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getMemberInfo(IAsyncResultCallback<GetMemberInfoResponse> callback, Object userState) {
        client.getMemberInfo(callback, userState);
    }

    /**
     * 修改用户信息 性别  昵称 等 修改那个字段就传那个字段
     *
     * @param callback
     * @param userState
     * @return
     */
    public void updateMobifyMember(MobifyMemberRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.updateMobifyMember(request, callback, userState);
    }

    /**
     * 意见反馈
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void postSuggest(PostSuggestRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.postSuggest(request, callback, userState);
    }

    /**
     * 获取活动页面N
     *
     * @param callback
     * @param userState
     * @return
     */
    public void getActivePageDataById(IAsyncResultCallback<List<GetActivePageDataResponse>> callback, Object userState) {
        client.getActivePageDataById(callback, userState);
    }

    /**
     * 获取sku库N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getSkuStock(GetSkuStockRequest request, IAsyncResultCallback<GetSkuStockResponse> callback, Object userState) {
        client.getSkuStock(request, callback, userState);
    }



    /**
     * 设置用户头像N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void setHeadPortraitResuest(SetHeadPortraitResuest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.setHeadPortraitResuest(request, callback, userState);
    }

    /**
     * 添加商品评论N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void addGoodsComment(AddGoodsCommentRequest request, IAsyncResultCallback<AddGoodsCommentResponse> callback, Object userState) {
        client.addGoodsComment(request, callback, userState);
    }

    /**
     * 通过商品id得到评论列表N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getGoodsCommentList(GetGoodsCommentListRequest request, IAsyncResultCallback<GetGoodsCommentListResponse> callback, Object userState) {
        client.getGoodsCommentList(request, callback, userState);
    }

    /**
     * 追加评论N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void appendComment(AppendCommentRequest request, IAsyncResultCallback<AppendCommentResponse> callback, Object userState) {
        client.appendComment(request, callback, userState);
    }

    /**
     * 银行卡列表N
     *
     * @param callback
     * @param userState
     */
    public void bankCardList(IAsyncResultCallback<List<BankCardListResponse>> callback, Object userState) {
        client.bankCardList(callback, userState);
    }

    /**
     * 银行卡绑定申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void bankCardBindApply(BankCardBindApplyRequest request, IAsyncResultCallback<BankCardBindApplyResponse> callback, Object userState) {
        client.bankCardBindApply(request, callback, userState);
    }

    /**
     * 银行卡绑定N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void bankCardBind(BankCardBindRequest request, IAsyncResultCallback<BankCardBindResponse> callback, Object userState) {
        client.bankCardBind(request, callback, userState);
    }

    /**
     * 支付应用申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void payApply(PayApplyRequest request, IAsyncResultCallback<PayApplyResponse> callback, Object userState) {
        client.payApply(request, callback, userState);
    }

    /**
     * 协议支付N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void protocolPay(ProtocolRequest request, IAsyncResultCallback<ProtocolResponse> callback, Object userState) {
        client.protocolPay(request, callback, userState);
    }

    /**
     * 充值查询N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void queryCart(QueryCartRequest request, IAsyncResultCallback<QueryCartResponse> callback, Object userState) {
        client.queryCart(request, callback, userState);
    }

    /**
     * 订单删除N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void orderDelete(OrderOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.orderDelete(request, callback, userState);
    }

    /**
     * 订单取消N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void orderCancel(OrderOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.orderCancel(request, callback, userState);
    }

    /**
     * 签收订单N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void receiveOreder(OrderOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.receiveOreder(request, callback, userState);
    }

    /**
     * 延迟收货N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void delayedReceive(OrderOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.delayedReceive(request, callback, userState);
    }

    /**
     * 获取订单物流信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void logisticsInfo(OrderOperateRequest request, IAsyncResultCallback<LogisticsInfoResponse> callback, Object userState) {
        client.logisticsInfo(request, callback, userState);
    }

    /**
     * 新售后申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void newApply(NewApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.newApply(request, callback, userState);
    }

    /**
     * 更改售后申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void updateApply(UpdateApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.updateApply(request, callback, userState);
    }

    /**
     * 添加退货信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void newReturnGoods(NewReturnGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.newReturnGoods(request, callback, userState);
    }

    /**
     * 退款售后列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void refundList(RefundListRequest request, IAsyncResultCallback<RefundListResponse> callback, Object userState) {
        client.refundList(request, callback, userState);
    }

    /**
     * 退款售后明细N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void refundDetail(RefundDetailRequest request, IAsyncResultCallback<RefundDetailResponse> callback, Object userState) {
        client.refundDetail(request, callback, userState);
    }

    /**
     * 退款申请确定N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void applyRefundConfirm(ApplyRefundConfirmRequest request, IAsyncResultCallback<ApplyRefundConfirmResponse> callback, Object userState) {
        client.applyRefundConfirm(request, callback, userState);
    }

    /**
     * 获取分类中首条文本内容信息
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void getFirstTextContent(GetFirstTextContentRequest request, IAsyncResultCallback<GetFirstTextContentResponse> callback, Object userState) {
        client.getFirstTextContent(request, callback, userState);
    }

    /**
     * 站长代付申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void userApply(OrderOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.userApply(request, callback, userState);
    }

    /**
     * 拒绝代付N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void refuseApply(RefuseApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.rRefuseApply(request, callback, userState);
    }

    /**
     * 代付款得到申请列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void waitPayOrderApplyList(WaitPayOrderApplyListRequest request, IAsyncResultCallback<WaitPayOrderApplyListResponse> callback, Object userState) {
        client.waitPayOrderApplyList(request, callback, userState);
    }

    /**
     * 获取申请详细信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void payApplyDetail(OperateIdRequest request, IAsyncResultCallback<PayApplyDetailResponse> callback, Object userState) {
        client.payApplyDetail(request, callback, userState);
    }

    /**
     * 待处理代付数量获取N
     *
     * @param callback
     * @param userState
     */
    public void payApplyQuantity(IAsyncResultCallback<PayApplyQuantityResponse> callback, Object userState) {
        client.payApplyQuantity( callback, userState);
    }

    /**
     * 用户收货相关信息，若存在记录则进行收货信息更新N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void bindToStation(BindToStationRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.bindToStation(request, callback, userState);
    }

    /**
     * 站点用户获取我的站点信息N
     *
     * @param callback
     * @param userState
     */
    public void getMyStationInfo(IAsyncResultCallback<GetMyStationInfoResponse> callback, Object userState) {
        client.getMyStationInfo(callback, userState);
    }

    /**
     * 获取当前站长用户所在站点的客户列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void getStationCustomerList(GetStationCustomerListRequest request, IAsyncResultCallback<GetStationCustomerListResponse> callback, Object userState) {
        client.getStationCustomerList(request, callback, userState);
    }
    /**
     * 站点用户添加站点客户N
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void addNewStationCustomer(AddNewStationCustomerRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.addNewStationCustomer(request, callback, userState);
    }

    /**
     * 获取站点客户信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void getStationCustomer(OperateIdRequest request, IAsyncResultCallback<GetStationCustomerResponse> callback, Object userState) {
        client.getStationCustomer(request, callback, userState);
    }

    /**
     * 更新站点客户信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void updateStationCustomer(UpdateStationCustomerRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.updateStationCustomer(request, callback, userState);
    }

    /**
     * 添加商品至站长推荐N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void addRecommend(AddRecommendRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.addRecommend(request, callback, userState);
    }

    /**
     * 得到站点信息和站点联系人信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void getStationCodeItem(GetStationCodeItemRequest request, IAsyncResultCallback<GetStationCodeItemResponse> callback, Object userState) {
        client.getStationCodeItem(request, callback, userState);
    }

    /**
     * 站长客户订单列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public void stationList(StationListRequest request, IAsyncResultCallback<StationListResponse> callback, Object userState) {
        client.stationList(request, callback, userState);
    }


}
