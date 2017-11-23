package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.Button;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MyCustomReponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.AddCustomModel;
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.AddCustomPresenter;
import com.coopbuy.mall.ui.module.center.view.AddCustom_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.utils.ViewClickUtil;
import com.coopbuy.mall.widget.tab.MyEditText;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/11 0011 14:14
 * @content 增加新客户
 */
public class AddCustomActivity extends BaseActivity<AddCustomPresenter, AddCustomModel> implements AddCustom_IView, IsEmptyPort {
    @Bind(R.id.edt_name)
    MyEditText edtName;
    @Bind(R.id.edit_phone)
    MyEditText editPhone;
    @Bind(R.id.edit_address)
    MyEditText editAddress;
    @Bind(R.id.edit_compelete)
    Button editCompelete;
    private String type;
    private MyCustomReponse.ItemsBean bean;
    private String mName;
    private String mPhone;
    private String mAddress;
    private AddUpdateCustomRequest request;
    private boolean isEmptyName;
    private boolean isEmptyPhone;
    private boolean isEmptyAddress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_custom;
    }

    @Override
    public void initModel() {
        mModel = new AddCustomModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AddCustomPresenter(this, mModel, this);

    }

    @Override
    public void initView() {
        setTitle(getString(R.string.title_add_mycustom));
        edtName.setIsEmptyPort(this);
        editPhone.setIsEmptyPort(this);
        editAddress.setIsEmptyPort(this);
        if (getIntent() != null) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            if (type.equals("edit")) {
                bean = (MyCustomReponse.ItemsBean) getIntent().getSerializableExtra(IntentUtils.DATA);
                if (bean != null) {
                    editAddress.setText(bean.getAddress());
                    edtName.setText(bean.getCustomerName());
                    editPhone.setText(bean.getPhone());
                    editCompelete.setClickable(true);
                    editCompelete.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
                }
            }
        }
    }

    @OnClick(R.id.edit_compelete)
    public void onViewClicked() {
        request = new AddUpdateCustomRequest();
        if (checkOk()) {
            request.setAddress(mAddress);
            request.setCustomerName(mName);
            request.setPhone(mPhone);
            if (type.equals("edit")) {  //修改接口
                request.setCustomerId(bean.getCustomerId());
                mPresenter.updateCustom(request);
            } else {    //添加接口
                mPresenter.addCustom(request);
            }
        }
    }

    private boolean checkOk() {
        mPhone = editPhone.getText();
        mAddress = editAddress.getText().toString().trim();
        mName = edtName.getText();
        if (CommonUtils.isEmpty(mName)) {
            ToastUtils.toastShort("客户名称不能为空");
            return false;
        }
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        if (CommonUtils.isEmpty(mAddress)) {
            ToastUtils.toastShort("客服地址不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void addSuccess() {
        finish();
    }

    @Override
    public void updateSuccess() {
        finish();
    }

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edt_name:
                isEmptyName = isEmpty;
                break;
            case R.id.edit_phone:
                isEmptyPhone = isEmpty;
                break;
            case R.id.edit_address:
                isEmptyAddress = isEmpty;
                break;
        }
        if (isEmptyAddress && isEmptyPhone && isEmptyName) {
            ViewClickUtil.setViewClickable(editCompelete, true);
        } else {
            ViewClickUtil.setViewClickable(editCompelete, false);
        }
    }
}
