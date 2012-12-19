package com.example.andprojdefault;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ResultActivity extends Activity {

	private Button button1 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v){
				Intent data = new Intent();
				data.putExtra("return", "valeure de retour");
				setResult(Activity.RESULT_OK, data);
				Log.i("MESSAGE", "in result activity !");
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

}
