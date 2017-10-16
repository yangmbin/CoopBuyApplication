package com.coopbuy.mall.api.login;

import com.coopbuy.mall.api.BaseApiClient;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.request.GetOrderListRequest;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
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
    public IAsyncRequestState getCategorys(IAsyncResultCallback<List<CategoryResponse>> callback, Object usetState) {
        return apiPostRequest(new TypeToken<List<CategoryResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.COTEGORYS, callback, usetState);
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









//    新下行  以前写的没有用了  暂时不删除

    public IAsyncRequestState login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<LoginResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.LOGIN, request, callback, userState);
    }

    /**
     * 获取分类数据
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
