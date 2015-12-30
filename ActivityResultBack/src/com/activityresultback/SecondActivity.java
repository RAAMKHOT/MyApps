package com.activityresultback;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class SecondActivity extends Activity {

	EditText inputedittext;
	Button sendbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		inputedittext=(EditText) findViewById(R.id.editTextinput);
		sendbutton=(Button) findViewById(R.id.buttonsend);
		
		sendbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				String data=inputedittext.getText().toString();
				Intent sendintent=new Intent();
				sendintent.putExtra("key1",data);
				setResult(RESULT_OK, sendintent);
				finish();
			}
		});
	}
}
