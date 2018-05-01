package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity {

	ListView Lv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Lv=(ListView) findViewById(R.id.listView1);
		String [] User={"Student","Verifier","Course Coordinator","Department Head","About"};
		ArrayAdapter <String> adapt=new ArrayAdapter <String>(this,android.R.layout.simple_expandable_list_item_1,User);
		Lv.setAdapter(adapt);
		Lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if((boolean)arg0.getItemAtPosition(arg2).equals("About"))
				{
				Intent intent=new Intent(SecondActivity.this,FourthActivity.class);
				startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Student"))
				{
				Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Department Head"))
				{
					Intent intent=new Intent(SecondActivity.this,AdminLoginActivity.class);
					startActivity(intent);	
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Verifier"))
				{
					Intent intent=new Intent(SecondActivity.this,VerifierLoginActivity.class);
					startActivity(intent);	
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Course Coordinator"))
				{
					Intent intent=new Intent(SecondActivity.this,HODLoginActivity.class);
					startActivity(intent);	
				}
				
			}});
	}



}
