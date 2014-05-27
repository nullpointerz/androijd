package com.example.bwcapp;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;



//import com.example.bwcapp.TCPClient.OnMessageReceived;



import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

import android.widget.VideoView;
		
public class DriveActivity extends Activity implements OnClickListener {
	private static final String PREFS_NAME = "UserInfo"; 
	private SharedPreferences settings; 
	private SharedPreferences.Editor editor;
	public static Socket socket;
	public static final int SERVERPORT = 50007;
	public static final String SERVER_IP = "129.16.200.20";
	VideoView videoView;
	Uri uri;
	wSocket ws;
	wSocket webSocket = new wSocket();
	public final String wsuri = "ws://192.168.2.10:80/Simulator";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drive);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
		Button b4 = (Button) findViewById(R.id.saveLoc1);
		Button b5 = (Button) findViewById(R.id.saveLoc2);
		Button b6 = (Button) findViewById(R.id.forwardbutton);
		Button b9 = (Button) findViewById(R.id.leftbutton);
		Button b7 = (Button) findViewById(R.id.rightbutton);
		Button b8 = (Button) findViewById(R.id.reversebutton);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		//new Thread(new wSocket()).start();
		//start();
		
		webSocket.execute();
		String path1 = "http://podcast.20min-tv.ch/podcast/20min/199693.mp4";
		String path2 = "rtsp://217.146.95.166:554/playlist/ch12zqcif.3gp";
		String path4 = "http://www.nps.gov/features/yell/live/live4.htm";
		String path5 = "192.168.0.16:8080";
		String path6 = "http://192.168.2.5:8080";
		Uri uri=Uri.parse(path6);
		//SERVER_IP = getLocalIpAddress();
		//VideoView video=(VideoView)findViewById(R.id.VideoView);
		//video.setVideoURI(uri);
		//video.start();
	
		
	}
	
		
		     
		  
	 


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.saveLoc1:
		webSocket.mConnection.sendTextMessage("stop");		
		break;
		
		case R.id.saveLoc2:
			 ws.mConnection.sendTextMessage("Hello, world!");
					
		Log.d("hej","då22");
		break;
		case R.id.forwardbutton:
			
			webSocket.mConnection.sendTextMessage("forward");
			
			Log.d("korv", "ska");
		break;
		case R.id.leftbutton:
			webSocket.mConnection.sendTextMessage("left");
			
		break;
		case R.id.rightbutton:
			webSocket.mConnection.sendTextMessage("right");
				
		break;
		case R.id.reversebutton:
			webSocket.mConnection.sendTextMessage("back");
			
		break;
		}
	}

//socket taken from autobahn
class wSocket extends AsyncTask<Void, Void, Void> {

	public final WebSocketConnection mConnection = new WebSocketConnection();


		 final String wsuri = "ws://192.168.2.4:50007";
		 
		 

	@Override
	protected Void doInBackground(Void... arg0) {
		
		 
		   try {
		      mConnection.connect(wsuri, new WebSocketHandler() {

		         @Override
		         public void onOpen() {
		            Log.d("", "Status: Connected to " + wsuri);
		          //mConnection.sendTextMessage("forward");
		          //mConnection.disconnect();
		          
		         }

		         @Override
		         public void onTextMessage(String payload) {
		            Log.d("", "Got echo: " + payload);
		         }

		         @Override
		         public void onClose(int code, String reason) {
		            Log.d("", "Connection lost.");
		            Log.d("", reason);
		         }
		      });
		   } catch (Exception e) {

		      Log.d("", e.toString());
		   }
		
	
		return null;
	}
}
}
/*class wSocket2 extends AsyncTask<Void, Void, Void> {

	public final WebSocketConnection mConnection = new WebSocketConnection();


		 final String wsuri = "ws://192.168.2.13:80/Simulator";
		 
		 

	@Override
	protected Void doInBackground(Void... arg0) {
		
		 
		   try {
		      mConnection.connect(wsuri, new WebSocketHandler() {

		         @Override
		         public void onOpen() {
		            Log.d("", "Status: Connected to " + wsuri);
		          mConnection.sendTextMessage("left");
		          mConnection.disconnect();
		          
		         }

		         @Override
		         public void onTextMessage(String payload) {
		            Log.d("", "Got echo: " + payload);
		         }

		         @Override
		         public void onClose(int code, String reason) {
		            Log.d("", "Connection lost.");
		            Log.d("", reason);
		         }
		      });
		   } catch (Exception e) {

		      Log.d("", e.toString());
		   }
		
	
		return null;
	}
	}

class wSocket3 extends AsyncTask<Void, Void, Void> {

	public final WebSocketConnection mConnection = new WebSocketConnection();


		 final String wsuri = "ws://192.168.2.13:80/Simulator";
		 
		 

	@Override
	protected Void doInBackground(Void... arg0) {
		
		 
		   try {
		      mConnection.connect(wsuri, new WebSocketHandler() {

		         @Override
		         public void onOpen() {
		            Log.d("", "Status: Connected to " + wsuri);
		          mConnection.sendTextMessage("right");
		          mConnection.disconnect();
		          
		         }

		         @Override
		         public void onTextMessage(String payload) {
		            Log.d("", "Got echo: " + payload);
		         }

		         @Override
		         public void onClose(int code, String reason) {
		            Log.d("", "Connection lost.");
		            Log.d("", reason);
		         }
		      });
		   } catch (Exception e) {

		      Log.d("", e.toString());
		   }
		
	
		return null;
	}
	}
class wSocket4 extends AsyncTask<Void, Void, Void> {

	public final WebSocketConnection mConnection = new WebSocketConnection();


		 final String wsuri = "ws://192.168.2.13:80/Simulator";
		 
		 

	@Override
	protected Void doInBackground(Void... arg0) {
		
		 
		   try {
		      mConnection.connect(wsuri, new WebSocketHandler() {

		         @Override
		         public void onOpen() {
		            Log.d("", "Status: Connected to " + wsuri);
		          mConnection.sendTextMessage("back");
		          mConnection.disconnect();
		          
		         }

		         @Override
		         public void onTextMessage(String payload) {
		            Log.d("", "Got echo: " + payload);
		         }

		         @Override
		         public void onClose(int code, String reason) {
		            Log.d("", "Connection lost.");
		            Log.d("", reason);
		         }
		      });
		   } catch (Exception e) {

		      Log.d("", e.toString());
		   }
		
	
		return null;
	}
	}
}
	// deadcode was going to be used to store information in the phone
	/*private void saveLoc(){
		
		settings = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE); 
        editor = settings.edit();
        int i = 0;
        int j = settings.getInt("nrloc" , i);
        editor.putInt("nrloc" + settings.getInt("nrloc" , i), 1);
        editor.putInt("nrloc", j+1);
        editor.commit();
        Log.d("", j + "korv");
		
	}*/


// Old attempts and working sockets before using websockets
/*try {
PrintWriter out = new PrintWriter(new BufferedWriter(
new OutputStreamWriter(socket.getOutputStream())),true);
out.println("forward");
out.flush();
out.close();
} catch (UnknownHostException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (Exception e) {
 e.printStackTrace();

}*/
/*public String getLocalIpAddress()
{
    try 
    {
        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)
        {
            NetworkInterface intf = en.nextElement();
            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
            {
                InetAddress inetAddress = enumIpAddr.nextElement();
                if (!inetAddress.isLoopbackAddress()) 
                {
                    return inetAddress.getHostAddress().toString();
                }
            }
        }
    } 
    catch (SocketException ex)
    {
        Log.e("", ex.toString());
    }
    return "";
}   
}*/
/*class ClientThread implements Runnable {
	
        @Override

        public void run() {

            try {
                InetAddress serverAddr = InetAddress.getByName(DriveActivity.SERVER_IP);
                DriveActivity.socket = new Socket(serverAddr, DriveActivity.SERVERPORT);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }



/*class ClientOutput {
	Socket socket;
	PrintWriter out;
	public void ClientOutputs(){
		try { //192.168.1.100
			socket = new Socket("127.0.0.1", 50007);
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception ex) {

		}
	}

	public void send2pi (String GUIinput){
		out.println(GUIinput);
	}

	public void send2pi (int[] GUIinput){
		out.println(GUIinput);
	}

	public void close(){
		out.close();
	}
}
*/


 /* class MyClientTask extends AsyncTask<Void, Void, Void> {
    	  
    	  String dstAddress;
    	  int dstPort;
    	  String response = "";
    	  
    	  MyClientTask(String addr, int port){
    	   dstAddress = "90.231.28.63";
    	   dstPort = 50007;
    	  }

    	  @Override
    	  protected Void doInBackground(Void... arg0) {
    	   
    	   Socket socket = null;
    	   
    	   try {
    	    socket = new Socket(dstAddress, dstPort);
    	    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
    	    pw.write("forward");
    	    pw.flush();
    	    pw.close();
    	    ByteArrayOutputStream byteArrayOutputStream = 
    	                  new ByteArrayOutputStream(1024);
    	    
    	    byte[] buffer = new byte[1024];
    	    
    	    int bytesRead;
    	    InputStream inputStream = socket.getInputStream();
    	    
    	    /*
    	     * notice:
    	     * inputStream.read() will block if no data return
    	     */
    	       /*      while ((bytesRead = inputStream.read(buffer)) != -1){
    	                 byteArrayOutputStream.write(buffer, 0, bytesRead);
    	                 
    	                 response += byteArrayOutputStream.toString("UTF-8");
    	             }
    	             
    	   } catch (UnknownHostException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	    response = "UnknownHostException: " + e.toString();
    	   } catch (IOException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	    response = "IOException: " + e.toString();
    	   }finally{
    	    if(socket != null){
    	     try {
    	      socket.close();
    	     } catch (IOException e) {
    	      // TODO Auto-generated catch block
    	      e.printStackTrace();
    	     }
    	    }
    	   }
    	   return null;
    	  }*/

    	 // @Override
    	 // protected void onPostExecute(Void result) {
    	   //textResponse.setText(response);
    	  // super.onPostExecute(result);
    	 // }
    	  
    	 //}

    	
