package com.mad.trafficclient.fragment;


import android.app.DatePickerDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.mad.trafficclient.R;

import java.util.Calendar;

public class Fragment_3 extends Fragment {

	private TextView mFrag5TextTime;
	private TextView mFrag5TextShow;
	private TextView mFrag5TextCar;
	private TextView mFrag5TextCar1;
	private Switch mFrag5SwitchCar1;
	private TextView mFrag5TextCar2;
	private Switch mFrag5SwitchCar2;
	private TextView mFrag5TextCar3;
	private Switch mFrag5SwitchCar3;
	private ImageView mFrag5ImgShow;
	private int day;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout03, container, false);
		initView(view);
		AnimationDrawable drawable = (AnimationDrawable) mFrag5ImgShow.getBackground();
		drawable.start();
		initTime();
		initCheack(day);
		return view;
	}

	private void initCheack(final int day) {
		if (day%2==0){
			mFrag5TextShow.setText("双号出行车辆：");
			mFrag5TextCar.setText("2");
			mFrag5TextCar1.setText("关");
			mFrag5TextCar2.setText("开");
			mFrag5TextCar3.setText("关");
			mFrag5SwitchCar1.setChecked(false);
			mFrag5SwitchCar1.setEnabled(false);
			mFrag5SwitchCar2.setChecked(true);
			mFrag5SwitchCar2.setEnabled(true);
			mFrag5SwitchCar3.setChecked(false);


			mFrag5SwitchCar3.setEnabled(false);
			mFrag5SwitchCar2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked){
						mFrag5TextCar.setText("2");
						mFrag5TextCar2.setText("开");
					}else {
						if (mFrag5TextCar2.getText().toString().equals("开")){
							mFrag5TextCar.setText("无");
						}
						mFrag5TextCar2.setText("关");
					}
				}
			});
		}else{
			mFrag5TextShow.setText("单号出行车辆：");
			mFrag5TextCar.setText("1、3");
			mFrag5TextCar1.setText("开");
			mFrag5TextCar2.setText("关");
			mFrag5TextCar3.setText("开");
			mFrag5SwitchCar1.setChecked(true);
			mFrag5SwitchCar1.setEnabled(true);
			mFrag5SwitchCar2.setChecked(false);
			mFrag5SwitchCar2.setEnabled(false);
			mFrag5SwitchCar3.setChecked(true);
			mFrag5SwitchCar3.setEnabled(true);
			mFrag5SwitchCar1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked){
						if(mFrag5TextCar3.getText().toString().equals("开")){
							mFrag5TextCar.setText("1、3");
							mFrag5TextCar1.setText("开");
						}else {
							mFrag5TextCar.setText("1");
							mFrag5TextCar1.setText("开");
						}
					}else{
						if(mFrag5TextCar3.getText().toString().equals("开")){
							mFrag5TextCar.setText("3");
							mFrag5TextCar1.setText("关");
						}else {
							if (mFrag5TextCar2.getText().toString().equals("关")){
								mFrag5TextCar.setText("无");
							}
							mFrag5TextCar1.setText("关");
						}
					}
				}
			});
			mFrag5SwitchCar3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked){
						if(mFrag5TextCar1.getText().toString().equals("开")){
							mFrag5TextCar.setText("1、3");
							mFrag5TextCar3.setText("开");
						}else {
							mFrag5TextCar.setText("3");
							mFrag5TextCar3.setText("开");
						}
					}else{
						if(mFrag5TextCar1.getText().toString().equals("开")){
							mFrag5TextCar.setText("1");
							mFrag5TextCar3.setText("关");
						}else {
							if (day%2!=0){
								mFrag5TextCar.setText("无");
							}
							mFrag5TextCar3.setText("关");
						}
					}
				}
			});
		}
	}

	private void initTime() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH)+1;
		day = calendar.get(calendar.DAY_OF_MONTH);
		String time = year+"年"+month+"月"+day+"日";
		mFrag5TextTime.setText(time);
	}

	private void initView(View view) {
		mFrag5TextTime = (TextView) view.findViewById(R.id.frag_5_text_time);
		mFrag5TextShow = (TextView) view.findViewById(R.id.frag_5_text_show);
		mFrag5TextCar = (TextView) view.findViewById(R.id.frag_5_text_car);
		mFrag5TextCar1 = (TextView) view.findViewById(R.id.frag_5_text_car1);
		mFrag5SwitchCar1 = (Switch) view.findViewById(R.id.frag_5_switch_car1);
		mFrag5TextCar2 = (TextView) view.findViewById(R.id.frag_5_text_car2);
		mFrag5SwitchCar2 = (Switch) view.findViewById(R.id.frag_5_switch_car2);
		mFrag5TextCar3 = (TextView) view.findViewById(R.id.frag_5_text_car3);
		mFrag5SwitchCar3 = (Switch) view.findViewById(R.id.frag_5_switch_car3);
		mFrag5ImgShow = (ImageView) view.findViewById(R.id.frag_5_img_show);
		mFrag5TextTime.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int themeResId = 2;
				Calendar calendar = Calendar.getInstance();
				new DatePickerDialog(getActivity() , themeResId,new DatePickerDialog.OnDateSetListener() {
					// 绑定监听器(How the parent is notified that the date is set.)
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
						// 此处得到选择的时间，可以进行你想要的操作
						mFrag5TextTime.setText( year + "年" + (monthOfYear+1)+ "月" + dayOfMonth + "日");
						initCheack(dayOfMonth);

					}
				} , calendar.get(Calendar.YEAR)
						,calendar.get(Calendar.MONTH)
						,calendar.get(Calendar.DAY_OF_MONTH)).show();

			}
		});
	}


}
