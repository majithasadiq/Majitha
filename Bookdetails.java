package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bookdetails extends Activity {

		DatabaseHelper mydb;
		EditText editBname,editDept,editSem,editIsbncode,editBid,editStatus;
		Button binsert,bdelete,bupdate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bookdetails);
		mydb=new DatabaseHelper(this);
		editBid=(EditText)findViewById(R.id.editTextbid);
		editBname=(EditText)findViewById(R.id.editTextbname);
		editDept=(EditText)findViewById(R.id.editTextdept);
		editSem=(EditText)findViewById(R.id.editTextsem);
		editIsbncode=(EditText)findViewById(R.id.editTextcode);
		editStatus=(EditText)findViewById(R.id.editTextstatus);
		binsert=(Button)findViewById(R.id.buttonadd);
		bdelete=(Button)findViewById(R.id.buttondelete);
		bupdate=(Button)findViewById(R.id.buttonupdate);
		adddata();
		deletedata();
		updatedata();
	}
	public void adddata(){
		binsert.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						boolean isInserted=mydb.insertdata(editBid.getText().toString(),editBname.getText().toString(), editDept.getText().toString(), editSem.getText().toString(),editIsbncode.getText().toString(),editStatus.getText().toString());
						if(isInserted==true){
							Toast.makeText(Bookdetails.this,"Data inserted",Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(Bookdetails.this,"Data not inserted",Toast.LENGTH_LONG).show();
							
						}
						
					}
				}
				);
	}
     public void deletedata(){
    	 bdelete.setOnClickListener(
    			 new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Integer rowsdeleted=mydb.deletebook(editBid.getText().toString());
						if(rowsdeleted>0){
							Toast.makeText(Bookdetails.this,"Data deleted",Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(Bookdetails.this,"Data not deleted",Toast.LENGTH_LONG).show();
						}
						
					}
				});
    	 
     }
     public void updatedata(){
    	 bupdate.setOnClickListener(
    			 new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						boolean isupdated=mydb.updatebook(editBid.getText().toString(),editBname.getText().toString(), editDept.getText().toString(), editSem.getText().toString(),editIsbncode.getText().toString(),editStatus.getText().toString());
						if(isupdated==true){
							Toast.makeText(Bookdetails.this,"Data updated",Toast.LENGTH_LONG).show();
						}
						else{
							Toast.makeText(Bookdetails.this,"Data not updated",Toast.LENGTH_LONG).show();
							
						}
						
						
					}
				});
     }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bookdetails, menu);
		return true;
	}
	  public void onBack(View view){
	    	Intent intent=new Intent(this,AdminHome.class);
	    	startActivity(intent);
	    	
	    }
}
