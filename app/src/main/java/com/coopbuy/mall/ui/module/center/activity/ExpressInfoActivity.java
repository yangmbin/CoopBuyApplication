package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ExpressInfoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class ExpressInfoActivity extends BaseActivity {

    @Bind(R.id.expressList)
    RecyclerView expressList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_express_info;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("物流详情");
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        ExpressInfoListAdapter mAdapter = new ExpressInfoListAdapter(this, list);
        expressList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        expressList.setAdapter(mAdapter);
        expressList.setFocusable(false);
    }
}
