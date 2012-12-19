package com.example.andprojdefault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SecondActivityMainActivity extends Activity {

	//private EditText tf = null;
	private static final String[] COUNTRIES = {"France", "UK", "USA"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.second_activity_main);
		//tf = (EditText) findViewById(R.id.editText1);
		
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		fillListItems(new HashMap<String, String>());
		
		
		setContentView(R.layout.listview_layout);
		setTheme(R.style.WidetBackground);
		/*Toast.makeText(getApplicationContext(), "New Activity !", Toast.LENGTH_SHORT).show();
		ListView myListView = (ListView) findViewById(R.id.myListView);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, (Integer) R.layout.list_item, COUNTRIES);
		myListView.setAdapter(aa);
		
		myListView.setTextFilterEnabled(true);
		myListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
				
			}
			
		});*/
		
		ListView myListView = (ListView) findViewById(R.id.myListView);
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("title", "android");
		map.put("description", "Hello Android");
		map.put("img", String.valueOf(R.drawable.ic_launcher));
		listItem.add(map);
		SimpleAdapter mShedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.layoutitem,
				new String[] {"img", "title", "description"}, new int[]{R.id.img, R.id.title, R.id.description});
		//setListAdapter(mShedule);
		myListView.setAdapter(mShedule);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_activity_main, menu);
		Bundle extras = getIntent().getExtras();
		String message = extras.getString("arg1");
		Log.i("RX", "message recieved = " + message);
		//tf.setText(message);
		return true;
	}
	
	public void fillListItems(HashMap<String, String> map){
		String url1 = "http://cci.corellis.eu/pois.php";
		String url2 = "http://ismycomputeron.com/";
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url2);
		try {
			HttpResponse response = httpclient.execute(httpget);
			if(response!=null){
				Toast.makeText(this, "Message comming soon!", Toast.LENGTH_SHORT).show();
				String line = "";
				InputStream input = response.getEntity().getContent();
				line = convertStreamToString(input);
				Toast.makeText(this, line, Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "No Response!", Toast.LENGTH_SHORT).show();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String convertStreamToString(InputStream is) {
	    String line = "";
	    StringBuilder total = new StringBuilder();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    
	    try {
			while ((line = rd.readLine()) != null){
				total.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return total.toString();
	}

}
