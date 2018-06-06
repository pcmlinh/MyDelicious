package com.example.user.mydelicious3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class Place extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydeliciousdb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "place";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PRICE = "price";
    private static final String KEY_POINT = "point";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";

    public Place(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_NAME+"("+KEY_ID+" integer primary key autoincrement, "+
                KEY_NAME+" text, "+
                KEY_ADDRESS+" text, "+
                KEY_PRICE+" text, "+
                KEY_POINT+" integer, "+
                KEY_DESCRIPTION+" text, "+
                KEY_IMAGE+" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public void addPlace(String name, String address, String price, int point, String description, String image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KEY_NAME,name);
        content.put(KEY_ADDRESS,address);
        content.put(KEY_PRICE,price);
        content.put(KEY_POINT,point);
        content.put(KEY_DESCRIPTION,description);
        content.put(KEY_IMAGE,image);

        String nullColumnHack = null;
        db.insert(TABLE_NAME, nullColumnHack,content);
    }
//    public boolean deletePlace(String mssv){
//        SQLiteDatabase db = this.getWritableDatabase();
//        return  db.delete(TABLE_NAME,KEY_MSSV+" = \""+mssv+"\"",null)>0;
//    }
//    public boolean editPlace(String name, String address, String price, int point, String description, String image){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content = new ContentValues();
//        content.put(KEY_NAME,name);
//        content.put(KEY_ADDRESS,address);
//        content.put(KEY_PRICE,price);
//        content.put(KEY_POINT,point);
//        content.put(KEY_DESCRIPTION,description);
//        content.put(KEY_IMAGE,image);
//        return db.update(TABLE_NAME,content,KEY_MSSV+" = \""+mssv+"\"",null)>0;
//    }
    public Cursor getAllPlace(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor con_tro = db.rawQuery("select * from "+TABLE_NAME,null);
        return con_tro;
    }
}
