package com.example.myscheme10;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class Family {

    private String surname;
    private int noOfMembers;
    private String state;
    private String city;
    private String caste;
    private int familyIncome;

    List<Member> members;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNoOfMembers(int noOfMembers) {
        this.noOfMembers = noOfMembers;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public void setFamilyIncome(int familyIncome) {
        this.familyIncome = familyIncome;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getSurname() {
        return surname;
    }


    public int getNoOfMembers() {
        return noOfMembers;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCaste() {
        return caste;
    }

    public int getFamilyIncome() {
        return familyIncome;
    }

    public List<Member> getMembers() {
        return members;
    }


    public boolean addMember() {

        return true;
    }

    public boolean save(Context context) {

        try {
            DBHelper dbh = new DBHelper(context);

            Log.println(Log.DEBUG, "Inside save of family", surname);


            boolean insert = dbh.insertFamily(surname, state, city, caste, noOfMembers, familyIncome);
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

}
