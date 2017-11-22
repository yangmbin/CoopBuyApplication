package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.request.CustomOrderRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.CustomOrderAdapter;
import com.coopbuy.mall.ui.module.center.model.CustomOrderModel;
import com.coopbuy.mall.ui.module.center.port.CustomOrderPort;
import com.coopbuy.mall.ui.module.center.presenter.CustomOrderPresenter;
import com.coopbuy.mall.ui.module.center.view.CustomOrder_IView;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.coopbuy.mall.widget.popwindow.CustomPopWindow;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author niu
 * @time 2017/11/15 10:00
 * @content 客户订单
 */
public class CustomOrderActivity extends BaseActivity<CustomOrderPresenter, CustomOrderModel> implements CustomOrder_IView, OnRefreshListener, OnLoadmoreListener, CustomOrderPort, View.OnClickListener {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.ll_apply)
    LinearLayout mLLApply;
    @Bind(R.id.ll_history)
    LinearLayout mLLHistory;
    private CustomOrderAdapter adapter;
    private List<CustomOrderReponse.ItemsBean> data;
    private int ss;
    private int mHeight = 200;
    private int mOld = 0;
    private int mNew = 0;
    private CustomPopWindow popWindow;
    private CustomOrderRequest request;
    private int mPagerIndex = 1;
    private int status = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_custom_order;
    }

    @Override
    public void initModel() {
        mModel = new CustomOrderModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new CustomOrderPresenter(this, mModel, this);
        request = new CustomOrderRequest();
        request.setCurrentPage(mPagerIndex);
        request.setOrderStatus(status);
        mPresenter.getCustomOrderData(request, "init");
    }

    @Override
    public void initView() {
        setTitle("客户订单");
        setRightText("筛选");
        mLLHistory.setOnClickListener(this);
        mLLApply.setOnClickListener(this);
        initRey();
    }

    @Override
    public void clickTitleBarRight(View v) {
        super.clickTitleBarRight(v);
        showPopBottom(v);
    }

    private void showPopBottom(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.popuwindow_dialog_bill, null);
        view.findViewById(R.id.tv_all).setOnClickListener(this);
        view.findViewById(R.id.tv_pended).setOnClickListener(this);
        TextView waipay = view.findViewById(R.id.tv_pending);
        waipay.setText("待支付");
        waipay.setOnClickListener(this);
        TextView waiSend = view.findViewById(R.id.tv_pended);
        waiSend.setText("待发货");
        waiSend.setOnClickListener(this);
        TextView wairecive = view.findViewById(R.id.tv_sending);
        wairecive.setText("待收货");
        wairecive.setOnClickListener(this);
        TextView compelete = view.findViewById(R.id.tv_sended);
        compelete.setText("已完成");
        compelete.setOnClickListener(this);
        popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(view)
                .setFocusable(true)
                .create();
        popWindow.showAsDropDown(v, 0, -25);
    }

    private void initRey() {
        data = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new CustomOrderAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
        recView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int se = recyclerView.computeVerticalScrollOffset();
                if (ss < se) {
                    Log.d("niu", "增加了" + ss);
                } else {
                    Log.d("niu", "减少了" + ss);
                }
                ss = se;
                setTop(se);
            }
        });
    }

    private boolean isset = true;

    private void setTop(int heigth) {
        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) mLLApply.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) mLLHistory.getLayoutParams();
        if (heigth >= 90) {
            heigth = 90;
        }
        Log.d("niu", "设置" + heigth);
        int s = mHeight - heigth;
        mNew = s;
        if (isset) {
            mOld = s;
            isset = false;
            layoutParams1.height = s;
            mLLApply.setLayoutParams(layoutParams1);
            layoutParams2.height = s;
            mLLApply.setLayoutParams(layoutParams2);
        }
        if (mOld + 6 < mNew || mOld - 6 > mNew) {
            mOld = mNew;
            layoutParams1.height = s;
            mLLApply.setLayoutParams(layoutParams1);
            layoutParams2.height = s;
            mLLApply.setLayoutParams(layoutParams2);
        }
    }

    @Override
    public void openDetial(int postion) {
        IntentUtils.gotoActivity(this, CustomOrderDetailActivity.class, data.get(postion).getOrderId());
    }

    @Override
    public void call(int postion) {
        DialogUtils.showTwoKeyDialog(this, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {

            }
        }, "确定拨打电话?", "取消", "确定");
    }

    @Override
    public void logistics(int psotion) {
        IntentUtils.gotoActivity(this, ExpressInfoActivity.class, data.get(psotion).getOrderId());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                ToastUtils.toastShort("全部");
                status = 0;
                break;
            case R.id.tv_pending:
                ToastUtils.toastShort("待支付");
                status = 1;
                break;
            case R.id.tv_pended:
                ToastUtils.toastShort("待发货");
                status = 2;
                break;
            case R.id.tv_sended:
                ToastUtils.toastShort("已完成");
                status = 3;
                break;
            case R.id.tv_sending:
                ToastUtils.toastShort("待收货");
                status = 4;
                break;
            case R.id.ll_apply:
                status = -1;
                IntentUtils.gotoActivity(this, PayOtherActivity.class);
                break;
            case R.id.ll_history:
                status = -1;
                IntentUtils.gotoActivity(this, PayHistoryActivity.class);
                break;
        }
        if (popWindow != null)
            popWindow.dissmiss();
        if (status != -1) {
            fresh();
        }
    }

    @Override
    public void getData(CustomOrderReponse bean, String type) {
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
        request.setOrderStatus(status);
        mPresenter.getCustomOrderData(request, "more");
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
    public void onRefresh(RefreshLayout refreshlayout) {
        fresh();
    }

    private void fresh() {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        request.setOrderStatus(status);
        mPresenter.getCustomOrderData(request, "fresh");
    }
}
