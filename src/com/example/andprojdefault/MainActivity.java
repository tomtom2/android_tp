package com.example.andprojdefault;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private static final String TAG = "MyLogCatTag";
	private Button button2 = null;
	private Button buttonLivres = null;
	private Button buttonMap = null;
	private EditText monTextField = null;
	private String message = null;
	Intent monIntent = null;
	Intent returnIntent = null;
	
	public static final int STATIC_INTEGER_VALUE = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.default_layout);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(getApplicationContext(), "Tue !", Toast.LENGTH_SHORT).show();
			}
		});
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);
		
		buttonLivres = (Button) findViewById(R.id.buttonLivres);
		buttonLivres.setOnClickListener(this);
		
		buttonMap = (Button) findViewById(R.id.buttonmap);
		buttonMap.setOnClickListener(this);
		
		monTextField = (EditText) findViewById(R.id.editText1);
		
		Log.i(TAG, "create activity !");
	}
	
	public void onClick(View v){
		Log.i(TAG, "click detected !");
		message = monTextField.getText().toString();
		//message = "aaa";
		if (v == button2){
			Log.i(TAG, "click on button 2 !");
			Toast.makeText(getApplicationContext(), "click on button 2 !", Toast.LENGTH_SHORT).show();
			
			if (message != "" && message != null){
				monIntent = new Intent(this, SecondActivityMainActivity.class);
				Log.i(TAG, "message send = " + message);
				monIntent.putExtra("arg1", message);
				startActivity(monIntent);
			}
			else{
				monIntent = new Intent(this, SecondActivityMainActivity.class);
				startActivity(monIntent);
			}
			
			/*
				returnIntent = new Intent(this, ResultActivity.class);
				startActivityForResult(monIntent, STATIC_INTEGER_VALUE);
				
				int requestCode = 0;
				int resultCode = 0;
				Intent data = null;
				onActivityResult(requestCode, resultCode, data);*/
			
			
            
		}
		else if (v == buttonLivres){
			Log.i(TAG, "go to bibliotheque !");
			monIntent = new Intent(this, LivreActivity.class);
			startActivity(monIntent);
		}
		else if (v == buttonMap){
			Log.i(TAG, "go to bibliotheque !");
			monIntent = new Intent(this, MyMapActivity.class);
			startActivity(monIntent);
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String myValue = "";
	      if (requestCode == STATIC_INTEGER_VALUE) {
	          if (resultCode == RESULT_OK) {
	        	  myValue = data.getStringExtra("return"); 
	        	  Toast.makeText(getApplicationContext(), myValue, Toast.LENGTH_SHORT).show();
	          }
	      }
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.i(TAG, "touch !");
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
