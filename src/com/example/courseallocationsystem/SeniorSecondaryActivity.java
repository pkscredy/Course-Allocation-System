package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class SeniorSecondaryActivity extends Activity {

	EditText Sname,Bname,Pyear,Percen;
	Button Btn;
	DatePicker DP;
	String sname=null;
	String bname=null;
	String pyear=null;
	String percen=null;
	String Email;
	int d;
	int m,y;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_senior_secondary);
		Sname=(EditText) findViewById(R.id.editText1);
		Bname=(EditText) findViewById(R.id.editText2);
		Pyear=(EditText) findViewById(R.id.editText3);
		Percen=(EditText) findViewById(R.id.editText4);
		Btn=(Button) findViewById(R.id.button1);
		Email=getIntent().getStringExtra("Email");
		DP=(DatePicker) findViewById(R.id.dataPicker1);
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			sname=Sname.getText().toString();
			bname=Bname.getText().toString();
			percen=Percen.getText().toString();
			//d=DP.getDayOfMonth();
			//m=DP.getMonth()+1;
			//y=DP.getYear();
			//pyear=Integer.toString(d)+"-"+Integer.toString(m)+"-"+Integer.toString(y);
			pyear="1-12-2016";
			if(sname.equals("")||bname.equals("")||percen.equals("")||pyear.equals(""))
			{
				Toast.makeText(SeniorSecondaryActivity.this,"Fill All The Fields",Toast.LENGTH_SHORT).show();
			}
			else
			{
				String method="Second";
				BackgroundTask backgroundTask=new BackgroundTask(SeniorSecondaryActivity.this);
				backgroundTask.execute(method,Email,"SnSec",sname,bname,percen,pyear);
				finish();
			}
			}
		});
	}

	
}
