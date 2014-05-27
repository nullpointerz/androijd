package com.example.bwcapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class RecentLocations extends Activity {
	private static final String PREFS_NAME = "UserInfo"; 
	private SharedPreferences settings; 
	private SharedPreferences.Editor editor;
	private int numberlocations;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recent_locations);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		final String url = "http://90.231.28.63/phpMyAdmin/getDBinfo.php";

		InputStream is = null;
		String result = "";
		//the year data to send
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("Account","Password"));
		 
		//http post
		try{
		        HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost(url);
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost);
		        HttpEntity entity = response.getEntity();
		        Log.d("", "kuk" + entity.isStreaming());
		        Log.d("", "kuken" + entity.getContentType());
		        is = entity.getContent();
		}catch(Exception e){
		        Log.e("log_tag", "Error in http connection "+e.toString());
		}
		//convert response to string
		try{
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
		        StringBuilder sb = new StringBuilder();
		        String line = null;
		        int i = 0;
		        while ((line = reader.readLine()) != null) {
		                sb.append(line + "\n");
		                i++;
		                Log.d("hehe", "snabb" + i);
		        }
		        is.close();
		        Log.d("vv","eee" + line);
		        result=sb.toString();
		}catch(Exception e){
		        Log.e("log_tag", "Error converting result "+e.toString());
		}
		 
		//parse json data
		try{
		        /*JSONArray jArray = new JSONArray(result);
		        for(int i=0;i<jArray.length();i++){
		                JSONObject json_data = jArray.getJSONObject(i);
		                Log.i("log_tag","id: "+json_data.getInt("ID")+
		                        ", Account: "+json_data.getString("Account")+
		                        ", Password: "+json_data.getString("Password")*/
		                        JSONObject  jobj  = new JSONObject(result);
		                String acc = jobj.getString("Account");
		                String pass = jobj.getString("Password");
		               /* String user_id = jobj.getString("user_id");
		                String userRank = jobj.getString("userRank");
		                String user_id = jobj.getString("user_id"); */
		                Log.d("he", "he" + acc);
		                Log.d("he", "he222" + pass);
		        
		
		}catch(JSONException e){
		        Log.e("log_tag", "Error parsing data "+e.toString());
		}
	
	}

		          
	
	private void loadLocations(){
		settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE); 
        editor = settings.edit();
        int i = 0;
        numberlocations = settings.getInt("nrloc" , i);
        for(int j = 0; j < numberlocations; j++){
        	showLocation(settings.getInt("nrloc" + j, i));
        }
       
		
	}
	private void showLocation(int int1) {
		// TODO Auto-generated method stub GÖRA KNAPPAR WOOO
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recent_locations, menu);
		return true;
	}

}
