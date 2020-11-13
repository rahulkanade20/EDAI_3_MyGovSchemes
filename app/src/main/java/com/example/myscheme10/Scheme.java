package com.example.myscheme10;

import java.util.ArrayList;
import java.util.List;

public class Scheme {

    private int scheme_id;
    private String gender;
    private String age;
    private String occupation;
    private String caste;
    private String centreOrState;
    private String income;
    private String description;
    private String link;
    private String famIncome;

    public String getFamIncome() {
        return famIncome;
    }

    public void setFamIncome(String famIncome) {
        this.famIncome = famIncome;
    }

    private static List<Scheme> listOfSchemes = new ArrayList<Scheme>();

    public static List<Scheme> getListOfSchemes() {
        return listOfSchemes;
    }

    public void setListOfSchemes(List<Scheme> listOfSchemes) {
        this.listOfSchemes = listOfSchemes;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(int scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCentreOrState() {
        return centreOrState;
    }

    public void setCentreOrState(String centreOrState) {
        this.centreOrState = centreOrState;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public static boolean addScheme(Scheme scheme) {

        listOfSchemes.add(scheme);
        return true;
    }

}





