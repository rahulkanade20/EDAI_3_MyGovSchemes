package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class viewMembersActivity extends AppCompatActivity {

    private Button btnBack;

    Family family = new Family();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_members);

        DBHelper db = new DBHelper(getApplicationContext());

        family = db.getFamily();

        List<String> names = new ArrayList<String>();

        names.add("Members");

        for(int i=0; i<family.getMembers().size(); i++) {

            names.add(family.getMembers().get(i).getName());
        }


        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backInvoke();
            }


        });
    }

    public void backInvoke() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}