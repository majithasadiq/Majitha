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

public class Normalsearchview extends Activity {
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
		setContentView(R.layout.activity_normalsearchview);
		Intent intent=getIntent();
		String namereceive=intent.getStringExtra(EXTRA_NAME);
		Intent intent1=getIntent();
		String deptreceive=intent1.getStringExtra(EXTRA_DEPT);
		Intent intent2=getIntent();
		String semreceive=intent2.getStringExtra(EXTRA_SEM);
		Intent intent3=getIntent();
		String codereceive=intent3.getStringExtra(EXTRA_CODE);
		//bname=(EditText)findViewById(R.id.editTextbname);
		tl=(TableLayout)findViewById(R.id.tablenormal);
		TableRow rowheader=new TableRow(this);
		rowheader.setBackgroundColor(Color.parseColor("#c0c0c0"));
		rowheader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
		String[] headerText={"BOOKNAME","DEPT","SEM","ISBN","STATUS"};
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
				Cursor cursor=db.rawQuery("select BNAME,DEPT,SEM,ISBNCODE,STATUS from BOOK_TABLE where BNAME=?", new String[]{namereceive});
				if(cursor.getCount()>0){
					while(cursor.moveToNext()){
						//read columns data
							String outlet_bname=cursor.getString(cursor.getColumnIndex("BNAME"));
							String outlet_dept=cursor.getString(cursor.getColumnIndex("DEPT"));
							int outlet_sem=cursor.getInt(cursor.getColumnIndex("SEM"));
							int outlet_code=cursor.getInt(cursor.getColumnIndex("ISBNCODE"));
							String outlet_status=cursor.getString(cursor.getColumnIndex("STATUS"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_dept,outlet_sem+"",outlet_code+"",outlet_status};
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
			else if(!deptreceive.equals("message")){
				Cursor cursor1=db.rawQuery("select BNAME,DEPT,SEM,ISBNCODE,STATUS from BOOK_TABLE where DEPT=?", new String[]{deptreceive});
				if(cursor1.getCount()>0){
					while(cursor1.moveToNext()){
						//read columns data
							String outlet_bname=cursor1.getString(cursor1.getColumnIndex("BNAME"));
							String outlet_dept=cursor1.getString(cursor1.getColumnIndex("DEPT"));
							int outlet_sem=cursor1.getInt(cursor1.getColumnIndex("SEM"));
							int outlet_code=cursor1.getInt(cursor1.getColumnIndex("ISBNCODE"));
							String outlet_status=cursor1.getString(cursor1.getColumnIndex("STATUS"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_dept,outlet_sem+"",outlet_code+"",outlet_status};
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
			else if(!semreceive.equals("message")){
				Cursor cursor2=db.rawQuery("select BNAME,DEPT,SEM,ISBNCODE,STATUS from BOOK_TABLE where SEM=?", new String[]{semreceive});
				if(cursor2.getCount()>0){
					while(cursor2.moveToNext()){
						//read columns data
							String outlet_bname=cursor2.getString(cursor2.getColumnIndex("BNAME"));
							String outlet_dept=cursor2.getString(cursor2.getColumnIndex("DEPT"));
							int outlet_sem=cursor2.getInt(cursor2.getColumnIndex("SEM"));
							int outlet_code=cursor2.getInt(cursor2.getColumnIndex("ISBNCODE"));
							String outlet_status=cursor2.getString(cursor2.getColumnIndex("STATUS"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_dept,outlet_sem+"",outlet_code+"",outlet_status};
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
			else if(!codereceive.equals("message")){
				Cursor cursor3=db.rawQuery("select BNAME,DEPT,SEM,ISBNCODE,STATUS from BOOK_TABLE where CODE=?", new String[]{codereceive});
				if(cursor3.getCount()>0){
					while(cursor3.moveToNext()){
						//read columns data
							String outlet_bname=cursor3.getString(cursor3.getColumnIndex("BNAME"));
							String outlet_dept=cursor3.getString(cursor3.getColumnIndex("DEPT"));
							int outlet_sem=cursor3.getInt(cursor3.getColumnIndex("SEM"));
							int outlet_code=cursor3.getInt(cursor3.getColumnIndex("ISBNCODE"));
							String outlet_status=cursor3.getString(cursor3.getColumnIndex("STATUS"));
							TableRow row=new TableRow(this);
							row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
							String[] colText={outlet_bname,outlet_dept,outlet_sem+"",outlet_code+"",outlet_status};
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
		getMenuInflater().inflate(R.menu.normalsearchview, menu);
		return true;
	}

}
