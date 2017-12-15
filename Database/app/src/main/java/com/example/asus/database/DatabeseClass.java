package com.example.asus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



class DatabaseExampleOutline
{

    // database column NAMES e.g. rowID
    private static final String KEY_ROWID 	    = "_id";
    private static final String KEY_TASKNAME = "task_name";
    private static final String KEY_TASKDESCRIPTION="task_description";
    private static final String KEY_COMPLETESTATUS = "complete_status";

    private static final String DATABASE_TABLE 	= "Task";
    private static final String DATABASE_NAME 	= "AndroidDb";
    private static final int DATABASE_VERSION 	= 1; // since it is the first version of the dB


    // SQL statement to create the database
    private static final String DATABASE_CREATE =
            "create table Task (_id integer primary key autoincrement,"+"task_name text not null," +
                    "task_description text not null,"+"complete_status integer not null);";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    // Constructor
    public DatabaseExampleOutline(Context ctx)
    {
        //
        this.context 	= ctx;
        DBHelper 		= new DatabaseHelper(context);
    }

    // nested dB helper class
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        //
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db)
        {

            // Execute SQL to create your tables (call the execSQL method of the SQLLiteDatabase class, passing in your create table(s) SQL)
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // dB structure change..

        }
    }   // end nested class

    public DatabaseExampleOutline open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }



    // remainder of the Database Example methods to "use" the database
    public void close()

    {
        DBHelper.close();
    }

    // an example of a database insert.  This is for a particular database that has three columns
    public long insertTasks(String task_name, String task_description, int complete_status)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TASKNAME, task_name);
        initialValues.put(KEY_TASKDESCRIPTION,task_description);
        initialValues.put(KEY_COMPLETESTATUS,complete_status);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    // an example of a custom method to query a database.

    public Cursor getTasks(long rowId) throws SQLException
    {
        // The query method from SQLLiteDatabase class has various parameters that define the query: the database table, the string of columns names to be returned and
        // the last set of parameters allow you to specify "where" conditions for the query.  In this case, there is just one "where" clause. The others are unused.

        Cursor mCursor =   db.query(true, DATABASE_TABLE, new String[]
                        {
                                // this String array is the 2nd paramter to the query method - and is the list of columns you want to return
                                KEY_ROWID,
                                KEY_TASKNAME,
                                KEY_TASKDESCRIPTION,
                                KEY_COMPLETESTATUS

                        },
                KEY_ROWID + "=" + rowId,  null, null, null, null, null);

        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

}// end class