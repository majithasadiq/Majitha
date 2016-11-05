package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {

		DatabaseHelper  mydbuser;
		EditText editname,edituname,editpass,editrpass,editdept,editsem,editmail;
		Button bsignup;
		String name,uname,pass,rpass,dept,sem,mail,mailpattern;
		//int s;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		mydbuser=new DatabaseHelper(this);
		editname=(EditText)findViewById(R.id.name);
		edituname=(EditText)findViewById(R.id.uname);
		editpass=(EditText)findViewById(R.id.pass);
		editrpass=(EditText)findViewById(R.id.rpass);
		editdept=(EditText)findViewById(R.id.dept);
		editsem=(EditText)findViewById(R.id.sem);
		editmail=(EditText)findViewById(R.id.mail);
		bsignup=(Button)findViewById(R.id.buttonsignup);
		adduserdata();
		
	
	}
	public void adduserdata(){
		bsignup.setOnClickListener(
				new View.OnClickListener() {
					
					public void onClick(View v){
						 name=editname.getText().toString();
							uname=edituname.getText().toString();
							 pass=editpass.getText().toString();
							 rpass=editrpass.getText().toString();
							 dept=editdept.getText().toString();
							 sem=editsem.getText().toString();
							// s=Integer.parseInt(sem);
							mail=editmail.getText().toString();
							mailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";
							
							
						
						if(name.equals("")||uname.equals("")||pass.equals("")||rpass.equals("")||dept.equals("")||sem.equals("")||mail.equals("")){
							Toast.makeText(Signup.this,"please enter the empty fields",Toast.LENGTH_LONG).show();
							
						}
						else if(!pass.equals(rpass)){
			                   Toast.makeText(Signup.this,"pasword and confirm password not match",Toast.LENGTH_LONG).show();
						}
					/*	else if(!dept.equals("cse")||!dept.equals("ece")||!dept.equals("eee")||!dept.equals("arch")||!dept.equals("it")||!dept.equals("mech")||!dept.equals("mca")||!dept.equals("msc")){
							Toast.makeText(Signup.this,"enter the valid department name",Toast.LENGTH_LONG).show();
						}
					/*	if(s<=0){
							Toast.makeText(Signup.this,"enter the valid semester",Toast.LENGTH_LONG).show();
						}
						else if((dept.equals("cse")||dept.equals("ece")||dept.equals("eee")||dept.equals("it")||dept.equals("mech"))&&(s>=9)){
							Toast.makeText(Signup.this,"enter the valid semester",Toast.LENGTH_LONG).show();
						}
						else if(s>=11){
							Toast.makeText(Signup.this,"enter the valid semester",Toast.LENGTH_LONG).show();
						}*/
						else if(!mail.matches(mailpattern)){
							Toast.makeText(Signup.this,"enter the valid mail address",Toast.LENGTH_LONG).show();
						}
						else{
							
						boolean isInserted=mydbuser.userdata(editname.getText().toString(),edituname.getText().toString(),editpass.getText().toString(),editrpass.getText().toString(),editdept.getText().toString(),editsem.getText().toString(),editmail.getText().toString());
						if(isInserted==true){
							Toast.makeText(Signup.this,"succesfully registered",Toast.LENGTH_LONG).show();
							Intent intent=new Intent(Signup.this,Login.class);
					    	startActivity(intent);
					    
						}
						else{
							Toast.makeText(Signup.this,"Data not inserted",Toast.LENGTH_LONG).show();
						}
					}
				}
				}
				);
					
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}
	  public void onBack(View view){
	    	Intent intent=new Intent(this,Login.class);
	    	startActivity(intent);
	    	
	    }
	 /* public void onSignup(View view){
	    	Intent intent=new Intent(this,Login.class);
	    	startActivity(intent);
	    	

	    }*/
}
