package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.IncomeAdapter;
import com.coopbuy.mall.ui.module.center.adapter.MyBillAdapter;
import com.coopbuy.mall.ui.module.center.model.IncomeModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.IncomePresenter;
import com.coopbuy.mall.ui.module.center.view.Income_IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class IncomeActivity extends BaseActivity<IncomePresenter, IncomeModel> implements FootMarkPort, Income_IView, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    private IncomeAdapter adapter;
    private List<InComeReponse.ItemsBean> data;
    private int mPagerIndex = 1;
    private CurrentPageRequest request;

    @Override
    public int getLayoutId() {
        return R.layout.activity_income;
    }

    @Override
    public void initModel() {
        mModel = new IncomeModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new IncomePresenter(this, mModel, this);
        request = new CurrentPageRequest();
        request.setCurrentPage(mPagerIndex);
        mPresenter.getIncome(request, "init");
    }

    @Override
    public void initView() {
        setTitle("预计收益");
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new IncomeAdapter(this,data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }


    @Override
    public void openDetial(int postion) {

    }

    /**
     * 停止刷新
     */
    @Override
    public void stopRefresh() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        ++mPagerIndex;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getIncome(request, "more");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getIncome(request, "fresh");
    }

    @Override
    public void getData(InComeReponse bean, String type) {
        if (type.equals("more")) {
            adapter.addMore(bean.getItems());
        } else {
            adapter.refresh(bean.getItems());
        }
    }
}
