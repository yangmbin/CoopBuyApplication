package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;
import android.os.CountDownTimer;


import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.RegisterModel;
import com.coopbuy.mall.ui.module.center.view.Register_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author csn
 * @date 2017/10/16 0016 14:47
 * @content
 */
public class RegisterPresenter extends BasePresenter<Register_IView, RegisterModel> {
    public RegisterPresenter(Context mContext, RegisterModel mModel, Register_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getSMSCode(String phone) {
        mView.showTransLoading();
        ImageCodeRequest request = new ImageCodeRequest();
        request.setPhone(phone);
        time = new TimeCounts(TIMECOUNT, 1000);
        mView.appendNetCall(mModel.getSMS(request, new IAsyncResultCallback<SMSCodeReponse>() {
            @Override
            public void onComplete(SMSCodeReponse smsCodeReponse, Object userState) {
                mView.smsCode(smsCodeReponse.getCode());
                mView.stopAll();
                time.start();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "sms"));
    }

    private TimeCounts time;
    private final int TIMECOUNT = 12000 * 10;//倒计时时间

    /**
     * 计时器
     **/
    private class TimeCounts extends CountDownTimer {

        public TimeCounts(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            mView.onTimeTick(l);
        }

        @Override
        public void onFinish() {
            mView.onTimeFinish();
        }
    }
}
