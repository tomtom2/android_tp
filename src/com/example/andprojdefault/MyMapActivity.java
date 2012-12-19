package com.example.andprojdefault;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MyMapActivity extends MapActivity {

	private List<Overlay> mapOverlays;
	static Context context;
	private OverlayItem[] items = {
			new OverlayItem(new GeoPoint(35952967, -83929158), "Point 1", "Description 1"),
			new OverlayItem(new GeoPoint(35953000, -83928000), "Point 2", "Description 2"),
			new OverlayItem(new GeoPoint(35955000, -83929158), "Point 3", "Description 3")
	};
	private MyItemizedOverLay itemizedOverlay1;
	private MapView mapView;
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		
		context = getApplicationContext();
		
		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setSatellite(true);
		mapView.setBuiltInZoomControls(true);
		
		setOverlay();
		/*MapController mapController = mapView.getController();
		Double lat = 43.30043*1E6;
		Double lon=5.3675*1E6;
		GeoPoint point = new GeoPoint(lat.intValue(), lon.intValue()) ;
		mapController.setCenter(point);
		mapController.setZoom(12);
		mapController.animateTo(point);*/
		
	}
	
	public void setOverlay(){
		mapOverlays = mapView.getOverlays();
		Drawable drawable1 = this.getResources().getDrawable(R.drawable.ic_launcher);
		this.itemizedOverlay1 = new MyItemizedOverLay(drawable1);
		
		for(OverlayItem item : items){
			itemizedOverlay1.addOverlay(item);
		}
		mapOverlays.add(itemizedOverlay1);
		
		mapView.postInvalidate();
	}

}
