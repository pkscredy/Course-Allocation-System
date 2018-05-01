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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StudentMainActivity extends Activity {

	ListView LV;
	String user=null;
	String status="Tag";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_main);
		user=getIntent().getStringExtra("Uname");
		LV=(ListView) findViewById(R.id.listView1);
		String []choice={"Check Status","Cancellation","Close"};
		ArrayAdapter <String>adapt=new ArrayAdapter<String>(StudentMainActivity.this,android.R.layout.simple_expandable_list_item_1,choice);
		LV.setAdapter(adapt);
		LV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if((boolean)arg0.getItemAtPosition(arg2).equals("Check Status"))
				{
					new BackTask().execute("Check Status",user);
				}
				else if((boolean)arg0.getItemAtPosition(arg2).equals("Cancellation"))
				{
					new BackTask().execute("Cancellation",user,status);
				}
				else
				{
					finish();
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
		}
		@Override
		protected String doInBackground(String... values) {
			// TODO Auto-generated method stub
				String method =values[0];
				if(method.equals("Cancellation"))
				{
					info_url="http://192.168.0.102:80/callot/cancellation.php";
				String uname=values[1];
				String status=values[2];
				try
				{
					URL url=new URL(info_url);
					HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.setDoOutput(true);
					httpURLConnection.setDoInput(true);
					OutputStream OS=httpURLConnection.getOutputStream();
					BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
					String data=URLEncoder.encode("Uname","UTF-8") +"="+ URLEncoder.encode(uname,"UTF-8") +"&"+URLEncoder.encode("Status","UTF-8") +"="+ URLEncoder.encode(status,"UTF-8");
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
				else if(method.equals("Check Status"))
				{
					info_url="http://192.168.0.102:80/callot/check.php";
				String uname=values[1];
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
		
		
			Toast.makeText(StudentMainActivity.this,result,Toast.LENGTH_SHORT).show();
		
		}


		

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
					super.onProgressUpdate(values);
		}
		

	}

	
}
