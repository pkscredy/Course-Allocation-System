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

public class AddHODActivity extends Activity {

	Spinner Sp;
	EditText Uname,Pass,Cpass;
	Button Btn;
	String uname=null;
	String pass=null;
	String cpass=null;
	String cour=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_hod);
		Sp=(Spinner) findViewById(R.id.spinner1);
		Uname=(EditText) findViewById(R.id.editText1);
		Pass=(EditText) findViewById(R.id.editText2);
		Cpass=(EditText) findViewById(R.id.editText3);
		Btn=(Button) findViewById(R.id.button1);
		String[]course={"BTECH","MCA","MTECH"};
		ArrayAdapter <String>adapt=new ArrayAdapter<String>(AddHODActivity.this,android.R.layout.simple_expandable_list_item_1,course);
		Sp.setAdapter(adapt);
		Sp.setPrompt("Select Course");
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
				uname=Uname.getText().toString();
				pass=Pass.getText().toString();
				cpass=Cpass.getText().toString();
				if(uname.equals("")||pass.equals("")||cpass.equals("")||cour.equals(""))
				{
					Toast.makeText(AddHODActivity.this,"Fill All The Details",Toast.LENGTH_SHORT).show();
				}
				else
				{
					if(pass.equals(cpass))
					{
						String method="Hod";
						BackgroundTask backgroundTask=new BackgroundTask(AddHODActivity.this);
						backgroundTask.execute(method,uname,cour,pass);
						finish();
					}
					else
					{
						Toast.makeText(AddHODActivity.this,"Password Does Not Match",Toast.LENGTH_SHORT).show();
						Pass.setText("Password :Should Be Same");
						Cpass.setText("Confirm Password :Should Be Same");
					}
				}
			
				
			}
		});
	}

	
}
