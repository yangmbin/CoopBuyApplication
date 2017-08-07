package com.coopbuy.mall.api.login;

import android.content.Context;

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
        }.getType(), Constant.SERVER_URL + Constant.LOGIN_REGISTER, callback, userState);
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
        }.getType(), Constant.LOGIN_QUIT, request, callback, userState);
    }

}
