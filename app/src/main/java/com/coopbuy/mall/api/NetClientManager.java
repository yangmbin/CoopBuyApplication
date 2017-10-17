package com.coopbuy.mall.api;

import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.api.reponse.ChangeAndForgetPwdResponse;
import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.api.reponse.HomePageDataByIdResponse;
import com.coopbuy.mall.api.reponse.HomePageDataResponse;
import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.request.GetOrderListRequest;
import com.coopbuy.mall.api.request.HomePageDataByIdRequest;
import com.coopbuy.mall.api.request.HomePageDataRequest;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.google.gson.reflect.TypeToken;
import com.guinong.net.callback.IAsyncEmptyCallback;
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
//    新下行  以前写的没有用了  暂时不删除

    /**
     * 登录
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.LOGIN, request, callback, userState);
    }

    /**
     * 图形验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState imageCode(ImageCodeRequest request, IAsyncResultCallback<String> callback, Object userState) {
        return apiGetRequest(new TypeToken<String>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.IMAGE_CODE, request, callback, userState);
    }

    /**
     * 退出登录
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState quit(IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.LOGOUT, callback, userState);
    }

    /**
     * 注册短信验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSMSCode(ImageCodeRequest request, IAsyncResultCallback<SMSCodeReponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SMSCodeReponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SMSCODE, request, callback, userState);
    }

    /**
     * 重置密码的短信
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSMSCodeUpdate(ImageCodeRequest request, IAsyncResultCallback<SMSCodeReponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SMSCodeReponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.SMSCODE_UPDATE, request, callback, userState);
    }

    /**
     * 更新 找回密码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState updatePwd(ChangeAndForgetPwdRequest request, IAsyncResultCallback<ChangeAndForgetPwdResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<ChangeAndForgetPwdResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.UPDATEPASSWORD, request, callback, userState);
    }

    /**
     * 注册
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState register(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<RegisterResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.REGISTER, request, callback, userState);
    }

    /**
     * 个人中心数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getUserInfo(IAsyncResultCallback<UserCenterInfoResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<UserCenterInfoResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.USERCENTERINFO, callback, userState);
    }

    /**
     * 获取分类数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCategoryData(IAsyncResultCallback<List<CategoryResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<CategoryResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_CATEGORY_DATA, callback, userState);
    }

    /**
     * 获取SKU详情
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSkuDetailData(SkuDetailRequest request, IAsyncResultCallback<SkuDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<SkuDetailResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_SKU_DETAIL, request, callback, userState);
    }


}
