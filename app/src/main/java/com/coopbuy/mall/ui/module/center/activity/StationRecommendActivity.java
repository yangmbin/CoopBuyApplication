package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.StationRecommendResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.StationRecAdapter;
import com.coopbuy.mall.widget.NormalDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author csn
 * @time 2017/10/13 0013 9:25
 * @content 站长推荐
 */
public class StationRecommendActivity extends BaseActivity {
    @Bind(R.id.recView)
    RecyclerView recView;

    private List<StationRecommendResponse> data;
    private StationRecAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_station_recommend;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        data = new ArrayList<>();
        initData();
        adapter = new StationRecAdapter();
        adapter.addDatas(data);
        final NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return data.get(pos).getTime();
            }
        };

        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int pos) {
                final View headView = LayoutInflater.from(StationRecommendActivity.this).inflate(R.layout.decoration_station_head_view, null);
                final TextView tiem = (TextView) headView.findViewById(R.id.tv_time);
                tiem.setText(data.get(pos).getTime());
                return headView;
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recView.addItemDecoration(decoration);
        recView.setLayoutManager(manager);
        recView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int i = 0; i < 7; i++) {
            if (i == 3||i==4) {
                StationRecommendResponse res = new StationRecommendResponse("2017.5." , "青青爱吃榴莲" + i, "177", "177" + i, "34*56*9", "2" + i * 2, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507873988409&di=2891b9a2a0070d71b70b5e86983d2c46&imgtype=0&src=http%3A%2F%2Fwww.fcfdcw.com%2FUploadFile%2Fimage%2F20141014%2F20141014151728_7968.jpg");
                data.add(res);
            } else {
                StationRecommendResponse res = new StationRecommendResponse("2017.5." + i, "青青爱吃榴莲" + i, "177", "177" + i, "34*56*9", "2" + i * 2, "http://static.bbs.nubia.cn/forum/201706/15/075821fnxxuinc77w8c2ui.jpg");
                data.add(res);
            }
        }
    }
}
