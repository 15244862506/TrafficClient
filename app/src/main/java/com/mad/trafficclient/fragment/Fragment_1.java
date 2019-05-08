/**
 * 
 */
package com.mad.trafficclient.fragment;

import com.mad.trafficclient.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.SQLInput;


public class  Fragment_1 extends Fragment implements View.OnClickListener
{
    private LinearLayout frag_01_Linear;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view = inflater
				.inflate(R.layout.fragment_layout01, container, false);


        initview(view);
		return view;
	}

    private void initview(View view) {

	    frag_01_Linear= (LinearLayout) view.findViewById(R.id.frag_01_Linear);

    }

    @Override
    public void onClick(View view) {
	    switch (view.getId()){
            case R.id.frag_01_Linear:
                InputMethodManager imm= (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
