package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

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
        setTitle(R.string.title_personal);
        circleImageView.setImageURI("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3878763046,310714624&fm=173&s=66518266BCC79005F682A06903006019&w=550&h=550&img.JPEG");
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
