package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	  public void onSearch(View view){
	    	Intent intent=new Intent(this,NormalSearch.class);
	    	startActivity(intent);
	    	
	    }
	  public void onElink(View view){
	    	Intent intent=new Intent(this,Elink.class);
	    	startActivity(intent);
	    	
	    }
	  public void onLogin(View view){
	    	Intent intent=new Intent(this,Loginhome.class);
	    	startActivity(intent);
	    	
	    }
	  public void onNewarrival(View view){
	    	Intent intent=new Intent(this,Newarrivalview.class);
	    	startActivity(intent);
	    	
	    }

}
