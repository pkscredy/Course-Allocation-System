package com.example.courseallocationsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.os.AsyncTask;
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

public class StudentLogin extends Activity {

	EditText Pass,Uname;
	Button Btn;
	String uname=null;
	String pass=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_login);
		Pass=(EditText) findViewById(R.id.editText2);
		Uname=(EditText) findViewById(R.id.editText1);
		Btn=(Button) findViewById(R.id.button1);
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uname=Uname.getText().toString();
				pass=Pass.getText().toString();
				if(uname.equals("")||pass.equals(""))
				{
					Toast.makeText(StudentLogin.this,"Fill All Details",Toast.LENGTH_SHORT).show();
				}
				else
				{
					new BackTask().execute(uname,pass);
				}			
			}
		});
		
		
	}
	public class BackTask extends AsyncTask<String,Void, String>
	{
		String info_url;
		String JSON_STRING=null;
		protected void onPreExecute() {
			// TODO Auto-generated method stub
		info_url="http://192.168.0.102:80/callot/StudentLogin.php";
		}
		@Override
		protected String doInBackground(String... values) {
			// TODO Auto-generated method stub
			
				String uname=values[0];
				String pass=values[1];
				try
				{
					URL url=new URL(info_url);
					HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.setDoOutput(true);
					httpURLConnection.setDoInput(true);
					OutputStream OS=httpURLConnection.getOutputStream();
					BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
					String data=URLEncoder.encode("Uname","UTF-8") +"="+ URLEncoder.encode(uname,"UTF-8") +"&"+URLEncoder.encode("Pass","UTF-8") +"="+ URLEncoder.encode(pass,"UTF-8");
					bufferedWriter.write(data);
					bufferedWriter.flush();
					bufferedWriter.close();
					OS.close();
					InputStream IS=httpURLConnection.getInputStream();
					BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
					StringBuilder stringBuilder=new StringBuilder();
					while((JSON_STRING=bufferedReader.readLine())!=null)
					{
					stringBuilder.append(JSON_STRING+"\n");
					}
					bufferedReader.close();
					IS.close();
					httpURLConnection.disconnect();
					return stringBuilder.toString().trim();
				}
				catch(MalformedURLException e)
				{
					e.printStackTrace();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				return pass;

			
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		if(result.equalsIgnoreCase("Success"))
		{
			Intent intent=new Intent(StudentLogin.this,StudentMainActivity.class);
			intent.putExtra("Uname",uname);
			startActivity(intent);
			finish();
		}
		else
		{
			Toast.makeText(StudentLogin.this,"Authentication Fails",Toast.LENGTH_SHORT).show();
		}
			
		
		}


		

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
					super.onProgressUpdate(values);
		}
		

	}

	

}
