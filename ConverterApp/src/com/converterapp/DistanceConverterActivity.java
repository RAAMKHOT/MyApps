package com.converterapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.app.Activity;
import android.content.Intent;

public class DistanceConverterActivity extends Activity {

	EditText InputDistenceVal;
	RadioGroup SelectDistenceGroupOpt;
	Button ResultDistence,HomeDistence;
	double value=0.00;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance_converter);
		
		InputDistenceVal=(EditText) findViewById(R.id.editText_Input_Distance);
		SelectDistenceGroupOpt=(RadioGroup) findViewById(R.id.radioGroup1_Select_Distence);
		ResultDistence=(Button) findViewById(R.id.button_Distance_Result);
		HomeDistence=(Button) findViewById(R.id.button_Distence_Home);
		value=0.00;
		
		SelectDistenceGroupOpt.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) 
			{
				switch (arg1) 
				{
				case R.id.radio0_Distence:
					double n1=Double.valueOf(InputDistenceVal.getText().toString());
					value=n1*100;
					break;
				case R.id.radio1_Distence:
					double n2=Double.valueOf(InputDistenceVal.getText().toString());
					value=n2/100;
					break;
				default:
					value=0.0;
					break;
				}
			}
		});
		
		ResultDistence.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				String data=String.valueOf(value);
				Intent sendintent=new Intent();
				sendintent.putExtra("key1",data);
				setResult(RESULT_OK, sendintent);
				finish();
			}
		});

		HomeDistence.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(DistanceConverterActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
