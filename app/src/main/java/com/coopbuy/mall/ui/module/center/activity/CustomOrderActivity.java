package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.CustomOrderAdapter;
import com.coopbuy.mall.ui.module.center.port.CustomOrderPort;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.popwindow.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author niu
 * @time 2017/11/15 10:00
 * @content 客户订单
 */
public class CustomOrderActivity extends BaseActivity implements CustomOrderPort, View.OnClickListener {
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.ll_apply)
    LinearLayout mLLApply;
    @Bind(R.id.ll_history)
    LinearLayout mLLHistory;
    private CustomOrderAdapter adapter;
    private List<MessageCenterResponse> data;
    private int ss;
    private int mHeight = 200;
    private int mOld = 0;
    private int mNew = 0;
    private CustomPopWindow popWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_custom_order;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

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
        setData();
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


    private void setData() {
        for (int i = 0; i < 10; i++) {
            MessageCenterResponse d = new MessageCenterResponse();
            d.setDetail("ssssdf" + i);
            if (i == 0)
                d.setName("悟空物流");
            if (i == 1)
                d.setName("八戒物流");
            if (i == 2)
                d.setName("沙僧物流");
            if (i > 2)
                d.setName("other物流" + i);
            d.setTime("2012." + i);
            d.setType(i);
            data.add(d);
        }
    }

    @Override
    public void openDetial(int postion) {
        IntentUtils.gotoActivity(this, StationCustomOrderDetailActivity.class);
    }

    @Override
    public void call(int postion) {

    }

    @Override
    public void logistics(int psotion) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                ToastUtils.toastShort("全部");
                break;
            case R.id.tv_pending:
                ToastUtils.toastShort("待支付");
                break;
            case R.id.tv_pended:
                ToastUtils.toastShort("待发货");
                break;
            case R.id.tv_sended:
                ToastUtils.toastShort("已完成");
                break;
            case R.id.tv_sending:
                ToastUtils.toastShort("待收货");
                break;
            case R.id.ll_apply:
                IntentUtils.gotoActivity(this, PayOtherActivity.class);
                break;
            case R.id.ll_history:
                IntentUtils.gotoActivity(this, PayHistoryActivity.class);
                break;
        }
        if (popWindow != null)
            popWindow.dissmiss();
    }
}
