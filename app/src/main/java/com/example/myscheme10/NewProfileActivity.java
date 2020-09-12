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

public class NewProfileActivity extends AppCompatActivity {

    private Button btnBack;

    private Button addMember;

    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);
        /*
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genderList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); */
        Log.println(Log.DEBUG, "Test", "Rajesh");
        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backInvoke();
            }


        });

        addMember = (Button) findViewById(R.id.button4);

        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMemberInvoke();
            }
        });

        save = (Button) findViewById(R.id.save1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInvoke();
            }
        });
    }

    public void backInvoke() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void addMemberInvoke() {

        Intent intent = new Intent(this, PersonalInfoActivity.class);
        startActivity(intent);
    }

    public void saveInvoke() {



    }

/*
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

 */
}