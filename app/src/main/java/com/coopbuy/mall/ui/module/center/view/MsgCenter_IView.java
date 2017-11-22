package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.MesCenterResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public interface MsgCenter_IView extends BaseView {

    void getData(List<MesCenterResponse> bean);
}
