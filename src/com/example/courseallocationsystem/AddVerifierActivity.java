package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddVerifierActivity extends Activity {

	EditText Uname,Pass,Cpass;
	Button Btn;
	String uname=null;
	String pass=null;
	String cpass=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_verifier);
		Uname=(EditText) findViewById(R.id.editText1);
		Pass=(EditText) findViewById(R.id.editText2);
		Cpass=(EditText) findViewById(R.id.editText3);
		Btn=(Button) findViewById(R.id.button1);
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				uname=Uname.getText().toString();
				pass=Pass.getText().toString();
				cpass=Cpass.getText().toString();
				if(uname.equals("")||pass.equals("")||cpass.equals(""))
				{
					Toast.makeText(AddVerifierActivity.this,"Fill All The Details",Toast.LENGTH_SHORT).show();
				}
				else
				{
					if(pass.equals(cpass))
					{
						String method="Verifier";
						BackgroundTask backgroundTask=new BackgroundTask(AddVerifierActivity.this);
						backgroundTask.execute(method,uname,pass);
						finish();
					}
					else
					{
						Toast.makeText(AddVerifierActivity.this,"Password Should Be Same",Toast.LENGTH_SHORT).show();
						Pass.setText("Password : Should Be Same");
						Cpass.setText("Confirm Password : Should Be Same");
					}
				}
			}
		});
	}

	

}
