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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HODMainActivity extends Activity {

	Button Btn;
	Button Btn1;
	EditText Et1,Et2;
	String uname=null;
	String user=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hodmain);
		Btn=(Button) findViewById(R.id.button1);
		Btn1=(Button) findViewById(R.id.button2);
		Et1=(EditText) findViewById(R.id.editText1);
		Et2=(EditText) findViewById(R.id.editText2);
		uname=getIntent().getStringExtra("Uname");
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new BackTask().execute("list",uname);
			}
		});
		Btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user=Et2.getText().toString();
				if(user.equals(""))
				{
				Toast.makeText(HODMainActivity.this,"Fill User Id",Toast.LENGTH_SHORT).show();	
				}
				else
				{
				new BackTask().execute("remove",user);
				}
			}
		});
	}
	public class BackTask extends AsyncTask<String,Void, String>
	{
		String info_url;
		String JSON_STRING=null;
		String method;
		protected void onPreExecute() {
			// TODO Auto-generated method stub
		}
		@Override
		protected String doInBackground(String... values) {
			// TODO Auto-generated method stub
				 method=values[0];
				if(method.equals("list"))
				{
					String uname=values[1];
					info_url="http://192.168.0.102:80/callot/getlist.php";
				try
				{
					URL url=new URL(info_url);
					HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.setDoOutput(true);
					httpURLConnection.setDoInput(true);
					OutputStream OS=httpURLConnection.getOutputStream();
					BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
					String data=URLEncoder.encode("Uname","UTF-8") +"="+ URLEncoder.encode(uname,"UTF-8");
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
				}
				else if(method.equals("remove"))
				{
					String uname=values[1];
					info_url="http://192.168.0.102:80/callot/remove.php";
				try
				{
					URL url=new URL(info_url);
					HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.setDoOutput(true);
					httpURLConnection.setDoInput(true);
					OutputStream OS=httpURLConnection.getOutputStream();
					BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
					String data=URLEncoder.encode("Uname","UTF-8") +"="+ URLEncoder.encode(uname,"UTF-8");
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
				}

				return null;

			
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			if(method.equals("list"))
			{
				Et1.setText(result);
			}
			else if(method.equals("remove"))
			{
			Toast.makeText(HODMainActivity.this,result,Toast.LENGTH_SHORT).show();
		}
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
					super.onProgressUpdate(values);
		}
		

	}

	

}
