package com.example.bwcapp;

import android.app.Application;

public class bwcapp extends Application {
private int i = 0;
	public int getDatabase() {
		
		return i;
		
		
	}
	
	public void changeDatabase() {
	i++;
	
}	
   

}
