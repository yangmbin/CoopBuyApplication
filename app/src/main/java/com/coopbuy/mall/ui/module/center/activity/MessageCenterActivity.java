package com.coopbuy.mall.ui.module.center.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MessageCenterAdapter;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

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
            if (i == 0)
                d.setName("物流信息" );
            if (i == 1)
                d.setName("客户消息" );
            if (i == 2)
                d.setName("系统消息" );
            if (i > 2)
                d.setName("other" + i);
            d.setTime("2012." + i);
            d.setType(i);
            data.add(d);
        }
    }

    @Override
    public void openDetial(int postion) {
        if (postion == 0) {
            IntentUtils.gotoActivity(this, LogisticsActivity.class);
        } else if (postion == 1) {
            IntentUtils.gotoActivity(this, SystemMsgActivity.class);
        } else {
            IntentUtils.gotoActivity(this, SystemMsgActivity.class);
        }
    }

}
