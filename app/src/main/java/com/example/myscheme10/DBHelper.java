package com.example.myscheme10;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DBHelper extends SQLiteOpenHelper {

    // The Android's default system path
    // of your application database.
    private static String DB_PATH = "";
    private static String DB_NAME = "database2.db";
    private static int DB_VER = 3;
    private SQLiteOpenHelper sqLiteOpenHelper;

    String[] array = {};


    /**
     * Constructor
     * Takes and keeps a reference of
     * the passed context in order
     * to access the application assets and resources. */
    public DBHelper(Context context)
    {

        super(context, DB_NAME, null, DB_VER);
       // this.myContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            Log.println(Log.DEBUG, "Testsql", "inside DB Create");
            String sqlstr = "CREATE TABLE " + "FAMILY " + " ( " + "family_id INTEGER NOT NULL, " + "surname TEXT NOT NULL, " + "NoOfMembers INTEGER NOT NULL, " + "state TEXT NOT NULL, " + "city TEXT NOT NULL, " + "familyIncome INTEGER NOT NULL, " + "caste TEXT NOT NULL )";

            Log.println(Log.DEBUG, "sqlquery", sqlstr);


            db.execSQL(sqlstr);

            Log.println(Log.DEBUG, "Testsql", sqlstr);
            Log.println(Log.DEBUG, "Testsql", " DB Created successfully.");
        }catch (Exception e){
            Log.println(Log.DEBUG,"Testsql", e.getMessage());
            Log.println(Log.DEBUG, "Testsql", "DB Creation failed.");
            throw e;
        }finally {
            //should we close DB connection
        }


     /*   db.execSQL("CREATE TABLE "Family" (
            "family-id"	INTEGER NOT NULL,
            "noOfMembers"	INTEGER,
            "state"	TEXT NOT NULL,
            "city"	TEXT NOT NULL,
            "caste"	TEXT NOT NULL,
            "familyIncome"	INTEGER NOT NULL,
            "surname"	TEXT NOT NULL,
            PRIMARY KEY("family-id" AUTOINCREMENT)
""));
*/
        // It is an abstract method
        // but we define our own method here.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion)
    {
        try {
            Log.println(Log.DEBUG,"Testsql", "inside onUpgrade");

            String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS Family";

            db.execSQL(SQL_DELETE_ENTRIES);
            Log.println(Log.DEBUG,"Testsql", "Dropped existing tables successfully.");

            onCreate(db);

            Log.println(Log.DEBUG,"Testsql", "Upgrade succeeded.");

        }catch(Exception e){
            Log.println(Log.DEBUG,"Testsql", e.getMessage());
            Log.println(Log.DEBUG,"Testsql", "Upgrade failed");
            throw e;
        }
    }

    public boolean insertFamily(String surname, String state, String city, String caste, int memOfFamily, int famIncome) {

        Log.println(Log.DEBUG, "Test1", "inside insertFamily function");
        Log.println(Log.DEBUG, "Test1", surname);
        Log.println(Log.DEBUG, "Test1", state);
        Log.println(Log.DEBUG, "Test1", city);
        Log.println(Log.DEBUG, "Test1", caste);
        Log.println(Log.DEBUG, "Test1", Integer.toString(memOfFamily));
        Log.println(Log.DEBUG, "Test1", Integer.toString(famIncome));

        int result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        try
        {
            ContentValues contentValues1 = new ContentValues();
            contentValues1.put("family_id", 1);
            contentValues1.put("surname", surname);
            contentValues1.put("noOfMembers", memOfFamily);
            contentValues1.put("state", state);
            contentValues1.put("city", city);
            contentValues1.put("familyIncome", famIncome);
            contentValues1.put("caste", caste);

            db.beginTransaction();

            String sqlStr = "DELETE FROM Family";
            db.execSQL(sqlStr);

            result = (int) db.insertOrThrow("FAMILY", null, contentValues1);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful();
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));
                return false;
            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert family function");
                return true;
            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());
            return false;
        }
        finally {
            db.endTransaction();
            db.close();
        }

    }

    public Family getFamily() {

        Family family = new Family();

        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String SQLQuery = "SELECT * FROM Family";

            Cursor result = db.rawQuery(SQLQuery, array);

            result.moveToFirst();

            Log.println(Log.DEBUG, "from database", Integer.toString(result.getColumnCount()));
            Log.println(Log.DEBUG, "from database", Integer.toString(result.getCount()));


            family.setSurname(result.getString(result.getColumnIndex("surname")));
        //    result.moveToFirst();
            family.setNoOfMembers(result.getInt(result.getColumnIndex("NoOfMembers")));
        //    result.moveToFirst();
            family.setFamilyIncome(result.getInt(result.getColumnIndex("familyIncome")));
        //    result.moveToFirst();
            family.setCaste(result.getString(result.getColumnIndex("caste")));
        //    result.moveToFirst();
            family.setState(result.getString(result.getColumnIndex("state")));
        //    result.moveToFirst();
            family.setCity(result.getString(result.getColumnIndex("city")));

            Log.println(Log.DEBUG, "Test3", "inside insertFamily function");
            Log.println(Log.DEBUG, "Test3", family.getSurname());
            Log.println(Log.DEBUG, "Test3", family.getState());
            Log.println(Log.DEBUG, "Test3", family.getCity());
            Log.println(Log.DEBUG, "Test3", family.getCaste());
            Log.println(Log.DEBUG, "Test3", Integer.toString(family.getNoOfMembers()));
            Log.println(Log.DEBUG, "Test3", Integer.toString(family.getFamilyIncome()));




            return family;
        } catch (android.database.SQLException e) {

            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

            return family;
        }
        finally {

            db.close();
        }
    }

    // This method is used to get the
    // algorithm topics from the database.
    /*
    public List<String> getAlgorithmTopics(
            Activity activity)
    {
        sqLiteOpenHelper
                = new DatabaseHelper(activity);
        SQLiteDatabase db
                = sqLiteOpenHelper
                .getWritableDatabase();

        List<String> list
                = new ArrayList<>();

        // query help us to return all data
        // the present in the ALGO_TOPICS table.
        String query = "SELECT * FROM " + ALGO_TOPICS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return list;
    }*/
}
