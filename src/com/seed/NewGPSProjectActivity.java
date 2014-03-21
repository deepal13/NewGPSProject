package com.seed;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewGPSProjectActivity extends Activity {
	/** Called when the activity is first created. */
	int time;
	Intent intent;
	PendingIntent pendingIntent;
	AlarmManager alarmManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
    }
    
    public void startAlert(View view) {
    			start();
	}
	
    public void start() {
		// TODO Auto-generated method stub
		EditText text1 = (EditText) findViewById(R.id.editText1);//number
		EditText text2 = (EditText) findViewById(R.id.editText2);//time
        
		String to = text1.getText().toString();
		time = Integer.parseInt(text2.getText().toString());
		
		Intent intent = new Intent(this, Broadcast_receiver.class);
		intent.putExtra("ToKey", to);
		
		
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
		
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(time*1000),(time*1000), pendingIntent);
		
		Toast.makeText(this, "alarm set",Toast.LENGTH_SHORT).show();


		
	}
    
}