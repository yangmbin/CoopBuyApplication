package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/17 0017 20:15
 * @content
 */
public interface AddressManage_IView extends BaseView{

    void getAddressMangeData(List<AddressInfoResponse> data,String type);

    void setDefaultSuccess();

}
