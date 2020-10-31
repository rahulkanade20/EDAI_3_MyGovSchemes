package com.example.myscheme10;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class Member {

    private String name;
    private int age;
    private String occupation;
    private int yearlyIncome;
    private String gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getYearlyIncome() {
        return yearlyIncome;
    }

    public String getGender() {
        return gender;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setYearlyIncome(int yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public boolean add(Context context, Member member) {

        try {
            DBHelper dbh = new DBHelper(context);

        //    Log.println(Log.DEBUG, "Inside save of family",);


            boolean insert = dbh.insertMember(member.getName(), member.getOccupation(), member.getGender(), member.getAge(), member.getYearlyIncome());
            if (insert == true) {
                Log.println(Log.DEBUG, "Test", "inserted successfully");
            } else {
                Log.println(Log.DEBUG, "Test", "insertion unsuccessful");
            }

            return insert;
        }
        catch( Exception e)
        {
            Log.println(Log.DEBUG, "Test", e.getMessage());
            return false;
        }
        finally{

        }


    }

    public List<String> getRecommendations() {

        List<String> listName = null;

        return listName;
    }

}
