package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdminProfileActivity extends Activity {

	ListView LV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_profile);
		LV=(ListView) findViewById(R.id.listView1);
		String []my={"Add Verifier","Add Course Coordinator","Add Course","Close"};
		ArrayAdapter <String> adapt=new ArrayAdapter<String>(AdminProfileActivity.this,android.R.layout.simple_expandable_list_item_1,my);
		LV.setAdapter(adapt);
		LV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if((boolean)arg0.getItemAtPosition(arg2).toString().equals("Add Verifier"))
				{
					Intent intent=new Intent(AdminProfileActivity.this,AddVerifierActivity.class);
					startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).toString().equals("Add Course Coordinator"))
				{
					Intent intent=new Intent(AdminProfileActivity.this,AddHODActivity.class);
					startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).toString().equals("Add Course"))
				{
					Intent intent=new Intent(AdminProfileActivity.this,AddCourseActivity.class);
					startActivity(intent);
				}
				else
				{
					finish();
				}
				
			}
		});
	}

	

}
