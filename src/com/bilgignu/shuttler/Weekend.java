package com.bilgignu.shuttler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Weekend extends Activity {

	Button ok;
	final Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weekend);
		addListenerOnButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weekend, menu);
		return true;
	}
	
	public void addListenerOnButtons(){
		ok = (Button) findViewById(R.id.we_ok_but);
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
			}
		});
	}

}
