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

public class ApproveActivity extends Activity {

	EditText Email;
	Spinner Sp;
	Button Btn;
	String email=null;
	String stat=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_approve);
		Email=(EditText) findViewById(R.id.editText1);
		Sp=(Spinner) findViewById(R.id.spinner1);
		Btn=(Button) findViewById(R.id.button1);
		String []status={"Approved","Not Approved"};
		ArrayAdapter <String> adapt=new ArrayAdapter<String>(ApproveActivity.this,android.R.layout.simple_expandable_list_item_1,status);
		Sp.setAdapter(adapt);
		Sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				stat=arg0.getSelectedItem().toString();
				
				
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
				email=Email.getText().toString();
				new BackTask().execute(email,stat);
			}
		});
	}

	
	public class BackTask extends AsyncTask<String,Void, String>
	{
		String info_url;
		String JSON_STRING=null;
		protected void onPreExecute() {
			// TODO Auto-generated method stub
		info_url="http://192.168.0.102:80/callot/stat.php";
		}
		@Override
		protected String doInBackground(String... values) {
			// TODO Auto-generated method stub
			
				String email=values[0];
				String stat=values[1];
				try
				{
					URL url=new URL(info_url);
					HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.setDoOutput(true);
					httpURLConnection.setDoInput(true);
					OutputStream OS=httpURLConnection.getOutputStream();
					BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
					String data=URLEncoder.encode("Email","UTF-8") +"="+ URLEncoder.encode(email,"UTF-8") +"&"+URLEncoder.encode("Stat","UTF-8") +"="+ URLEncoder.encode(stat,"UTF-8");
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
				return null;

			
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		
			Toast.makeText(ApproveActivity.this,result,Toast.LENGTH_SHORT).show();
			finish();

		
		}


		

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
					super.onProgressUpdate(values);
		}
		

	}

}
