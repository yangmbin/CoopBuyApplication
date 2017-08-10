package com.coopbuy.mall.ui.module.test.model;

import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.AddGoodsRequest;
import com.coopbuy.mall.api.login.AppNewVersionResponse;
import com.coopbuy.mall.api.login.CartListResponse;
import com.coopbuy.mall.api.login.CreateMobileOrderRequest;
import com.coopbuy.mall.api.login.CreateMobileOrderResponse;
import com.coopbuy.mall.api.login.CreateShipAddressRequest;
import com.coopbuy.mall.api.login.DeleteShipAddressRequest;
import com.coopbuy.mall.api.login.GetDefaultAddressResponse;
import com.coopbuy.mall.api.login.GetGoodsFreightRequest;
import com.coopbuy.mall.api.login.GetGoodsFreightResponse;
import com.coopbuy.mall.api.login.GetHeplCenterContentRequest;
import com.coopbuy.mall.api.login.GetHeplCenterContentResponse;
import com.coopbuy.mall.api.login.GetMemberInfoResponse;
import com.coopbuy.mall.api.login.GetNewCommentRequest;
import com.coopbuy.mall.api.login.GetNewCommentResponse;
import com.coopbuy.mall.api.login.GetOrderAllListRequest;
import com.coopbuy.mall.api.login.GetOrderAllListResponse;
import com.coopbuy.mall.api.login.GetOrderQuantityResponse;
import com.coopbuy.mall.api.login.GetShopIdRequest;
import com.coopbuy.mall.api.login.GetShopIdResponse;
import com.coopbuy.mall.api.login.GetStationRecommendResponse;
import com.coopbuy.mall.api.login.GetTextCOntentResponse;
import com.coopbuy.mall.api.login.GetTextContentRequest;
import com.coopbuy.mall.api.login.GoodsDetailDescResponse;
import com.coopbuy.mall.api.login.GoodsDetailInfoResponse;
import com.coopbuy.mall.api.login.GoodsDetailRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.api.login.ImageCodeRequest;
import com.coopbuy.mall.api.login.ImageCodeResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.api.login.LoginQuitRespsonse;
import com.coopbuy.mall.api.login.LoginRequest;
import com.coopbuy.mall.api.login.LoginResponse;
import com.coopbuy.mall.api.login.MobifyOrderPayConfirmRequest;
import com.coopbuy.mall.api.login.MobifyOrderPayConfirmResponse;
import com.coopbuy.mall.api.login.MobifyShipAddressRequest;
import com.coopbuy.mall.api.login.MobileOrderListResponse;
import com.coopbuy.mall.api.login.NetOrderRequest;
import com.coopbuy.mall.api.login.NetOrderResponse;
import com.coopbuy.mall.api.login.NewUserGoodsOrderRequest;
import com.coopbuy.mall.api.login.NewUserGoodsOrderresponse;
import com.coopbuy.mall.api.login.OperateSuccessResponse;
import com.coopbuy.mall.api.login.OrderConfirmRequest;
import com.coopbuy.mall.api.login.OrderConfirmResponse;
import com.coopbuy.mall.api.login.OrderFreightRequest;
import com.coopbuy.mall.api.login.OrderFreightResponse;
import com.coopbuy.mall.api.login.PayApplyAndChannelRequest;
import com.coopbuy.mall.api.login.PayApplyAndChannelResponse;
import com.coopbuy.mall.api.login.PostSuggestRequest;
import com.coopbuy.mall.api.login.QuantityResponse;
import com.coopbuy.mall.api.login.RegionsByParentIdRequest;
import com.coopbuy.mall.api.login.RegionsByParentIdResponse;
import com.coopbuy.mall.api.login.RegionsResponse;
import com.coopbuy.mall.api.login.RegisterRequest;
import com.coopbuy.mall.api.login.RegisterResponse;
import com.coopbuy.mall.api.login.RemoveGoodsRequest;
import com.coopbuy.mall.api.login.SendSmsCodeRequest;
import com.coopbuy.mall.api.login.SendSmsCodeResponse;
import com.coopbuy.mall.api.login.SetDefaultAddressRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeResponse;
import com.coopbuy.mall.api.login.SmsResetPasswordRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordResponse;
import com.coopbuy.mall.api.login.StationListByRegionIdRequest;
import com.coopbuy.mall.api.login.StationListByRegionIdResponse;
import com.coopbuy.mall.api.login.UpdateGoodsQuantityRequest;
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
     * 获得站长推荐的商品
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
    public void getOrderAllList(GetOrderAllListRequest request, IAsyncResultCallback<GetOrderAllListResponse> callback, Object userState) {
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
    public void getOrderListWaitForPayment(GetOrderAllListRequest request, IAsyncResultCallback<GetOrderAllListResponse> callback, Object userState) {
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
    public void getOrderListWaitForReceive(GetOrderAllListRequest request, IAsyncResultCallback<GetOrderAllListResponse> callback, Object userState) {
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
    public void getOrderListWaitForDispatch(GetOrderAllListRequest request, IAsyncResultCallback<GetOrderAllListResponse> callback, Object userState) {
        client.getOrderListWaitForReceive(request, callback, userState);
    }

    /**
     * 待评价
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getOrderListWaitForComment(GetOrderAllListRequest request, IAsyncResultCallback<GetOrderAllListResponse> callback, Object userState) {
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
    public void getOrderDetail(GetOrderAllListRequest request, IAsyncResultCallback<GetOrderAllListResponse> callback, Object userState) {
        client.getOrderDetail(request, callback, userState);
    }

    /**
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public void getHeplCenter(GetHeplCenterContentRequest request, IAsyncResultCallback<GetHeplCenterContentResponse> callback, Object userState) {
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
    public void updateMobifyMember(IAsyncResultCallback<OperateSuccessResponse> callback, Object userState) {
        client.updateMobifyMember(callback, userState);
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
}
