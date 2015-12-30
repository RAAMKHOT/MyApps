package com.converterapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CurrencyConverterActivity extends Activity {

	EditText InputCurrencyVal;
	RadioGroup SelectGroupOpt;
	Button ResultCurrency,HomeCurrency;
	double value=0.00;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency_converter);

		InputCurrencyVal=(EditText) findViewById(R.id.editText_Input_Currency);
		SelectGroupOpt=(RadioGroup) findViewById(R.id.radioGroup_Select_Currency);
		ResultCurrency=(Button) findViewById(R.id.button_Result_Currency);
		HomeCurrency=(Button) findViewById(R.id.button_Home_Currncy);
		value=0.0;

		SelectGroupOpt.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) 
			{
				switch (arg1) 
				{
				case R.id.radio0_First_Currency:
					double n1=Double.valueOf(InputCurrencyVal.getText().toString());
					value=n1*66.57;
					break;
				case R.id.radio1_Second_Curency:
					double n2=Double.valueOf(InputCurrencyVal.getText().toString());
					value=n2/66.57;
					break;
				default:
					value=0.0;
					break;
				}
			}
		});
		ResultCurrency.setOnClickListener(new OnClickListener() 
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

		HomeCurrency.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(CurrencyConverterActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}
}
