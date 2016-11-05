package com.example.mobilelibrary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Elinkview extends Activity {
	public static final String EXTRA_NAME="message";
	public static final String EXTRA_DEPT="message";
	public static final String EXTRA_SEM="message";
	public static final String EXTRA_CODE="message";
	DatabaseHelper mydb=new DatabaseHelper(this);
	EditText bname;
	TableLayout tl;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elinkview);
		Intent intent=getIntent();
		String namereceive=intent.getStringExtra(EXTRA_NAME);
		Intent intent1=getIntent();
		String deptreceive=intent1.getStringExtra(EXTRA_DEPT);
		Intent intent2=getIntent();
		String semreceive=intent2.getStringExtra(EXTRA_SEM);
		Intent intent3=getIntent();
		String codereceive=intent3.getStringExtra(EXTRA_CODE);
		
		//bname=(EditText)findViewById(R.id.editTextbname);
		tl=(TableLayout)findViewById(R.id.tableelink);
		TableRow rowheader=new TableRow(this);
		rowheader.setBackgroundColor(Color.parseColor("#c0c0c0"));
		rowheader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
		String[] headerText={"BOOKNAME","ISBN","ELINK"};
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
		//	String selectquery="SELECT NBNAME,NDEPT,NSEM,NISBNCODE FROM NEWARRIVAL_TABLE;";
			
		//	String name=bname.getText().toString();
			if(!namereceive.equals("message")){
				Cursor cursor=db.rawQuery("select EBNAME,ECODE,LINK from ELINK_TABLE where EBNAME=?", new String[]{namereceive});
				if(cursor.getCount()>0){
					while(cursor.moveToNext()){
						//read columns data
							String outlet_bname=cursor.getString(cursor.getColumnIndex("EBNAME"));
						//	String outlet_dept=cursor.getString(cursor.getColumnIndex("EDEPT"));
						//	int outlet_sem=cursor.getInt(cursor.getColumnIndex("ESEM"));
							int outlet_code=cursor.getInt(cursor.getColumnIndex("ECODE"));
							String outlet_status=cursor.getString(cursor.getColumnIndex("LINK"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_code+"",outlet_status};
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
			}
			else if(!deptreceive.equals("message")){
				Cursor cursor3=db.rawQuery("select EBNAME,ECODE,LINK from ELINK_TABLE where EDEPT=?", new String[]{deptreceive});
				if(cursor3.getCount()>0){
					while(cursor3.moveToNext()){
						//read columns data
							String outlet_bname=cursor3.getString(cursor3.getColumnIndex("EBNAME"));
						//	String outlet_dept=cursor.getString(cursor.getColumnIndex("EDEPT"));
						//	int outlet_sem=cursor.getInt(cursor.getColumnIndex("ESEM"));
							int outlet_code=cursor3.getInt(cursor3.getColumnIndex("ECODE"));
							String outlet_status=cursor3.getString(cursor3.getColumnIndex("LINK"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_code+"",outlet_status};
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
			}
			else if(!semreceive.equals("message")){
				Cursor cursor2=db.rawQuery("select EBNAME,ECODE,LINK from ELINK_TABLE where ESEM=?", new String[]{semreceive});
				if(cursor2.getCount()>0){
					while(cursor2.moveToNext()){
						//read columns data
							String outlet_bname=cursor2.getString(cursor2.getColumnIndex("EBNAME"));
			//				String outlet_dept=cursor2.getString(cursor2.getColumnIndex("EDEPT"));
				//			int outlet_sem=cursor.getInt(cursor.getColumnIndex("ESEM"));
							int outlet_code=cursor2.getInt(cursor2.getColumnIndex("ECODE"));
							String outlet_status=cursor2.getString(cursor2.getColumnIndex("LINK"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_code+"",outlet_status};
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
				}
				else if(!codereceive.equals("message")){
					Cursor cursor1=db.rawQuery("select EBNAME,ECODE,LINK from ELINK_TABLE where ECODE=?", new String[]{codereceive});
					if(cursor1.getCount()>0){
						while(cursor1.moveToNext()){
							//read columns data
								String outlet_bname=cursor1.getString(cursor1.getColumnIndex("EBNAME"));
						//		String outlet_dept=cursor.getString(cursor.getColumnIndex("EDEPT"));
							//	int outlet_sem=cursor.getInt(cursor.getColumnIndex("ESEM"));
								int outlet_code=cursor1.getInt(cursor1.getColumnIndex("ECODE"));
								String outlet_status=cursor1.getString(cursor1.getColumnIndex("LINK"));
								TableRow row=new TableRow(this);
								row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
								String[] colText={outlet_bname,outlet_code+"",outlet_status};
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
		getMenuInflater().inflate(R.menu.elinkview, menu);
		return true;
	}

}
