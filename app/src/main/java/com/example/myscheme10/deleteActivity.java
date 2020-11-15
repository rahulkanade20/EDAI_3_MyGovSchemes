package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class deleteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button btnBack;

    private Button confirm;

    Spinner input;

    String name;

    Family family = new Family();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        DBHelper db = new DBHelper(getApplicationContext());

    ///    Family family = new Family();

        family = db.getFamily();

        List<String> names = new ArrayList<String>();

        Log.println(Log.DEBUG, "deleteMember", String.valueOf(family.getMembers().size()));


        for(int i=0; i<family.getMembers().size(); i++) {

                names.add(family.getMembers().get(i).getName());
        }


        Spinner spinner = (Spinner) findViewById(R.id.spinnerDel);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);

        input = (Spinner) findViewById(R.id.spinnerDel);


    //    for(int i=0; i<family.getMembers().size(); i++) {

    //        adapter.add(family.getMembers().get(i).getName());
    //    }

    //    spinner.setAdapter(adapter);

        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backInvoke();
            }


        });

        confirm = (Button) findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInvoke();
            }


        });

    }

    public void backInvoke() {

        Intent intent = new Intent(this, NewProfileActivity.class);
        startActivity(intent);

    }

    public void confirmInvoke() {

        DBHelper db = new DBHelper(getApplicationContext());

        name = input.getSelectedItem().toString();

        for(int i=0; i<family.getMembers().size(); i++) {

            if(family.getMembers().get(i).getName() == name){
                Log.println(Log.DEBUG, "deleteMember", "about to delete member : " + name);

                family.getMembers().remove(i);
                db.deleteMember(name);

            }

        }

        Log.println(Log.DEBUG, "deleteMember", name);



        Intent intent = new Intent(this, NewProfileActivity.class);
        startActivity(intent);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }


}