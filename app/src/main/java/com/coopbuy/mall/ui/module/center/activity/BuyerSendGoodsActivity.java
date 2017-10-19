package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.widget.dialog.BottomListDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;


public class BuyerSendGoodsActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_buyer_send_goods;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("退货信息");
    }

    @OnClick({R.id.selectExpressBtn})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.selectExpressBtn:
                showExpressDialog();
                break;
        }
    }

    private void showExpressDialog() {
        List<String> list = new ArrayList();
        list.add("中通");
        list.add("中通");
        list.add("中通");
        list.add("中通");
        list.add("中通");
        list.add("中通");
        BottomListDialog dialog = new BottomListDialog(mContext, list, new TextView(mContext));
        dialog.showAtBottom();
    }

}
