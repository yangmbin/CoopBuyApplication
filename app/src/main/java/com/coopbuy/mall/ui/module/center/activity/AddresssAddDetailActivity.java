package com.coopbuy.mall.ui.module.center.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.api.request.GetBindStationRequest;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.AddSuccessEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.ui.module.center.adapter.ExpandableListPort;
import com.coopbuy.mall.ui.module.center.adapter.MyBaseExpandableListAdapter;
import com.coopbuy.mall.ui.module.center.adapter.Shuizhui;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.presenter.AddUserAddressPresenter;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.CustomerExpandableListView;
import com.coopbuy.mall.widget.cityview.AddressStreetSelectorDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class AddresssAddDetailActivity extends BaseActivity<AddUserAddressPresenter, AddUserAddressModel> implements AddUserAddress_IView, ExpandableListPort {
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
    @Bind(R.id.ll_street_community)
    LinearLayout llStreetCommunity;
    //没有站长数据 隐藏
    @Bind(R.id.ll_ishasbind)
    LinearLayout llIsHasbind;
    @Bind(R.id.expandlist)
    CustomerExpandableListView expandlist;
    private List<String> groupData;//group的数据源
    private Map<Integer, List<GetBindStationReponse.StationUsersBean>> childData;//child的数据源
    private MyBaseExpandableListAdapter myAdapter;
    private AddAddressRequest request;
    private List<AddressTownResponse> mSreetDataBean;//二级数据
    private List<AddressTownResponse> mCommUnityBean;//第三级数据
    private AddressStreetSelectorDialog addressStreetSelectorDialog;
    private long mStreetCode;
    private long mCommUnityCode;
    GetChildProvincesRequest gcprequest;
    private String mStreetStr;
    private String mAddressDetail;
    private boolean isAddressEmpty = false;

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
        mPresenter.getChildProvincesData(gcprequest, "street");
    }

    @Override
    public void initView() {
        mSreetDataBean = new ArrayList<>();
        mCommUnityBean = new ArrayList<>();
        llIsHasbind.setVisibility(View.GONE);
        tvStreetSelect.setVisibility(View.VISIBLE);
        tvCommunitySelect.setVisibility(View.VISIBLE);
        if (null != getIntent()) {
            request = (AddAddressRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
            tvName.setText(request.getUserName());
            tvPhone.setText(request.getTel());
            tvProvince.setText(request.getAddressDetail());
        }
        setTitle("收货地址填写");
        setInputListener();
    }

    private void setInputListener() {
        edtAddressDetail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isAddressEmpty = true;
                } else {
                    isAddressEmpty = false;
                }
                setBtnClickState();
            }
        });
    }

    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isAddressEmpty) {
            tvComplete.setClickable(true);
            tvComplete.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
        } else {
            tvComplete.setClickable(false);
            tvComplete.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }

    private void setExpandlist(List<GetBindStationReponse> data) {
        groupData = new ArrayList<String>();
        childData = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            groupData.add(data.get(i).getSstationName());
            List<GetBindStationReponse.StationUsersBean> sd = new ArrayList<>();
            for (int j = 0; j < data.get(i).getStationUsers().size(); j++) {
                GetBindStationReponse.StationUsersBean bean = data.get(i).getStationUsers().get(j);
                bean.setStationId(data.get(i).getStationId());
                if (i == 0) {
                    bean.setSelect(true);//设置第一个选中状态 不管有几个服务站 默认设置站点的第一个为默认
                    request.setStationId(bean.getStationId());
                    request.setStationUserId(bean.getStationUserId());
                }
                GetBindStationReponse.StationUsersBean bean1 = new GetBindStationReponse.StationUsersBean();
                bean1.setIsStationMaster(false);
                bean1.setStationUserId(2);
                bean1.setStationUserName("测试1");
                sd.add(bean);
                sd.add(bean1);
            }
            childData.put(i, sd);
        }
        myAdapter = new MyBaseExpandableListAdapter(this, groupData, childData, this);
        expandlist.setGroupIndicator(null);//这里不显示系统默认的group indicator
        expandlist.setAdapter(myAdapter);
        registerForContextMenu(expandlist);//给ExpandListView添加上下文菜单

    }

    @OnClick({R.id.tv_last, R.id.tv_complete, R.id.rl_street_select, R.id.rl_community})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_last:
                this.finish();
                break;
            case R.id.tv_complete:
                if (checkAddress()) {
                    request.setAddress(mAddressDetail);
                    mPresenter.addReciverAddress(request);
                }
                break;
            case R.id.rl_street_select:
                if (!mSreetDataBean.isEmpty()) {
                    setStreetSelectorDialog("street");
                } else {
                    mPresenter.getChildProvincesData(gcprequest, "street");
                }
                break;
            case R.id.rl_community:
                if (TextUtils.isEmpty(mStreetStr)) {
                    ToastUtils.toastShort("请先选择街道");
                    return;
                }
                if (!mCommUnityBean.isEmpty()) {
                    setStreetSelectorDialog("commUnity");
                } else {
                    mPresenter.getChildProvincesData(gcprequest, "commUnity");
                }
                break;
        }
    }

    private boolean checkAddress() {
        mAddressDetail = edtAddressDetail.getText().toString().trim();
        if (TextUtils.isEmpty(mAddressDetail)) {
            ToastUtils.toastShort("详情收货地址还没有填写");
            return false;
        }
        return true;
    }

    /**
     * 选择街道对话框
     */
    private void setStreetSelectorDialog(final String type) {
        if (type.equals("street")) {
            addressStreetSelectorDialog = new AddressStreetSelectorDialog(this, mSreetDataBean);
        } else {
            addressStreetSelectorDialog = new AddressStreetSelectorDialog(this, mCommUnityBean);
        }
        addressStreetSelectorDialog.show();
        addressStreetSelectorDialog.setOnAddressChangedListener(new AddressStreetSelectorDialog.OnAddressChangedListener() {
            @Override
            public void onCanceled() {
                addressStreetSelectorDialog.dismiss();
            }

            @Override
            public void onConfirmed(String currentStreetName, String currentZipCode, boolean ishasBindSite) {
                if (type.equals("street")) {
                    mStreetStr = currentStreetName;
                    tvStreet.setText(currentStreetName);
                    mStreetCode = Long.valueOf(currentZipCode);
                    tvStreetSelect.setVisibility(View.GONE);
                    gcprequest = new GetChildProvincesRequest();
                    gcprequest.setParentId(mStreetCode);
                    mPresenter.getChildProvincesData(gcprequest, "commUnity");//重新请求 村 居委会 需要重新设置
                    tvCommunity.setText("村(社区)");
                    tvCommunitySelect.setVisibility(View.VISIBLE);
                    llIsHasbind.setVisibility(View.GONE);
                    mCommUnityCode = 0;
                    //设置添加地址
                    request.setRegionId(mStreetCode);
                } else {
                    mCommUnityCode = Long.valueOf(currentZipCode);
                    tvCommunity.setText(currentStreetName);
                    tvCommunitySelect.setVisibility(View.GONE);
                    if (ishasBindSite) { //  需要请求绑定的站点
                        GetBindStationRequest request = new GetBindStationRequest();
                        request.setRegionId(mCommUnityCode);
                        mPresenter.getBindStationData(request);
                        llIsHasbind.setVisibility(View.VISIBLE);
                    } else {
                        llIsHasbind.setVisibility(View.GONE);
                    }
                    //设置添加地址 如果到街道选择
                    request.setRegionId(mCommUnityCode);
                }
                addressStreetSelectorDialog.dismiss();
            }
        });
    }

    @Override
    public void getProviencesReponse(List<AreaDataResponse> data) {

    }

    @Override
    public void getChileProiencesData(List<AddressTownResponse> data, String type) {
        if (type.equals("street")) {
            mSreetDataBean.addAll(data);
        } else {
            mCommUnityBean.addAll(data);
        }
    }

    @Override
    public void getBindStationData(List<GetBindStationReponse> data) {
        setExpandlist(data);
    }

    @Override
    public void getStreetFail() {
        //获取街道失败 那么久不会有村 居委会了
        llStreetCommunity.setVisibility(View.GONE);
    }

    @Override
    public void getConmmunityFail() {
        rlCommunity.setVisibility(View.GONE);
    }

    @Override
    public void addSuccess() {
        this.finish();
        EventBusInstance.getInstance().post(new AddSuccessEvent());
    }


    @Override
    public void checkPostionIstrue(GetBindStationReponse.StationUsersBean bean) {
        request.setStationId(bean.getStationId());
        request.setStationUserId(bean.getStationUserId());
    }
}
