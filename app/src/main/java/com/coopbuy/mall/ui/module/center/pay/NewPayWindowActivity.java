package com.coopbuy.mall.ui.module.center.pay;

import android.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderPayApplyResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.api.reponse.WeixinEntity;
import com.coopbuy.mall.api.request.MobilePayRequest;
import com.coopbuy.mall.api.request.OrderPayApplyRequest;
import com.coopbuy.mall.api.request.OrderSubmitRequest;
import com.coopbuy.mall.base.BaseFragmentActivity;
import com.coopbuy.mall.bean.PayAgainParams;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.WeiXinEvent;
import com.coopbuy.mall.mypay.PayListener;
import com.coopbuy.mall.mypay.PayUtils;
import com.coopbuy.mall.ui.module.center.adapter.PayListAdapter;
import com.coopbuy.mall.ui.module.center.model.NewPayWindow_Model;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.NewPayWindow_Presenter;
import com.coopbuy.mall.ui.module.center.view.NewPayWindow_View;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.google.gson.Gson;
import com.guinong.net.utils.LogUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class NewPayWindowActivity extends BaseFragmentActivity<NewPayWindow_Presenter, NewPayWindow_Model> implements NewPayWindow_View, PayListener, FootMarkPort {
    @Bind(R.id.swipe_target)
    RecyclerView recView;
    @Bind(R.id.tv_count_total)
    TextView mCountsTotal;
    @Bind(R.id.tv_count_total_price)
    TextView mCountsTotalPrice;
    private PayListAdapter adapter;
    private List<TradeChannelResponse> data;
    /**
     * 订单支付请求
     */
    private OrderSubmitRequest request;
    private String enterType;
    private String mWaitOrderId = "";
    private String mChannelId;
    private PayAgainParams mPayAgainParms;
    private String mTotal = "";
    private String mAllPrice = "";
    private MobilePayRequest mobileRequest;
    /**
     * type (integer): 支付类型(1=商品订单，2=话费订单)
     */
    private int payListType = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_window;
    }

    @Override
    public void initModel() {
        mModel = new NewPayWindow_Model();
    }

    @Override
    protected void setThisActivityName() {
        thisActivityName = "NewPayWindowActivity";
    }

    //这里需要注意 话费不可以站长代付
    @Override
    public void initPresenter() {
        mPresenter = new NewPayWindow_Presenter(this, mModel, this);
        mPresenter.getPayTradeChannel(payListType);
    }

    @Override
    public void initView() {
        getWindow().setLayout(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
        EventBusInstance.getInstance().registerEvent(this);
        mPayAgainParms = new PayAgainParams();
        if (null != getIntent()) {
            enterType = getIntent().getStringExtra("type");
            if (enterType.equals("wait")) {
                mPayAgainParms = (PayAgainParams) getIntent().getSerializableExtra(IntentUtils.DATA);
                payListType = mPayAgainParms.getPalyListType();
                mWaitOrderId = mPayAgainParms.getmWaitOrderId();
                mTotal = mPayAgainParms.getmCountsTotal();
                mAllPrice = mPayAgainParms.getmCountsTotalPrice();
            } else if (enterType.equals("order")) {
                payListType = 1;
                request = (OrderSubmitRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
                mTotal = "" + request.getGoodsCounts();
                mAllPrice = "" + request.getTotalPrice();
            } else if (enterType.equals("mobile")) {
                payListType = 2;
                mobileRequest = (MobilePayRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
                mTotal = mobileRequest.getCount();
                mAllPrice = mobileRequest.getAllPrice();
            }
        }
        mCountsTotal.setText(mTotal);
        mCountsTotalPrice.setText("¥" + mAllPrice);
        mPayAgainParms.setmCountsTotalPrice(mAllPrice);
        mPayAgainParms.setmCountsTotal(mTotal);
        mPayAgainParms.setmWaitOrderId(mWaitOrderId);
        mPayAgainParms.setmChannelId(mChannelId);
        mPayAgainParms.setPalyListType(payListType
        );
        initRec();
    }

    private void initRec() {
        data = new ArrayList<>();
        adapter = new PayListAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        DialogUtils.showTwoKeyDialogMoreMeg(this, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                windFinish();
            }
        }, "放弃支付吗?", "订单需要在xx内完成支付", "超时将自动取消", "继续付款", "确认放弃");
        //  MobclickAgent.onEvent(mContext, Constant.PAY_CLOSE);    //购买
    }

    @OnClick({R.id.back, R.id.tv_shopcart_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.tv_shopcart_submit:
                if (mChannelId.equals("Master")) {
                    ToastUtils.toastLong("是不是很想支付呀，那找华仔去吧");
                    return;
                }
                if (!TextUtils.isEmpty(mChannelId)) {
                    if (enterType.equals("wait")) {//待付款的
                        mPresenter.orderPayApply(setPayRequest(), mChannelId);
                    } else if (enterType.equals("order")) {
                        mPresenter.orderSubmit(request, mChannelId);
                    } else if (enterType.equals("mobile")) {
                        mPresenter.submitMobleOrder(mobileRequest);
                    }
                } else {
                    ToastUtils.toastLong("请选择支付方式！");
                }
                //   MobclickAgent.onEvent(mContext, Constant.PAY_QUICK_BANK_LIMIT);
                break;
            default:
                break;
        }
    }

    private OrderPayApplyRequest setPayRequest() {
        OrderPayApplyRequest request = new OrderPayApplyRequest();
        request.setOrderId(mWaitOrderId + "");
        request.setChannelId(mChannelId);
        return request;
    }

    @Override
    public void aliPaySuccess() {
        thisFinish("1");
    }

    @Override
    public void aliPayFail() {
        thisFinish("2");
    }

    private void thisFinish(String type) {
        if (type.equals("1")) {
            IntentUtils.gotoActivity(mContext, PaySuccessActivity.class, request.getTotalPrice());
            /*IntentUtils.gotoMainActivity(mContext, 2);
            IntentUtils.gotoMeOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_WAITSEND);*/
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            finish();
        } else {
            if (enterType.equals("wait")) {
                windFinish();
            } else {
                IntentUtils.gotoActivity(mContext, PayFailActivity.class, mPayAgainParms);
             /*   IntentUtils.gotoMainActivity(mContext, 2);
                IntentUtils.gotoMeOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_WAITPAY);*/
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                finish();
            }
        }
    }

    private void windFinish() {
        finish();
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
      /*  if (mPalyType.equals("AliPay.APP")) {
            overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
        }else {

        }*/
    }

    @Override
    public void aliAuthSuccess() {

    }

    @Override
    public void aliAuthFail() {

    }

    @Override
    public void wechatPaySuccess() {

    }

    @Override
    public void wechatPayFail() {

    }

    /**
     * 主界面切换通知 重新调起数据
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadWeixin(WeiXinEvent event) {
        if (event != null) {
            if (event.getCode() == 0) {//支付成功
                //进行跳转
                //   MobclickAgent.onEvent(mContext, Constant.WECHAT_OK);
                aliPaySuccess();
            } else {//支付失败
                //进行跳转
                //    MobclickAgent.onEvent(mContext, Constant.WECHAT_CANCLE);
                aliPayFail();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.error("niu", "onStop");
    }

    @Override
    public void showCustomLayout(int layoutId) {

    }

    @Override
    public void stopRefresh() {

    }

    @Override
    public void submitOrder(OrderSubmitResponse orderSubmit, String payType) {
        OrderPayApplyRequest request = new OrderPayApplyRequest();
        mWaitOrderId = orderSubmit.getOrderId();
        mPayAgainParms.setmWaitOrderId(mWaitOrderId);
        request.setOrderId(mWaitOrderId);
        request.setChannelId(payType);
        mPresenter.orderPayApply(request, payType);
    }

    @Override
    public void orderPayApply(OrderPayApplyResponse response, String payType) {
        if (payType.equals("AliPay.APP")) {
            if (response.getPayParams() != null && (!TextUtils.isEmpty(response.getPayParams()))) {
                PayUtils utils = new PayUtils(this, NewPayWindowActivity.this);
                utils.aliPay(response.getPayParams());
            } else {
                ToastUtils.toastLong("支付参数错误！！");
            }
        } else if (payType.equals("WeiXin.APP")) {
            if (response.getPayParams() != null && (!TextUtils.isEmpty(response.getPayParams()))) {
                WeixinEntity entity = new Gson().fromJson(response.getPayParams(), WeixinEntity.class);
                PayUtils utils = new PayUtils(this, NewPayWindowActivity.this);
                if (entity != null) {
                    utils.payWeChat(entity);
                }
            } else {
                ToastUtils.toastLong("支付参数错误！！");
            }
        }
    }

    @Override
    public void getPayTradeChannel(List<TradeChannelResponse> payList) {
        //默认选中第一个
        if (!payList.isEmpty()) {
            payList.get(0).setSelect(true);
            mChannelId = payList.get(0).getChannelId();
            mPayAgainParms.setmChannelId(mChannelId);
        }
        adapter.addData(payList);
    }

    @Override
    public void submitMobileSuccess(OrderSubmitResponse bean) {
        mWaitOrderId = bean.getOrderId();
        mPayAgainParms.setmWaitOrderId(bean.getOrderId());
        mPresenter.orderPayApply(setPayRequest(), mChannelId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }

    @Override
    public void openDetial(int postion) {
        mChannelId = data.get(postion).getChannelId();
        mPayAgainParms.setmChannelId(mChannelId);
    }
}
