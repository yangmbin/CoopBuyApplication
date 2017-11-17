package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.DataAnalyseResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.DataAnalyseModel;
import com.coopbuy.mall.ui.module.center.presenter.DataAnalysePresenter;
import com.coopbuy.mall.ui.module.center.view.DataAnalyse_IView;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class DataAnalyseActivity extends BaseActivity<DataAnalysePresenter, DataAnalyseModel> implements DataAnalyse_IView {

    @Bind(R.id.tv_remain_sum)
    TextView tvRemainSum;
    /**
     * 账单状态
     */
    @Bind(R.id.tv_bill_status)
    TextView tvBillSatatus;
    @Bind(R.id.tv_income)
    TextView tvIncome;
    @Bind(R.id.tv_bill_outtime)
    TextView tvBillOutTime;
    @Bind(R.id.tv_data_forecast_income)
    TextView tvDataForecastIncome;
    @Bind(R.id.tv_month_income)
    TextView tvMonthIncome;
    @Bind(R.id.tv_month_bill)
    TextView tvMonthBill;
    @Bind(R.id.tv_bill_hint)
    TextView tvBillHint;

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_analyse;
    }

    @Override
    public void initModel() {
        mModel = new DataAnalyseModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new DataAnalysePresenter(this, mModel, this);
        mPresenter.getDataAnalyse();
    }

    @Override
    public void initView() {
        setTitle(R.string.lab_center_data);
    }


    @OnClick({ R.id.rl_bill, R.id.tv_detail_income, R.id.tv_detail_bill})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_bill:

                break;
            case R.id.tv_detail_income:
                IntentUtils.gotoActivity(this, IncomeActivity.class);
                break;
            case R.id.tv_detail_bill:
                IntentUtils.gotoActivity(this, MyBillActivity.class);
                break;
        }
    }

    @Override
    public void getData(DataAnalyseResponse bean) {
        tvRemainSum.setText(bean.getTotalCommissionAmount() + "");
        tvDataForecastIncome.setText(bean.getNextSettlementBookDate() + "");
        tvBillOutTime.setText("下一期出账时间:" + bean.getNextSettlementBookDate());

        if (null != bean.getLastSettleBookInfo()) {
            tvBillSatatus.setText(bean.getLastSettleBookInfo().getBookStatus());
            tvMonthIncome.setText(bean.getLastSettleBookInfo().getTotalBookAmount() + "");
            tvMonthBill.setText(bean.getLastSettleBookInfo().getBookDate());
            tvBillHint.setText(bean.getLastSettleBookInfo().getTip());
        } else {
            tvBillSatatus.setText("未出账");
            tvMonthBill.setText("本期无账单");
            tvBillHint.setVisibility(View.GONE);
        }
    }
}
