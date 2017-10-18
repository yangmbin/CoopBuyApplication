package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.presenter.AddUserAddressPresenter;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.cityview.AddressStreetSelectorDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AddresssAddDetailActivity extends BaseActivity<AddUserAddressPresenter, AddUserAddressModel> implements AddUserAddress_IView {
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_province)
    TextView tvProvince;
    @Bind(R.id.tv_last)
    TextView tvLast;
    @Bind(R.id.tv_complete)
    TextView tvComplete;
    @Bind(R.id.tv_street)
    TextView tvStreet;
    @Bind(R.id.tv_street_select)
    TextView tvStreetSelect;
    @Bind(R.id.rl_street_select)
    RelativeLayout rlStreetSelect;
    @Bind(R.id.tv_community)
    TextView tvCommunity;
    @Bind(R.id.tv_community_select)
    TextView tvCommunitySelect;
    @Bind(R.id.rl_community)
    RelativeLayout rlCommunity;
    @Bind(R.id.edt_address_detail)
    EditText edtAddressDetail;
    private AddAddressRequest request;
    private List<AddressTownResponse> mSreetDataBean;
    private AddressStreetSelectorDialog addressStreetSelectorDialog;
    private int mStreetCode;
    GetChildProvincesRequest gcprequest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_addresss_add_detail;
    }

    @Override
    public void initModel() {
        mModel = new AddUserAddressModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AddUserAddressPresenter(this, mModel, this);
        gcprequest = new GetChildProvincesRequest();
        gcprequest.setParentId(request.getCityCode());
        mPresenter.getChildProvincesData(gcprequest,"street");
    }

    @Override
    public void initView() {
        mSreetDataBean = new ArrayList<>();
        tvStreetSelect.setVisibility(View.VISIBLE);
        tvCommunitySelect.setVisibility(View.VISIBLE);
        if (null != getIntent()) {
            request = (AddAddressRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
            tvName.setText(request.getUserName());
            tvPhone.setText(request.getTel());
            tvProvince.setText(request.getAddress());
        }
        setTitle("收货地址填写");
    }

    @OnClick({R.id.tv_province, R.id.tv_last, R.id.tv_complete, R.id.rl_street_select, R.id.rl_community})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_province:

                break;
            case R.id.tv_last:

                break;
            case R.id.tv_complete:

                break;
            case R.id.rl_street_select:
                if (!mSreetDataBean.isEmpty()) {
                    setStreetSelectorDialog();
                } else {
                    mPresenter.getChildProvincesData(gcprequest,"street");
                }
                break;
            case R.id.rl_community:

                break;
        }
    }

    /**
     * 选择街道对话框
     */
    private void setStreetSelectorDialog() {
        addressStreetSelectorDialog = new AddressStreetSelectorDialog(this, mSreetDataBean);
        addressStreetSelectorDialog.show();
        addressStreetSelectorDialog.setOnAddressChangedListener(new AddressStreetSelectorDialog.OnAddressChangedListener() {
            @Override
            public void onCanceled() {
                addressStreetSelectorDialog.dismiss();
            }

            @Override
            public void onConfirmed(String currentStreetName, String currentZipCode) {
                tvStreet.setText(currentStreetName);
                mStreetCode = Integer.valueOf(currentZipCode);
                addressStreetSelectorDialog.dismiss();
                tvStreetSelect.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void getProviencesReponse(List<AreaDataResponse> data) {

    }

    @Override
    public void getChileProiencesData(List<AddressTownResponse> data) {
        mSreetDataBean.addAll(data);
    }

    @Override
    public void getStreetFail() {

    }

    @Override
    public void getConmmunityFail() {

    }

}
