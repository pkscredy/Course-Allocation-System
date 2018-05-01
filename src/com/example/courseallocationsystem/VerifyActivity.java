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

public class VerifyActivity extends Activity {

	EditText Email,Data;
	Button Basic,Exam,Degree;
	String uname=null;
	//String resultfinal=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verify);
		Email=(EditText) findViewById(R.id.editText1);
		Data=(EditText) findViewById(R.id.editText2);
		Basic=(Button) findViewById(R.id.button1);
		Exam=(Button) findViewById(R.id.button2);
		Degree=(Button) findViewById(R.id.button3);
		Basic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uname=Email.getText().toString();
				Data.setText("");
				new BackTask().execute("Basic",uname);
				
			}
		});
		Exam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uname=Email.getText().toString();
				Data.setText("");
				new BackTask().execute("Exam",uname);
			}
		});
		Degree.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uname=Email.getText().toString();
				Data.setText("");
				new BackTask().execute("Degree",uname);
			}
		} );
		
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
				String method=values[0];
				String uname=values[1];
				if(method.equals("Basic"))
				{
					info_url="http://192.168.0.102:80/callot/getbasic.php";
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
		else if(method.equals("Exam"))
		{
			info_url="http://192.168.0.102:80/callot/getexam.php";
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
		else if(method.equals("Degree"))
		{
			info_url="http://192.168.0.102:80/callot/getdegree.php";
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
Data.setText(result);

}




@Override
protected void onProgressUpdate(Void... values) {
	// TODO Auto-generated method stub
			super.onProgressUpdate(values);
}


	}


	
}
