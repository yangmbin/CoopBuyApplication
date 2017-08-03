package com.coopbuy.mall.ui.module.test.presenter;

import android.content.Context;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.api.login.LoginRequest;
import com.coopbuy.mall.api.login.LoginResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.test.model.NiuTestModel;
import com.coopbuy.mall.ui.module.test.view.NiuTest_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.google.gson.Gson;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 17:11
 * @content
 */
public class NiuTestPresenter extends BasePresenter<NiuTest_IView, NiuTestModel> {
    private LoginClient client;
    private Gson gson;

    public NiuTestPresenter(Context mContext, NiuTestModel mModel, NiuTest_IView mView) {
        super(mContext, mModel, mView);
    }

    public void sendRequest(String value) {
        client = new LoginClient();
        gson = new Gson();
        mView.showFillLoading();
        switch (value) {
            case "登录":
                LoginRequest request = new LoginRequest();
                request.setUserName("18786712371");
                request.setPassWord("xh123456");
                client.LoginRequest(request, new IAsyncResultCallback<LoginResponse>() {
                    @Override
                    public void onComplete(LoginResponse loginResponse, Object userState) {
                        if (loginResponse != null) {
                            mView.showData(gson.toJson(loginResponse));
                            ToastUtils.toastShort("登录成功");
                            mView.stopLoading();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                            mView.showData(error.getDetail());
                            mView.stopLoading();
                        }
                    }
                }, "login");
                break;
            case "注册":
                break;
            case "忘记密码":
                break;
            case "修改密码":
                break;
            case "图形验证":
                break;
            case "首页":
                break;
            case "分类":
                client.getCatetorys(new IAsyncResultCallback<List<CategorysResponse>>() {
                    @Override
                    public void onComplete(List<CategorysResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            mView.showData(gson.toJson(categorysResponses));
                            ToastUtils.toastShort("分类测试成功");
                            mView.stopLoading();
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        mView.showData(error.getDetail());
                        mView.stopLoading();
                    }
                }, "cate");
                break;
            case "搜索":

                break;
            default:
                break;


        }
    }
}
