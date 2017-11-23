package com.coopbuy.mall.ui.module.center.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
import com.coopbuy.mall.ui.module.center.port.ExpandableListPort;
import com.coopbuy.mall.ui.module.center.adapter.MyBaseExpandableListAdapter;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.AddUserAddressPresenter;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.utils.ViewClickUtil;
import com.coopbuy.mall.widget.CustomerExpandableListView;
import com.coopbuy.mall.widget.cityview.AddressStreetSelectorDialog;
import com.coopbuy.mall.widget.tab.MyEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class AddresssAddDetailActivity extends BaseActivity<AddUserAddressPresenter, AddUserAddressModel> implements AddUserAddress_IView, ExpandableListPort, IsEmptyPort {
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
    MyEditText edtAddressDetail;
    @Bind(R.id.ll_street_community)
    LinearLayout llStreetCommunity;
    @Bind(R.id.ll_ishasbind)
    LinearLayout llIshasbind;
    //没有站长数据 隐藏
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
    //这里是防止有些只有省市区是 完成按钮没有效果的情况
    private boolean isAddressDataEmpty = false;
    //是否修改过省市区
    private boolean isRevise;
    private String type; //add  edit  添加和修改
    private String[] streetCommUnityCodes;
    private String[] streetCommUnity;

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
        setReviceAddress();
    }

    private void setReviceAddress() {
        if (type.equals("edit")) { //这是修改地址 进入的   后期再改吧  重新选择吧
           /* streetCommUnityCodes = request.getRegionIdPath().split(",");
            mStreetCode = Long.valueOf(streetCommUnityCodes[streetCommUnityCodes.length - 1]);
            edtAddressDetail.setText(request.getAddressDetailOld());//街道 和村可能已经改变 但是详情可以不变
            if (isRevise) {//地址修改过  详情地址可以不变 但是对应地址需要修改  这里需要更一般添加处理 拿上一级code来进行处理
                isAddressEmpty = false;
                //请求对应数据
                getProiencesData(request.getCityCode(), "street");
                request.setRegionId(mStreetCode);
                return;
            } else {//地址没有修改过
                isAddressEmpty = true;
                tvComplete.setClickable(true);
                tvComplete.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
                streetCommUnity = request.getRegionName().split(",");
                if (streetCommUnityCodes.length == 5) {//这里需要根据服务器的地址去拉起 对应街道  村庄的数据
                    tvStreet.setText(streetCommUnity[3]);
                    tvCommunity.setText(streetCommUnity[4]);
                    setViewViesible(tvStreetSelect, false);
                    setViewViesible(tvCommunitySelect, false);
                    mStreetStr = streetCommUnity[3];
                    //请求街道地址
                    getProiencesData(Long.valueOf(streetCommUnityCodes[2]), "street");
                }
                if (streetCommUnityCodes.length == 4) {
                    mStreetStr = streetCommUnity[3];
                    tvStreet.setText(streetCommUnity[3]);
                    setViewViesible(tvStreetSelect, false);
                    getProiencesData(Long.valueOf(streetCommUnityCodes[2]), "street");
                    rlCommunity.setVisibility(View.GONE);//只有4级 村庄不显示了
                }
                if (streetCommUnityCodes.length == 3) {
                    llStreetCommunity.setVisibility(View.GONE);//只有3级
                }
                request.setRegionId(mStreetCode);
            }*/
            //  getProiencesData(request.getCityCode(), "street");
        } else {

        }
        getProiencesData(request.getCityCode(), "street", "init");
    }

    @Override
    public void initView() {
        mSreetDataBean = new ArrayList<>();
        mCommUnityBean = new ArrayList<>();
        edtAddressDetail.setIsEmptyPort(this);
        setViewViesible(tvStreetSelect, true);
        setViewViesible(tvCommunitySelect, true);
        if (null != getIntent()) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            request = (AddAddressRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
            tvName.setText(request.getUserName());
            tvPhone.setText(request.getTel());
            tvProvince.setText(request.getAddressDetail());
            isRevise = request.isRevise();
        }
        setTitle("收货地址填写");

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
                sd.add(bean);
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
                    if (request.getAddressId() != 0) {
                        mPresenter.updateAddress(request);
                    } else {
                        mPresenter.addReciverAddress(request);
                    }
                }
                break;
            case R.id.rl_street_select:
                if (!mSreetDataBean.isEmpty()) {
                    setStreetSelectorDialog("street");
                } else {
                    mPresenter.getChildProvincesData(gcprequest, "street", "again");
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
                    mPresenter.getChildProvincesData(gcprequest, "commUnity", "init");
                }
                break;
        }
    }

    private boolean checkAddress() {
        mAddressDetail = edtAddressDetail.getText().toString().trim();
        if (tvStreet.getText().toString().trim().equals("镇(街道)")) {
            ToastUtils.toastShort("镇(街道) 还没有填写");
            return false;
        }
        if (tvCommunity.getText().toString().trim().equals("村(社区)")) {
            ToastUtils.toastShort("村(社区) 还没有填写");
            return false;
        }
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
                    setViewViesible(tvStreetSelect, false);
                    llIshasbind.setVisibility(View.GONE);
                    //重新请求 村 居委会 需要重新设置
                    getProiencesData(mStreetCode, "commUnity", "init");
                    tvCommunity.setText("村(社区)");
                    setViewViesible(tvCommunitySelect, true);
                    mCommUnityCode = 0;
                    //设置添加地址
                    request.setRegionId(mStreetCode);
                } else {
                    mCommUnityCode = Long.valueOf(currentZipCode);
                    tvCommunity.setText(currentStreetName);
                    setViewViesible(tvCommunitySelect, false);
                    request.setRegionId(mCommUnityCode);
                    //  需要请求绑定的站点
                    getBindData(mCommUnityCode, ishasBindSite);
                    //设置添加地址 如果到街道选择
                }
                addressStreetSelectorDialog.dismiss();
            }
        });
    }

    @Override
    public void getProviencesReponse(List<AreaDataResponse> data, String type) {

    }

    private void getProiencesData(long code, String type, String aigain) {
        gcprequest = new GetChildProvincesRequest();
        gcprequest.setParentId(code);
        mPresenter.getChildProvincesData(gcprequest, type, aigain);
    }

    private void getBindData(long code, boolean ishasBindSite) {
        if (ishasBindSite) { //  需要请求绑定的站点
            GetBindStationRequest request = new GetBindStationRequest();
            request.setRegionId(code);
            mPresenter.getBindStationData(request);
            llIshasbind.setVisibility(View.VISIBLE);
        } else {
            llIshasbind.setVisibility(View.GONE);
        }
    }

    @Override
    public void getChileProiencesData(List<AddressTownResponse> data, String type, String again) {
        isAddressDataEmpty = false;
        if (type.equals("street")) {
            if (!mSreetDataBean.isEmpty()) {
                mSreetDataBean.clear();
            }
            mSreetDataBean.addAll(data);
            if (again.equals("again"))//没有拉到数据 重新点击时直接打开弹框
                setStreetSelectorDialog("street");
           /* if (this.type.equals("edit")) {//编辑修改地址状态
                if (streetCommUnityCodes.length == 5) {//有村庄 才请求数据
                    getProiencesData(Long.valueOf(streetCommUnityCodes[3]), "commUnity");
                }
            }*/
        } else {
            if (!mCommUnityBean.isEmpty()) {
                mCommUnityBean.clear();
            }
            mCommUnityBean.addAll(data);
           /* if (this.type.equals("edit") && !tvCommunity.getText().toString().trim().equals("村(社区)")) {//编辑修改地址状态 请求站点数据
                if (streetCommUnityCodes.length == 5) {//有村庄 才请求数据
                    mCommUnityCode = Long.valueOf(streetCommUnityCodes[4]);
                    getBindData(mCommUnityCode, request.isHasBindStation());
                }
            }*/
        }
    }

    @Override
    public void getBindStationData(List<GetBindStationReponse> data) {
        setExpandlist(data);
    }

    @Override
    public void getStreetFail() {
        //获取街道失败 那么久不会有村 居委会了
        setViewViesible(llStreetCommunity, false);
        isAddressDataEmpty = true;
    }

    @Override
    public void getConmmunityFail() {
        setViewViesible(rlCommunity, false);
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

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edt_address_detail:
                isAddressEmpty = isEmpty;
                break;
        }
        if ((isAddressEmpty && !tvStreet.getText().toString().trim().equals("镇(街道)") && !tvCommunity.getText().toString().trim().equals("村(社区)")) || (isAddressEmpty && isAddressDataEmpty)) {
            ViewClickUtil.setViewClickable(tvComplete, true);
        } else {
            ViewClickUtil.setViewClickable(tvComplete, false);
        }
    }
}
