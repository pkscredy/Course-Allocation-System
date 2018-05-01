package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends Activity {

	EditText Uname,Pass;
	Button Btn;
	String uname=null;
	String pass=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);
		Uname=(EditText) findViewById(R.id.editText1);
		Pass=(EditText) findViewById(R.id.editText2);
		Btn=(Button) findViewById(R.id.button1);
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uname=Uname.getText().toString();
				pass=Pass.getText().toString();
				if((uname.equalsIgnoreCase("Admin"))&&(pass.equalsIgnoreCase("Admin")))
				{
					Intent intent=new Intent(AdminLoginActivity.this,AdminProfileActivity.class);
					startActivity(intent);
					finish();	
				}
				else
				{
					Toast.makeText(AdminLoginActivity.this,"Authentication Fail",Toast.LENGTH_LONG).show();
					Uname.setText("");
					Pass.setText("");
				}
				
				
			}
		});
	}



}
