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

public class VerifierMainActivity extends Activity {

	ListView LV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verifier_main);
		LV=(ListView) findViewById(R.id.listView1);
		String []task={"Verify","Approve","Close"};
		ArrayAdapter <String> adapt=new ArrayAdapter<String>(VerifierMainActivity.this,android.R.layout.simple_expandable_list_item_1,task);
		LV.setAdapter(adapt);
		LV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if((boolean)arg0.getItemAtPosition(arg2).equals("Verify"))
				{
					Intent intent=new Intent(VerifierMainActivity.this,VerifyActivity.class);
					startActivity(intent);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Approve"))
				{
					Intent intent=new Intent(VerifierMainActivity.this,ApproveActivity.class);
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
