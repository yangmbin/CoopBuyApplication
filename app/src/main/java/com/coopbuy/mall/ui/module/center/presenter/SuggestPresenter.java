package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.request.DeleteFootRequest;
import com.coopbuy.mall.api.request.SuggestRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.SuggestModel;
import com.coopbuy.mall.ui.module.center.view.Suggest_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;

/**
 * Created by niu on 2017/10/31- 17:12
 */
public class SuggestPresenter extends BasePresenter<Suggest_IView, SuggestModel> {
    public SuggestPresenter(Context mContext, SuggestModel mModel, Suggest_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 建议
     *
     * @param request
     */
    public void suggest(SuggestRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.suggestion(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.success();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, ""));
    }
}
