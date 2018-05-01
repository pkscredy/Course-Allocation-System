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
import android.widget.Toast;

public class PreviousActivity extends Activity {

	ListView LV;
	String Email,Type;
	int s=0,ss=0,ug=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_previous);
		LV=(ListView) findViewById(R.id.listView1);
		Bundle B=getIntent().getExtras();
		Email=B.getString("Email");
		Type=B.getString("Type");
		String [] pexam={"Secondary School","Senior Secondary","UG Course","SUBMIT"};
		ArrayAdapter <String> adapt=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,pexam);
		LV.setAdapter(adapt);
		LV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if((boolean)arg0.getItemAtPosition(arg2).equals("Secondary School"))
				{
					s=1;
					Intent intent=new Intent(PreviousActivity.this,SecondaryActivity.class);
					intent.putExtra("Email",Email);
					startActivity(intent);
					
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Senior Secondary"))
				{
					ss=1;
					Intent intent=new Intent(PreviousActivity.this,SeniorSecondaryActivity.class);
					intent.putExtra("Email",Email);
					startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("UG Course"))
				{
					ug=1;
					if(Type.equalsIgnoreCase("IIT JEE"))
					{
					Toast.makeText(PreviousActivity.this,"Not Allowed",Toast.LENGTH_LONG).show();	
					}
					else
					{
					Intent intent=new Intent(PreviousActivity.this,GraduateActivity.class);
					intent.putExtra("Email",Email);
					startActivity(intent);
					}
				}
				else
				{
					if(s==0)
						Toast.makeText(PreviousActivity.this,"Fill Secondary School Details",Toast.LENGTH_SHORT).show();
					if(ss==0)
						Toast.makeText(PreviousActivity.this,"Fill Senior Secondary School Details",Toast.LENGTH_SHORT).show();
					if(ug==0)
						Toast.makeText(PreviousActivity.this,"Fill UG Course Details",Toast.LENGTH_SHORT).show();
					if((s==1)&&(ss==1)&&(ug==1))
						finish();
						
				}
			}
		});
	}


	
}
