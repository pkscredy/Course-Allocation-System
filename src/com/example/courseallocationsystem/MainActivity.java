package com.example.courseallocationsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button Btn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Btn=(Button) findViewById(R.id.button1);
	}
public void Goto(View v)
{
	Intent intent=new Intent(MainActivity.this,SecondActivity.class);
	startActivity(intent);
}
	

}
