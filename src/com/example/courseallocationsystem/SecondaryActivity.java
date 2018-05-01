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

public class SecondaryActivity extends Activity {

	EditText Sname;
	EditText Bname;
	EditText Pcent;
	String sname=null;
	String bname=null;
	String pcent=null;
	String pyear=null;
	String Email;
	int d,m,y;
	Button btn;
	DatePicker Dp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondary);
		Sname=(EditText) findViewById(R.id.editText1);
		Bname=(EditText) findViewById(R.id.editText2);
		Pcent=(EditText) findViewById(R.id.editText3);
		btn=(Button) findViewById(R.id.button1);
		Dp=(DatePicker) findViewById(R.id.datePicker11);
		Email=getIntent().getStringExtra("Email");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sname=Sname.getText().toString();
				bname=Bname.getText().toString();
				pcent=Pcent.getText().toString();
				d=Dp.getDayOfMonth();
				m=Dp.getMonth()+1;
				y=Dp.getYear();
				pyear=Integer.toString(d)+"-"+Integer.toString(m)+"-"+Integer.toString(y);
				//pyear="22-12-2015";
				if(sname.equals("")||bname.equals("")||pcent.equals("")||pyear.equals(""))
				{
					Toast.makeText(SecondaryActivity.this,"Fill All The Details",Toast.LENGTH_LONG).show();
				}
				else
				{
					String method="Second";
					BackgroundTask backgroundTask=new BackgroundTask(SecondaryActivity.this);
					backgroundTask.execute(method,Email,"Secondary",sname,bname,pcent,pyear);
					finish();
				}
				
			}
		});
	}

	
}
