package com.example.myscrapcollector;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class UDBHelper extends SQLiteOpenHelper {
    public static final String DATABASENAME="Aptech.db";

    //==================USER TABLE
    public static final String TABLENAME="UserTable";
    public static final String COL_1="user_id";
    public static final String COL_2="user_name";
    public static final String COL_3="user_password";
    public static final String COL_4="user_email";
    public static final String COL_5="user_no";

    //==================SCRAP TABLE
    public static final String SITABLENAME="ScrapTable";
    public static final String scol_1="Item_id";
    public static final String scol_2="Item_Name";
    public static final String scol_3="Item_Price";

    //==================SCRAP COLLECTOR TABLE
    public static final String SCTABLENAME="SCTable";
    public static final String col_1="sc_id";
    public static final String col_2="sc_name";
    public static final String col_3="sc_pass";
    public static final String col_4="sc_email";
    public static final String col_5="sc_no";

    //==================Appointment TABLE
    public static final String PICKTABLENAME="PickupTable";
    public static final String pcol_1="p_id";
    public static final String pcol_2="p_name";
    public static final String pcol_3="p_location";
    public static final String pcol_4="p_email";
    public static final String pcol_5="p_no";
    public static final String pcol_6="p_date";




    public UDBHelper(@Nullable Context context) {
        super(context,DATABASENAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLENAME+"(user_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name TEXT,user_password TEXT,user_email TEXT,user_no TEXT)");
    sqLiteDatabase.execSQL("create table "+SCTABLENAME+"(sc_id INTEGER PRIMARY KEY AUTOINCREMENT,sc_name TEXT,sc_pass TEXT,sc_email TEXT,sc_no TEXT)");
    sqLiteDatabase.execSQL("create table "+SITABLENAME+"(Item_id INTEGER PRIMARY KEY AUTOINCREMENT,Item_Name TEXT,Item_Price TEXT)");
        sqLiteDatabase.execSQL("create table "+PICKTABLENAME+"(p_id INTEGER PRIMARY KEY AUTOINCREMENT,p_name TEXT,p_location TEXT,p_email TEXT,p_no TEXT,p_date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+SITABLENAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+PICKTABLENAME);
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+SCTABLENAME);
        onCreate(sqLiteDatabase);
    }
    //==================================================================================usertable
    public boolean registerrecord (String name,String pass,String email,String num)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,name);
        cv.put(COL_3,pass);
        cv.put(COL_4,email);
        cv.put(COL_5,num);


        long success = db.insert(TABLENAME,null,cv);
        if (success == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public  boolean getUser(String name,String pass)
    {
        String selectQuery ="select * from "+ TABLENAME +" where " + COL_2 +" = " + "'"+name+"'" + " and " + COL_3 +" = "+"'"+pass+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if(cursor.getCount()>0) {

            return true;

        }

        cursor.close();
        db.close();

        return false;
    }

    //==================================================================================scrapCollectortable
    public boolean SCregister (String scname,String scpass,String scemail,String scnum)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put(col_2,scname);
        cv1.put(col_3,scpass);
        cv1.put(col_4,scemail);
        cv1.put(col_5,scnum);


        long success = db.insert(SCTABLENAME,null,cv1);
        if (success == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public  boolean getSC(String scname,String scpass)
    {
        String selectQuery ="select * from "+ SCTABLENAME +" where " + col_2 +" = " + "'"+scname+"'" + " and " + col_3 +" = "+"'"+scpass+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if(cursor.getCount()>0) {

            return true;

        }

        cursor.close();
        db.close();

        return false;
    }

    //-----------------------------------------------ShowRecord

    @SuppressLint("Range")
    public ArrayList<HashMap<String,String>> show_Scollector()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> itemlist = new ArrayList<>();

        String query = "SELECT sc_name,sc_email,sc_no FROM "+ SCTABLENAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> item = new HashMap<>();

            item.put("name",cursor.getString(cursor.getColumnIndex(col_2)));
            item.put("em",cursor.getString(cursor.getColumnIndex(col_4)));
            item.put("num",cursor.getString(cursor.getColumnIndex(col_5)));


            itemlist.add(item);
        }
        return  itemlist;
    }


    //==================================================================================scrapItemtable
    public boolean addscrap (String scname,String scprice)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put(scol_2,scname);
        cv1.put(scol_3,scprice);



        long success = db.insert(SITABLENAME,null,cv1);
        if (success == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //-----------------------------------------------ShowRecord

    @SuppressLint("Range")
    public ArrayList<HashMap<String,String>> show_record()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> itemlist = new ArrayList<>();

        String query = "SELECT Item_id,Item_Name,Item_Price FROM "+ SITABLENAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> item = new HashMap<>();
            item.put("Id",cursor.getString(cursor.getColumnIndex(scol_1)));
            item.put("Name",cursor.getString(cursor.getColumnIndex(scol_2)));
            item.put("Price",cursor.getString(cursor.getColumnIndex(scol_3)));


            itemlist.add(item);
        }
        return  itemlist;
    }

    //----------------------------------------------- delete record
    public  boolean delete_record(int id) //define
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(SITABLENAME,"Item_id = "+id,null) > 0;


    }

    //-------------------------------------InsertPickupTable
    public boolean insert_pickup(String name,String location,String email,String phone,String date)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(pcol_2,name);
        cv.put(pcol_3,location);
        cv.put(pcol_4,email);
        cv.put(pcol_5,phone);
        cv.put(pcol_6,date);

        long sucess  = db.insert(PICKTABLENAME,null,cv);
        if(sucess == -1)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }
    //-----------------------------------------------ShowPickup

    @SuppressLint("Range")
    public ArrayList<HashMap<String,String>> show_pickup()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> itemlist = new ArrayList<>();

        String query = "SELECT p_id,p_name,p_location,p_email,p_no,p_date  FROM "+ PICKTABLENAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> item = new HashMap<>();
            item.put("Id",cursor.getString(cursor.getColumnIndex(pcol_1)));
            item.put("Name",cursor.getString(cursor.getColumnIndex(pcol_2)));
            item.put("Location",cursor.getString(cursor.getColumnIndex(pcol_3)));
            item.put("Email",cursor.getString(cursor.getColumnIndex(pcol_4)));
            item.put("No",cursor.getString(cursor.getColumnIndex(pcol_5)));
            item.put("Date",cursor.getString(cursor.getColumnIndex(pcol_6)));


            itemlist.add(item);
        }
        return  itemlist;
    }

}












