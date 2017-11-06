package com.coopbuy.mall.ui.module.center.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CheckPhoneReponse;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.api.request.MobilePayRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.PhoneRechargeAdapter;
import com.coopbuy.mall.ui.module.center.model.PhoneRechargeModel;
import com.coopbuy.mall.ui.module.center.pay.NewPayWindowActivity;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.PhoneRechargePresenter;
import com.coopbuy.mall.ui.module.center.view.PhoneRecharge_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class PhoneRechargeActivity extends BaseActivity<PhoneRechargePresenter, PhoneRechargeModel> implements PhoneRecharge_IView, FootMarkPort, View.OnFocusChangeListener, TextWatcher {
    @Bind(R.id.edit_phone)
    EditText editPhone;
    @Bind(R.id.tv_charge)
    TextView tvCharge;
    @Bind(R.id.iv_clear)
    ImageView ivClear;
    @Bind(R.id.tv_area)
    TextView mArea;
    @Bind(R.id.swipe_target)
    RecyclerView swipeTarget;
    @Bind(R.id.tv_charge_number)
    TextView tvChargeNumber;
    @Bind(R.id.btn_complete)
    Button btnComplete;
    private String mPhone;
    private String mCardId;
    private List<PhoneRechargeListReponse> data;
    private PhoneRechargeAdapter adapter;
    private MobilePayRequest request;
    private boolean hasFoucs;
    private boolean isPhoneImepty = false;
    private boolean isSelect = false;
    private String mRechargePrice;

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone_charge;
    }

    @Override
    public void initModel() {
        mModel = new PhoneRechargeModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new PhoneRechargePresenter(this, mModel, this);
        mPresenter.getMobilList();
    }

    @Override
    public void initView() {
        setTitle(R.string.title_charge);
        request = new MobilePayRequest();
        initRey();
        editPhone.addTextChangedListener(this);
        editPhone.setOnFocusChangeListener(this);
    }

    private boolean checkPhone(boolean checekSecletc) {
        mPhone = editPhone.getText().toString().trim();
        setArea("");
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        if (checekSecletc) {
            if (!isSelect) {
                ToastUtils.toastShort("请选择充值的金额");
            }
        }
        return true;
    }

    private void initRey() {
        data = new ArrayList<>();
        adapter = new PhoneRechargeAdapter(this, data, this);
        swipeTarget.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        swipeTarget.setAdapter(adapter);
    }


    @Override
    public void getMobilData(List<PhoneRechargeListReponse> data) {
        request.setCardId(data.get(0).getCardId());
        adapter.addData(data);
    }

    @Override
    public void getCheckPhoneData(CheckPhoneReponse bean) {
        setArea(bean.getArea());
    }


    private void setArea(String msg) {
        mArea.setText(msg);
    }

    @Override
    public void openDetial(int postion) {
        mRechargePrice = data.get(postion).getSalePrice() + "";
        tvChargeNumber.setText("支付：" + mRechargePrice + "元");
        request.setCardId(data.get(postion).getCardId());
        isSelect = true;
        setBtnClickState();
    }

    @OnClick({R.id.iv_clear, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_clear:
                editPhone.setText("");
                mArea.setText("");
                break;
            case R.id.btn_complete:
                if (checkPhone(true)) {
                    request.setCount("1");
                    request.setAllPrice(mRechargePrice);
                    Intent intent = new Intent(this, NewPayWindowActivity.class);
                    intent.putExtra(IntentUtils.DATA, request);
                    intent.putExtra("type", "mobile");
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
                }
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        this.hasFoucs = hasFocus;
        if (hasFocus) {
            setClearIconVisible(editPhone.getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    protected void setClearIconVisible(boolean visible) {
        if (visible) {
            ivClear.setVisibility(View.VISIBLE);
        } else {
            ivClear.setVisibility(View.GONE);
        }
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (hasFoucs) {
            setClearIconVisible(charSequence.length() > 0);
            if (charSequence.length() == 11) {
                if (checkPhone(false)) {
                    request.setPhone(mPhone);
                    mPresenter.getCheckPhoneData(request);
                }
            }
        } else {
            setClearIconVisible(false);
        }
        if (charSequence.length() > 0) {
            isPhoneImepty = true;
        } else {
            isPhoneImepty = false;
        }
        setBtnClickState();
    }

    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isPhoneImepty && isSelect) {
            btnComplete.setClickable(true);
            btnComplete.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
        } else {
            btnComplete.setClickable(false);
            btnComplete.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }
}
