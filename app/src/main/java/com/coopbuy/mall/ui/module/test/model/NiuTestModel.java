package com.coopbuy.mall.ui.module.test.model;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.*;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 17:09
 * @content
 */
public class NiuTestModel implements BaseModel {


    public IAsyncRequestState getImageCode(ImageCodeRequest request, IAsyncResultCallback<ImageCodeResponse> callback, Object userState) {
        return client.getImageCode(request, callback, userState);
    }

    public IAsyncRequestState sendSmsCode(SendSmsCodeRequest request, IAsyncResultCallback<SendSmsCodeResponse> callback, Object userState) {
        return client.senSmsCode(request, callback, userState);

    }

    public IAsyncRequestState smsResetPasswordGetCode(SmsResetPasswordGetCodeRequest request, IAsyncResultCallback<SmsResetPasswordGetCodeResponse> callback, Object userState) {
        return client.smsResetPasswordGetCode(request, callback, userState);
    }

    public IAsyncRequestState smsResetPassword(SmsResetPasswordRequest request, IAsyncResultCallback<SmsResetPasswordResponse> callback, Object userState) {
        return client.smsResetPassword(request, callback, userState);
    }

    public IAsyncRequestState registerUser(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        return client.register(request, callback, userState);
    }

    public IAsyncRequestState loginQuit(IAsyncResultCallback<LoginQuitRespsonse> callback, Object userState) {
        return client.quitUser(callback, userState);
    }

    public IAsyncRequestState homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        return client.homePageData(request, callback, userState);
    }

    public IAsyncRequestState getCategorys(IAsyncResultCallback<List<CategorysResponse>> callback, Object userState) {
        return client.getCategorys(callback, userState);
    }

    /**
     * 获得站长推荐的商品
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getStationRecommend(IAsyncResultCallback<List<GetStationRecommendResponse>> callback, Object userState) {
        return client.getStationRecommend(callback, userState);
    }

    /**
     * 获取Banner详情
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
        return client.getPageDataById(request, callback, userState);
    }

    /**
     * 获得默认收货地址
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDefalutAddress(IAsyncResultCallback<GetDefaultAddressResponse> callback, Object userState) {
        return client.getDefalutAddress(callback, userState);
    }

    /**
     * 获取收货地址列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDefalutAddressList(IAsyncResultCallback<List<GetDefaultAddressResponse>> callback, Object userState) {
        return client.getDefalutAddressList(callback, userState);
    }

    /**
     * 获取行政区数
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getRegions(IAsyncResultCallback<List<RegionsResponse>> callback, Object userState) {
        return client.getRegions(callback, userState);
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
        return client.getRegionsByParentId(request, callback, userState);
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
        return client.getRegionsStationByParentId(request, callback, userState);
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
        return client.createShipAddress(request, callback, userState);
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
        return client.deleteShipAddress(request, callback, userState);
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
        return client.mobifyShipAddress(request, callback, userState);
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
        return client.setDefaultShipAddress(request, callback, userState);
    }

    /**
     * 代付款 待处理 付款数量
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getQuantityNumber(IAsyncResultCallback<QuantityResponse> callback, Object userState) {
        return client.getQuantityNumber(callback, userState);
    }

    /**
     * 商品详情添加商品到购物车
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addGoods(AddGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.addGoods(request, callback, userState);
    }

    /**
     * 购物车列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCartList(IAsyncResultCallback<CartListResponse> callback, Object userState) {
        return client.getCartList(callback, userState);
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
        return client.updateGoodsQuantity(request, callback, userState);
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
        return client.removeGoods(request, callback, userState);
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
        return client.orderConfirm(request, callback, userState);
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
        return client.getOrderFreightAndUpdateOrderCounts(request, callback, userState);
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
        return client.newUserGoodsOrder(request, callback, userState);
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
        return client.goodsDetailImage(request, callback, userState);
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
        return client.goodsDeatailInfo(request, callback, userState);
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
        return client.getShopInfo(request, callback, userState);
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
        return client.getNetComment(request, callback, userState);
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
        return client.getGoodsFreight(request, callback, userState);
    }

    /**
     * 获取app更新状态
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getAppNewVersion(IAsyncResultCallback<AppNewVersionResponse> callback, Object userState) {
        return client.getAppNewVersion(callback, userState);
    }

    /**
     * 电话 充值  的列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMobileOrderList(IAsyncResultCallback<MobileOrderListResponse> callback, Object userState) {
        return client.getMobileOrderList(callback, userState);
    }

    /**
     * 支付通道申请
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPayApplyAndChannel(PayApplyAndChannelRequest request, IAsyncResultCallback<PayApplyAndChannelResponse> callback, Object userState) {
        return client.getPayApplyAndChannel(request, callback, userState);
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
        return client.mobifyOrderPayComfirm(request, callback, userState);
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
        return client.createMobileOrder(request, callback, userState);
    }

    /**
     * 获取各订单数量
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderQuantityNumber(IAsyncResultCallback<GetOrderQuantityResponse> callback, Object userState) {
        return client.getOrderQuantityNumber(callback, userState);
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
        return client.getOrderAllList(request, callback, userState);
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
        return client.getOrderListWaitForPayment(request, callback, userState);
    }

    /**
     * 待发货 待收货
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderListWaitForReceive(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return client.getOrderListWaitForReceive(request, callback, userState);
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
        return client.getOrderListWaitForDispatch(request, callback, userState);
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
        return client.getOrderListWaitForComment(request, callback, userState);
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
        return client.getOrderDetail(request, callback, userState);
    }

    /**
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getHelpCenter(GetHelpCenterContentRequest request, IAsyncResultCallback<GetHeplCenterContentResponse> callback, Object userState) {
        return client.getHeplCenter(request, callback, userState);
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
        return client.getTextContent(request, callback, userState);
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
        return client.getNetOrder(request, callback, userState);
    }


    /**
     * 获取用户信息
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMemberInfo(IAsyncResultCallback<GetMemberInfoResponse> callback, Object userState) {
        return client.getMemberInfo(callback, userState);
    }

    /**
     * 修改用户信息 性别  昵称 等 修改那个字段就传那个字段
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updateMobifyMember(MobifyMemberRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.updateMobifyMember(request, callback, userState);
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
        return client.postSuggest(request, callback, userState);
    }

    /**
     * 获取活动页面N
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getActivePageDataById(IAsyncResultCallback<List<GetActivePageDataResponse>> callback, Object userState) {
        return client.getActivePageDataById(callback, userState);
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
        return client.getSkuStock(request, callback, userState);
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
        return client.setHeadPortraitResuest(request, callback, userState);
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
        return client.addGoodsComment(request, callback, userState);
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
        return client.getGoodsCommentList(request, callback, userState);
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
        return client.appendComment(request, callback, userState);
    }

    /**
     * 银行卡列表N
     *
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bankCardList(IAsyncResultCallback<List<BankCardListResponse>> callback, Object userState) {
        return client.bankCardList(callback, userState);
    }

    /**
     * 银行卡绑定申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bankCardBindApply(BankCardBindApplyRequest request, IAsyncResultCallback<BankCardBindApplyResponse> callback, Object userState) {
        return client.bankCardBindApply(request, callback, userState);
    }

    /**
     * 银行卡绑定N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bankCardBind(BankCardBindRequest request, IAsyncResultCallback<BankCardBindResponse> callback, Object userState) {
        return client.bankCardBind(request, callback, userState);
    }

    /**
     * 支付应用申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState payApply(PayApplyRequest request, IAsyncResultCallback<PayApplyResponse> callback, Object userState) {
        return client.payApply(request, callback, userState);
    }

    /**
     * 协议支付N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState protocolPay(ProtocolRequest request, IAsyncResultCallback<ProtocolResponse> callback, Object userState) {
        return client.protocolPay(request, callback, userState);
    }

    /**
     * 充值查询N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState queryCart(QueryCartRequest request, IAsyncResultCallback<QueryCartResponse> callback, Object userState) {
        return client.queryCart(request, callback, userState);
    }

    /**
     * 订单删除N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState orderDelete(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.orderDelete(request, callback, userState);
    }

    /**
     * 订单取消N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState orderCancel(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.orderCancel(request, callback, userState);
    }

    /**
     * 签收订单N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState receiveOreder(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.receiveOreder(request, callback, userState);
    }

    /**
     * 延迟收货N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState delayedReceive(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.delayedReceive(request, callback, userState);
    }

    /**
     * 获取订单物流信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState logisticsInfo(OrderIdOperateRequest request, IAsyncResultCallback<LogisticsInfoResponse> callback, Object userState) {
        return client.logisticsInfo(request, callback, userState);
    }

    /**
     * 新售后申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState newApply(NewApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.newApply(request, callback, userState);
    }

    /**
     * 更改售后申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState updateApply(UpdateApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.updateApply(request, callback, userState);
    }

    /**
     * 添加退货信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState newReturnGoods(NewReturnGoodsRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.newReturnGoods(request, callback, userState);
    }

    /**
     * 退款售后列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState refundList(RefundListRequest request, IAsyncResultCallback<RefundListResponse> callback, Object userState) {
        return client.refundList(request, callback, userState);
    }

    /**
     * 退款售后明细N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState refundDetail(RefundDetailRequest request, IAsyncResultCallback<RefundDetailResponse> callback, Object userState) {
        return client.refundDetail(request, callback, userState);
    }

    /**
     * 退款申请确定N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState applyRefundConfirm(ApplyRefundConfirmRequest request, IAsyncResultCallback<ApplyRefundConfirmResponse> callback, Object userState) {
        return client.applyRefundConfirm(request, callback, userState);
    }

    /**
     * 获取分类中首条文本内容信息
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getFirstTextContent(GetFirstTextContentRequest request, IAsyncResultCallback<GetFirstTextContentResponse> callback, Object userState) {
        return client.getFirstTextContent(request, callback, userState);
    }

    /**
     * 站长代付申请N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState userApply(OrderIdOperateRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.userApply(request, callback, userState);
    }

    /**
     * 拒绝代付N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState refuseApply(RefuseApplyRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.rRefuseApply(request, callback, userState);
    }

    /**
     * 代付款得到申请列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState waitPayOrderApplyList(WaitPayOrderApplyListRequest request, IAsyncResultCallback<WaitPayOrderApplyListResponse> callback, Object userState) {
        return client.waitPayOrderApplyList(request, callback, userState);
    }

    /**
     * 获取申请详细信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState payApplyDetail(OperateIdRequest request, IAsyncResultCallback<PayApplyDetailResponse> callback, Object userState) {
        return client.payApplyDetail(request, callback, userState);
    }

    /**
     * 待处理代付数量获取N
     *
     * @param callback
     * @param userState
     */
    public IAsyncRequestState payApplyQuantity(IAsyncResultCallback<PayApplyQuantityResponse> callback, Object userState) {
        return client.payApplyQuantity(callback, userState);
    }

    /**
     * 用户收货相关信息，若存在记录则进行收货信息更新N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState bindToStation(BindToStationRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.bindToStation(request, callback, userState);
    }

    /**
     * 站点用户获取我的站点信息N
     *
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getMyStationInfo(IAsyncResultCallback<GetMyStationInfoResponse> callback, Object userState) {
        return client.getMyStationInfo(callback, userState);
    }

    /**
     * 获取当前站长用户所在站点的客户列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getStationCustomerList(GetStationCustomerListRequest request, IAsyncResultCallback<GetStationCustomerListResponse> callback, Object userState) {
        return client.getStationCustomerList(request, callback, userState);
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
        return client.addNewStationCustomer(request, callback, userState);
    }

    /**
     * 获取站点客户信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getStationCustomer(OperateIdRequest request, IAsyncResultCallback<GetStationCustomerResponse> callback, Object userState) {
        return client.getStationCustomer(request, callback, userState);
    }

    /**
     * 更新站点客户信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState updateStationCustomer(UpdateStationCustomerRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.updateStationCustomer(request, callback, userState);
    }

    /**
     * 添加商品至站长推荐N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState addRecommend(AddRecommendRequest request, IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        return client.addRecommend(request, callback, userState);
    }

    /**
     * 得到站点信息和站点联系人信息N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getStationCodeItem(GetStationCodeItemRequest request, IAsyncResultCallback<GetStationCodeItemResponse> callback, Object userState) {
        return client.getStationCodeItem(request, callback, userState);
    }

    /**
     * 站长客户订单列表N
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState stationList(StationListRequest request, IAsyncResultCallback<StationListResponse> callback, Object userState) {
        return client.stationList(request, callback, userState);
    }


}
