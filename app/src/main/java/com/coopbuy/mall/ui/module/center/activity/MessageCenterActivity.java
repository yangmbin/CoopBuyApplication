package com.coopbuy.mall.ui.module.center.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MesCenterResponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MessageCenterAdapter;
import com.coopbuy.mall.ui.module.center.model.MesgCenterModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.MesgCenterPresenter;
import com.coopbuy.mall.ui.module.center.view.MsgCenter_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MessageCenterActivity extends BaseActivity<MesgCenterPresenter, MesgCenterModel> implements FootMarkPort, MsgCenter_IView {
    @Bind(R.id.recView)
    RecyclerView recView;
    private MessageCenterAdapter adapter;
    private List<MesCenterResponse> data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_message_center;
    }

    @Override
    public void initModel() {
        mModel = new MesgCenterModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MesgCenterPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        setTitle("消息中心");
    }

    private void initRey() {

        adapter = new MessageCenterAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }


    @Override
    public void openDetial(int postion) {
        if (data.get(postion).getId() == 3) {
            IntentUtils.gotoActivity(this, LogisticsActivity.class);
        } else if (data.get(postion).getId() == 2) {
            ToastUtils.toastShort("打开客户消息");
        } else {
            IntentUtils.gotoActivity(this, SystemMsgActivity.class, data.get(postion).getId());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getData();
    }

    @Override
    public void getData(List<MesCenterResponse> bean) {
        data = new ArrayList<>();
        data.addAll(bean);
        initRey();
    }
}
