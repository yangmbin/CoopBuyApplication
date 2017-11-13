package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class DataAnalyseActivity extends BaseActivity {

    @Bind(R.id.tv_remain_sum)
    TextView tvRemainSum;
    @Bind(R.id.tv_data_income)
    TextView tvDataIncome;
    @Bind(R.id.tv_income)
    TextView tvIncome;
    @Bind(R.id.tv_data_forecast_income)
    TextView tvDataForecastIncome;

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_analyse;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.lab_center_data);
    }


    @OnClick({R.id.tv_data_confirm, R.id.rl_bill, R.id.tv_detail_income, R.id.tv_detail_bill})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_data_confirm:
                break;
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

}
