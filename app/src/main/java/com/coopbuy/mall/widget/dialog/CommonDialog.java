package com.coopbuy.mall.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.coopbuy.mall.R;


/**
 * 自定义弹出对话框
 *
 * @author ymb
 *         Create at 2017/4/27 17:04
 */
public class CommonDialog extends Dialog {

    private Context mContext;
    private ClickCallBack mCallBack;
    private ClickCallBackTow mClickCallBackTow;
    private int mType = 2;
    private String mMsg, mMsgSub, mLeftText, mRightText, mTitle;
    public static final int TYPE_ONE_KEY = 1;
    public static final int TYPE_TWO_KEY = 2;
    private TextView tv_ok;
    private TextView tv_cancel;
    private TextView tv_content;
    private TextView tv_title;
    private TextView tv_hint;

    public CommonDialog(Context context, ClickCallBack callBack, int type, String msg, String leftText, String rightText) {
        super(context, R.style.CommonDialogStyle);
        mContext = context;
        mCallBack = callBack;
        mType = type;
        mMsg = msg;
        mLeftText = leftText;
        mRightText = rightText;
    }

    public CommonDialog(Context context, ClickCallBack callBack, int type, String title, String msg, String hint, String leftText, String rightText) {
        super(context, R.style.CommonDialogStyle);
        mContext = context;
        mCallBack = callBack;
        mType = type;
        mMsg = msg;
        mLeftText = leftText;
        mRightText = rightText;
        mTitle = title;
        mMsgSub = hint;
    }

    public CommonDialog(Context context, ClickCallBackTow callBack, int type, String msg, String leftText, String rightText) {
        super(context, R.style.CommonDialogStyle);
        mContext = context;
        mClickCallBackTow = callBack;
        mType = type;
        mMsg = msg;
        mLeftText = leftText;
        mRightText = rightText;
    }

    public CommonDialog(Context context, ClickCallBack callBack, int type, String msg, String msgSub, String leftText, String rightText) {
        super(context, R.style.CommonDialogStyle);
        mContext = context;
        mCallBack = callBack;
        mType = type;
        mMsg = msg;
        mMsgSub = msgSub;
        mLeftText = leftText;
        mRightText = rightText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_common, null);
        setContentView(view);

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        lp.width = (int) (dm.widthPixels * 0.8); // 把对话框宽度设置为屏幕宽度的0.8
        dialogWindow.setAttributes(lp);

        //设置按钮的隐藏
        if (mType == TYPE_ONE_KEY) {
            ((View) view.findViewById(R.id.dialog_common_btn_divider)).setVisibility(View.GONE);
            ((TextView) view.findViewById(R.id.tv_cancel)).setVisibility(View.GONE);
        }
        // 设置子内容是否隐藏
        if (!TextUtils.isEmpty(mMsgSub))
            view.findViewById(R.id.dialog_common_msg_sub).setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(mTitle)) {
            view.findViewById(R.id.dialog_common_title).setVisibility(View.VISIBLE);
        }
        //设置显示内容
        ((TextView) view.findViewById(R.id.dialog_common_msg)).setText(mMsg);
        ((TextView) view.findViewById(R.id.dialog_common_msg_sub)).setText(mMsgSub);
        ((TextView) view.findViewById(R.id.dialog_common_title)).setText(mTitle);
        ((TextView) view.findViewById(R.id.tv_ok)).setText(mRightText);
        ((TextView) view.findViewById(R.id.tv_cancel)).setText(mLeftText);
        //设置显示内容
        tv_content = (TextView) view.findViewById(R.id.dialog_common_msg);


        // 设置按钮监听
        tv_ok = (TextView) view.findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mCallBack) {
                    mCallBack.onConfirm();
                }
                if (null != mClickCallBackTow) {
                    mClickCallBackTow.onConfirm();
                }
                dismiss();
            }
        });

        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mCallBack) {
                    dismiss();
                }
                if (null != mClickCallBackTow) {
                    mClickCallBackTow.onCancle();
                    dismiss();
                }
            }
        });

    }

    // 回调接口，执行具体的处理逻辑
    public interface ClickCallBackTow {
        void onConfirm();

        void onCancle();
    }

    public interface ClickCallBack {
        void onConfirm();
    }

    /**
     * 设置确认按钮的颜色
     */
    public void setOkTextColor(int color) {
        if (null != tv_ok) {
            tv_ok.setTextColor(color);
        }

    }

    /**
     * 设置内容控件的颜色
     */
    public void setContentTextColor(int color) {
        if (null != tv_ok) {
            tv_ok.setTextColor(color);
        }

    }

    /**
     * setOkTextColor的文字大小
     */
    public void setOkTextSize(int dp) {
        if (null != tv_ok) {
            tv_ok.setTextSize(dp);
        }
    }

    /**
     * 设置内容控件的文字大小
     */
    public void setContentTextSize(int dp) {
        if (null != tv_content) {
            tv_content.setTextSize(dp);
        }

    }

    /**
     * 设置取消按钮的文字大小
     */
    public void setCancelTextSize(int dp) {
        if (null != tv_cancel) {
            tv_cancel.setTextSize(dp);
        }

    }

    /**
     * 设置取消按钮的颜色
     */
    public void setCancelTextColor(int color) {
        if (null != tv_cancel) {
            tv_cancel.setTextColor(color);

        }
    }
}
