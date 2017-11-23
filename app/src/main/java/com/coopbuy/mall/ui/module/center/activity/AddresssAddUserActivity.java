package com.coopbuy.mall.ui.module.center.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.AddSuccessEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.AddUserAddressPresenter;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.AddressDataUtil;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.PermissionUtil;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.utils.ViewClickUtil;
import com.coopbuy.mall.widget.cityview.AddressDialog;
import com.coopbuy.mall.widget.cityview.AddressSelectorDialog;
import com.coopbuy.mall.widget.tab.MyEditText;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/20 0020 13:59
 * @content 修改 添加是一个
 */
public class AddresssAddUserActivity extends BaseActivity<AddUserAddressPresenter, AddUserAddressModel> implements AddUserAddress_IView, IsEmptyPort {

    @Bind(R.id.edt_name)
    MyEditText edtName;
    @Bind(R.id.edt_phone)
    MyEditText edtPhone;
    @Bind(R.id.tv_city)
    TextView mCity;
    @Bind(R.id.tv_select)
    TextView tvSelect;
    @Bind(R.id.btn_next)
    Button btnNext;
    private long mCode;
    private String mUserName;
    private String mUserPhone;
    private String mUserCity;
    private boolean isPhoneEmpty = false;
    private boolean isNameEmpty = false;
    /**
     * 城市联动
     */
    private AddressSelectorDialog addressSelectorDialog;
    private List<AreaDataResponse> mprovinceCityDistrictBean;
    //修改地址相关数据
    private String type;
    private AddressInfoResponse bean;
    private String oldAddress;
    //修改地址时 地址是否更改过 如果更改过 在下一级修改地址是村需要重新填写  如果没有需要设置对应的数据  这里感觉有点难度  需要知道对应的地址编码 下一级才可以改变
    //也就是需要根据现在的地址查找对应的数据城市编码

    private boolean isRevise = false;

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
                mPresenter.getProvincesData("init");
            }
        }
    };

    @Override
    public void initView() {
        edtName.setIsEmptyPort(this);
        edtPhone.setIsEmptyPort(this);
        EventBusInstance.getInstance().registerEvent(this);
        tvSelect.setVisibility(View.VISIBLE);
        if (null != getIntent()) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            if (type.equals("edit")) {
                bean = (AddressInfoResponse) getIntent().getSerializableExtra(IntentUtils.DATA);
                if (null != bean) {
                    edtName.setText(bean.getUserName());
                    edtPhone.setText(bean.getTel());
                    String[] city = bean.getRegionName().split(",");
                    oldAddress = city[0] + city[1] + city[2];
                    mCity.setText(oldAddress);
                    tvSelect.setVisibility(View.GONE);
                    btnNext.setClickable(true);
                    btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
                    isNameEmpty = true;
                    isPhoneEmpty = true;
                    mUserCity = oldAddress;
                }
            }
        }
        setTitle("收货地址填写");
    }
    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isNameEmpty && isPhoneEmpty && !TextUtils.isEmpty(mUserCity)) {
            btnNext.setClickable(true);
            btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
        } else {
            btnNext.setClickable(false);
            btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
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

    @OnClick({R.id.btn_next, R.id.rl_select_address})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (checkPhoneAndPwd()) {
                    AddAddressRequest request = new AddAddressRequest();
                    request.setUserName(mUserName);
                    request.setTel(mUserPhone);
                    request.setAddressDetail(mUserCity);
                    request.setCityCode(mCode);
                    if (type.equals("edit")) {//处于编辑地址是  下面的参数只有添加修改地址的id  只有修改地址用到
                        mUserCity.trim();
                        if (oldAddress.equals(mUserCity)) {//修改时省市区是否修改过 如果没有修改过 下一级数据保持不变
                            isRevise = false;
                            request.setCityCode(Long.valueOf(bean.getRegionIdPath().split(",")[2]));//没有修改使用服务器提供的 直接拿到区 县的代码code
                        } else {
                            isRevise = true;
                            request.setRevise(isRevise);
                            request.setCityCode(mCode);//修改了 使用最新的
                        }
                     /*   request.setRegionName(bean.getRegionName());
                        request.setRegionIdPath(bean.getRegionIdPath());*/
                        request.setAddressId(bean.getAddressId());
                      /*  request.setHasBindStation(bean.isHasBindStation());
                        request.setAddressDetailOld(bean.getAddress());//设置服务器的地址详情*/
                    }
                    IntentUtils.gotoActivity(this, AddresssAddDetailActivity.class, request, type);
                }
                break;
            case R.id.rl_select_address:
                if (!isNameEmpty) {//数据有点多 待用户填写完在打开弹窗
                    ToastUtils.toastShort("请先填写收货人姓名");
                    return;
                }
                if (!isPhoneEmpty) {
                    ToastUtils.toastShort("请先填写手机号");
                    return;
                }
                if (mprovinceCityDistrictBean != null) {
                    setCitySelectorDialog();
                } else {
                    mPresenter.getProvincesData("again");
                }
                break;
        }
    }


    @Override
    public void getProviencesReponse(List<AreaDataResponse> data, String type) {
        mprovinceCityDistrictBean = data;
        AddressDataUtil.writeObject(mprovinceCityDistrictBean);
        if (type.equals("again")) {
            setCitySelectorDialog();
        }
    }

    @Override
    public void getChileProiencesData(List<AddressTownResponse> data, String type,String atin) {

    }

    @Override
    public void getBindStationData(List<GetBindStationReponse> data) {

    }

    @Override
    public void getStreetFail() {

    }

    @Override
    public void getConmmunityFail() {

    }

    @Override
    public void addSuccess() {

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


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(AddSuccessEvent event) {
        if (event != null) {
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edt_name:
                isNameEmpty = isEmpty;
                break;
            case R.id.edt_phone:
                isPhoneEmpty = isEmpty;
                break;
        }
        if (isNameEmpty && isPhoneEmpty) {
            ViewClickUtil.setViewClickable(btnNext, true);
        } else {
            ViewClickUtil.setViewClickable(btnNext, false);
        }
    }
}
