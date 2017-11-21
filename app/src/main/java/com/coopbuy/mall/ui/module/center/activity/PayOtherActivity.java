package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.PayOtherResponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.PayOtherAdapter;
import com.coopbuy.mall.ui.module.center.model.PayOtherModel;
import com.coopbuy.mall.ui.module.center.port.PayOtherPort;
import com.coopbuy.mall.ui.module.center.presenter.PayOtherPresenter;
import com.coopbuy.mall.ui.module.center.view.PayOther_IView;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author niu
 * @time 2017/11/13 15:33
 * @content 代付
 */
public class PayOtherActivity extends BaseActivity<PayOtherPresenter, PayOtherModel> implements PayOtherPort, PayOther_IView, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private PayOtherAdapter adapter;
    private List<PayOtherResponse.ItemsBean> data;
    private CurrentPageRequest request;
    private int mPagerIndex = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_another;
    }

    @Override
    public void initModel() {
        mModel = new PayOtherModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new PayOtherPresenter(this, mModel, this);
        request = new CurrentPageRequest();
        request.setCurrentPage(mPagerIndex);
        //   mPresenter.getData(request, "init");
    }

    @Override
    public void initView() {
        setTitle("代付申请");
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        setData();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new PayOtherAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    private void setData() {
        for (int i = 0; i < 5; i++) {
            PayOtherResponse.ItemsBean bean = new PayOtherResponse.ItemsBean();
            bean.setApplyTime("2018-5-6  5:1:54");
            bean.setConsignerName("ss" + i);
            bean.setConsignerTel("154255155" + i);
            bean.setApplyAmount(i * 2);
            data.add(bean);
        }
    }

    @Override
    public void getData(PayOtherResponse bean, String type) {
        if (type.equals("more")) {
            adapter.addMore(bean.getItems());
        } else {
            adapter.refresh(bean.getItems());
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        ++mPagerIndex;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getData(request, "more");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getData(request, "fresh");

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
    public void call(String phone) {
        DialogUtils.showTwoKeyDialog(this, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {

            }
        }, "确定拨打电话?", "取消", "确定");
    }

    @Override
    public void detail(int postion) {
        IntentUtils.gotoActivity(this, PayOtherDetailActivity.class, data.get(postion).getOrderId());
    }

    @Override
    public void refuse() {
        DialogUtils.showTwoKeyDialog(this, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {

            }
        }, "确定拒绝该代付申请?", "取消", "确定");
    }

    @Override
    public void payMent(int postion) {

    }
}
