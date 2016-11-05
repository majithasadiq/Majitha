package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AdminHome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_home, menu);
		return true;
	}
	 public void onBookdetails(View view){
	    	Intent intent=new Intent(this,Bookdetails.class);
	    	startActivity(intent);
	    	
	    }
	 public void onNewarrivals(View view){
	    	Intent intent=new Intent(this,Newarrivalsdetails.class);
	    	startActivity(intent);
	    	
	    }
	 public void onElink(View view){
	    	Intent intent=new Intent(this,Elinkdetails.class);
	    	startActivity(intent);
	    	
	    }

}
