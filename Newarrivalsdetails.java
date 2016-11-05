package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Newarrivalsdetails extends Activity {
	DatabaseHelper myNdb;
	EditText editnbid,editnbname,editndept,editnsem,editncode;
	Button bninsert,bndelete,bnupdate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newarrivalsdetails);
		myNdb=new DatabaseHelper(this);
		editnbid=(EditText)findViewById(R.id.editTextnabid);
		editnbname=(EditText)findViewById(R.id.editTextnabname);
		editndept=(EditText)findViewById(R.id.editTextnadept);
		editnsem=(EditText)findViewById(R.id.editTextnasem);
		editncode=(EditText)findViewById(R.id.editTextnacode);
		bninsert=(Button)findViewById(R.id.buttonnainsert);
		bndelete=(Button)findViewById(R.id.buttonnadelete);
		bnupdate=(Button)findViewById(R.id.buttonnaupdate);
		addndata();
		deletendata();
		updatendata();
	}
	public void addndata(){
		bninsert.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
					     boolean isInserted=myNdb.insertnewarrival(editnbid.getText().toString(), editnbname.getText().toString(), editndept.getText().toString(), editnsem.getText().toString(), editncode.getText().toString());
						 if(isInserted==true){
							 Toast.makeText(Newarrivalsdetails.this,"Data inserted",Toast.LENGTH_LONG).show();
						 }
						 else{
							 Toast.makeText(Newarrivalsdetails.this,"Data not inserted",Toast.LENGTH_LONG).show();
						 }
					}
				});
	}
	 public void deletendata(){
    	 bndelete.setOnClickListener(
    			 new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Integer rowsdeleted=myNdb.deletenewarrival(editnbid.getText().toString());
						if(rowsdeleted>0){
							Toast.makeText(Newarrivalsdetails.this,"Data deleted",Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(Newarrivalsdetails.this,"Data not deleted",Toast.LENGTH_LONG).show();
						}
						
					}
				});
    	 
     }
	 public void updatendata(){
			bnupdate.setOnClickListener(
					new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
						     boolean isupdated=myNdb.updatenewarrival(editnbid.getText().toString(), editnbname.getText().toString(), editndept.getText().toString(), editnsem.getText().toString(), editncode.getText().toString());
							 if(isupdated==true){
								 Toast.makeText(Newarrivalsdetails.this,"Data updated",Toast.LENGTH_LONG).show();
							 }
							 else{
								 Toast.makeText(Newarrivalsdetails.this,"Data not updated",Toast.LENGTH_LONG).show();
							 }
						}
					});
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.newarrivalsdetails, menu);
		return true;
	}
	public void onBack(View view){
    	Intent intent=new Intent(this,AdminHome.class);
    	startActivity(intent);
    	
    }
 

}
