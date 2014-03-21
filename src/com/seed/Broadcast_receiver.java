package com.seed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.sax.StartElementListener;
import android.widget.Toast;

public class Broadcast_receiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "alarm ringing",Toast.LENGTH_LONG).show();

		// Vibrate the mobile phone
	    Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(5000);
		
		String toValue = (String)intent.getExtras().get("ToKey"); 
		
		
		//String strmsg="Hello" ;
		//Gps gpsobj=new Gps();
		//strmsg=gpsobj.getMsg();
		Intent i=new Intent(context,Gps.class);
		i.putExtra("tovalue",toValue);
		context.startActivity(i);
		
		//Sms obj =new Sms();
		
		//obj.sendSmsMessage(toValue,strmsg);
		
		
		
	}

}


