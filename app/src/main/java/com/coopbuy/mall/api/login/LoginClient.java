package com.coopbuy.mall.api.login;

import com.coopbuy.mall.api.BaseApiClient;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.google.gson.reflect.TypeToken;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/1 0001 14:09
 * @content 这里是登录相关api
 */
public class LoginClient extends BaseApiClient {
    public LoginClient() {
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
    public IAsyncRequestState LoginRequest(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL + Constant.LOGIN, request, callback, userState);
    }
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
    public IAsyncRequestState getStationRecommend(IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<HomePageDataResponse>() {
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
    public IAsyncRequestState getRegionsByParentId(StationListByRegionIdRequest request, IAsyncResultCallback<List<RegionsByParentIdResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<RegionsByParentIdResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.GET_REGIONS_BY_PARENTID, request, callback, userState);
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
        }.getType(), Constant.SERVER_URL + Constant.ORDER_CONFIRM, request, callback, userState);
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


}
