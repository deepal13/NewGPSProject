package com.seed;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.MapActivity;

public class Gps  extends MapActivity
{
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		String tovalue = extras.getString("tovalue");

		getMsg(tovalue);
		
		
	}

	public void getMsg(String toValue)
	{
		
		
		String strmsg=null;

        LocationManager mgr=(LocationManager)getSystemService(LOCATION_SERVICE);
        Location location=mgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        
        int lat,lng;
        if(location!=null)
        {
        	// convert to microdegrees
        	lat=(int)(location.getLatitude()*100000);
        	lng=(int)(location.getLongitude()*100000);
        
        	strmsg=lat+" /"+lng;
        	
        }
        else
        {
        	//Default to pune city
        	lng=73849167;
        	lat=18529722;
        	
        	
        }
    	Sms obj =new Sms();
		
		obj.sendSmsMessage(toValue,strmsg);
    

		
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
