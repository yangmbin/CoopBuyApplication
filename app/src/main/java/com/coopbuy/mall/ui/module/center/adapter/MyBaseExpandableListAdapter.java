package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;

import java.util.List;
import java.util.Map;

/**
 * ExpandListView的适配器，继承自BaseExpandableListAdapter
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private ExpandableListPort port;
    private Context mContext;
    private List<String> groupTitle;
    //子项是一个map，key是group的id，每一个group对应一个ChildItem的list
    private Map<Integer, List<GetBindStationReponse.StationUsersBean>> childMap;


    public MyBaseExpandableListAdapter(Context context, List<String> groupTitle, Map<Integer, List<GetBindStationReponse.StationUsersBean>> childMap, ExpandableListPort port) {
        this.mContext = context;
        this.groupTitle = groupTitle;
        this.childMap = childMap;
        this.port = port;
    }


    /*
     *  Gets the data associated with the given child within the given group
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //我们这里返回一下每个item的名称，以便单击item时显示
        return childMap.get(groupPosition).get(childPosition).getStationUserName();
    }

    /*
     * 取得给定分组中给定子视图的ID. 该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /*
     *  Gets a View that displays the data for the given child within the given group
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                             ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.childitem, null);
            childHolder = new ChildHolder();
            childHolder.ll_head = (LinearLayout) convertView.findViewById(R.id.ll_head);
            childHolder.stationerName = (TextView) convertView.findViewById(R.id.tv_stationer_name);
            childHolder.stationMark = (ImageView) convertView.findViewById(R.id.iv_station_mark);
            childHolder.cb = (TextView) convertView.findViewById(R.id.tv_select);
            childHolder.rlStation = (RelativeLayout) convertView.findViewById(R.id.rl_station);
            childHolder.v = (LinearLayout) convertView.findViewById(R.id.ll_v);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        GetBindStationReponse.StationUsersBean bean = childMap.get(groupPosition).get(childPosition);
        childHolder.rlStation.setOnClickListener(new MyCheckLinseter(groupPosition, childPosition, bean));
        if (bean.isSelect()) {
            childHolder.rlStation.setBackgroundResource(R.drawable.shape_orange_no_solid_bind);
            childHolder.cb.setBackgroundResource(R.mipmap.icon_bind_check);
        } else {
            childHolder.rlStation.setBackgroundResource(R.drawable.shape_grey_no_solid_bind);
            childHolder.cb.setBackgroundResource(R.mipmap.icon_bind_uncheck);
        }
        if (childPosition != 0) {
            childHolder.ll_head.setVisibility(View.GONE);

        } else {
            childHolder.ll_head.setVisibility(View.VISIBLE);
        }
        childHolder.stationerName.setText(bean.getStationUserName());
        if (bean.isIsStationMaster()) {
            childHolder.stationMark.setVisibility(View.VISIBLE);
        } else {
            childHolder.stationMark.setVisibility(View.GONE);
        }
        //这里是制造分割线
        if (childPosition == childMap.get(groupPosition).size() - 1) {
            childHolder.v.setVisibility(View.VISIBLE);
        } else {
            childHolder.v.setVisibility(View.GONE);
        }
        return convertView;
    }

    /**
     * 这是checkbox的监听
     */
    class MyCheckLinseter implements OnClickListener {
        private int groupPostion;
        private int childPostion;
        private GetBindStationReponse.StationUsersBean bean;

        public MyCheckLinseter(int groupPostion, int childPostion, GetBindStationReponse.StationUsersBean bean) {
            this.groupPostion = groupPostion;
            this.childPostion = childPostion;
            this.bean = bean;
        }

        @Override
        public void onClick(View view) {
            setSelect();
            notifyDataSetChanged();
            port.checkPostionIstrue(bean);
        }

        private void setSelect() {
            for (int i = 0; i < childMap.size(); i++) {
                for (int j = 0; j < childMap.get(i).size(); j++) {
                    GetBindStationReponse.StationUsersBean bean = childMap.get(i).get(j);
                    if (i == groupPostion && j == childPostion) {
                        bean.setSelect(true);
                    } else {
                        bean.setSelect(false);
                    }
                }
            }
        }
    }

    /*
     * 取得指定分组的子元素数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return childMap.get(groupPosition).size();
    }

    /**
     * 取得与给定分组关联的数据
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupTitle.get(groupPosition);
    }

    /**
     * 取得分组数
     */
    @Override
    public int getGroupCount() {
        return groupTitle.size();
    }

    /**
     * 取得指定分组的ID.该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /*
     *Gets a View that displays the given group
     *return: the View corresponding to the group at the specified position
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.groupitem, null);
            groupHolder = new GroupHolder();
            groupHolder.stationName = (TextView) convertView.findViewById(R.id.tv_station_name);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        String title = groupTitle.get(groupPosition);
        groupHolder.stationName.setText(title);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // Indicates whether the child and group IDs are stable across changes to the underlying data
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // Whether the child at the specified position is selectable
        return true;
    }

    /**
     * show the text on the child and group item
     */
    private class GroupHolder {
        TextView stationName;

    }

    private class ChildHolder {
        //站长名称
        TextView stationerName;
        //站长标签
        ImageView stationMark;
        TextView cb;
        LinearLayout ll_head;
        //选中是背景颜色要变
        RelativeLayout rlStation;
        LinearLayout v;
    }
}
