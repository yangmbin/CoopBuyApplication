package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.AddressMangeAdapter;
import com.coopbuy.mall.ui.module.center.model.AddressManageModel;
import com.coopbuy.mall.ui.module.center.presenter.AddressManagePresenter;
import com.coopbuy.mall.ui.module.center.view.AddressManage_IView;
import com.coopbuy.mall.utils.IntentUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/11 0011 14:43
 * @content 地址管理
 */
public class AddressManageActivity extends BaseActivity<AddressManagePresenter, AddressManageModel> implements AddressManage_IView {

    @Bind(R.id.rv_banner_detail)
    RecyclerView mRecycleView;

    private DelegateAdapter delegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters;
    private List<AddressInfoResponse> mData;
    private LinearLayoutHelper bannerSlider1Helper;

    @Override
    public int getLayoutId() {
        return R.layout.activity_address_manage;
    }

    @Override
    public void initModel() {
        mModel = new AddressManageModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AddressManagePresenter(this, mModel, this);
        mPresenter.getAddressData();
    }

    @Override
    public void initView() {
        setTitle("地址管理");
        initRecycleView();
    }

    private void initRecycleView() {
        mAdapters = new LinkedList<>();
        mData = new ArrayList<>();
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycleView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        delegateAdapter = new DelegateAdapter(layoutManager, false);
        mRecycleView.setAdapter(delegateAdapter);
    }

    @OnClick(R.id.tv_add_address)
    public void onViewClicked() {
        IntentUtils.gotoActivity(this, AddresssAddUserActivity.class);
    }

    @Override
    public void getAddressMangeData(List<AddressInfoResponse> data) {
        delegateAdapter.clear();
        mAdapters.clear();
        bannerSlider1Helper = new LinearLayoutHelper();
        mAdapters.add(new AddressMangeAdapter(this, data, bannerSlider1Helper));
        delegateAdapter.setAdapters(mAdapters);
    }
}
