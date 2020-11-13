package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class recommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        String recommendationString = "";

        schemeEvaluation evaluation = new schemeEvaluation();

        Family family = new Family();

        //    List<Boolean> result = new ArrayList<Boolean>();

        schemeEvaluation evaluator = new schemeEvaluation();

        //    Scheme scheme = new Scheme();

        DBHelper db = new DBHelper(getApplicationContext());

        family = db.getFamily();

        db.getSchemes();

        Log.println(Log.DEBUG, "recommendation", "inside recommendation");


        for(int i=0; i<family.getMembers().size(); i++) {

            Log.println(Log.DEBUG, "recommendation", String.valueOf(family.getMembers().get(i).getAge()));//.getMySchemes().get(0)));
        }

        for(int i=0; i<Scheme.getListOfSchemes().size(); i++) {

            Log.println(Log.DEBUG, "recommendation", String.valueOf(Scheme.getListOfSchemes().get(i).getDescription()));//.getMySchemes().get(0)));
        }

        Log.println(Log.DEBUG, "recommendation_size", String.valueOf(family.getMembers().size()));//.getMySchemes().get(0)));

        for(int i = 0; i<family.getMembers().size(); i++) {

            for(int j = 0; j<Scheme.getListOfSchemes().size(); j++) {

                List<Boolean> result = new ArrayList<Boolean>();

                result = evaluator.Evaluator(family, family.getMembers().get(i), Scheme.getListOfSchemes().get(j));

                if(result.size() == 5) {

                    Log.println(Log.DEBUG, "recommendation_s", String.valueOf(family.getMembers().get(i).getName()));//.getMySchemes().get(0)));

                    family.getMembers().get(i).addToMySchemes(Scheme.getListOfSchemes().get(j));

                    Log.println(Log.DEBUG, "recommendation_s", String.valueOf(family.getMembers().get(i).getMySchemes().get(0).getDescription()));//.getMySchemes().get(0)));

                }

                //else {

                //   family.getMembers().get(i).addToMySchemes(0);

                //}
            }

        }

        Log.println(Log.DEBUG, "recommendation_size1", String.valueOf(family.getMembers().size()));//.getMySchemes().get(0)));


        for(int i=0; i<family.getMembers().size(); i++) {

            recommendationString =  recommendationString + family.getMembers().get(i).getName() + "\n";

            Log.println(Log.DEBUG, "recommendation_insFor", String.valueOf(i));//.getMySchemes().get(0)));

            for(int j=0; j<family.getMembers().get(i).getMySchemes().size(); j++) {

                recommendationString = recommendationString + family.getMembers().get(i).getMySchemes().get(j).getDescription() + "\n";

                recommendationString = recommendationString + family.getMembers().get(i).getMySchemes().get(j).getLink() + "\n";

                Log.println(Log.DEBUG, "recommendation1", String.valueOf(family.getMembers().get(i).getMySchemes().size()));

                Log.println(Log.DEBUG, "recommendation_ins_iFor", String.valueOf(family.getMembers().get(i).getMySchemes().get(j)));//.getMySchemes().get(0)));

            }

            recommendationString = recommendationString + "**************************************************************************************" + "\n";


            //    Log.println(Log.DEBUG, "recommendation1", String.valueOf(family.getMembers().get(i).getMySchemes().size()));//.getMySchemes().get(0)));
        }

        Log.println(Log.DEBUG, "recommendationString", recommendationString);//.getMySchemes().get(0)));

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(recommendationString);
/*
        for(int i=0; i<family.getMembers().size(); i++) {

            recommendationString =  recommendationString + family.getMembers().get(i).getName() + "\n";

            for(int j=0; j<family.getMembers().get(i).getMySchemes().size(); j++) {

                recommendationString = recommendationString + family.getMembers().get(i).getMySchemes().get(j).getDescription() + "\n";

                recommendationString = recommendationString + family.getMembers().get(i).getMySchemes().get(j).getLink() + "\n";
            }

            recommendationString = "**************************************************************************************" + "\n";


        }

        Log.println(Log.DEBUG, "recommendationString", recommendationString);//.getMySchemes().get(0)));

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(recommendationString);

*/



    }
}