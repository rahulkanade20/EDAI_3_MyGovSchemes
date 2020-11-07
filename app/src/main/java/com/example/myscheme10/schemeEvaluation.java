package com.example.myscheme10;

import java.util.ArrayList;

public class schemeEvaluation {
/*
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ArrayList<Boolean> result = new ArrayList<Boolean>();

        Family family = new Family();

        family.setSurname("abc");
        family.setState("Maha");
        family.setCity("pun");
        family.setNoOfMembers(4);
        family.setFamilyIncome(100000000);
        family.setCaste("SST");

        Member member = new Member();

        member.setAge(11);
        member.setGender("female");
        member.setName("def");
        member.setOccupation("student");
        member.setYearlyIncome(0);



        Scheme scheme = new Scheme();

        scheme.setAge("age>=10");
        scheme.setGender("female");
        scheme.setOccupation("student");
        scheme.setScheme_id(1);
        scheme.setCaste("OPEN, SC, BC");
        scheme.setCentreOrState("centre");
        scheme.setDescription("scheme for girls");
        scheme.setIncome("NA");

        result = Evaluator(family, member, scheme);

        System.out.println(result);

    }
*/
    public static ArrayList<Boolean> Evaluator(Family family, Member member, Scheme scheme) {

        //    String[] caste_array = {};


        String ageCondition = scheme.getAge();
        String incomeCondition = scheme.getIncome();

        ArrayList<Boolean> array = new ArrayList<>();

        String ageArray[] = {};

        String incomeArray[] = {};

        if(scheme.getAge() == "NA") {

            array.add(true);
        }

        else {

            if (ageCondition.contains("<=")) {

                ageArray = ageCondition.split("<=");

                if (ageArray.length == 2) {

                    if (member.getAge() <= Integer.valueOf(ageArray[1])) {

                        array.add(true);
                    }
                }

                if (ageArray.length == 3) {

                    if (Integer.valueOf(ageArray[0]) <= member.getAge() && member.getAge() <= Integer.valueOf(ageArray[2])) {

                        array.add(true);
                    }
                }

            } else if (ageCondition.contains(">=")) {

                ageArray = ageCondition.split(">=");

                if (member.getAge() >= Integer.valueOf(ageArray[1])) {

                    array.add(true);
                }


            }
        }

        if(scheme.getIncome() == "NA") {

            array.add(true);
        }

        else {

            if (incomeCondition.contains("<=")) {

                incomeArray = incomeCondition.split("<=");

                if (incomeArray.length == 2) {

                    if (member.getAge() <= Integer.valueOf(incomeArray[1])) {

                        array.add(true);
                    }
                }

                if (incomeArray.length == 3) {

                    if (Integer.valueOf(incomeArray[0]) <= member.getYearlyIncome() && member.getYearlyIncome() <= Integer.valueOf(incomeArray[2])) {

                        array.add(true);
                    }
                }

            } else if (incomeCondition.contains(">=")) {

                incomeArray = ageCondition.split(">=");

                if (member.getAge() >= Integer.valueOf(incomeArray[1])) {

                    array.add(true);
                }


            }
        }

        //    int count = countMatches(ageCondition);

        //    caste_array = scheme.getCaste().split(",");

        if (member.getGender() == scheme.getGender() || scheme.getGender() == "NA") {

            array.add(true);
        }

        if(member.getOccupation() == scheme.getOccupation() || scheme.getOccupation() == "NA") {

            array.add(true);
        }



        if(scheme.getCaste().contains(family.getCaste()) || scheme.getCaste().contains("NA")) {

            array.add(true);
        }

        return array;

    }

//    public static int countMatches(String condition) {

//        condition.indexOf(">=");
//    }


}




