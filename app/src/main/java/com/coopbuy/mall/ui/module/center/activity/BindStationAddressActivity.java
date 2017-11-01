package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.bean.ScanMesg;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author csn
 * @time 2017/10/11 0011 10:44
 * @content 绑定站长 填写收货信息
 */
public class BindStationAddressActivity extends BaseActivity {
    @Bind(R.id.tv_station_name)
    TextView tvStationName;
    @Bind(R.id.tv_stationer_name)
    TextView tvStationerName;
    @Bind(R.id.tv_setationer_phone)
    TextView tvSetationerPhone;
    private String mType = "";
    private ScanMesg sm;


    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_station_address;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("填写收货信息");
        if (null != getIntent()) {
            mType = getIntent().getStringExtra(IntentUtils.PARAM1);
            if (null != mType && mType.equals("scan")) {
                sm = (ScanMesg) getIntent().getSerializableExtra(IntentUtils.DATA);
                if (sm != null) {
                    tvSetationerPhone.setText(sm.getPhone());
                    tvStationerName.setText(sm.getName());
                    tvStationName.setText(sm.getStationName());
                }
            }
        }
    }
}
