package com.mad.trafficclient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.mad.trafficclient.login.LoginActivity;

public class GuideActivity extends Activity {

	RelativeLayout guide_RL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_guide);
		guide_RL = (RelativeLayout) findViewById(R.id.guide_RL);

//		SharedPreferences sharedPreferences=getSharedPreferences("data2",MODE_PRIVATE);
//		int x=sharedPreferences.getInt("s",0);
//		if (x==0){
//			guide_RL.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View view) {
//					SharedPreferences.Editor editor=getSharedPreferences("data2",MODE_PRIVATE).edit();
//					editor.putInt("s",1);
//					editor.apply();
//					Intent intent = new Intent(GuideActivity.this,
//							LoginActivity.class);
//					startActivity(intent);
//					finish();
//				}
//			});
//		}else {
//
//			Intent intent = new Intent(GuideActivity.this,
//					LoginActivity.class);
//			startActivity(intent);
//			finish();
//		}

		SharedPreferences sharedPreferences=getSharedPreferences("data3",MODE_PRIVATE);
		int x=sharedPreferences.getInt("s",0);
		if (x==0){
			guide_RL.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					SharedPreferences.Editor editor=getSharedPreferences("data3",MODE_PRIVATE).edit();
					editor.putInt("s",1);
					editor.apply();
					Intent intent=new Intent(GuideActivity.this,LoginActivity.class);
					startActivity(intent);
				}
			});
		}else {
			Intent intent=new Intent(GuideActivity.this,LoginActivity.class);
			startActivity(intent);
			finish();
		}

	}

}
