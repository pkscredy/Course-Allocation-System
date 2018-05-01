package com.example.courseallocationsystem;

import java.sql.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GraduateActivity extends Activity {

	DatePicker DPP;
	Button Btn;
	EditText Cname,Uname,Percent;
	Spinner Sp;
	String cname=null;
	String uname=null;
	String percent=null;
	String course=null;
	String pyear=null;
	String email=null;
	int d,m,y;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graduate);
		DPP=(DatePicker) findViewById(R.id.datePicker111);
		Btn=(Button) findViewById(R.id.button1);
		Cname=(EditText) findViewById(R.id.editText1);
		Uname=(EditText) findViewById(R.id.editText2);
		Percent=(EditText) findViewById(R.id.editText3);
		email=getIntent().getStringExtra("Email");
		Sp=(Spinner) findViewById(R.id.spinner1);
		String []ugCourse={"BCA","BTech CS","BTech Mechanical","BTech Civil"};
		ArrayAdapter <String> adapt=new ArrayAdapter<String>(GraduateActivity.this,android.R.layout.simple_expandable_list_item_1,ugCourse);
		Sp.setAdapter(adapt);
		Sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				course=arg0.getSelectedItem().toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cname=Cname.getText().toString();
				uname=Uname.getText().toString();
				percent=Percent.getText().toString();
				d=DPP.getDayOfMonth();
				m=DPP.getMonth()+1;
				y=DPP.getYear();
				pyear=Integer.toString(d)+"-"+Integer.toString(m)+"-"+Integer.toString(y);
				if(cname.equals("")||uname.equals("")||course.equals("")||percent.equals("")||pyear.equals(""))
				{
					Toast.makeText(GraduateActivity.this,"Fill All The Details",Toast.LENGTH_LONG).show();
				}
				else
				{
					String method="Second";
					BackgroundTask backgroundTask=new BackgroundTask(GraduateActivity.this);
					backgroundTask.execute(method,email,course,cname,uname,percent,pyear);
					finish();
				}
				
				
			}
		});
	}

	

}
