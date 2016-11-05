package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
		
		private static Button button_ex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonexitlistener();
    }

    public void onButtonexitlistener(){
    	button_ex=(Button)findViewById(R.id.button_exit);
    	button_ex.setOnClickListener(
    			new View.OnClickListener() {
					

    				@Override
					public void onClick(View v) {
							AlertDialog.Builder a_builder=new AlertDialog.Builder(MainActivity.this);
							a_builder.setMessage("Do you want to close this App!!").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int arg1) {
											finish();
									
								}
							})
							.setNegativeButton("No", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int arg1) {
										dialog.cancel();
								}
							});
							AlertDialog alert=a_builder.create();
							alert.setTitle("Alert!!");
							alert.show();
					}
					
				}
    			
    		);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClickHere(View view){
    	Intent intent=new Intent(this,HomeActivity.class);
    	startActivity(intent);
    	
    }
    
    
}
