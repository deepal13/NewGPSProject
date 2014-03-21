package com.seed;

import android.telephony.SmsManager;
import android.util.Log;



public class Sms {
	
	public void sendSmsMessage(String straddress,String strmsg)
	{
		Log.i("sms","before sending");
		SmsManager smsMgr=SmsManager.getDefault();
		smsMgr.sendTextMessage(straddress, null,strmsg, null,null);
		
		Log.i("sms","sms sent");
	}
}


