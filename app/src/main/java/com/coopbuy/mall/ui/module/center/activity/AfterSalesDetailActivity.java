package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesDetailGoodsListAdapter;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesDetailMoreListAdapter;
import com.coopbuy.mall.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AfterSalesDetailActivity extends BaseActivity {


    @Bind(R.id.goodsList)
    RecyclerView goodsList;
    @Bind(R.id.moreList)
    RecyclerView moreList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_after_sales_detail;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("售后详情");
        initAdapter();
    }

    private void initAdapter() {
        // 商品列表
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        AfterSalesDetailGoodsListAdapter mAdapter = new AfterSalesDetailGoodsListAdapter(this, list);
        goodsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        goodsList.setAdapter(mAdapter);
        goodsList.setFocusable(false);

        // 更多列表
        List list2 = new ArrayList();
        list2.add(new Object());
        list2.add(new Object());
        list2.add(new Object());
        AfterSalesDetailMoreListAdapter mAdapter2 = new AfterSalesDetailMoreListAdapter(this, list2);
        moreList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        moreList.setAdapter(mAdapter2);
        moreList.setFocusable(false);
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.buyerSendGoodsBtn})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.buyerSendGoodsBtn:
                IntentUtils.gotoActivity(mContext, BuyerSendGoodsActivity.class);
                break;
        }
    }
}
