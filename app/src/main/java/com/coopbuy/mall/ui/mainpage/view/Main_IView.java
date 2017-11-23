package com.coopbuy.mall.ui.mainpage.view;

import com.coopbuy.mall.api.reponse.CheckUpdateResponse;
import com.coopbuy.mall.base.BaseView;

public interface Main_IView extends BaseView {
    void setCheckUpdateData(CheckUpdateResponse checkUpdateResponse);
}
