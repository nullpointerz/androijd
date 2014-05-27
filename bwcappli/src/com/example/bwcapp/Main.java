package com.example.bwcapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainpage);
		Button b1 = (Button) findViewById(R.id.StartDriving);
		Button b2 = (Button) findViewById(R.id.RecentLocations);
		Button b3 = (Button) findViewById(R.id.About); 
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.StartDriving:
			Intent intent = new Intent(this, DriveActivity.class);
		startActivity(intent);
		    break;
		case R.id.RecentLocations:
			Intent intent2 = new Intent(this, RecentLocations.class);
			startActivity(intent2);
			
			break;
		case R.id.About:
			Intent intent3 = new Intent(this, AboutActivity.class);
			startActivity(intent3);
			Log.d("FARBROR", "Månad");
			break;
		}
	
			}
		
	}


