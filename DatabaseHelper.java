package com.example.mobilelibrary;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
  
public class DatabaseHelper  extends SQLiteOpenHelper{
	public static final String DATABASE_NAME="library.db";
	//public static final String DATABASE_USER="user.db";
	public static final int DB_VERSION= 4;
	
	//public SQLiteDatabase db;
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table BOOK_TABLE(BID INTEGER PRIMARY KEY AUTOINCREMENT ,"+"BNAME TEXT,"+"DEPT TEXT,"+"SEM INTEGER,"+"ISBNCODE INTEGER,"+"STATUS TEXT);");
		db.execSQL("create table USER_TABLE(NAME TEXT,"+"USERNAME TEXT,"+"PASSWORD TEXT,"+"REPASSWORD TEXT,"+"DEPT TEXT,"+"SEMESTER INTEGER,"+"EMAIL_ID TEXT);");
		db.execSQL("create table NEWARRIVAL_TABLE(NBID INTEGER PRIMARY KEY AUTOINCREMENT,"+"NBNAME TEXT,"+"NDEPT TEXT,"+"NSEM INTEGER,"+"NISBNCODE INTEGER);");
		db.execSQL("create table ELINK_TABLE(EBID INTEGER PRIMARY KEY AUTOINCREMENT,"+"EBNAME TEXT,"+"EDEPT TEXT,"+"ESEM INTEGER,"+"ECODE INTEGER,"+"LINK TEXT);");
		
	
	}

	public boolean insertdata(String id,String bname,String dept,String semester,String isbncode,String status){
    	SQLiteDatabase db=this.getWritableDatabase();
    	ContentValues contentvalues=new ContentValues();
    	contentvalues.put("BID", id);
    	contentvalues.put("BNAME", bname);
    	contentvalues.put("DEPT", dept);
    	contentvalues.put("SEM", semester);
    	contentvalues.put("ISBNCODE", isbncode);
     	contentvalues.put("STATUS", status);
    	long result=db.insert("BOOK_TABLE", null, contentvalues);
    	if(result==-1)
    		return false;
    	else
    		return true;
    	
    	
    }
	public boolean updatebook(String id,String bname,String dept,String semester,String isbncode,String status){
    	SQLiteDatabase db=this.getWritableDatabase();
    	ContentValues contentvalues=new ContentValues();
    	contentvalues.put("BID", id);
    	contentvalues.put("BNAME", bname);
    	contentvalues.put("DEPT", dept);
    	contentvalues.put("SEM", semester);
    	contentvalues.put("ISBNCODE", isbncode);
     	contentvalues.put("STATUS", status);
    	db.update("BOOK_TABLE",contentvalues, "BID=?",new String[] {id});
    	return true;
    	
    }
	
	public Integer deletebook(String id){
		SQLiteDatabase db=this.getWritableDatabase();
		return db.delete("BOOK_TABLE", "BID=?", new String[] {id});
		
	}
	public boolean insertnewarrival(String nid,String nbname,String ndept,String nsem,String ncode){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues nbook=new ContentValues();
		nbook.put("NBID", nid);
		nbook.put("NBNAME", nbname);
		nbook.put("NDEPT", ndept);
		nbook.put("NSEM", nsem);
		nbook.put("NISBNCODE", ncode);
		long result=db.insert("NEWARRIVAL_TABLE", null, nbook);
		if(result==-1)
			return false;
		else
			return true;
	}
	public Integer deletenewarrival(String nid){
		SQLiteDatabase db=this.getWritableDatabase();
		return db.delete("NEWARRIVAL_TABLE", "NBID=?", new String[] {nid});
	}
	public boolean updatenewarrival(String nid,String nbname,String ndept,String nsem,String ncode){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues nbook=new ContentValues();
		nbook.put("NBID", nid);
		nbook.put("NBNAME", nbname);
		nbook.put("NDEPT", ndept);
		nbook.put("NSEM", nsem);
		nbook.put("NISBNCODE", ncode);
		db.update("NEWARRIVAL_TABLE", nbook, "NBID=?", new String[]{nid});
		return true;
	}
	public boolean insertebook(String eid,String ebname,String edept,String esem,String ecode,String elink){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues ebook=new ContentValues();
		ebook.put("EBID", eid);
		ebook.put("EBNAME", ebname);
		ebook.put("EDEPT", edept);
		ebook.put("ESEM", esem);
		ebook.put("ECODE", ecode);
		ebook.put("LINK", elink);
		long result=db.insert("ELINK_TABLE", null, ebook);
		if(result==-1)
			return false;
		else
			return true;
		
	}
	public Integer deleteebook(String eid){
		SQLiteDatabase db=this.getWritableDatabase();
		return db.delete("ELINK_TABLE", "EBID=?", new String[] {eid});
	}
	public boolean updateebook(String eid,String ebname,String edept,String esem,String ecode,String elink){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues ebook=new ContentValues();
		ebook.put("EBID", eid);
		ebook.put("EBNAME", ebname);
		ebook.put("EDEPT", edept);
		ebook.put("ESEM", esem);
		ebook.put("ECODE", ecode);
		ebook.put("LINK", elink);
		db.update("ELINK_TABLE", ebook, "EBID=?", new String[]{eid});
		return true;
		
	}
	
	
	public boolean userdata(String name,String username,String password,String rpassword,String dept,String sem,String email){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues user=new ContentValues();
		user.put("NAME", name);
        user.put("USERNAME",username);
        user.put("PASSWORD",password);
        user.put("REPASSWORD",rpassword);
        user.put("DEPT",dept);
        user.put("SEMESTER",sem);
        user.put("EMAIL_ID",email);
        long result=db.insert("USER_TABLE", null,user);
        if(result==-1)
        	 return false;
        else
        	return true;
		
	}
	public String getpassword(String uname){
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.query("USER_TABLE",null,"USERNAME=?",new String[]{uname},null,null,null);
		if(cursor.getCount()<1){
			cursor.close();
			return "NOT EXIST";
		}
		cursor.moveToFirst();
		String password=cursor.getString(cursor.getColumnIndex("PASSWORD"));
		cursor.close();
		return password;
	}

	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			db.execSQL("DROP TABLE IF EXISTS BOOK_TABLE;");
			db.execSQL("DROP TABLE IF EXISTS USER_TABLE;");
			db.execSQL("DROP TABLE IF EXISTS NEWARRIVAL_TABLE;");
			db.execSQL("DROP TABLE IF EXISTS ELINK_TABLE;");
			onCreate(db);
		
	}

}