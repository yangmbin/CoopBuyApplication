package com.coopbuy.mall.ui.module.center.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.presenter.AddUserAddressPresenter;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.AddressDataUtil;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.PermissionUtil;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.cityview.AddressDialog;
import com.coopbuy.mall.widget.cityview.AddressSelectorDialog;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AddresssAddUserActivity extends BaseActivity<AddUserAddressPresenter, AddUserAddressModel> implements AddUserAddress_IView, View.OnFocusChangeListener {

    @Bind(R.id.edt_name)
    EditText edtName;
    @Bind(R.id.edt_phone)
    EditText edtPhone;
    @Bind(R.id.tv_city)
    TextView mCity;
    @Bind(R.id.iv_name_clear)
    ImageView ivNameClear;
    @Bind(R.id.iv_phone_clear)
    ImageView ivPhoneClear;
    @Bind(R.id.tv_select)
    TextView tvSelect;
    @Bind(R.id.btn_next)
    Button btn_next;
    private long mCode;
    private String mUserName;
    private String mUserPhone;
    private String mUserCity;
    private boolean isPhoneEmpty = false;
    private boolean isNameEmpty = false;
    private boolean isPhoneFocus = false;
    private boolean isNameFocus = false;
    /**
     * 城市联动
     */
    private AddressSelectorDialog addressSelectorDialog;
    private List<AreaDataResponse> mprovinceCityDistrictBean;


    @Override
    public int getLayoutId() {
        return R.layout.activity_addresss_add;
    }

    @Override
    public void initModel() {
        mModel = new AddUserAddressModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AddUserAddressPresenter(this, mModel, this);
        //进入就开始网络请求
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PermissionUtil.verifyStoragePermissions(this);
        }
        readAddressData();
    }

    /**
     * 通过子线程读取数据
     */
    private void readAddressData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = AddressDataUtil.readObject();
                handler.sendMessage(message);
            }
        }).start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mprovinceCityDistrictBean = (List<AreaDataResponse>) msg.obj;
            if (mprovinceCityDistrictBean == null) {
                mPresenter.getProvincesData();
            }
        }
    };

    @Override
    public void initView() {
        setTitle("收货地址填写");
        tvSelect.setVisibility(View.VISIBLE);
        ivNameClear.setVisibility(View.GONE);
        ivPhoneClear.setVisibility(View.GONE);
        edtName.setOnFocusChangeListener(this);
        edtPhone.setOnFocusChangeListener(this);
        setInputListener();
    }

    private void setInputListener() {
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setFocus(charSequence.length(), ivNameClear, isNameFocus);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setFocus(charSequence.length(), ivNameClear, isNameFocus);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isNameEmpty = true;
                } else {
                    isNameEmpty = false;
                }
                setBtnClickState();
            }
        });
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setFocus(charSequence.length(), ivPhoneClear, isPhoneFocus);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setFocus(charSequence.length(), ivPhoneClear, isPhoneFocus);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isPhoneEmpty = true;
                } else {
                    isPhoneEmpty = false;
                }
                setBtnClickState();
            }
        });
    }


    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isNameEmpty && isPhoneEmpty && !TextUtils.isEmpty(mUserCity)) {
            btn_next.setClickable(true);
            btn_next.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
        } else {
            btn_next.setClickable(false);
            btn_next.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }

    private void setCitySelectorDialog() {
        if (addressSelectorDialog == null) {
            addressSelectorDialog = new AddressSelectorDialog(this, mprovinceCityDistrictBean);
        }
        addressSelectorDialog.show();
        addressSelectorDialog.setOnAddressChangedListener(new AddressDialog.OnAddressChangedListener() {
            @Override
            public void onCanceled() {
                addressSelectorDialog.dismiss();
            }

            @Override
            public void onConfirmed(String currentProvinceName, String currentCityName, String currentDistrictName, String currentZipCode) {
                mUserCity = currentProvinceName + " " + currentCityName + " " + currentDistrictName;
                mCity.setText(mUserCity);
                //  tv_street.setText("");
                mCode = Long.valueOf(currentZipCode);
                addressSelectorDialog.dismiss();
                tvSelect.setVisibility(View.GONE);
                setBtnClickState();
                //    mPresenter.getStreetData(String.valueOf(mCode));
            }
        });
    }

    @OnClick({R.id.btn_next, R.id.rl_select_address, R.id.iv_name_clear, R.id.iv_phone_clear})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (checkPhoneAndPwd()) {
                    AddAddressRequest request = new AddAddressRequest();
                    request.setUserName(mUserName);
                    request.setTel(mUserPhone);
                    request.setAddress(mUserCity);
                    request.setCityCode(mCode);
                    IntentUtils.gotoActivity(this, AddresssAddDetailActivity.class, request);
                }
                break;
            case R.id.rl_select_address:
                if (mprovinceCityDistrictBean != null) {
                    if (!isNameEmpty) {//数据有点多 待用户填写完在打开弹窗
                        ToastUtils.toastShort("请先填写收货人姓名");
                        return;
                    }
                    if (!isPhoneEmpty) {
                        ToastUtils.toastShort("请先填写手机号");
                        return;
                    }
                    setCitySelectorDialog();
                } else {
                    mPresenter.getProvincesData();
                }
                break;
            case R.id.iv_name_clear:
                edtName.setText("");
                break;
            case R.id.iv_phone_clear:
                edtPhone.setText("");
                break;
        }
    }

    @Override
    public void getProviencesReponse(List<AreaDataResponse> data) {
        mprovinceCityDistrictBean = data;
        AddressDataUtil.writeObject(mprovinceCityDistrictBean);
    }

    @Override
    public void getChileProiencesData(List<AddressTownResponse> data) {

    }


    /**
     * 检查手机号和密码
     **/
    private boolean checkPhoneAndPwd() {
        mUserName = edtName.getText().toString().trim();
        mUserPhone = edtPhone.getText().toString().trim();

        if (CommonUtils.isEmpty(mUserPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mUserPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        if (CommonUtils.isEmpty(mUserName)) {
            ToastUtils.toastShort("收货人不能为空");
            return false;
        }
        if (CommonUtils.isEmpty(mUserCity)) {
            ToastUtils.toastShort("收货地址你还没选择");
            return false;
        }
        return true;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.edt_name:
                isNameFocus = b;
                if (!b) {
                    ivNameClear.setVisibility(View.GONE);
                } else {
                    if (isNameEmpty) {
                        ivNameClear.setVisibility(View.VISIBLE);
                    }
                }
                break;
            case R.id.edt_phone:
                isPhoneFocus = b;
                if (!b) {
                    ivPhoneClear.setVisibility(View.GONE);
                } else {
                    if (isPhoneEmpty) {
                        ivPhoneClear.setVisibility(View.VISIBLE);
                    }
                }
                break;
        }
    }

    @Override
    public void getStreetFail() {

    }

    @Override
    public void getConmmunityFail() {

    }
}
