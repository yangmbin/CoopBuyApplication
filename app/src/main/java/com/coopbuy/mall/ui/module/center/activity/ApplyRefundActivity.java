package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ApplyRefundGoodsListAdapter;
import com.coopbuy.mall.widget.dialog.BottomListDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class ApplyRefundActivity extends BaseActivity {

    @Bind(R.id.goodsList)
    RecyclerView goodsList;
    @Bind(R.id.radioBtnRefund)
    LinearLayout radioBtnRefund;
    @Bind(R.id.radioBtnReturnGoods)
    LinearLayout radioBtnReturnGoods;
    @Bind(R.id.radioRefundSelected)
    ImageView radioRefundSelected;
    @Bind(R.id.radioReturnGoodsSelected)
    ImageView radioReturnGoodsSelected;

    @Override
    public int getLayoutId() {
        return R.layout.activity_apply_refund;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("申请退款");
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        ApplyRefundGoodsListAdapter mAdapter = new ApplyRefundGoodsListAdapter(this, list);
        goodsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        goodsList.setAdapter(mAdapter);
        goodsList.setFocusable(false);
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @OnClick({R.id.radioBtnRefund, R.id.radioBtnReturnGoods, R.id.selectRefundReasonBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioBtnRefund:
                clickRefundBtn();
                break;
            case R.id.radioBtnReturnGoods:
                clickReturnGoodsBtn();
                break;
            case R.id.selectRefundReasonBtn:
                showReasonDialog();
                break;
        }
    }

    /**
     * 点击退款单选按钮
     */
    private void clickRefundBtn() {
        radioBtnRefund.setBackgroundResource(R.drawable.shape_orange_1_no_solid_bg);
        radioBtnReturnGoods.setBackgroundResource(R.drawable.shape_gray_3_no_solid_bg);
        radioRefundSelected.setVisibility(View.VISIBLE);
        radioReturnGoodsSelected.setVisibility(View.INVISIBLE);
    }

    /**
     * 点击退款退货单选按钮
     */
    private void clickReturnGoodsBtn() {
        radioBtnRefund.setBackgroundResource(R.drawable.shape_gray_3_no_solid_bg);
        radioBtnReturnGoods.setBackgroundResource(R.drawable.shape_orange_1_no_solid_bg);
        radioRefundSelected.setVisibility(View.INVISIBLE);
        radioReturnGoodsSelected.setVisibility(View.VISIBLE);
    }

    /**
     * 显示原因对话框
     */
    private void showReasonDialog() {
        List<String> list = new ArrayList();
        list.add("原因");
        list.add("原因");
        list.add("原因");
        list.add("原因");
        list.add("原因");
        BottomListDialog dialog = new BottomListDialog(mContext, list, new TextView(mContext));
        dialog.showAtBottom();
    }
}
