package com.example.courseallocationsystem;

import java.net.DatagramPacket;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class FifthActivity extends Activity {

	Spinner Sp;
	Button Btn;
	EditText Name,Email,Add,Con;
	DatePicker DP;
	String name=null;
	String email=null;
	String gender=null;
	String address=null;
	String contact=null;
	String dob=null;
	int d,m,y;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifth);
		Sp=(Spinner) findViewById(R.id.spinner1);
		Btn=(Button) findViewById(R.id.button1);
		Name=(EditText) findViewById(R.id.editText1);
		Email=(EditText) findViewById(R.id.editText2);
		Add=(EditText) findViewById(R.id.editText3);
		Con=(EditText) findViewById(R.id.editText4);
		DP=(DatePicker) findViewById(R.id.datePicker1);
		String [] Gender={"Male","Female"};
		ArrayAdapter <String> adapt=new ArrayAdapter <String>(this,android.R.layout.simple_expandable_list_item_1,Gender);
		Sp.setAdapter(adapt);
		Sp.setPrompt("Gender");
		Sp.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				gender=arg0.getSelectedItem().toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		Btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				name=Name.getText().toString();
				email=Email.getText().toString();
				address=Add.getText().toString();
				contact=Con.getText().toString();
				d=DP.getDayOfMonth();
				m=DP.getMonth()+1;
				y=DP.getYear();
				dob=Integer.toString(d)+"-"+Integer.toString(m)+"-"+Integer.toString(y);
				Toast.makeText(FifthActivity.this,dob,Toast.LENGTH_LONG).show();	
					if(name.equals("")||email.equals("")||address.equals("")||contact.equals("")||dob.equals("")||gender.equals(""))
					{
						Toast.makeText(FifthActivity.this,"Please Enter All Details",Toast.LENGTH_LONG).show();
					}
					else
					{
						
						String reg="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
						Pattern pattern=Pattern.compile(reg);
						Matcher m=pattern.matcher(email);
						if(m.matches())
						{
							if(contact.length()==10)
							{
								String method="BasicInfo";
								
								BackgroundTask backgroundTask=new BackgroundTask(FifthActivity.this);
								backgroundTask.execute(method,name,email,gender,address,contact,dob);
							Intent intent=new Intent(FifthActivity.this,ProfileActivity.class);
							intent.putExtra("Email",email);
							startActivity(intent);
							finish();
							
							}
							else
							{
								Toast.makeText(FifthActivity.this,"Wrong Phone Number",Toast.LENGTH_LONG).show();
								Con.setText("INVALID PHONE NUMBER");
							}
						}
						else
						{
							Toast.makeText(FifthActivity.this,"Invalid Email Id",Toast.LENGTH_LONG).show();
							Email.setText("INVALID EMAIL ADDRESS");
						}
					}
				}
				
				
			});
	}



}
