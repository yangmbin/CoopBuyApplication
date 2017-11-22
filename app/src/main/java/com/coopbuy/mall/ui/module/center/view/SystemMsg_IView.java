package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.SystemMegResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/1- 9:49
 */

public interface SystemMsg_IView extends BaseView {
    void getData(SystemMegResponse bean, String type);

    void setOneReadSuccess(int postion);

    void setAllReadSuccess();

}
