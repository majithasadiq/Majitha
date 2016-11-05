package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity {

	EditText edituname,editpass;
	Button blogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		loginbutton();
	}
	public void loginbutton(){
		edituname=(EditText)findViewById(R.id.editText_username);
		editpass=(EditText)findViewById(R.id.editText_password);
		blogin=(Button)findViewById(R.id.button_login);
		blogin.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(edituname.getText().toString().equals("admin")&&editpass.getText().toString().equals("admin@123")){
							Toast.makeText(Admin.this,"login successfully",Toast.LENGTH_LONG).show();
							Intent intent=new Intent(Admin.this,AdminHome.class);
							startActivity(intent);
						}
						else{
							Toast.makeText(Admin.this,"username or password incorrect",Toast.LENGTH_LONG).show();
						}
						
					}
				});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}
	
	/* public void onLogin(View view){
	    	Intent intent=new Intent(this,Bookdetails.class);
	    	startActivity(intent);
	    	
	    }*/
	 public void onBack(View view){
	    	Intent intent=new Intent(this,Loginhome.class);
	    	startActivity(intent);
	    	
	    }
}
