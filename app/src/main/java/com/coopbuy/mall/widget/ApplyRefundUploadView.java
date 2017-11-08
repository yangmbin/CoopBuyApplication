package com.coopbuy.mall.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 申请售后上传图片视图
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class ApplyRefundUploadView extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private SimpleDraweeView image0, image1, image2;
    private ImageView image0Delete, image1Delete, image2Delete;
    private SelectListener mListener;
    private List<String> mCurrentImages = new ArrayList<>(); // 网络图片
    private List<String> mLocalImages = new ArrayList<>(); // 本地图片
    private int mCurrentClickPos = 0; // 当前点击的位置，需要用于判断是新增图片还是替换图片

    public ApplyRefundUploadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.apply_refund_upload_view, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        image0 = mView.findViewById(R.id.image0);
        image1 = mView.findViewById(R.id.image1);
        image2 = mView.findViewById(R.id.image2);
        image0Delete = mView.findViewById(R.id.image0_delete);
        image1Delete = mView.findViewById(R.id.image1_delete);
        image2Delete = mView.findViewById(R.id.image2_delete);

        image0.setOnClickListener(this);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image0Delete.setOnClickListener(this);
        image1Delete.setOnClickListener(this);
        image2Delete.setOnClickListener(this);

        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image0:
                mCurrentClickPos = 0;
                mListener.onSelect();
                break;
            case R.id.image1:
                mCurrentClickPos = 1;
                mListener.onSelect();
                break;
            case R.id.image2:
                mCurrentClickPos = 2;
                mListener.onSelect();
                break;
            case R.id.image0_delete:
                deleteImage(0);
                break;
            case R.id.image1_delete:
                deleteImage(1);
                break;
            case R.id.image2_delete:
                deleteImage(2);
                break;
        }
    }

    /**
     * 页面初始化
     */
    private void initView() {
        image0.setVisibility(VISIBLE);
        image1.setVisibility(GONE);
        image2.setVisibility(GONE);
        image0Delete.setVisibility(GONE);
        image1Delete.setVisibility(GONE);
        image2Delete.setVisibility(GONE);
    }

    /**
     * 获取图片列表
     */
    public List<String> getCurrentImages() {
        return mCurrentImages;
    }


    /**
     * 添加图片
     * @param serverPath
     */
    public void addImage(String serverPath, String localPath) {
        // 新增图片
        if (mCurrentClickPos + 1 > mCurrentImages.size()) {
            mCurrentImages.add(serverPath);
            mLocalImages.add(localPath);
        } else {
            mCurrentImages.set(mCurrentClickPos, serverPath);
            mLocalImages.set(mCurrentClickPos, localPath);
        }
        updateUI();
    }

    /**
     * 删除对应图片
     * @param index
     */
    private void deleteImage(int index) {
        mCurrentImages.remove(index);
        mLocalImages.remove(index);
        updateUI();
    }

    /**
     * 更新UI
     */
    private void updateUI() {
        switch (mLocalImages.size()) {
            case 0:
                image0.setVisibility(VISIBLE);
                image1.setVisibility(GONE);
                image2.setVisibility(GONE);
                image0Delete.setVisibility(GONE);
                image1Delete.setVisibility(GONE);
                image2Delete.setVisibility(GONE);

                image0.setImageURI(Uri.parse(""));
                image1.setImageURI(Uri.parse(""));
                image2.setImageURI(Uri.parse(""));
                break;
            case 1:
                image0.setVisibility(VISIBLE);
                image1.setVisibility(VISIBLE);
                image2.setVisibility(GONE);
                image0Delete.setVisibility(VISIBLE);
                image1Delete.setVisibility(GONE);
                image2Delete.setVisibility(GONE);

                image0.setImageURI(Uri.fromFile(new File(mLocalImages.get(0))));
                image1.setImageURI(Uri.parse(""));
                image2.setImageURI(Uri.parse(""));
                break;
            case 2:
                image0.setVisibility(VISIBLE);
                image1.setVisibility(VISIBLE);
                image2.setVisibility(VISIBLE);
                image0Delete.setVisibility(VISIBLE);
                image1Delete.setVisibility(VISIBLE);
                image2Delete.setVisibility(GONE);

                image0.setImageURI(Uri.fromFile(new File(mLocalImages.get(0))));
                image1.setImageURI(Uri.fromFile(new File(mLocalImages.get(1))));
                image2.setImageURI(Uri.parse(""));
                break;
            case 3:
                image0.setVisibility(VISIBLE);
                image1.setVisibility(VISIBLE);
                image2.setVisibility(VISIBLE);
                image0Delete.setVisibility(VISIBLE);
                image1Delete.setVisibility(VISIBLE);
                image2Delete.setVisibility(VISIBLE);

                image0.setImageURI(Uri.fromFile(new File(mLocalImages.get(0))));
                image1.setImageURI(Uri.fromFile(new File(mLocalImages.get(1))));
                image2.setImageURI(Uri.fromFile(new File(mLocalImages.get(2))));
                break;
        }
    }


    /**
     * 设置监听
     * @param listener
     */
    public void setSelectListener(SelectListener listener) {
        mListener = listener;
    }


    /**
     * 上传图片按钮监听
     */
    public interface SelectListener {
        void onSelect();
    }
}
