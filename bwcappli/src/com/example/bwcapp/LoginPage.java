package com.example.bwcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity implements OnClickListener {
	 	private EditText  username=null;
	 	private EditText  password=null;
	 	private Button login;

	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_loginpage);
	      username = (EditText)findViewById(R.id.editText1);
	      password = (EditText)findViewById(R.id.editText2);
	      login = (Button)findViewById(R.id.button1);
	   }

	   public void login(View view){
	      if(username.getText().toString().equals("admin") && 
	      password.getText().toString().equals("admin")){
	      Toast.makeText(getApplicationContext(), "Redirecting...", 
	      Toast.LENGTH_SHORT).show();
	      Intent intent = new Intent(this, Main.class);
	  		startActivity(intent);
	      }
	      }	  		   
	   	
	
	
     
	


	
	@Override
	public void onClick(View v) {
		 
	  		
	}
	}
