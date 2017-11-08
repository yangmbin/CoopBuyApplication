package com.coopbuy.mall.ui.module.center.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

public class PersonalActivity extends BaseActivity {


    @Bind(R.id.circleImageView)
    SimpleDraweeView circleImageView;
    @Bind(R.id.tv_user_id)
    TextView tvUserId;
    @Bind(R.id.tv_user_nick)
    TextView tvUserNick;
    @Bind(R.id.tv_user_sex)
    TextView tvUserSex;
    UserCenterInfoResponse.UserInfoBean userInfoBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        if (null != getIntent()) {
            userInfoBean = (UserCenterInfoResponse.UserInfoBean) getIntent().getSerializableExtra(IntentUtils.DATA);
            if (null == userInfoBean.getHeadPortraitPath() || TextUtils.isEmpty(userInfoBean.getHeadPortraitPath())) {
                circleImageView.setImageURI(Constants.images[(new Random().nextInt(12) +1)]);
            } else {
                circleImageView.setImageURI(userInfoBean.getHeadPortraitPath());
            }
            tvUserId.setText(userInfoBean.getUserId() + "");
            tvUserNick.setText(userInfoBean.getNick());
            int sex = userInfoBean.getSex();
            if (sex == 0) {
                tvUserSex.setText("待设置");
            } else if (sex == 1) {
                tvUserSex.setText("女");
            } else {
                tvUserSex.setText("男");
            }
        }
        setTitle(R.string.title_personal);
    }

    @OnClick({R.id.ll_head_image, R.id.ll_nick, R.id.ll_sex})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_head_image:

                break;
            case R.id.ll_nick:

                break;
            case R.id.ll_sex:

                break;
        }
    }
}
