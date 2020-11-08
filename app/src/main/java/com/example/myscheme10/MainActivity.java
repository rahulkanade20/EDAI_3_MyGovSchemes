package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnProfile;

    private Button refresh;

    private Button recommend;

    public static Family family = new Family();

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = (Button) findViewById(R.id.btnProfile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileInvoke();
            }
        });

        refresh = (Button) findViewById(R.id.button2);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshInvoke();
            }
        });

        recommend = (Button) findViewById(R.id.button3);

        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recommendInvoke();
            }
        });

        db = new DBHelper(this);
    /*
        try {
            db.createDataBase();
            db.openDataBase();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    */
    }

    @Override
    protected void onDestroy() {
     //   db.close();
        super.onDestroy();
    }

    public void profileInvoke() {

        Intent intent = new Intent(this, NewProfileActivity.class);
        startActivity(intent);

    }

    public void refreshInvoke() {


    }

    public void recommendInvoke() {
/*
        schemeEvaluation evaluation = new schemeEvaluation();

        Family family = new Family();

        List<Boolean> result = new ArrayList<Boolean>();

        schemeEvaluation evaluator = new schemeEvaluation();

    //    Scheme scheme = new Scheme();

        DBHelper db = new DBHelper(getApplicationContext());

        family = db.getFamily();

        for(int i=0; i<family.getMembers().size(); i++) {

            Log.println(Log.DEBUG, "recommendation", String.valueOf(family.getMembers().get(i).getMySchemes().get(0)));
        }

        for(int i = 0; i<family.getMembers().size(); i++) {

            for(int j = 0; j<Scheme.getListOfSchemes().size(); j++) {

                result = evaluator.Evaluator(family, family.getMembers().get(i), Scheme.getListOfSchemes().get(j));

                if(result.size() == 5) {

                    family.getMembers().get(i).addToMySchemes(Scheme.getListOfSchemes().get(j).getScheme_id());
                }
            }

        }


*/
    }
}