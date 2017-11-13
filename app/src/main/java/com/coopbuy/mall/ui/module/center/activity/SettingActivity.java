package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.app.CoopBuyApplication;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.ui.module.center.model.SettingModel;
import com.coopbuy.mall.ui.module.center.presenter.SettingPresenter;
import com.coopbuy.mall.ui.module.center.view.Setting_IView;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.DataCleanManager;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.FinalConstant;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity<SettingPresenter, SettingModel> implements Setting_IView {

    public static final int MSG_GETSIZE = 1;    //获得缓存大小
    @Bind(R.id.iv_check_movement)
    CheckBox ivCheckMovement;
    @Bind(R.id.tv_set_quit)
    TextView tvSetQuit;
    @Bind(R.id.tv_size)
    TextView mSize;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initModel() {
        mModel = new SettingModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SettingPresenter(this, mModel, this);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_GETSIZE:
                    Bundle bundle = msg.getData();
                    mSize.setText(bundle.getString("size"));
                    stopAll();
                    break;
            }
        }
    };

    @Override
    public void initView() {
        setTitle(R.string.title_set);
        getCacheSize();
        if (sharedPreferencesUtils.getLoginStatus()) {
            tvSetQuit.setVisibility(View.VISIBLE);
        } else {
            tvSetQuit.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.ll_change_password, R.id.ll_suggest, R.id.ll_clear_images, R.id.ll_about, R.id.iv_check_movement, R.id.tv_set_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_change_password:
                IntentUtils.gotoActivity(this, ForgetPwdActivity.class, Constants.CHANGE_TYPE);
                break;
            case R.id.ll_suggest:
                IntentUtils.gotoActivity(this, SuggestionActivity.class);
                break;
            case R.id.ll_clear_images:
                DialogUtils.showTwoKeyDialog(this, new CommonDialog.ClickCallBack() {
                    @Override
                    public void onConfirm() {
                        showTransLoading();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DataCleanManager.cleanApplicationData(mContext);
                                getCacheSize();
                            }
                        }).start();
                    }
                }, "确定清除本地缓存?", "取消", "确定");
                break;
            case R.id.iv_check_movement:

                break;
            case R.id.tv_set_quit:
                mPresenter.quit();
                break;
            case R.id.ll_about:
                IntentUtils.gotoActivity(this, AboutActivity.class);
                break;
        }
    }

    public void getCacheSize() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String size = DataCleanManager.getCacheSize(CoopBuyApplication.getAppContext().getCacheDir());
                    Message message = mHandler.obtainMessage();
                    message.what = MSG_GETSIZE;
                    Bundle bundle = new Bundle();
                    bundle.putString("size", size);
                    message.setData(bundle);
                    mHandler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void quitSucces() {
        ToastUtils.toastShort("退出成功");
        sharedPreferencesUtils.clearUserData();
        IntentUtils.gotoMainActivity(this, MainActivity.class, FinalConstant.MAIN_HOME_TYPE);
        this.finish();
    }

    @Override
    public void quitFail(String mesg) {
        ToastUtils.toastShort(mesg);
    }
}
