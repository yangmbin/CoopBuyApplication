package com.coopbuy.mall.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.daimajia.numberprogressbar.NumberProgressBar;

/**
 * APP更新对话框
 * @author ymb
 * Create at 2017/8/22 14:24
 */
public class APPUpdateDialog extends Dialog {

    private Context mContext;
    private ClickCallBack mCallBack;
    private TextView tv_close, tv_update, tv_title, tv_content;
    private NumberProgressBar mProgressBar;
    private String title, content;

    public APPUpdateDialog(Context context, String title, String content) {
        super(context, R.style.APPUpdateDialogStyle);
        mContext = context;
        this.title = title;
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_app_update, null);
        setContentView(view);

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        lp.width = (int) (dm.widthPixels * 0.85); // 把对话框宽度设置为屏幕宽度的0.85
        dialogWindow.setAttributes(lp);
        setCancelable(false);

        tv_close = view.findViewById(R.id.tv_close);
        tv_update = view.findViewById(R.id.tv_update);
        tv_title = view.findViewById(R.id.tv_title);
        tv_content = view.findViewById(R.id.tv_content);
        mProgressBar = view.findViewById(R.id.progress);

        tv_update.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                mCallBack.onClose();
            }
        });
        tv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_update.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);
                mCallBack.onUpdate();
            }
        });

        // 设置标题和内容
        setTitle(this.title);
        setContent(this.content);
    }

    // 回调接口，执行具体的处理逻辑
    public interface ClickCallBack {
        void onUpdate();
        void onClose();
    }

    public void setProgress(int progress) {
        mProgressBar.setProgress(progress);
    }

    public void setCallBack(ClickCallBack callBack) {
        this.mCallBack = callBack;
    }

    public void setTitle(String title) {
        tv_title.setText("新版本" + title);
    }

    public void setContent(String content) {
        tv_content.setText(content);
    }
}
