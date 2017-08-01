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

    /**
     * 商品分类
     *
     * @param callback
     * @param usetState
     * @return
     */
    public IAsyncRequestState getCatetorys(IAsyncResultCallback<List<CategorysResponse>> callback, Object usetState) {
        return apiPostRequest(new TypeToken<List<CategorysResponse>>() {
        }.getType(), Constant.SERVER_URL + Constant.COTEGORYS, callback, usetState);
    }
}
