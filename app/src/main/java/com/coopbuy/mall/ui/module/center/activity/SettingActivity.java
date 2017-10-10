package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.CheckBox;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {


    @Bind(R.id.iv_check_movement)
    CheckBox ivCheckMovement;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.title_set);
    }

    @OnClick({R.id.ll_change_password, R.id.ll_suggest, R.id.ll_clear_images, R.id.ll_about, R.id.iv_check_movement})
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
            case R.id.ll_about:
                IntentUtils.gotoActivity(this, AboutActivity.class);
                break;
        }
    }

}
