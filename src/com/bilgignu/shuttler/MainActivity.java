package com.bilgignu.shuttler;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button kus,dol,san,kab,pan,hal,top; 
	final Context context = this;
	private static boolean firstTime = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(firstTime){
			firstTime=false;
			checkWeekend();
		}
		addListenerOnButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void checkWeekend(){
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY){
        	Intent intent = new Intent(context, Weekend.class);
            startActivity(intent);
        }
	}
	
	public void addListenerOnButtons(){
		kus = (Button) findViewById(R.id.bKus);
		dol = (Button) findViewById(R.id.bDol);
		san = (Button) findViewById(R.id.bSan);
		kab = (Button) findViewById(R.id.bKab);
		pan = (Button) findViewById(R.id.bPan);
		hal = (Button) findViewById(R.id.bHal);
		top = (Button) findViewById(R.id.bTop);
		
		kus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, From_Kus.class);
                startActivity(intent);
			}
		});
		
	}

}
