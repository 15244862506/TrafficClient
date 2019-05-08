package com.mad.trafficclient.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mad.trafficclient.R;
import com.mad.trafficclient.util.Util;

public class Fragment_2 extends Fragment {


	//View
	private ExpandableListView frag_07_exap_list_view;

	//View
	private ExpandableListView expandableListView;

	//Model：定义的数据
	private String[] groups = {"中医院站", "联想大夏站"};

	//注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
	private String[][] childs = {{"1号(101人)", "2号(101人)"}, {"1号(101人)", "2号(101人)"}};




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_layout02, container, false);
		expandableListView = (ExpandableListView)view.findViewById(R.id.frag_02_expandableListView);

		expandableListView.setAdapter(new MyExpandableListView());



		return view;
	}

	//为ExpandableListView自定义适配器
	class MyExpandableListView extends BaseExpandableListAdapter {

		//返回一级列表的个数
		@Override
		public int getGroupCount() {
			return groups.length;
		}
		//返回每个二级列表的个数
		@Override
		public int getChildrenCount(int groupPosition) { //参数groupPosition表示第几个一级列表
			Log.d("smyhvae", "-->" + groupPosition);
			return childs[groupPosition].length;
		}

		//返回一级列表的单个item（返回的是对象）
		@Override
		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		//返回二级列表中的单个item（返回的是对象）
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return childs[groupPosition][childPosition];  //不要误写成groups[groupPosition][childPosition]
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		//每个item的id是否是固定？一般为true
		@Override
		public boolean hasStableIds() {
			return true;
		}

		//【重要】填充一级列表
		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			LayoutInflater LayoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if (convertView == null) {
				convertView = LayoutInflater.inflate(R.layout.fragment_layout02_item1_group, null);
			} else {

			}
			TextView tv_group = (TextView) convertView.findViewById(R.id.frag_02itemi_group);
			tv_group.setText(groups[groupPosition]);
			return convertView;
		}

		//【重要】填充二级列表
		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            LayoutInflater LayoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if (convertView == null) {


			convertView = LayoutInflater.inflate(R.layout.fragment_layout02_item2_child, null);
			}

			ImageView iv_child = (ImageView) convertView.findViewById(R.id.frag_02_item2_image);
			TextView tv_child = (TextView) convertView.findViewById(R.id.frag_02_tiem2_chlid);

//			iv_child.setImageResource(resId);
			tv_child.setText(childs[groupPosition][childPosition]);

			return convertView;
		}

		//二级列表中的item是否能够被选中？可以改为true
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}
}