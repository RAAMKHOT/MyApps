package com.converterapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	Spinner selectionspinner;
	Button submitbutton;
	TextView resulttextview;
	int positionchoice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final String[] choice={"Currency","Distance"};

		selectionspinner=(Spinner) findViewById(R.id.spinner_selcte_options);
		submitbutton=(Button) findViewById(R.id.button_submit);
		resulttextview=(TextView) findViewById(R.id.textView_Result);

		ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, choice);
		selectionspinner.setAdapter(adapter);

				
		//hear we can create the button reference and set to the setOnClickListener... 
		submitbutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) 
			{
				selectionspinner.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,int pos, long arg3)
					{
						positionchoice=pos;
					}
					@Override
					public void onNothingSelected(AdapterView<?> arg0)
					{
						
					}
				});
				
				if(positionchoice==0)
				{
					Intent intent=new Intent(MainActivity.this, CurrencyConverterActivity.class);
					startActivityForResult(intent, 123);
				}
				else if(positionchoice==1)
				{
					Intent intent=new Intent(MainActivity.this, DistanceConverterActivity.class);
					startActivityForResult(intent, 123);
				}
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
			resulttextview.setText(result);
		}
		else
		{
			resulttextview.setText("ERROR...");
		}
	}
}
