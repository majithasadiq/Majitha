package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Search extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	  public void onBack(View view){
	    	Intent intent=new Intent(this,HomeActivity.class);
	    	startActivity(intent);
	    	
	    }
	  public void onNormalsearch(View view){
	    	Intent intent=new Intent(this,NormalSearch.class);
	    	startActivity(intent);
	    	
	    }

}
