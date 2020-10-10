package com.example.myscheme10;

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


    public boolean add() {

        return true;
    }

    public List<String> getRecommendations() {

        List<String> listName = null;

        return listName;
    }

}
