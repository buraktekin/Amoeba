package com.bilgignu.shuttler;

import java.util.Calendar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Shuttle extends Activity {
	
	public static int hour;
	public static int minute;
	public static int beklencek;

	public String formatTime(long millis){
	    String output = "";
	    long seconds = millis / 1000;
	    long minutes = seconds / 60;
	    long hours = minutes/ 60;

	    seconds = seconds % 60;
	    minutes = minutes % 60;
	    hours = hours%60;

	    String secondsD = String.valueOf(seconds);
	    String minutesD = String.valueOf(minutes);
	    String hoursD=String.valueOf(hours);

	    if (seconds < 10)
	        secondsD = "0" + seconds;
	    if (minutes < 10)
	        minutesD = "0" + minutes;

	    if (hours < 10)
	        hoursD = "0" + hours;

	    output = hoursD+" : "+minutesD + " : " + secondsD;

	    return output;
	}
	
	public void getTime(){
		Calendar cal = Calendar.getInstance();
        
        minute = cal.get(Calendar.MINUTE);
		hour = cal.get(Calendar.HOUR_OF_DAY);
        
        if (minute >= 10 && minute < 40)
        	beklencek = (40 - minute) * 60000;
        else if (minute > 40)
        	beklencek = (70 - minute) * 60000;
        else if (minute < 10)
        	beklencek = (10 - minute) * 60000;
        
	}
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shuttle);
		getTime();
		final TextView tv =(TextView) findViewById(R.id.counter);
		CountDownTimer count = new CountDownTimer(beklencek,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				tv.setText(formatTime(millisUntilFinished));
			}
			
			@Override
			public void onFinish() {
				tv.setText("Done!");
				
			}};
			count.start();
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shuttle, menu);
		return true;
	}

}
