package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesDetailGoodsListAdapter;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesDetailMoreListAdapter;
import com.coopbuy.mall.ui.module.center.model.AfterSalesDetailModel;
import com.coopbuy.mall.ui.module.center.presenter.AfterSalesDetailPresenter;
import com.coopbuy.mall.ui.module.center.view.AfterSalesDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AfterSalesDetailActivity extends BaseActivity<AfterSalesDetailPresenter, AfterSalesDetailModel> implements AfterSalesDetail_IView {


    @Bind(R.id.goodsList)
    RecyclerView goodsList;
    @Bind(R.id.moreList)
    RecyclerView moreList;
    @Bind(R.id.moreBtnLayout)
    LinearLayout moreBtnLayout;
    @Bind(R.id.trade_other_text)
    TextView tradeOtherText;
    @Bind(R.id.trade_other_remark)
    TextView tradeOtherRemark;
    @Bind(R.id.trade_other_layout)
    LinearLayout tradeOtherLayout;
    @Bind(R.id.trade_success_node1_text)
    TextView tradeSuccessNode1Text;
    @Bind(R.id.trade_success_node1_time)
    TextView tradeSuccessNode1Time;
    @Bind(R.id.trade_success_node2_text)
    TextView tradeSuccessNode2Text;
    @Bind(R.id.trade_success_node2_time)
    TextView tradeSuccessNode2Time;
    @Bind(R.id.trade_success_node3_text)
    TextView tradeSuccessNode3Text;
    @Bind(R.id.trade_success_node3_time)
    TextView tradeSuccessNode3Time;
    @Bind(R.id.apply_reason)
    TextView applyReason;
    @Bind(R.id.apply_amount)
    TextView applyAmount;
    @Bind(R.id.apply_quantity)
    TextView applyQuantity;
    @Bind(R.id.apply_time)
    TextView applyTime;
    @Bind(R.id.apply_no)
    TextView applyNo;
    @Bind(R.id.refuse_layout)
    LinearLayout refuseLayout;
    @Bind(R.id.agree_apply_layout)
    LinearLayout agreeApplyLayout;
    @Bind(R.id.express_layout)
    LinearLayout expressLayout;
    @Bind(R.id.refund_success_layout)
    LinearLayout refundSuccessLayout;
    @Bind(R.id.refuse_reason)
    TextView refuseReason;
    @Bind(R.id.reapply_btn)
    TextView reapplyBtn;
    @Bind(R.id.shop_name)
    TextView shopName;
    @Bind(R.id.shop_tel)
    TextView shopTel;
    @Bind(R.id.shop_address)
    TextView shopAddress;
    @Bind(R.id.cancel_apply)
    TextView cancelApply;
    @Bind(R.id.update_return_goods)
    TextView updateReturnGoods;
    @Bind(R.id.shipping_company)
    TextView shippingCompany;
    @Bind(R.id.latest_express_info)
    TextView latestExpressInfo;
    @Bind(R.id.refund_total_amount)
    TextView refundTotalAmount;
    @Bind(R.id.back_total_amount)
    TextView backTotalAmount;

    private AfterSalesDetailGoodsListAdapter mGoodsListAdapter;
    private AfterSalesDetailMoreListAdapter mMoreListAdapter;
    // 商品列表数据
    private List<AfterSalesDetailResponse.ProductsBean> mGoodsListDatas = new ArrayList<>();
    // 更多列表数据
    private List<AfterSalesDetailResponse.ApplyNodesBean> mMoreListDatas = new ArrayList<>();

    private AfterSalesDetailResponse mAfterSalesDetailResponse;

    @Override
    public int getLayoutId() {
        return R.layout.activity_after_sales_detail;
    }

    @Override
    public void initModel() {
        mModel = new AfterSalesDetailModel();
    }

    @Override
    public void initView() {
        setTitle("售后详情");
        initAdapter();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AfterSalesDetailPresenter(mContext, mModel, this);
        mPresenter.getAfterSalesDetail(getIntent().getStringExtra(IntentUtils.PARAM1));
    }

    @Override
    protected void networkRetry() {
        mPresenter.getAfterSalesDetail(getIntent().getStringExtra(IntentUtils.PARAM1));
    }

    private void initAdapter() {
        // 商品列表
        mGoodsListAdapter = new AfterSalesDetailGoodsListAdapter(this, mGoodsListDatas);
        goodsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        goodsList.setAdapter(mGoodsListAdapter);
        goodsList.setFocusable(false);

        // 更多列表
        mMoreListAdapter = new AfterSalesDetailMoreListAdapter(this, mMoreListDatas);
        moreList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        moreList.setAdapter(mMoreListAdapter);
        moreList.setFocusable(false);
    }

    /**
     * 点击事件
     */
    @OnClick({R.id.update_return_goods, R.id.moreBtn, R.id.reapply_btn, R.id.copy_info, R.id.cancel_apply, R.id.view_express_info})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            // 买家寄货
            case R.id.update_return_goods:
                IntentUtils.gotoActivity(mContext, BuyerSendGoodsActivity.class);
                break;
            // 更多按钮
            case R.id.moreBtn:
                moreList.setVisibility(View.VISIBLE);
                moreBtnLayout.setVisibility(View.GONE);
                break;
            // 重新申请
            case R.id.reapply_btn:
                reApplyRefund();
                break;
            // 复制信息
            case R.id.copy_info:
                break;
            // 撤销申请
            case R.id.cancel_apply:
                mPresenter.cancelApplyRefund(mAfterSalesDetailResponse.getApplyNo());
                break;
            // 查看物流
            case R.id.view_express_info:
                break;
        }
    }

    /**
     * 重新申请退款
     */
    private void reApplyRefund() {
        BeforeApplyRefundRequest request = new BeforeApplyRefundRequest();
        if (mGoodsListDatas.size() == 1)
            request.setSkuId(mGoodsListDatas.get(0).getSkuId());
        else
            request.setSkuId(-1);
        request.setOrderId(mAfterSalesDetailResponse.getOrderId());
        request.setApplyNo(mAfterSalesDetailResponse.getApplyNo());
        IntentUtils.gotoActivity(mContext, ApplyRefundActivity.class, request);
    }

    /**
     * 网络数据返回回调设置界面
     *
     * @param afterSalesDetailResponse
     */
    @Override
    public void setAfterSalesDetail(AfterSalesDetailResponse afterSalesDetailResponse) {

        mAfterSalesDetailResponse = afterSalesDetailResponse;

        // 设置商品列表
        mGoodsListDatas.clear();
        mGoodsListDatas.addAll(afterSalesDetailResponse.getProducts());
        mGoodsListAdapter.notifyDataSetChanged();

        // 设置更多列表
        mMoreListDatas.clear();
        mMoreListDatas.addAll(afterSalesDetailResponse.getApplyNodes());
        mMoreListAdapter.notifyDataSetChanged();

        // 设置顶部交易信息
        if (afterSalesDetailResponse.getTradeNode().size() == 1) {
            tradeOtherLayout.setVisibility(View.VISIBLE);
            tradeOtherText.setText(afterSalesDetailResponse.getTradeNode().get(0).getText());
            tradeOtherRemark.setText(afterSalesDetailResponse.getTradeNode().get(0).getRemark());
        } else {
            tradeOtherLayout.setVisibility(View.GONE);
        }

        // 设置公共普通信息
        applyReason.setText("退款原因：" + afterSalesDetailResponse.getReason());
        applyAmount.setText("退款金额：¥" + StringUtils.keepTwoDecimalPoint(afterSalesDetailResponse.getApplyAmount()));
        applyQuantity.setText("申请件数：" + afterSalesDetailResponse.getApplyQuantity());
        applyTime.setText("申请时间：" + afterSalesDetailResponse.getApplyTime());
        applyNo.setText("退款编号：" + afterSalesDetailResponse.getApplyNo());


        /** 设置其他显示隐藏模块 */
        refuseLayout.setVisibility(View.GONE);
        agreeApplyLayout.setVisibility(View.GONE);
        expressLayout.setVisibility(View.GONE);
        refundSuccessLayout.setVisibility(View.GONE);
        // 显示同意退款的布局
        if (afterSalesDetailResponse.getStatus() == 2) {
            agreeApplyLayout.setVisibility(View.VISIBLE);
            shopName.setText(afterSalesDetailResponse.getShopName() + "（" + afterSalesDetailResponse.getConsignerName() + "）");
            shopTel.setText(afterSalesDetailResponse.getConsignerTel());
            shopAddress.setText(afterSalesDetailResponse.getAddress());
            if (afterSalesDetailResponse.isCanCancelApply())
                cancelApply.setVisibility(View.VISIBLE);
            else
                cancelApply.setVisibility(View.GONE);
            if (afterSalesDetailResponse.isCanUpdateReturnGoods())
                updateReturnGoods.setVisibility(View.VISIBLE);
            else
                updateReturnGoods.setVisibility(View.GONE);
        }
        // 显示寄货物流的布局
        if (afterSalesDetailResponse.getStatus() == 3 || afterSalesDetailResponse.getStatus() == 4 || afterSalesDetailResponse.getStatus() == 5) {
            expressLayout.setVisibility(View.VISIBLE);
            shippingCompany.setText("退货物流：" + afterSalesDetailResponse.getShippingCompany() + "（单号" + afterSalesDetailResponse.getCompanyCode() + "）");
            latestExpressInfo.setText(afterSalesDetailResponse.getCargoInfo().getText());
        }
        // 显示退款成功的布局
        if (afterSalesDetailResponse.getStatus() == 6) {
            refundSuccessLayout.setVisibility(View.VISIBLE);
            refundTotalAmount.setText("¥" + StringUtils.keepTwoDecimalPoint(afterSalesDetailResponse.getApplyAmount()));
            backTotalAmount.setText("¥" + StringUtils.keepTwoDecimalPoint(afterSalesDetailResponse.getApplyAmount()));
        }
        // 显示拒绝退款的布局
        if (afterSalesDetailResponse.getStatus() == 7) {
            refuseLayout.setVisibility(View.VISIBLE);
            refuseReason.setText("拒绝原因：" + afterSalesDetailResponse.getAuditorRemark());
            if (afterSalesDetailResponse.isCanReApply())
                reapplyBtn.setVisibility(View.VISIBLE);
            else
                reapplyBtn.setVisibility(View.GONE);
        }
    }

    /**
     * 撤销申请成功回调
     */
    @Override
    public void cancelApplySuccess() {
        IntentUtils.gotoActivityWithClearTop(mContext, AfterSalesActivity.class);
    }
}
