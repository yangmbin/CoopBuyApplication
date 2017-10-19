package com.coopbuy.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.tab.MainTabView;
import com.guinong.net.utils.LogUtil;

/**
 * @author wangyu
 * @time 2017/4/14 0014 on 下午 14:00
 * @desc 我的订单
 */
public class OrderBarView extends RelativeLayout implements View.OnTouchListener {

    private Context mContext;
    private int OnClickType = Constants.ORDER_TYPE_ALL;
    /**
     * 我的订单
     */
    private RelativeLayout mAllOrder;
    /**
     * 待支付
     */
    private MainTabView mWaitpay;
    /**
     * 待发货
     */
    private MainTabView mWaitsend;
    /**
     * 待收货
     */
    private MainTabView mWaitcharge;

    /**
     * 售后
     */
    private MainTabView mAftersales;
    float y = 0.0f;

    public OrderBarView(Context context) {
        this(context, null);
    }

    public OrderBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void initView(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.order_me, this);
        mAllOrder = (RelativeLayout) findViewById(R.id.look_allOrder);
        mWaitpay = (MainTabView) findViewById(R.id.wait_pay);
        mWaitsend = (MainTabView) findViewById(R.id.wait_send);
        mWaitcharge = (MainTabView) findViewById(R.id.wait_charge);
        mAftersales = (MainTabView) findViewById(R.id.after_sales);
        initListener();
    }

    /**
     * 设置点击事件
     */
    private void initListener() {
        mAllOrder.setOnClickListener(mOnClickListener);
        mWaitpay.setOnClickListener(mOnClickListener);
        mWaitsend.setOnClickListener(mOnClickListener);
        mWaitcharge.setOnClickListener(mOnClickListener);
        mAftersales.setOnClickListener(mOnClickListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                y = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                float currrY = ev.getY();
                if (Math.abs(currrY - y) < 1) {
                    //不想要父视图拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;

        }
        return super.onTouchEvent(ev);
    }

    /**
     * 设置代付款消息数量
     *
     * @param dox
     */
    public void setWaitpayDox(int dox) {
        mWaitpay.setDotText(dox);
    }

    /**
     * 设置待发货消息数量
     *
     * @param dox
     */
    public void setWaitsendDox(int dox) {
        mWaitsend.setDotText(dox);
    }


    /**
     * 设置待收货消息数量
     *
     * @param dox
     */
    public void setWaitchargeDox(int dox) {
        mWaitcharge.setDotText(dox);
    }

    /**
     * 设置售后消息数量
     *
     * @param dox
     */
    public void setAftersalesDox(int dox) {
        mAftersales.setDotText(dox);
    }

    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.look_allOrder:
                    OnClickType = Constants.ORDER_TYPE_ALL;
                    break;
                case R.id.wait_pay:
                    OnClickType = Constants.ORDER_TYPE_WAITPAY;
                    break;
                case R.id.wait_send:
                    OnClickType = Constants.ORDER_TYPE_WAITSEND;
                    break;
                case R.id.wait_charge:
                    OnClickType = Constants.ORDER_TYPE_WAITCHARGE;
                    break;
                case R.id.after_sales:
                    OnClickType = Constants.ORDER_TYPE_AFTERSALES;
                    break;
                default:
                    break;
            }
            // 判断是否登录
        /*    Boolean isLogin = SharedPreferencesUtils.getInstance(CoopBuyApplication.context).getLoginStatus();
            if (isLogin) {*/
            IntentUtils.gotoOrderActivity(mContext, OnClickType);
            /*} else {
                LoginActivity.newIntentMeActivity(mContext, FinalConstant.login_type_to_activity, OnClickType);
            }*/
        }
    };

    @Override
    public boolean onTouch(View view, MotionEvent ev) {
        int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                y = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                float currrY = ev.getY();
                LogUtil.error("tag", "order----up1-----onTouchEvent---" + "y----:" + y + "-------,,vaue----:" + Math.abs(currrY - y));
                if (Math.abs(currrY - y) < 10) {
                    //不想要父视图拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;

        }
        return super.onTouchEvent(ev);
    }
}
