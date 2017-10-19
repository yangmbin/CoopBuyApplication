package com.coopbuy.mall.widget.cityview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressTownResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Army on 2017/2/24
 */
public class AddressStreetSelectorDialog extends BaseDialog implements View.OnClickListener {
    private WheelView id_street;
    private Context mContext;
    private TextView tvCancel;
    private TextView tvConfirm;
    protected boolean isDataLoaded = false;
    private List<AddressTownResponse> streetList;

    /**
     * 当前街道
     */
    protected String mCurrentStreetName = "";

    /**
     * 当前邮编
     */
    protected String mCurrentZipCode = "";
    public OnAddressChangedListener listener;

    public AddressStreetSelectorDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;

    }

    public AddressStreetSelectorDialog(Context context) {
        super(context);
        this.mContext = context;
    }
    public AddressStreetSelectorDialog(Context context, List<AddressTownResponse> bean) {
        super(context);
        this.mContext = context;
        streetList=bean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_address_street);
        setUpViews();
        setUpListener();
    }

    private void setUpViews() {
        id_street = (WheelView) findViewById(R.id.id_street);
        tvCancel = (TextView) findViewById(R.id.btn_cancel);
        tvConfirm = (TextView) findViewById(R.id.btn_confirm);
        initProvinceSelectView();
    }

    private void setUpListener() {
        // 取消和确定
        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                if (null != listener) {
                    listener.onCanceled();
                }
                break;
            case R.id.btn_confirm:
                if (null != listener) {
                    listener.onConfirmed(mCurrentStreetName, mCurrentZipCode);
                }
                break;
            default:
                break;
        }
    }

    private void initProvinceSelectView() {

        id_street.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                String districtText = streetList.get(id).getName();
                if (!mCurrentStreetName.equals(districtText)) {
                    mCurrentStreetName = districtText;
                }
                mCurrentZipCode = String.valueOf(streetList.get(id).getId());
            }

            @Override
            public void selecting(int id, String text) {

            }
        });

        setDefaultData();
    }






    private void setDefaultData() {
        ArrayList<String> mDistrictData=new ArrayList<>();
        for (int i = 0; i <streetList.size() ; i++) {
            mDistrictData.add(streetList.get(i).getName());
        }

        id_street.setData(mDistrictData);
        id_street.setDefault(0);
        mCurrentStreetName = mDistrictData.get(0);
        mCurrentZipCode = String.valueOf(streetList.get(0).getId());
    }


    public interface OnAddressChangedListener {
        void onCanceled();

        void onConfirmed(String currentStreetName, String currentZipCode);
    }

    public void setOnAddressChangedListener(OnAddressChangedListener listener) {
        this.listener = listener;
    }
}
