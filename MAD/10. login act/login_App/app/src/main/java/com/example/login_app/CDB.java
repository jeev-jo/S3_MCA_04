package com.example.login_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="DMS";
    public CDB(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL("create table TbContact ( sl_no integer, f_name text, s_name text, dob text, place text, phone integer primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int i, int i1) {
        arg0.execSQL("DROP TABLE IF EXISTS TbContact");
        onCreate(arg0);
    }

    public void addContact(String f, String s, String d, String pl, int ph){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("f_name",f);
            cv.put("s_name",s);
            cv.put("dob",d);
            cv.put("place",pl);
            cv.put("phone",ph);
            db.insert("TbContact",null,cv);
            db.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public String[] getContact(int i){
        String a[] = new String[4];
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c  = db.query("TbContact", new String[] {"f_name","s_name","dob","place","phone"}, "phone" + "=?", new String[] {String.valueOf(i)},null,null,null);
            if (c != null && c.getCount() !=0){
                c.moveToFirst();
                a[0] = c.getString(1);
                a[1] = c.getString(2);
                a[2] = c.getString(3);
                a[3] = c.getString(4);
            }
            else{
                a[0] = "";
                a[1] = "";
                a[2] = "";
                a[3] = "";

            }
    } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    public void update(String f, String s, String d, String pl, int i){

    }

    public void delete(int i){

    }
}

