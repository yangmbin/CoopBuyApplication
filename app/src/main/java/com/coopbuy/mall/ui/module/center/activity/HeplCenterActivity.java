package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/9 0009 10:52
 * @content
 */
public class HeplCenterActivity extends BaseActivity {
    @Bind(R.id.swipe_target)
    RecyclerView mSwipeTarget;

    @Override
    public int getLayoutId() {
        return R.layout.activity_hepl_center;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.title_help_center);
    }


    @OnClick({R.id.ll_change_password, R.id.ll_bind, R.id.ll_call_station, R.id.ll_customer, R.id.ll_phone_service, R.id.ll_call_online_service, R.id.ll_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_change_password:
                break;
            case R.id.ll_bind:
                break;
            case R.id.ll_call_station:
                break;
            case R.id.ll_customer:
                break;
            case R.id.ll_phone_service:
                break;
            case R.id.ll_call_online_service:
                break;
            case R.id.ll_feedback:
                break;
        }
    }
}
