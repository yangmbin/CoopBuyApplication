package com.coopbuy.mall.widget.cityview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AreaDataResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Army on 2017/2/24
 */
public class AddressSelectorDialog extends AddressDialog implements View.OnClickListener {
    private WheelView mViewProvince;
    private WheelView mViewCity;
    private WheelView mViewDistrict;
    private Context mContext;
    private TextView tvCancel;
    private TextView tvConfirm;
    protected boolean isDataLoaded = false;
    private List<AreaDataResponse> provinceList;
    private int provincePosition;
    private int cityPosition;
    private int distrcitPosition;

    public AddressSelectorDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;

    }

    public AddressSelectorDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public AddressSelectorDialog(Context context, List<AreaDataResponse> bean) {
        super(context);
        this.mContext = context;
        provinceList = bean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_address);
        setUpViews();
        setUpListener();
    }

    private void setUpViews() {
        mViewProvince = (WheelView) findViewById(R.id.id_province);
        mViewCity = (WheelView) findViewById(R.id.id_city);
        mViewDistrict = (WheelView) findViewById(R.id.id_district);
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
                    listener.onConfirmed(mCurrentProvinceName, mCurrentCityName, mCurrentDistrictName, mCurrentZipCode);
                }
                break;
            default:
                break;
        }
    }

    private String getZipCode() {
        String mCode = "";
        if (provinceList != null && provinceList.size() > 0) {
            mCode = String.valueOf(provinceList.get(provincePosition).getId());
        }
        if (provinceList.get(provincePosition).getChilds() != null && provinceList.get(provincePosition).getChilds().size() > 0) {
            mCode = String.valueOf(provinceList.get(provincePosition).getChilds().get(cityPosition).getId());
        }
        if (provinceList.get(provincePosition).getChilds().get(cityPosition).getChilds() != null && provinceList.get(provincePosition).getChilds().get(cityPosition).getChilds().size() > 0) {
            mCode = String.valueOf(provinceList.get(provincePosition).getChilds().get(cityPosition).getChilds().get(distrcitPosition).getId());
        }
        return mCode;
    }

    private void initProvinceSelectView() {
        mViewProvince.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                provincePosition = id;
                cityPosition = 0;
                distrcitPosition = 0;
                mCurrentZipCode = getZipCode();
                String provinceText = mProvinceDatas.get(id);
                if (!mCurrentProvinceName.equals(provinceText)) {
                    mCurrentProvinceName = provinceText;

                    ArrayList<String> mCityData = mCitisDatasMap.get(mCurrentProvinceName);
                    if (mCityData.size() == 0) {
                        mCityData = new ArrayList<String>();
                        mCityData.add("");
                    }
                    mViewCity.resetData(mCityData);
                    mViewCity.setDefault(0);

                    mCurrentCityName = mCityData.get(0);
                    if (mCurrentCityName.equals("市辖区")){
                        mCurrentCityName = mCurrentCityName+mProvinceDatas.get(id);
                    }
                    ArrayList<String> mDistrictData = mDistrictDatasMap.get(mCurrentCityName);
                    if (mDistrictData.size() == 0) {
                        mDistrictData = new ArrayList<String>();
                        mDistrictData.add("");
                    }
                    mViewDistrict.resetData(mDistrictData);
                    mViewDistrict.setDefault(0);
                    mCurrentDistrictName = mDistrictData.get(0);
                }

//                mCurrentZipCode = mZipcodeDatasMap.get(mCurrentDistrictName);


            }

            @Override
            public void selecting(int id, String text) {
            }
        });

        mViewCity.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                cityPosition = id;
                distrcitPosition = 0;
                mCurrentZipCode = getZipCode();
                ArrayList<String> mCityData = mCitisDatasMap.get(mCurrentProvinceName);
                if (mCityData.size() == 0) {
                    mCityData = new ArrayList<String>();
                    mCityData.add("");
                }
                String cityText = mCityData.get(id) == null ? "" : mCityData.get(id);
                if (!mCurrentCityName.equals(cityText)) {
                    mCurrentCityName = cityText;
                    ArrayList<String> mCountyData = mDistrictDatasMap.get(mCurrentCityName);
                    if (mCountyData.size() == 0) {
                        mCountyData = new ArrayList<String>();
                        mCountyData.add("");
                    }
                    mViewDistrict.resetData(mCountyData);
                    mViewDistrict.setDefault(0);
                    mCurrentDistrictName = mCountyData.get(0);
                }

            }

            @Override
            public void selecting(int id, String text) {

            }
        });

        mViewDistrict.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                distrcitPosition = id;
                mCurrentZipCode = getZipCode();
                ArrayList<String> mDistrictData;
                if (mCurrentCityName.equals("市辖区")) {
                    mDistrictData = mDistrictDatasMap.get(mCurrentCityName + mProvinceDatas.get(0));
                } else {
                    mDistrictData = mDistrictDatasMap.get(mCurrentCityName);
                }
                if (mDistrictData.size() == 0) {
                    mDistrictData = new ArrayList<String>();
                    mDistrictData.add("");
                }
                String districtText = mDistrictData.get(id) == null ? "" : mDistrictData.get(id);
                if (!mCurrentDistrictName.equals(districtText)) {
                    mCurrentDistrictName = districtText;
                }
                // mCurrentZipCode = mZipcodeDatasMap.get(mCurrentDistrictName);

            }

            @Override
            public void selecting(int id, String text) {

            }
        });
        getData();


    }

    private void getData() {
        // 启动线程读取数据
        new Thread() {
            @Override
            public void run() {
                // 读取数据
                isDataLoaded = initProvinceDatas();
                // 通知界面线程
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        setDefaultData();
                    }
                });
            }
        }.start();
    }


    /**
     * //     * 初始化数据
     * //
     */

    protected boolean initProvinceDatas() {

        if (provinceList != null && !provinceList.isEmpty()) {
            mCurrentProvinceName = provinceList.get(0).getName();
            List<AreaDataResponse.ChildsBeanX> cityList = provinceList.get(0).getChilds();
            if (cityList != null && !cityList.isEmpty()) {
                mCurrentCityName = cityList.get(0).getName();
                mCurrentZipCode = String.valueOf(cityList.get(0).getId());
                List<AreaDataResponse.ChildsBeanX.ChildsBeanY> districtList = cityList.get(0).getChilds();
                if (districtList != null && !districtList.isEmpty()) {
                    mCurrentDistrictName = districtList.get(0).getName();
                    mCurrentZipCode = String.valueOf(districtList.get(0).getId());
                }
            }
        }
        //*/
        //            mProvinceDatas = new String[provinceList.size()];
        mProvinceDatas = new ArrayList<String>();
        for (int i = 0; i < provinceList.size(); i++) {
            mProvinceDatas.add(provinceList.get(i).getName());
            List<AreaDataResponse.ChildsBeanX> cityList = provinceList.get(i).getChilds();
            ArrayList<String> cityNames = new ArrayList<String>();
            if (cityList != null || cityList.size() > 0) {
                for (int j = 0; j < cityList.size(); j++) {
                    cityNames.add(cityList.get(j).getName());
                    List<AreaDataResponse.ChildsBeanX.ChildsBeanY> districtList = cityList.get(j).getChilds();
                    ArrayList<String> distrinctNameArray = new ArrayList<String>();
                    if (districtList != null || districtList.size() > 0) {
                        AreaDataResponse.ChildsBeanX.ChildsBeanY[] distrinctArray = new AreaDataResponse.ChildsBeanX.ChildsBeanY[districtList.size()];
                        for (int k = 0; k < districtList.size(); k++) {
                            // ProvinceCityDistrictBean.ProvinceData.CityData.Diustrict districtModel = new (ProvinceCityDistrictBean.ProvinceData.CityData.Diustrict)(districtList.get(k).getName(), String.valueOf(districtList.get(k).getId());
                            distrinctArray[k] = districtList.get(k);
                            distrinctNameArray.add(districtList.get(k).getName());
                            mZipcodeDatasMap.put(districtList.get(k).getName(), String.valueOf(districtList.get(k).getId()));
                        }
                        //这里由于使用的是map 所以key不能是一样的 一样会导致被覆盖
                        if (cityNames.get(j).equals("市辖区")) {
                            mDistrictDatasMap.put(cityNames.get(j) + mProvinceDatas.get(i), distrinctNameArray);
                        } else {
                            mDistrictDatasMap.put(cityNames.get(j), distrinctNameArray);
                        }
                    }
                }
                mCitisDatasMap.put(provinceList.get(i).getName(), cityNames);
            }
        }
        return true;
    }

    private void setDefaultData() {
        mViewProvince.setData(mProvinceDatas);
        mViewProvince.setDefault(0);
        mCurrentProvinceName = mProvinceDatas.get(0);

        ArrayList<String> mCityData = mCitisDatasMap.get(mCurrentProvinceName);
        if (mCityData.size() == 0) {
            mCityData = new ArrayList<String>();
            mCityData.add("");
        }
        mViewCity.setData(mCityData);
        mViewCity.setDefault(0);
        mCurrentCityName = mCityData.get(0) == null ? "" : mCityData.get(0);
        String key = mCurrentCityName + mProvinceDatas.get(0);
        ArrayList<String> mDistrictData = mDistrictDatasMap.get(key);
        if (mDistrictData.size() == 0) {
            mDistrictData = new ArrayList<String>();
            mDistrictData.add("");
        }
        mViewDistrict.setData(mDistrictData);
        mViewDistrict.setDefault(0);
        mCurrentDistrictName = mDistrictData.get(0) == null ? "" : mDistrictData.get(0);
//        mCurrentZipCode = mZipcodeDatasMap.get(mCurrentDistrictName);
//        String aa=mZipcodeDatasMap.get(mCurrentDistrictName);
        mCurrentZipCode = getZipCode();
    }
}
