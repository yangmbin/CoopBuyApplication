package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.RecommendResponse;
import com.coopbuy.mall.api.reponse.StationRecommendResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.StationRecAdapter;
import com.coopbuy.mall.ui.module.center.model.RecommendModel;
import com.coopbuy.mall.ui.module.center.presenter.RecommendPresenter;
import com.coopbuy.mall.ui.module.center.view.Recommend_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.NormalDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author csn
 * @time 2017/10/13 0013 9:25
 * @content 站长推荐
 */
public class StationRecommendActivity extends BaseActivity<RecommendPresenter, RecommendModel> implements Recommend_IView {
    @Bind(R.id.recView)
    RecyclerView recView;

    private List<RecommendResponse.ProductsBean> data;
    private StationRecAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_station_recommend;
    }

    @Override
    public void initModel() {
        mModel = new RecommendModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new RecommendPresenter(this, mModel, this);
        mPresenter.getData();
    }

    @Override
    public void initView() {
        setTitle("站长推荐");
        data = new ArrayList<>();
        adapter = new StationRecAdapter();
    }

    private void initRecy() {
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
        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int pos) {
                ToastUtils.toastLong(pos + "点击了");
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recView.addItemDecoration(decoration);
        recView.setLayoutManager(manager);
        recView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getRecommendData(List<RecommendResponse> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).getProducts().size(); j++) {
                data.get(i).getProducts().get(j).setTime(data.get(i).getTime());
                this.data.add(data.get(i).getProducts().get(j));
            }
        }
        initRecy();
    }
}
