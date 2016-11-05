package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NormalSearch extends Activity {
	EditText bname,dept,sem,code;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_normal_search);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.normal_search, menu);
		return true;
	}
	  public void onBack(View view){
	    	Intent intent=new Intent(this,HomeActivity.class);
	    	startActivity(intent);
	    	
	    }
	  public void onSearch(View view){
		  bname=(EditText)findViewById(R.id.editTextbname);
		  String namesend=bname.getText().toString();
		  dept=(EditText)findViewById(R.id.editTextdept);
		  String deptsend=dept.getText().toString();
		  sem=(EditText)findViewById(R.id.editTextsem);
		  String semsend=sem.getText().toString();
		  code=(EditText)findViewById(R.id.editTextcode);
		  String codesend=code.getText().toString();
		  if(!namesend.equals("")){
	    	Intent intent=new Intent(this,Normalsearchview.class);
	    	intent.putExtra(Normalsearchview.EXTRA_NAME,namesend);
	    	startActivity(intent);
		  }
		  else if(!deptsend.equals("")){
			  Intent intent=new Intent(this,Normalsearchview.class);
		    	intent.putExtra(Normalsearchview.EXTRA_DEPT,deptsend);
		    	startActivity(intent);

		  }
		  else if(!semsend.equals("")){
			  Intent intent=new Intent(this,Normalsearchview.class);
		    	intent.putExtra(Normalsearchview.EXTRA_SEM,semsend);
		    	startActivity(intent);

		  }
		  else if(!codesend.equals("")){
			  Intent intent=new Intent(this,Normalsearchview.class);
		    	intent.putExtra(Normalsearchview.EXTRA_CODE,codesend);
		    	startActivity(intent);

		  }
		  else{
			  Toast.makeText(NormalSearch.this, "field empty",Toast.LENGTH_LONG).show();
		  }
	    }

}
