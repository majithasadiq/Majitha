package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	DatabaseHelper mydb;
	EditText uname,pass;
	String username,password,storedpassword;
	Button blogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mydb=new DatabaseHelper(this);
		uname=(EditText)findViewById(R.id.editTextulusername);
		pass=(EditText)findViewById(R.id.editTextulpassword);
		blogin=(Button)findViewById(R.id.buttonullogin);
		check();
		
	}
	public void check(){
		blogin.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
		
						 username=uname.getText().toString();
						 password=pass.getText().toString();
						 storedpassword=mydb.getpassword(username);
					/*	if(username.equals("")){
							Toast.makeText(Login.this, "username can't be empty",Toast.LENGTH_LONG).show();
						}
						else if(password.equals("")){
							Toast.makeText(Login.this, "password can't be empty",Toast.LENGTH_LONG).show();
						}
						else */if(password.equals(storedpassword)){
							Toast.makeText(Login.this, "login successfull",Toast.LENGTH_LONG).show();
							Intent intent=new Intent(Login.this,Loginview.class);
					    	startActivity(intent);
					    
						}
						else{
							Toast.makeText(Login.this, "username or password incorrect",Toast.LENGTH_LONG).show();
						}
						
						
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	  public void onBack(View view){
	    	Intent intent=new Intent(this,Loginhome.class);
	    	startActivity(intent);
	    	
	    }
	  public void onSignup(View view){
	    	Intent intent=new Intent(this,Signup.class);
	    	startActivity(intent);
	    	
	    }
}
