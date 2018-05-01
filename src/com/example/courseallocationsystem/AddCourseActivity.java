package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddCourseActivity extends Activity {

	Spinner Sp;
	EditText Num;
	Button Btn;
	String cour=null;
	String num=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_course);
		Sp=(Spinner) findViewById(R.id.spinner1);
		Num=(EditText) findViewById(R.id.editText1);
		Btn=(Button) findViewById(R.id.button1);
		String []course={"BTECH","MTECH","MCA"};
		ArrayAdapter<String> adapt=new ArrayAdapter<String>(AddCourseActivity.this,android.R.layout.simple_expandable_list_item_1,course);
		Sp.setAdapter(adapt);
		Sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				cour=arg0.getSelectedItem().toString();
				
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
				num=Num.getText().toString();
				if(num.equals("")||cour.equals(""))
				{
					Toast.makeText(AddCourseActivity.this,"Fill All The Details",Toast.LENGTH_SHORT).show();
				}
				else
				{
					String method="Course";
					BackgroundTask backgroundTask=new BackgroundTask(AddCourseActivity.this);
					backgroundTask.execute(method,cour,num);
					finish();
				}
				
			}
		});
	}

	
}
