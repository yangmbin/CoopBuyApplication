package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.reponse.SystemMegResponse;
import com.coopbuy.mall.api.request.MegRequest;
import com.coopbuy.mall.api.request.MessageReadRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MessageCenterAdapter;
import com.coopbuy.mall.ui.module.center.adapter.SystemMsgAdapter;
import com.coopbuy.mall.ui.module.center.model.SystemMsgModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.SystemMsgPresenter;
import com.coopbuy.mall.ui.module.center.view.SystemMsg_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SystemMsgActivity extends BaseActivity<SystemMsgPresenter, SystemMsgModel> implements SystemMsg_IView, FootMarkPort, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    private int mPagerIndex = 1;
    private SystemMsgAdapter adapter;
    private List<SystemMegResponse.ItemsBean> data;
    private MegRequest request;
    private int msgType = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_system_msg;
    }

    @Override
    public void initModel() {
        mModel = new SystemMsgModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SystemMsgPresenter(this, mModel, this);
        request = new MegRequest();
        request.setCurrentPage(mPagerIndex);
        request.setGroupId(msgType);
        mPresenter.getData(request, "init");
    }

    @Override
    public void clickTitleBarRight(View v) {
        super.clickTitleBarRight(v);
        mPresenter.msgReadAll(request);
    }


    @Override
    public void initView() {
        setTitle("系统消息");
        setRightText("全部已读");
        if (getIntent() != null) {
            msgType = getIntent().getIntExtra(IntentUtils.PARAM1, 1);
        }
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new SystemMsgAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }


    @Override
    public void openDetial(int postion) {
        int type = data.get(postion).getMessageType();
        if (type == 1 || type == 2) { //文本 html
            ToastUtils.toastLong("跳转h5");
            IntentUtils.gotoActivity(this, MegHtmlActivity.class);
        } else if (type == 3) {//订单消息
            if (data.get(postion).getItem() != null)
                IntentUtils.gotoActivity(this, OrderDetailActivity.class, data.get(postion).getItem().getOrderId());
        } else if (type == 4) {//售后 需要申请号
            if (data.get(postion).getItem() != null)
                IntentUtils.gotoActivity(this, AfterSalesDetailActivity.class, data.get(postion).getItem().getRefundNo());
        }
        MessageReadRequest readRequest = new MessageReadRequest();
        readRequest.setMessageId(data.get(postion).getMessageId());
        mPresenter.megReadOne(readRequest, postion);
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
        mPresenter.getData(request, "more");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getData(request, "fresh");
    }

    @Override
    public void getData(SystemMegResponse bean, String type) {
        if (type.equals("more")) {
            adapter.addMore(bean.getItems());
        } else {
            adapter.refresh(bean.getItems());
        }
    }

    @Override
    public void setOneReadSuccess(int postion) {
        data.get(postion).setIsRead(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setAllReadSuccess() {
        ToastUtils.toastShort("操作成功");
    }
}
