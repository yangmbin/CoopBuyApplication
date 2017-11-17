package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.reponse.MyBillReponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyBillAdapter;
import com.coopbuy.mall.ui.module.center.model.MyBillModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.MyBillPresenter;
import com.coopbuy.mall.ui.module.center.view.MyBill_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.popwindow.CustomPopWindow;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MyBillActivity extends BaseActivity<MyBillPresenter, MyBillModel> implements FootMarkPort, View.OnClickListener, MyBill_IView, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    private CustomPopWindow popWindow;
    private MyBillAdapter adapter;
    private List<MyBillReponse.ItemsBean> data;
    private CurrentPageRequest request;
    private int mPagerIndex = 1;
    /**
     * 0=全部，1=待审核，2=已审核，3=已发放，4=已作废
     */
    private int mStatus = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_bill;
    }

    @Override
    public void initModel() {
        mModel = new MyBillModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MyBillPresenter(this, mModel, this);
        request = new CurrentPageRequest();
        request.setCurrentPage(1);
        request.setSettlementStatus(0);
        mPresenter.getIncome(request, "init");
    }

    @Override
    public void clickTitleBarRight(View v) {
        super.clickTitleBarRight(v);
        showPopBottom(v);
    }

    @Override
    public void initView() {
        setTitle(R.string.title_bill);
        setRightText(R.string.lab_bill_filter);
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new MyBillAdapter(this, data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    private void showPopBottom(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.popuwindow_dialog_bill, null);
        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.findViewById(R.id.tv_all).setOnClickListener(this);
        view.findViewById(R.id.tv_pended).setOnClickListener(this);
        view.findViewById(R.id.tv_pending).setOnClickListener(this);
        view.findViewById(R.id.tv_sended).setOnClickListener(this);
        view.findViewById(R.id.tv_sending).setOnClickListener(this);
        popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(view)
                .setFocusable(true)
                .create();
        popWindow.showAsDropDown(v, 0, -25);
    }

    @Override
    public void openDetial(int postion) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                ToastUtils.toastShort("全部");
                mStatus = 0;
                break;
            case R.id.tv_pending:
                mStatus = 1;
                ToastUtils.toastShort("待审核");
                break;
            case R.id.tv_pended:
                mStatus = 2;
                ToastUtils.toastShort("已审核");
                break;
            case R.id.tv_sended:
                mStatus = 3;
                ToastUtils.toastShort("已发放");
                break;
            case R.id.tv_sending:
                mStatus = 4;
                ToastUtils.toastShort("已作废");
                break;
        }
        request.setCurrentPage(1);
        request.setSettlementStatus(mStatus);
        mPresenter.getIncome(request, "fresh");
        if (popWindow != null)
            popWindow.dissmiss();
    }

    @Override
    public void getData(MyBillReponse bean, String type) {
        if (type.equals("more")) {
            adapter.addMore(bean.getItems());
        } else {
            adapter.refresh(bean.getItems());
        }
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
        request.setSettlementStatus(mStatus);
        mPresenter.getIncome(request, "more");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        request.setSettlementStatus(mStatus);
        mPresenter.getIncome(request, "fresh");
    }
}
