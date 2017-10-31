package com.coopbuy.mall.ui.module.center.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MessageCenterAdapter;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MessageCenterActivity extends BaseActivity implements FootMarkPort {
    @Bind(R.id.recView)
    RecyclerView recView;
    private MessageCenterAdapter adapter;
    private List<MessageCenterResponse> data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_message_center;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("消息中心");
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        setData();
        adapter = new MessageCenterAdapter(data, this);
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

    }
}
