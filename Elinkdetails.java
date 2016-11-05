package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Elinkdetails extends Activity {

	DatabaseHelper myEdb;
	EditText editebid,editebname,editedept,editesem,editecode,editeelink;
	Button beinsert,bedelete,beupdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elinkdetails);
		myEdb=new DatabaseHelper(this);
		editebid=(EditText)findViewById(R.id.editTextebid);
		editebname=(EditText)findViewById(R.id.editTextebname);
		editedept=(EditText)findViewById(R.id.editTextedept);
		editesem=(EditText)findViewById(R.id.editTextesem);
		editecode=(EditText)findViewById(R.id.editTextecode);
		editeelink=(EditText)findViewById(R.id.editTexteelink);
		beinsert=(Button)findViewById(R.id.buttoneinsert);
		bedelete=(Button)findViewById(R.id.buttonedelete);
		beupdate=(Button)findViewById(R.id.buttoneupdate);
		addedata();
		deleteedata();
		updateedata();
	}
	public void addedata(){
		beinsert.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						boolean isInserted=myEdb.insertebook(editebid.getText().toString(),editebname.getText().toString(), editedept.getText().toString(), editesem.getText().toString(),editecode.getText().toString(),editeelink.getText().toString());
						if(isInserted==true){
							Toast.makeText(Elinkdetails.this,"Data inserted",Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(Elinkdetails.this,"Data not inserted",Toast.LENGTH_LONG).show();
							
						}
						
					}
				}
				);
	}
     public void deleteedata(){
    	 bedelete.setOnClickListener(
    			 new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Integer rowsdeleted=myEdb.deleteebook(editebid.getText().toString());
						if(rowsdeleted>0){
							Toast.makeText(Elinkdetails.this,"Data deleted",Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(Elinkdetails.this,"Data not deleted",Toast.LENGTH_LONG).show();
						}
						
					}
				});
    	 
     }
    
     public void updateedata(){
 		beupdate.setOnClickListener(
 				new View.OnClickListener() {
 					
 					@Override
 					public void onClick(View v) {
 						boolean isupdated=myEdb.updateebook(editebid.getText().toString(),editebname.getText().toString(), editedept.getText().toString(), editesem.getText().toString(),editecode.getText().toString(),editeelink.getText().toString());
 						if(isupdated==true){
 							Toast.makeText(Elinkdetails.this,"Data updated",Toast.LENGTH_LONG).show();
 						}
 						else{
 							Toast.makeText(Elinkdetails.this,"Data not updated",Toast.LENGTH_LONG).show();
 							
 						}
 						
 					}
 				}
 				);
 	}
     
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.elinkdetails, menu);
		return true;
	}
	public void onBack(View view){
    	Intent intent=new Intent(this,AdminHome.class);
    	startActivity(intent);
    	
    }
 

}
