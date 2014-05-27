package com.example.bwcapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	
	 Button btn5 = (Button) findViewById(R.id.Forum);	
     btn5.setOnClickListener(this);
     Button btn6 = (Button) findViewById(R.id.Mail);
     btn6.setOnClickListener(this);
     
	}
         public void onClick(View v) {
        	 switch(v.getId()) {
             case R.id.Forum:
            	 Intent bwcForum = new Intent(android.content.Intent.ACTION_VIEW);
                 bwcForum.setData(Uri.parse("http://imgur.com/OVYbZlL"));
                 startActivity(bwcForum);
             break;
             case R.id.Mail:
            	 Intent mailService = new Intent(Intent.ACTION_SEND);
                 mailService.setType("plain/text");
                 mailService.putExtra(Intent.EXTRA_EMAIL, new String[] { "bwc@gmail.com" });
                 mailService.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                 mailService.putExtra(Intent.EXTRA_TEXT, "Message here");
                 startActivity(Intent.createChooser(mailService, ""));
             break;
        	
        	 }   

         }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

}
