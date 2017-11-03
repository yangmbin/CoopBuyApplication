package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.CheckPhoneReponse;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * Created by niu on 2017/11/1- 9:49
 */

public interface PhoneRecharge_IView extends BaseView {

    void getMobilData(List<PhoneRechargeListReponse> data);

    void getCheckPhoneData(CheckPhoneReponse bean);
}
