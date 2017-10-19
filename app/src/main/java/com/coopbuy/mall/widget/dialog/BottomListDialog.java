package com.coopbuy.mall.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class BottomListDialog {

    private RecyclerView mRecyclerView;
    private TextListAdapter mAdapter;
    private View mView;
    private Dialog dialog;
    private TextView text;

    public BottomListDialog(final Context context, final List<String> list, TextView text) {
        dialog = new Dialog(context, R.style.BottomPopDialogStyle);
        this.text = text;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.dialog_bottom_list, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.text_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        mAdapter = new TextListAdapter(context, list);
        mRecyclerView.setAdapter(mAdapter);

        // 设置风格
        setPopWindowStyle(context);
    }

    public void showAtBottom() {
        dialog.show();
    }

    private void setPopWindowStyle(Context context) {
        dialog.setContentView(mView);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        // mView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = mView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(y < height){
                        dialog.dismiss();
                    }
                }
                return true;
            }
        });
    }

    /**
     * 适配器
     */
    class TextListAdapter extends BaseRecyclerAdapter<String> {

        Context context;

        public TextListAdapter(Context ctx, List<String> list) {
            super(ctx, list);
            context = ctx;
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_dialog_bottom_list;
        }

        @Override
        protected void bindData(final BaseRecyclerHolder holder, int position, String item) {
            holder.getTextView(R.id.text_content).setText(item);
            holder.getTextView(R.id.text_content).setTag(item);
            holder.getTextView(R.id.text_content).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    text.setText((String) v.getTag());
                }
            });
        }
    }
}