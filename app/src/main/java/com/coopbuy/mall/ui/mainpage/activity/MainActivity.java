package com.coopbuy.mall.ui.mainpage.activity;

import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.entity.TabEntity;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.presenter.MainPresenter;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;
import com.coopbuy.mall.ui.module.test.activity.TestActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements Main_IView {

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout mTabLayout;
    private View mDecorView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initModel() {
        mModel = new MainModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter(mContext, mModel, this);
    }

    @Override
    public void initView() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mDecorView = getWindow().getDecorView();
        mTabLayout = ViewFindUtils.find(mDecorView, R.id.tablayout);
        mTabLayout.setTabData(mTabEntities);
    }

    @OnClick({R.id.btn_test})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                IntentUtils.gotoActivity(mContext, TestActivity.class);
                break;
        }
    }
}
