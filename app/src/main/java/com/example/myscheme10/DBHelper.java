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
    private static String DB_NAME = "database15.db";
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
        int result = 0;

        int result1 = 0;

        try {
            Log.println(Log.DEBUG, "Testsql", "inside DB Create");
            String sqlstr = "CREATE TABLE " + "FAMILY " + " ( " + "family_id INTEGER NOT NULL, " + "surname TEXT NOT NULL, " + "NoOfMembers INTEGER NOT NULL, " + "state TEXT NOT NULL, " + "city TEXT NOT NULL, " + "familyIncome INTEGER NOT NULL, " + "caste TEXT NOT NULL )";
            String sqlstr1 = "CREATE TABLE " + "MEMBERS " + " ( " + "family_id INTEGER NOT NULL, " + "name TEXT NOT NULL, " + "occupation TEXT NOT NULL, " + "gender TEXT NOT NULL, " + "age INTEGER NOT NULL, " + "yearlyIncome INTEGER NOT NULL )";
            String sqlstr2 = "CREATE TABLE " + "SCHEMES " + " ( " + "scheme_id INTEGER NOT NULL, " + "gender TEXT NOT NULL, " + "age TEXT NOT NULL, " + "occupation TEXT NOT NULL, " + "caste TEXT NOT NULL, " + "centreorstate TEXT NOT NULL, " + "income TEXT NOT NULL, " + "familyIncome TEXT NOT NULL, " + "description TEXT NOT NULL, " + "link TEXT NOT NULL )";

            Log.println(Log.DEBUG, "sqlquery", sqlstr);
            Log.println(Log.DEBUG, "sqlquery1", sqlstr1);
            Log.println(Log.DEBUG, "sqlquery1", sqlstr2);


            db.execSQL(sqlstr);
            db.execSQL(sqlstr1);
            db.execSQL(sqlstr2);


            Log.println(Log.DEBUG, "Testsql", sqlstr);
            Log.println(Log.DEBUG, "Testsql", " DB Created successfully.");

        }catch (Exception e){
            Log.println(Log.DEBUG,"Testsql", e.getMessage());
            Log.println(Log.DEBUG, "Testsql", "DB Creation failed.");
            throw e;
        }finally {
            //should we close DB connection
        }

    //    SQLiteDatabase db1 = this.getWritableDatabase();

        try
        {
            ContentValues contentValues1 = new ContentValues();

            contentValues1.put("scheme_id", 1);
            contentValues1.put("gender", "Female");
            contentValues1.put("age", "age<=10");
            contentValues1.put("occupation", "NA");
            contentValues1.put("caste", "NA");
            contentValues1.put("centreorstate", "centre");
            contentValues1.put("income", "NA");
            contentValues1.put("familyIncome", "NA");
            contentValues1.put("description", "Sukanya Samriddhi Scheme");
            contentValues1.put("link", "http://nsiindia.gov.in/InternalPage.aspx?Id_Pk=89");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues1);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
        //    db.close();
        }

        try
        {
            ContentValues contentValues2 = new ContentValues();

            contentValues2.put("scheme_id", 2);
            contentValues2.put("gender", "NA");
            contentValues2.put("age", "NA");
            contentValues2.put("occupation", "NA");
            contentValues2.put("caste", "ST");
            contentValues2.put("centreorstate", "state");
            contentValues2.put("income", "NA");
            contentValues2.put("familyIncome", "income<=250000");
            contentValues2.put("description", "Vocational Education Fee Reimbursement");
            contentValues2.put("link", "https://mahadbtmahait.gov.in/Home/Index");

            db.beginTransaction();

            result1 = (int) db.insertOrThrow("SCHEMES", null, contentValues2);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result1 <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Content2", "returning true from insert content2 function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }

        try
        {
            ContentValues contentValues3 = new ContentValues();

            contentValues3.put("scheme_id", 3);
            contentValues3.put("gender", "NA");
            contentValues3.put("age", "NA");
            contentValues3.put("occupation", "Farmer");
            contentValues3.put("caste", "NA");
            contentValues3.put("centreorstate", "centre");
            contentValues3.put("income", "NA");
            contentValues3.put("familyIncome", "NA");
            contentValues3.put("description", "Pradhan Mantri Fasal Bima Yojana (PMFBY)");
            contentValues3.put("link", "https://pmfby.gov.in/");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues3);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues4 = new ContentValues();

            contentValues4.put("scheme_id", 4);
            contentValues4.put("gender", "NA");
            contentValues4.put("age", "NA");
            contentValues4.put("occupation", "Farmer");
            contentValues4.put("caste", "NA");
            contentValues4.put("centreorstate", "state");
            contentValues4.put("income", "NA");
            contentValues4.put("familyIncome", "NA");
            contentValues4.put("description", "Solar water pumps scheme for farmers in Maharashtra");
            contentValues4.put("link", "//mahades.maharashtra.gov.in/MPSIMS/ViewSchemeProfile.do?OWASP_CSRFTOKEN=null&mode=printProfile&recordId=96619&planyearId=2016");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues4);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues5 = new ContentValues();

            contentValues5.put("scheme_id", 5);
            contentValues5.put("gender", "NA");
            contentValues5.put("age", "NA");
            contentValues5.put("occupation", "Farmer");
            contentValues5.put("caste", "NA");
            contentValues5.put("centreorstate", "centre");
            contentValues5.put("income", "NA");
            contentValues5.put("familyIncome", "NA");
            contentValues5.put("description", "Paramparagat Krishi Vikas Yojna (PKVY)");
            contentValues5.put("link", "//pgsindia-ncof.gov.in/pkvy/index.aspx");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues5);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues6 = new ContentValues();

            contentValues6.put("scheme_id", 6);
            contentValues6.put("gender", "NA");
            contentValues6.put("age", "NA");
            contentValues6.put("occupation", "Farmer");
            contentValues6.put("caste", "NA");
            contentValues6.put("centreorstate", "state");
            contentValues6.put("income", "NA");
            contentValues6.put("familyIncome", "NA");
            contentValues6.put("description", "Mahatma Jyotiba Phule Jan Arogya Yojana");
            contentValues6.put("link", "https://www.jeevandayee.gov.in/");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues6);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues7 = new ContentValues();

            contentValues7.put("scheme_id", 7);
            contentValues7.put("gender", "NA");
            contentValues7.put("age", "18<=age<=40");
            contentValues7.put("occupation", "Farmer");
            contentValues7.put("caste", "NA");
            contentValues7.put("centreorstate", "centre");
            contentValues7.put("income", "NA");
            contentValues7.put("familyIncome", "NA");
            contentValues7.put("description", "Pradhan Mantri Kisan Maandhan yojana");
            contentValues7.put("link", "//pmkmy.gov.in/");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues7);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }

        try
        {
            ContentValues contentValues8 = new ContentValues();

            contentValues8.put("scheme_id", 8);
            contentValues8.put("gender", "NA");
            contentValues8.put("age", "NA");
            contentValues8.put("occupation", "Doctor");
            contentValues8.put("caste", "NA");
            contentValues8.put("centreorstate", "centre");
            contentValues8.put("income", "NA");
            contentValues8.put("familyIncome", "NA");
            contentValues8.put("description", "Medical insurance scheme");
            contentValues8.put("link", "https://www.mohfw.gov.in/pdf/FAQPradhanMantriGaribKalyanPackageInsuranceSchemeforHealthWorkersFightingCOVID19.pdf");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues8);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues9 = new ContentValues();

            contentValues9.put("scheme_id", 9);
            contentValues9.put("gender", "NA");
            contentValues9.put("age", "NA");
            contentValues9.put("occupation", "Lawyer");
            contentValues9.put("caste", "NA");
            contentValues9.put("centreorstate", "centre");
            contentValues9.put("income", "NA");
            contentValues9.put("familyIncome", "NA");
            contentValues9.put("description", "Tele Law Scheme");
            contentValues9.put("link", "https://doj.gov.in/page/tele-law-scheme");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues9);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues10 = new ContentValues();

            contentValues10.put("scheme_id", 10);
            contentValues10.put("gender", "NA");
            contentValues10.put("age", "NA");
            contentValues10.put("occupation", "Army");
            contentValues10.put("caste", "NA");
            contentValues10.put("centreorstate", "centre");
            contentValues10.put("income", "NA");
            contentValues10.put("familyIncome", "NA");
            contentValues10.put("description", "Sainik Rest Houses");
            contentValues10.put("link", "http://www.desw.gov.in/welfare-schemes");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues10);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }

        try
        {
            ContentValues contentValues11 = new ContentValues();

            contentValues11.put("scheme_id", 11);
            contentValues11.put("gender", "NA");
            contentValues11.put("age", "NA");
            contentValues11.put("occupation", "Army");
            contentValues11.put("caste", "NA");
            contentValues11.put("centreorstate", "centre");
            contentValues11.put("income", "NA");
            contentValues11.put("familyIncome", "NA");
            contentValues11.put("description", "Financial Assistance for Ex-Servicemen in Penury");
            contentValues11.put("link", "http://www.desw.gov.in/welfare-schemes");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues11);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
        }


        try
        {
            ContentValues contentValues12 = new ContentValues();

            contentValues12.put("scheme_id", 12);
            contentValues12.put("gender", "NA");
            contentValues12.put("age", "NA");
            contentValues12.put("occupation", "Army");
            contentValues12.put("caste", "NA");
            contentValues12.put("centreorstate", "centre");
            contentValues12.put("income", "NA");
            contentValues12.put("familyIncome", "NA");
            contentValues12.put("description", "RMEWF-Financial Assistance for Education of Children/Widows of ESM");
            contentValues12.put("link", "http://www.desw.gov.in/welfare-schemes");

            db.beginTransaction();

            result = (int) db.insertOrThrow("SCHEMES", null, contentValues12);
            //    Log.println(Log.DEBUG, "TestResult", Integer.toString(result));

            db.setTransactionSuccessful(); // commit transaction
            if(result <= 0) {

                Log.println(Log.DEBUG, "Test", Integer.toString(result));

            }

            else {

                Log.println(Log.DEBUG, "Test", "returning true from insert member function");

            }

        } catch (android.database.SQLException e) {
            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        }
        finally {
            db.endTransaction();
            //    db.close();
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
            String SQL_DELETE_ENTRIES1 = "DROP TABLE IF EXISTS Members";
            String SQL_DELETE_ENTRIES2 = "DROP TABLE IF EXISTS Schemes";

            db.execSQL(SQL_DELETE_ENTRIES);
            db.execSQL(SQL_DELETE_ENTRIES1);
            db.execSQL(SQL_DELETE_ENTRIES2);

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
            //String sqlStr1 = "DELETE FROM Members";

            //db.execSQL(sqlStr1);
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

     //   Member member = new Member();

        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String SQLQuery = "SELECT * FROM Family";
            String SQLQuery1 = "SELECT * FROM Members";
            String SQLQuery2 = "SELECT name FROM Members";
            String SQLQuery3 = "SELECT * FROM Schemes";


            Cursor result = db.rawQuery(SQLQuery, array);
            Cursor result1 = db.rawQuery(SQLQuery1, array);
            Cursor result_scheme = db.rawQuery(SQLQuery3, array);
            //    Cursor result2 = db.rawQuery(SQLQuery2, array);
            if (result.getCount() != 0) {

                result.moveToFirst();

                Log.println(Log.DEBUG, "from database", Integer.toString(result.getColumnCount()));
                Log.println(Log.DEBUG, "from database", Integer.toString(result.getCount()));

                Log.println(Log.DEBUG, "from scheme table", Integer.toString(result_scheme.getColumnCount()));
                Log.println(Log.DEBUG, "from scheme table", Integer.toString(result_scheme.getCount()));

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

                if (result1.getCount() != 0) {

                    result1.moveToFirst();

                    Log.println(Log.DEBUG, "from databaseMemb", Integer.toString(result1.getColumnCount()));
                    Log.println(Log.DEBUG, "from databaseMemb", Integer.toString(result1.getCount()));

                    for (int i = 1; i <= result1.getCount(); i++) {

                        Member member = new Member();

                        Log.println(Log.DEBUG, "members added", result1.getString(result1.getColumnIndex("name")));

                        member.setName(result1.getString(result1.getColumnIndex("name")));
                        member.setGender(result1.getString(result1.getColumnIndex("gender")));
                        member.setOccupation(result1.getString(result1.getColumnIndex("occupation")));
                        member.setAge(result1.getInt(result1.getColumnIndex("age")));
                        member.setYearlyIncome(result1.getInt(result1.getColumnIndex("yearlyIncome")));
                        family.addMember(member);
                        result1.moveToNext();


                    }

                }

            }

            return family;

        } catch (android.database.SQLException e) {

            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

            return family;
        } finally {

            db.close();
        }
    }

    public void getSchemes() {

    //    Scheme schemeObj = new Scheme();

        if(Scheme.getListOfSchemes().size() > 0) {

            return;
        }

        String SQLQuery = "SELECT * FROM Schemes";

        SQLiteDatabase db = this.getReadableDatabase();

        try {

            Cursor result = db.rawQuery(SQLQuery, array);

            if (result.getCount() != 0) {

                result.moveToFirst();

                for (int i = 1; i <= result.getCount(); i++) {

                    Scheme schemeObj = new Scheme();

                    schemeObj.setScheme_id(result.getInt(result.getColumnIndex("scheme_id")));
                    schemeObj.setAge(result.getString(result.getColumnIndex("age")));
                    schemeObj.setCaste(result.getString(result.getColumnIndex("caste")));
                    schemeObj.setGender(result.getString(result.getColumnIndex("gender")));
                    schemeObj.setOccupation(result.getString(result.getColumnIndex("occupation")));
                    schemeObj.setIncome(result.getString(result.getColumnIndex("income")));
                    schemeObj.setCentreOrState(result.getString(result.getColumnIndex("centreorstate")));
                    schemeObj.setDescription(result.getString(result.getColumnIndex("description")));
                    schemeObj.setLink(result.getString(result.getColumnIndex("link")));
                    schemeObj.setFamIncome(result.getString(result.getColumnIndex("familyIncome")));

                    Scheme.addScheme(schemeObj);

                    result.moveToNext();

                }
            }

        //    return schemeObj;

        } catch (android.database.SQLException e) {

            e.printStackTrace();
            Log.println(Log.DEBUG, "Test", e.getMessage());

        //    return schemeObj;

        } finally {

            db.close();
        }
    }

    public void deleteMember(String name) {

        String name1 = "'" + name + "'";

        String[] whereArray = {name};

        String SQLQuery = "DELETE FROM MEMBERS WHERE name = " + name1;
        Log.println(Log.DEBUG, "deleteMember", "DELETE MEMBER Query is " + SQLQuery);
        SQLiteDatabase db = this.getWritableDatabase();

        try{

            Log.println(Log.DEBUG, "deleteMember", "Inside try of delete ");

            db.beginTransaction();

        //    Cursor result = db.rawQuery(SQLQuery, array);

            db.delete("MEMBERS", "name=?", whereArray);

        //    Log.println(Log.DEBUG, "deleteMember", "Cursor result " + String.valueOf(result));

            db.setTransactionSuccessful();



        } catch (android.database.SQLException e) {

        e.printStackTrace();

        Log.println(Log.DEBUG, "deleteMember", e.getMessage());

        //    return schemeObj;

        } finally {

                db.endTransaction();
                db.close();
        }

    }

/*        //    result2.moveToFirst();

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
*/
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
