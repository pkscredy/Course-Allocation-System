package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends Activity {

	ListView Lv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		Lv=(ListView) findViewById(R.id.listView1);
		String []log={"Login","Sign Up"};
		ArrayAdapter <String> adapt=new ArrayAdapter <String>(this,android.R.layout.simple_expandable_list_item_1,log);
		Lv.setAdapter(adapt);
		Lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if((boolean)arg0.getItemAtPosition(arg2).equals("Login"))
				{
					Intent intent=new Intent(ThirdActivity.this,StudentLogin.class);
					startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Sign Up"))
				{
					Intent intent=new Intent(ThirdActivity.this,FifthActivity.class);
					startActivity(intent);
				}
				else
				{
					
				}
				
			}});
	}

	
}
