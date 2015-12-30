package com.activityresultback;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button startbutton;
	TextView outputtextview;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startbutton=(Button) findViewById(R.id.buttonstart);
		outputtextview=(TextView) findViewById(R.id.textViewoutput);

		startbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(MainActivity.this, SecondActivity.class);
				startActivityForResult(intent, 123);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		if (resultCode==RESULT_OK) 
		{
			Bundle extras=data.getExtras();
			String result=extras.getString("key1");
			outputtextview.setText(result);
		}
		else
		{
			outputtextview.setText("ERROR...");
		}
	}
}
