package com.example.andprojdefault;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MyItemizedOverLay extends ItemizedOverlay<OverlayItem>{

	private ArrayList<OverlayItem> myOverlays;
	
	public MyItemizedOverLay(Drawable defaultMarker){
		super(boundCenterBottom(defaultMarker));
		myOverlays = new ArrayList<OverlayItem>();
		populate();
	}
	
	public void addOverlay(OverlayItem overlay){
		myOverlays.add(overlay);
		populate();
	}
	
	protected OverlayItem createItem(int i){
		return myOverlays.get(i);
	}
	
	protected boolean onTap(int i){
		GeoPoint gpoint = myOverlays.get(i).getPoint();
		double lat = gpoint.getLatitudeE6()/1e6;
		double lon = gpoint.getLongitudeE6()/1e6;
		String toast = "Title: "+ myOverlays.get(i).getTitle();
		Toast.makeText(MyMapActivity.context,  toast,  Toast.LENGTH_SHORT).show();
		return true;
	}
	
	public int size(){
		return myOverlays.size();
	}
}
