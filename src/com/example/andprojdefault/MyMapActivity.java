package com.example.andprojdefault;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MyMapActivity extends MapActivity {

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		MapView mapView = (MapView) findViewById(R.id.map_view);
		mapView.setSatellite(true);
		mapView.setBuiltInZoomControls(true);
	}

}
