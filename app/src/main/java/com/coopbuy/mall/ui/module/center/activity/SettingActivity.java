package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.SettingModel;
import com.coopbuy.mall.ui.module.center.presenter.SettingPresenter;
import com.coopbuy.mall.ui.module.center.view.Setting_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity<SettingPresenter, SettingModel> implements Setting_IView {


    @Bind(R.id.iv_check_movement)
    CheckBox ivCheckMovement;
    @Bind(R.id.tv_set_quit)
    TextView tvSetQuit;

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

    @Override
    public void initView() {
        setTitle(R.string.title_set);
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
                IntentUtils.gotoActivity(this, SetPassWordActivity.class);
                break;
            case R.id.ll_suggest:
                IntentUtils.gotoActivity(this, SuggestionActivity.class);
                break;
            case R.id.ll_clear_images:
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

    @Override
    public void quitSucces() {
        ToastUtils.toastShort("退出成功");
        sharedPreferencesUtils.clearUserData();
        this.finish();
    }

    @Override
    public void quitFail(String mesg) {
        ToastUtils.toastShort(mesg);
    }


}
