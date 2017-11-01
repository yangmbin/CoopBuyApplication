package com.coopbuy.mall.ui.module.center.activity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

/**
 * @author niu
 * @time 2017/11/1 14:42
 * @content 二维码生成
 */
public class CreatQRActivity extends BaseActivity {

    @Bind(R.id.iv_creatQR)
    ImageView ivCreatQR;
    @Bind(R.id.circleImageView)
    SimpleDraweeView circleImageView;
    @Bind(R.id.tv_name)
    TextView tvName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_creat_qr;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("我的二维码");
        createEnglishQRCodeWithLogo();
        circleImageView.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509530120577&di=155b0eabe2d24e4c3a6afce988ef35f4&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fbaike%2Fc0%3Dbaike60%2C5%2C5%2C60%2C20%2Fsign%3D62d333081e950a7b613846966bb809bc%2F77c6a7efce1b9d16d321f25ff0deb48f8c54642d.jpg");
        tvName.setText("青青");
    }

    private void createEnglishQRCodeWithLogo() {
        /*
        这里为了偷懒，就没有处理匿名 AsyncTask 内部类导致 Activity 泄漏的问题
        请开发在使用时自行处理匿名内部类导致Activity内存泄漏的问题，处理方式可参考 https://github.com/GeniusVJR/LearningNotes/blob/master/Part1/Android/Android%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F%E6%80%BB%E7%BB%93.md
         */
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap logoBitmap = BitmapFactory.decodeResource(CreatQRActivity.this.getResources(), R.mipmap.logo);
                return QRCodeEncoder.syncEncodeQRCode("爱心服务站!青青!181347827367", BGAQRCodeUtil.dp2px(CreatQRActivity.this, 150), Color.BLACK, Color.WHITE, logoBitmap);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    ivCreatQR.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(CreatQRActivity.this, "生成带logo的英文二维码失败", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

}
