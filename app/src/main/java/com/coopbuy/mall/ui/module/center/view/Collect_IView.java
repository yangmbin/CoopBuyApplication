package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/17 0017 20:15
 * @content
 */
public interface Collect_IView extends BaseView {

    void getCollectData(CollectResponse data, String type);

    void updateSuccess(int postion);

    void publishSuccess();

    void removeSuccess();
}
