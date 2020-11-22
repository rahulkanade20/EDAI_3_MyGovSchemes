package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class NewProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String surname;
    String state;
    String city;
    String caste;
    int familyIncome;
    int familyMembers;

    Family family1 = new Family();

    Family family1_ = new Family();

    private Button btnBack;

    private Button addMember;

    private Button deleteMember;

    private Button save;

    String[] stringArray = {};

    EditText surnameInput;
    EditText noOfMemInput;
    EditText stateInput;
    EditText cityInput;
    Spinner casteInput;
    EditText famIncomeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DBHelper dbh = new DBHelper(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);



        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.caste, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        /*
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genderList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); */
        Log.println(Log.DEBUG, "Test", "Rahul");

        surnameInput = (EditText) findViewById(R.id.txtSurname);
        noOfMemInput = (EditText) findViewById(R.id.txtMemCnt);
        stateInput = (EditText) findViewById(R.id.txtState);
        cityInput = (EditText) findViewById(R.id.txtCity);
    //    casteInput = (EditText) findViewById(R.id.txtCaste);
        famIncomeInput = (EditText) findViewById(R.id.txtIncome);

        casteInput = (Spinner) findViewById(R.id.spinner2);

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

        deleteMember = (Button) findViewById(R.id.buttonDel);

        deleteMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteMemberInvoke();
            }
        });

        save = (Button) findViewById(R.id.save1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInvoke();
            }
        });

        family1_ = dbh.getFamily();

        surnameInput.setText(family1_.getSurname());

        noOfMemInput.setText(Integer.toString(family1_.getNoOfMembers()));

        stateInput.setText(family1_.getState());

        cityInput.setText(family1_.getCity());

        //casteInput.setText(family1_.getCaste());

        famIncomeInput.setText(Integer.toString(family1_.getFamilyIncome()));


    }

    public void backInvoke() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void addMemberInvoke() {

        Intent intent = new Intent(this, PersonalInfoActivity.class);
        startActivity(intent);
    }

    public void deleteMemberInvoke() {

        Intent intent = new Intent(this, deleteActivity.class);
        startActivity(intent);
    }

    public void saveInvoke() {

        surname = surnameInput.getText().toString();
        state = stateInput.getText().toString();
        city = cityInput.getText().toString();
        caste = casteInput.getSelectedItem().toString();
        familyMembers = Integer.valueOf(noOfMemInput.getText().toString());
        familyIncome = Integer.valueOf(famIncomeInput.getText().toString());

        family1.setSurname(surname);
        family1.setState(state);
        family1.setCity(city);
        family1.setCaste(caste);
        family1.setNoOfMembers(familyMembers);
        family1.setFamilyIncome(familyIncome);

        boolean result = family1.save(getApplicationContext());
        if(result == true) {

            Log.println(Log.DEBUG, "Test", "family.save returning true");
        }

        else {

            Log.println(Log.DEBUG, "Test", "family.save returning false");
        }

        Log.println(Log.DEBUG, "Test", surname);
        Log.println(Log.DEBUG, "Test", state);
        Log.println(Log.DEBUG, "Test", city);
        Log.println(Log.DEBUG, "Test", caste);
        Log.println(Log.DEBUG, "Test", Integer.toString(familyMembers));
        Log.println(Log.DEBUG, "Test", Integer.toString(familyIncome));


    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }


}