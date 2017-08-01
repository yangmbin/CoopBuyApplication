package com.coopbuy.mall.ui.mainpage.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.api.login.LoginRequest;
import com.coopbuy.mall.api.login.LoginResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {
    LoginClient client = new LoginClient();

    @Override
    public int getLayoutId() {
        return R.layout.activity_test2;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.btn_login, R.id.btn_category})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                LoginRequest request = new LoginRequest();
                request.setUserName("13885758966 ");
                request.setPassWord("GNwhb8966");
                client.LoginRequest(request, new IAsyncResultCallback<LoginResponse>() {
                    @Override
                    public void onComplete(LoginResponse loginResponse, Object userState) {

                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {
                        if (error != null) {
                            error.getDetail();
                        }
                    }
                }, "login");
                break;
            case R.id.btn_category:
                client.getCatetorys(new IAsyncResultCallback<List<CategorysResponse>>() {
                    @Override
                    public void onComplete(List<CategorysResponse> categorysResponses, Object userState) {
                        if (categorysResponses != null) {
                            ToastUtils.toastShort("分类测试成功");
                        }
                    }

                    @Override
                    public void onError(NetworkException error, Object userState) {

                    }
                }, "cate");
                break;
        }
    }
}
