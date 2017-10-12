package com.coopbuy.mall.ui.module.guide.activity;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

public class AdActivity extends BaseActivity {

    @Bind(R.id.tv_countdown)
    TextView tvCountdown;
    private int recLen = 3;
    @Bind(R.id.adFaceImage)
    SimpleDraweeView adFaceImage;
    Timer timer = new Timer();
    List<String> data = new ArrayList<>();

    private Boolean isEnter = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ad;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!isEnter) {
                        recLen--;
                        if (null != tvCountdown) {
                            tvCountdown.setText("" + recLen);
                            if (recLen < 1) {
                                timer.cancel();
                                enterMain();
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            });
        }
    };

    @Override
    public void initView() {
        data.add("http://img.mp.itc.cn/upload/20170523/767c3db63af84ab2aeaaf75965d82751_th.jpg");
        data.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=687377592,2755268545&fm=173&s=A9B07B946430778C3C94108D0100E0E0&w=640&h=640&img.JPEG");
        data.add("http://images.china.cn/attachement/jpg/site1000/20161208/d02788e9b28a19b2e8091c.jpg");
        data.add("http://upload.cankaoxiaoxi.com/2017/0601/1496319083789.jpg");
        data.add("http://img.mp.itc.cn/upload/20170523/a12dfd0aaaac48df87ebc8a9facf0de1_th.jpg");
        data.add("http://upload.cankaoxiaoxi.com/2017/0712/1499848730908.jpg");
        data.add("http://img.mp.itc.cn/upload/20170523/4ea90c1526ca44b0a6ad54dc838aef02_th.jpg");
        data.add("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=664805904,642534961&fm=173&s=1A83884548629A4540198C3403005043&w=640&h=416&img.JPG");
        data.add("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4190673290,2916013540&fm=173&s=5220964146AAFB5D5204C9350300B04B&w=640&h=496&img.JPEG");
        data.add("http://himg2.huanqiu.com/attachment2010/2017/0920/10/29/20170920102904153.jpg");
        data.add("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2533984618,710311247&fm=173&s=E776556EC2F0A6764055E59A0100C093&w=640&h=427&img.JPEG");
        adFaceImage.setImageURI(data.get(new Random().nextInt(10) % (11)));
        timer.schedule(task, 1000, 1000);
    }

    @OnClick({R.id.adFaceImage, R.id.ll_enter})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.adFaceImage:
                ToastUtils.toastShort("跳转广告页。。。");
                break;
            case R.id.ll_enter:
                enterMain();
                isEnter = true;
                break;
        }
    }

    private void enterMain() {
        if (!isEnter) {
            IntentUtils.gotoActivity(this, MainActivity.class);
            finish();
        } else {
            finish();
            return;
        }
    }
}
