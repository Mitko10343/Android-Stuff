//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 18/11/2017.
 */

public class foodsDatabase {

    //Creating the variables to hold the column names of table
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FOODNAME = "foodname";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_SERVINGSIZE = "servingSize";

    //Variables to store database name, table name and database version
    public static final String DATABASE_NAME = "foodsDB";
    public static final String DATABASE_TABLE = "food";
    public static final int DATABASE_VERSION = 1;

    //Variable that will hold a query for creating the table
    private static final String DATABASE_CREATE =
            "create table food(_id integer primary key autoincrement not null," +
            "foodname text not null," + " calories integer not null," +
            "servingSize integer not null);";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    //constructor for the foodsDatabaseClass
    public foodsDatabase(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    //Database Helper class That will create and upgrade the database
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXIST" +DATABASE_TABLE);
            onCreate(db);
        }
    }//end Database Helper Class

    //Back into foods Database class
    //open the database
    public foodsDatabase open() throws Exception
    {
        //db.execSQL("DROP TABLE IF EXIST" +DATABASE_TABLE);
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //close the database
    public void close()
    {
        DBHelper.close();
    }

    //Method to add food into the database
    public long addFood(String foodName,int calories,int servingSize)
    {
        db = DBHelper.getWritableDatabase();

        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_FOODNAME,foodName);
        initialValues.put(COLUMN_CALORIES,calories);
        initialValues.put(COLUMN_SERVINGSIZE,servingSize);

        return db.insert(DATABASE_TABLE,null,initialValues);
    }//end Method

    //method that displays a list of all the foods in database
    public Cursor DisplayFoods()
    {

        return db.query(DATABASE_TABLE,new String[]
                {
                    COLUMN_ID,
                    COLUMN_FOODNAME,
                    COLUMN_CALORIES,
                    COLUMN_SERVINGSIZE
                },
                null,null,null,null,null);
    }//End Method

    //Method that returns a search result for a food
    public Cursor getFood(String food_name) throws SQLException
    {
        db = DBHelper.getReadableDatabase();
        String foodName = null;
        
        Cursor mCursor = db.rawQuery("Select * from food where foodname =?",new String[]{
                food_name
        });

        if(mCursor.moveToFirst()) {
            foodName = mCursor.getString(mCursor.getColumnIndex("foodname"));
        }
        
        if(foodName.equals(food_name))
        {
            return mCursor;
        }
        else
        {
            return  null;
        }

    }

}
