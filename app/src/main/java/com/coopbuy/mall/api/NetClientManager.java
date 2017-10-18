package com.coopbuy.mall.api;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.api.reponse.ChangeAndForgetPwdResponse;
import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.api.reponse.GetProviencesReponse;
import com.coopbuy.mall.api.reponse.HomePageDataByIdResponse;
import com.coopbuy.mall.api.reponse.HomePageDataResponse;
import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
import com.coopbuy.mall.api.request.GetOrderListRequest;
import com.coopbuy.mall.api.request.HomePageDataByIdRequest;
import com.coopbuy.mall.api.request.HomePageDataRequest;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.api.request.OrderListRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
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
     * 得到地址信息
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getAddressData(IAsyncResultCallback<List<AddressInfoResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<AddressInfoResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ADDRESSLIST, callback, userState);
    }

    /**
     * 添加地址
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addAddress(AddAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(Constant.SERVER_URL_NEW + Constant.ADDADDRESSS, request, callback, userState);
    }

    /**
     * 得到省市区地址数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getProvinces(IAsyncResultCallback<List<AreaDataResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<AreaDataResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.PROVINCES, callback, userState);
    }

    /**
     * 获取村  社区数据
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getChildProvinces(GetChildProvincesRequest request, IAsyncResultCallback<List<AddressTownResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<AddressTownResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.CHILD_PROVINCES, request, callback, userState);
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

    /**
     * 获取商品描述
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getDescriptionData(ProductIdRequest request, IAsyncResultCallback<DescriptionResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<DescriptionResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_DESCRIPTION, request, callback, userState);
    }


    /**
     * 获取商品Sku列表
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getSkuInfoListData(ProductIdRequest request, IAsyncResultCallback<List<SkuInfoResponse>> callback, Object userState) {
        return apiPostRequest(new TypeToken<List<SkuInfoResponse>>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.GET_SKU_INFO_LIST, request, callback, userState);
    }

    /**
     * 获取指定规格值或属性值的sku信息
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState findSkuInfoData(FindSkuInfoRequest request, IAsyncResultCallback<SkuDetailResponse.SkuInfoBean> callback, Object userState) {
        return apiPostRequest(new TypeToken<SkuDetailResponse.SkuInfoBean>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.FIND_SKU_INFO, request, callback, userState);
    }

    /**
     * 订单列表
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderList(OrderListRequest request, IAsyncResultCallback<OrderListResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderListResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ORDER_LIST, request, callback, userState);
    }

    /**
     * 订单详情
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderDetail(OrderDetailRequest request, IAsyncResultCallback<OrderDetailResponse> callback, Object userState) {
        return apiPostRequest(new TypeToken<OrderDetailResponse>() {
        }.getType(), Constant.SERVER_URL_NEW + Constant.ORDER_DETAIL, request, callback, userState);
    }
}
