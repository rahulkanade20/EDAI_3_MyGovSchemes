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
    private static String DB_NAME = "database3.db";
    private static int DB_VER = 1;
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
            String sqlstr1 = "CREATE TABLE " + "MEMBERS " + " ( " + "family_id INTEGER NOT NULL, " + "name TEXT NOT NULL, " + "occupation TEXT NOT NULL, " + "gender TEXT NOT NULL, " + "age INTEGER NOT NULL, " + "yearlyIncome INTEGER NOT NULL )";

            Log.println(Log.DEBUG, "sqlquery", sqlstr);
            Log.println(Log.DEBUG, "sqlquery1", sqlstr1);


            db.execSQL(sqlstr);
            db.execSQL(sqlstr1);


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

    public boolean insertMember(String name, String occupation, String gender, int age, int yearlyIncome) {

        Log.println(Log.DEBUG, "TestMember1", "inside insertMember function");
        Log.println(Log.DEBUG, "TestMember1", name);
        Log.println(Log.DEBUG, "TestMember1", occupation);
        Log.println(Log.DEBUG, "TestMember1", gender);
    //    Log.println(Log.DEBUG, "Test1", caste);
        Log.println(Log.DEBUG, "TestMember1", Integer.toString(age));
        Log.println(Log.DEBUG, "TestMember1", Integer.toString(yearlyIncome));

        int result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        try
        {
            ContentValues contentValues1 = new ContentValues();

            contentValues1.put("family_id", 1);
            contentValues1.put("name", name);
            contentValues1.put("occupation", occupation);
            contentValues1.put("gender", gender);
            contentValues1.put("age", age);
            contentValues1.put("yearlyIncome", yearlyIncome);


            db.beginTransaction();

            result = (int) db.insertOrThrow("MEMBERS", null, contentValues1);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful();
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));
                return false;
            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");
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
            String SQLQuery1 = "SELECT * FROM Members";
            String SQLQuery2 = "SELECT name FROM Members";

            Cursor result = db.rawQuery(SQLQuery, array);
            Cursor result1 = db.rawQuery(SQLQuery1, array);
        //    Cursor result2 = db.rawQuery(SQLQuery2, array);

            result.moveToFirst();
            result1.moveToFirst();
        //    result2.moveToFirst();

            Log.println(Log.DEBUG, "from database", Integer.toString(result.getColumnCount()));
            Log.println(Log.DEBUG, "from database", Integer.toString(result.getCount()));

            Log.println(Log.DEBUG, "from databaseMemb", Integer.toString(result1.getColumnCount()));
            Log.println(Log.DEBUG, "from databaseMemb", Integer.toString(result1.getCount()));

        //    Log.println(Log.DEBUG, "from databaseMemb", Integer.toString(result2.getColumnCount()));
        //    Log.println(Log.DEBUG, "from databaseMemb", Integer.toString(result2.getCount()));

         //   result1.moveToFirst();


            for(int i=1; i<=result1.getCount(); i++) {

                Log.println(Log.DEBUG, "members added", result1.getString(result1.getColumnIndex("name")));
                result1.moveToNext();
            }

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
