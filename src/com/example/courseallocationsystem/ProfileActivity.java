package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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

public class ProfileActivity extends Activity {

	Spinner Sp1,Sp2;
	Button Btn;
	EditText Pass,Cpass,Eroll,Erank;
	String pass=null;
	String roll=null;
	String rank=null;
	String etype=null;
	String cat=null;
	String cpass=null;
	String course=null;
	String email=null;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Sp1=(Spinner) findViewById(R.id.spinner1);
		Sp2=(Spinner) findViewById(R.id.spinner2);
		Btn=(Button) findViewById(R.id.button1);
		Pass=(EditText) findViewById(R.id.editText1);
		Cpass=(EditText) findViewById(R.id.editText2);
		Eroll=(EditText) findViewById(R.id.editText3);
		Erank=(EditText) findViewById(R.id.editText4);
		email=getIntent().getStringExtra("Email");
		String [] Exam={"NIMCET","GATE","IIT JEE"};
		String [] Cat={"GENERAL","OBC","SC","ST","KASHMIRI MIGRANT","PHYSICALLY HANDICAP"};
		ArrayAdapter <String> adapt1=new ArrayAdapter <String>(this,android.R.layout.simple_expandable_list_item_1,Exam);
		Sp1.setAdapter(adapt1);
		Sp1.setPrompt("Choose Exam Type");
		ArrayAdapter <String> adapt2=new ArrayAdapter <String>(this,android.R.layout.simple_expandable_list_item_1,Cat);
		Sp2.setAdapter(adapt2);
		Sp2.setPrompt("Choose Your Category");
		Sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				etype=arg0.getSelectedItem().toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				cat=arg0.getSelectedItem().toString();
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
				pass=Pass.getText().toString();
				cpass=Cpass.getText().toString();
				roll=Eroll.getText().toString();
				rank=Erank.getText().toString();
				if(pass.equals("")||cpass.equals("")||roll.equals("")||rank.equals("")||etype.equals("")||cat.equals(""))
				{
					Toast.makeText(ProfileActivity.this,"Please Fill All The Details",Toast.LENGTH_LONG).show();
				}
				else
				{
					if(pass.equals(cpass))
					{
						 
						 if(etype.equals("NIMCET"))
						 {
							 course="MCA";
						 }
						 else if(etype.equals("GATE"))
						 {
							course="MTECH"; 
						 }
						 else if(etype.equalsIgnoreCase("IIT JEE"))
						 {
							course="BTECH"; 
						 }
						 
						String  method="ExamInfo";
							 BackgroundTask backTask=new BackgroundTask(ProfileActivity.this);
							backTask.execute(method,email,pass,roll,rank,etype,cat,course);
							Bundle B=new Bundle();
							B.putString("Email",email);
							B.putString("Type",etype);
							Intent intent=new Intent(ProfileActivity.this,PreviousActivity.class);
							intent.putExtras(B);
							startActivity(intent);
							finish();
					}
					else
					{
						Toast.makeText(ProfileActivity.this,"Password Should Be same",Toast.LENGTH_SHORT).show();
						Pass.setText("Password : Should be same");
						Cpass.setText("Confirm Password : should be same");
					}
				}
				
				
			}
		});
		
	}

	

}
