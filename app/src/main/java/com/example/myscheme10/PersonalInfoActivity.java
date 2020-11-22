package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonalInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button save;

    private Button btnBack;

    private Spinner spinner1, spinner3;

    Member member = new Member();

    Family family = new Family();

    EditText nameInput;
    EditText ageInput;
    Spinner occupationInput;
    EditText yearlyIncomeInput;
    Spinner genderInput;

    String name;
    int age ;
    String occupation;
    int yearlyIncome;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        addItemsOnSpinner3();

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genderList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        nameInput = (EditText) findViewById(R.id.editTextTextPersonName8);
        ageInput = (EditText) findViewById(R.id.editTextNumber3);
        occupationInput = (Spinner) findViewById(R.id.spinner3);
        yearlyIncomeInput = (EditText) findViewById(R.id.editTextNumber4);

        genderInput = (Spinner) findViewById(R.id.spinner1);


        save = (Button) findViewById(R.id.save2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInvoke();
            }
        });

        btnBack = (Button) findViewById(R.id.cancel2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backInvoke();
            }


        });
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void saveInvoke() {

        name = nameInput.getText().toString();
        occupation = occupationInput.getSelectedItem().toString();
        age = Integer.valueOf(ageInput.getText().toString());
        yearlyIncome = Integer.valueOf(yearlyIncomeInput.getText().toString());

        gender = genderInput.getSelectedItem().toString();

        member.setName(name);
        member.setAge(age);
        member.setOccupation(occupation);
        member.setYearlyIncome(yearlyIncome);
        member.setGender(gender);

        family.addMember(member);

        Log.println(Log.DEBUG, "TestMember", name);
        Log.println(Log.DEBUG, "TestMember", occupation);
        Log.println(Log.DEBUG, "TestMember", gender);
        Log.println(Log.DEBUG, "TestMember", Integer.toString(age));
        Log.println(Log.DEBUG, "TestMember", Integer.toString(yearlyIncome));
        Log.println(Log.DEBUG, "TestMember", Integer.toString(family.getMembers().size()));

        boolean result = member.add(getApplicationContext(), family.getMembers().get((family.getMembers().size()-1)));

        if(result == true) {

            Log.println(Log.DEBUG, "TestMember", "member.add returning true");
        }

        else {

            Log.println(Log.DEBUG, "TestMember", "member.add returning false");
        }

        Intent intent = new Intent(this, NewProfileActivity.class);
        startActivity(intent);

    }

    public void backInvoke() {

        Intent intent = new Intent(this, NewProfileActivity.class);
        startActivity(intent);

    }

    public void addItemsOnSpinner3() {

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<String> list = new ArrayList<String>();
        list.add("Occupation");
        list.add("Farmer");
        list.add("Businessman");
        list.add("Doctor");
        list.add("Lawyer");
        list.add("Army");
        list.add("Student");
        list.add("Other");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter);
    }
}
