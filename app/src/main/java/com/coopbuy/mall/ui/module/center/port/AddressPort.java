package com.coopbuy.mall.ui.module.center.port;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;

/**
 * @author csn
 * @date 2017/10/20 0020 9:52
 * @content
 */
public interface AddressPort {

    void setDefault(AddressInfoResponse bean);

    void editAddress(AddressInfoResponse bean);

    void delete(AddressInfoResponse bean);

    void setReceivedAddress(AddressInfoResponse bean);
}
