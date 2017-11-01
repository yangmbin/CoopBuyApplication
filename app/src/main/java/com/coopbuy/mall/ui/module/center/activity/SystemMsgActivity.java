package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MessageCenterAdapter;
import com.coopbuy.mall.ui.module.center.adapter.SystemMsgAdapter;
import com.coopbuy.mall.ui.module.center.model.SystemMsgModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.SystemMsgPresenter;
import com.coopbuy.mall.ui.module.center.view.SystemMsg_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SystemMsgActivity extends BaseActivity<SystemMsgPresenter, SystemMsgModel> implements SystemMsg_IView, FootMarkPort {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    private SystemMsgAdapter adapter;
    private List<MessageCenterResponse> data;

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
    }

    @Override
    public void initView() {
        setTitle("系统消息");
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        setData();
        adapter = new SystemMsgAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    private void setData() {
        for (int i = 0; i < 4; i++) {
            MessageCenterResponse d = new MessageCenterResponse();
            d.setDetail("ssssdf" + i);
            d.setName("孙悟空" + i);
            d.setTime("2012." + i);
            d.setType(i);
            data.add(d);
        }
    }

    @Override
    public void openDetial(int postion) {
        ToastUtils.toastLong("这货想要看得找UI!-_-");
    }
}
