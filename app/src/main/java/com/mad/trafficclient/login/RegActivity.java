package com.mad.trafficclient.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.mad.trafficclient.R;


public class RegActivity extends Activity implements View.OnClickListener {

	EditText etUserName, etUserPwd, etUserPwdSecond;
	Button btReg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		findViewById(R.id.frag_reg_activity).setOnClickListener(this);
		initView();
		initLsenter();
//		initLiserter();

	}

	private void initLiserter() {

		// TODO Auto-generated method stub
		btReg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(RegActivity.this,
						LoginActivity.class);
				startActivity(intent);
			}
		});


	}

	private void initView() {
		etUserName = (EditText) findViewById(R.id.et_user_name);
		etUserPwd = (EditText) findViewById(R.id.et_user_pwd);
		etUserPwdSecond = (EditText) findViewById(R.id.et_user_pwd_second);
		btReg = (Button) findViewById(R.id.bt_reg);

	}

	private void initLsenter() {
		btReg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}


	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case  R.id.frag_reg_activity:
				InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(view.getWindowToken(),0);
		}
	}
}
