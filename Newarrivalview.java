package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Newarrivalview extends Activity {

	DatabaseHelper mydb=new DatabaseHelper(this);
	TableLayout tl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newarrivalview);
		tl=(TableLayout)findViewById(R.id.tableyout);
		TableRow rowheader=new TableRow(this);
		rowheader.setBackgroundColor(Color.parseColor("#c0c0c0"));
		rowheader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
		String[] headerText={"BOOKNAME","DEPT","SEM","ISBN"};
		for(String c:headerText){
			TextView tv=new TextView(this);
			tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
		    tv.setGravity(Gravity.CENTER);
		    tv.setTextSize(18);
		    tv.setPadding(5, 5, 5, 5);
		    tv.setText(c);
		    rowheader.addView(tv);
		}
		tl.addView(rowheader);
		//get data from sqlite database and add them to table
		SQLiteDatabase db=mydb.getReadableDatabase();
		db.beginTransaction();
		try{
			String selectquery="SELECT NBNAME,NDEPT,NSEM,NISBNCODE FROM NEWARRIVAL_TABLE;";
				Cursor cursor=db.rawQuery(selectquery, null);
				if(cursor.getCount()>0){
					while(cursor.moveToNext()){
						//read columns data
							String outlet_bname=cursor.getString(cursor.getColumnIndex("NBNAME"));
							String outlet_dept=cursor.getString(cursor.getColumnIndex("NDEPT"));
							int outlet_sem=cursor.getInt(cursor.getColumnIndex("NSEM"));
							int outlet_code=cursor.getInt(cursor.getColumnIndex("NISBNCODE"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_dept,outlet_sem+"",outlet_code+""};
							for(String text:colText){
								TextView tv=new TextView(this);
								tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
								tv.setGravity(Gravity.CENTER);
							    tv.setTextSize(16);
							    tv.setPadding(5, 5, 5, 5);
							    tv.setText(text);
							    row.addView(tv);
							    
								
							}
							tl.addView(row);
							
					}
				}
				db.setTransactionSuccessful();
		}
		catch(SQLiteException e){
			e.printStackTrace();
		}
		finally{
			db.endTransaction();
			db.close();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.newarrivalview, menu);
		return true;
	}

}
