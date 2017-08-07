package com.coopbuy.mall.ui.module.test.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.test.port.ClickPort;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 15:50
 * @content
 */
public class TestParamsAdapter extends BaseRecyclerAdapter<String> {
    private ClickPort port;
    private List<String> mData;
    private Object object;

    public TestParamsAdapter(Context ctx, List<String> list, ClickPort port, Object object) {
        super(ctx, list);
        this.mData = list;
        Collections.reverse(mData);
        this.object = object;
        this.port = port;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_test_params;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, final int position, String item) {
        TextView tvName = holder.getTextView(R.id.tv_params_name);
        holder.getTextView(R.id.tv_params).setText("参数" + (position + 1));
        tvName.setText(mData.get(position));
        final EditText edtValues = holder.getEditText(R.id.edt_params_vlaue);
        edtValues.setText(getParams(mData.get(position)));
        edtValues.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setParams(mData.get(position), editable.toString());
            }
        });
    }

    private void setParams(String name, String values) {
        Class modelclass = object.getClass();
        Field[] fields = modelclass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                try {
                    if (f.getName().equals(name)) {
                        f.set(object, values);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private String getParams(String name) {
        Class modelclass = object.getClass();
        String values = "";
        Field[] fields = modelclass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);

            try {
                if (f.getName().equals(name)) {
                    values = (String) f.get(object);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return values;
    }
}
