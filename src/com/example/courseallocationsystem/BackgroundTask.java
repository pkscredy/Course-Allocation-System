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

import org.apache.http.auth.MalformedChallengeException;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String,Void, String> {

	Context ctx;
	BackgroundTask(Context c)
	{
		ctx=c;
	}
	protected void onPreExecute() {
		// TODO Auto-generated method stub
	 
	}
	@Override
	protected String doInBackground(String... values) {
		// TODO Auto-generated method stub
		String info_reg_url="http://192.168.0.102:80/callot/inforegister.php";
		String info_exam_url="http://192.168.0.102:80/callot/examregister.php";
		String degree_url="http://192.168.0.102:80/callot/degree.php";
		String verify_url="http://192.168.0.102:80/callot/verify.php";
		String hod_url="http://192.168.0.102:80/callot/hod.php";
		String course_url="http://192.168.0.102:80/callot/course.php";
		String method=values[0];
		if(method.equals("BasicInfo"))
		{
			String name=values[1];
			String email=values[2];
			String gender=values[3];
			String address=values[4];
			String contact=values[5];
			String dob=values[6];
			try
			{
				URL url=new URL(info_reg_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream OS=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
				String data=URLEncoder.encode("Name","UTF-8") +"="+ URLEncoder.encode(name,"UTF-8") +"&"+URLEncoder.encode("Email","UTF-8") +"="+ URLEncoder.encode(email,"UTF-8") +"&"+URLEncoder.encode("Gender","UTF-8") +"="+ URLEncoder.encode(gender,"UTF-8") +"&"+URLEncoder.encode("Address","UTF-8") +"="+ URLEncoder.encode(address,"UTF-8") +"&"+URLEncoder.encode("Contact","UTF-8") +"="+ URLEncoder.encode(contact,"UTF-8") +"&"+URLEncoder.encode("Dob","UTF-8") +"="+ URLEncoder.encode(dob,"UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
				InputStream IS=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
				String response="";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					response+=line;
				}
				bufferedReader.close();
				IS.close();
				httpURLConnection.disconnect();
				return response;
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
		else if(method.equals("ExamInfo"))
		{
			String email=values[1];
			String pass=values[2];
			String roll=values[3];
			String rank=values[4];
			String type=values[5];
			String cat=values[6];
			String course=values[7];
			try
			{
				URL url=new URL(info_exam_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream OS=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
				//String data=URLEncoder.encode("name","UTF-8") +"="+ URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode("email","UTF-8");
				String data=URLEncoder.encode("Email","UTF-8") +"="+ URLEncoder.encode(email,"UTF-8") +"&"+URLEncoder.encode("Pass","UTF-8") +"="+ URLEncoder.encode(pass,"UTF-8") +"&"+URLEncoder.encode("Roll","UTF-8") +"="+ URLEncoder.encode(roll,"UTF-8") +"&"+URLEncoder.encode("Rank","UTF-8") +"="+ URLEncoder.encode(rank,"UTF-8") +"&"+URLEncoder.encode("Type","UTF-8") +"="+ URLEncoder.encode(type,"UTF-8") +"&"+URLEncoder.encode("Cat","UTF-8") +"="+ URLEncoder.encode(cat,"UTF-8") +"&"+URLEncoder.encode("Course","UTF-8") +"="+ URLEncoder.encode(course,"UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
				InputStream IS=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
				String response="";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					response+=line;
				}
				bufferedReader.close();
				IS.close();
				httpURLConnection.disconnect();
				return response;
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
		else if(method.equals("Second"))
		{
			String email=values[1];
			String course=values[2];
			String sname=values[3];
			String bname=values[4];
			String cgpa=values[5];
			String year=values[6];
			try
			{
				URL url=new URL(degree_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				//httpURLConnection.connect();
				OutputStream OS=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
				//String data=URLEncoder.encode("name","UTF-8") +"="+ URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode("email","UTF-8");
				String data=URLEncoder.encode("Email","UTF-8") +"="+ URLEncoder.encode(email,"UTF-8") +"&"+URLEncoder.encode("Course","UTF-8") +"="+ URLEncoder.encode(course,"UTF-8") +"&"+URLEncoder.encode("Sname","UTF-8") +"="+ URLEncoder.encode(sname,"UTF-8") +"&"+URLEncoder.encode("Bname","UTF-8") +"="+ URLEncoder.encode(bname,"UTF-8") +"&"+URLEncoder.encode("Cgpa","UTF-8") +"="+ URLEncoder.encode(cgpa,"UTF-8") +"&"+URLEncoder.encode("Year","UTF-8") +"="+ URLEncoder.encode(year,"UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
				InputStream IS=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
				String response="";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					response+=line;
				}
				bufferedReader.close();
				IS.close();
				httpURLConnection.disconnect();
				return response;
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
		else if(method.equals("Verifier"))
		{
			String uname=values[1];
			String pass=values[2];
			try
			{
				URL url=new URL(verify_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream OS=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
				//String data=URLEncoder.encode("name","UTF-8") +"="+ URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode("email","UTF-8");
				String data=URLEncoder.encode("Uname","UTF-8") +"="+ URLEncoder.encode(uname,"UTF-8") +"&"+URLEncoder.encode("Pass","UTF-8") +"="+ URLEncoder.encode(pass,"UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
				InputStream IS=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
				String response="";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					response+=line;
				}
				bufferedReader.close();
				IS.close();
				httpURLConnection.disconnect();
				return response;
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
		else if(method.equals("Hod"))
		{
			String name=values[1];
			String course=values[2];
			String pass=values[3];
			try
			{
				URL url=new URL(hod_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream OS=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
				//String data=URLEncoder.encode("name","UTF-8") +"="+ URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode("email","UTF-8");
				String data=URLEncoder.encode("Name","UTF-8") +"="+ URLEncoder.encode(name,"UTF-8") +"&"+URLEncoder.encode("Course","UTF-8") +"="+ URLEncoder.encode(course,"UTF-8")+"&"+URLEncoder.encode("Pass","UTF-8") +"="+ URLEncoder.encode(pass,"UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
				InputStream IS=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
				String response="";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					response+=line;
				}
				bufferedReader.close();
				IS.close();
				httpURLConnection.disconnect();
				return response;
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
		else if(method.equals("Course"))
		{
			String name=values[1];
			String num=values[2];
			try
			{
				URL url=new URL(course_url);
				HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream OS=httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
				//String data=URLEncoder.encode("name","UTF-8") +"="+ URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode("email","UTF-8");
				String data=URLEncoder.encode("Name","UTF-8") +"="+ URLEncoder.encode(name,"UTF-8") +"&"+URLEncoder.encode("Num","UTF-8") +"="+ URLEncoder.encode(num,"UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
				InputStream IS=httpURLConnection.getInputStream();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"ISO-8859-1"));
				String response="";
				String line="";
				while((line=bufferedReader.readLine())!=null)
				{
					response+=line;
				}
				bufferedReader.close();
				IS.close();
				httpURLConnection.disconnect();
				return response;
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
				


		return "Nothing:";

		
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
		
		//AlertDialog alertDialog=new AlertDialog.Builder(ctx).create();
		//alertDialog.setTitle("Registration Information");
		//alertDialog.setMessage(result);
		//alertDialog.show();
	}


	

	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
				super.onProgressUpdate(values);
	}
	

}
