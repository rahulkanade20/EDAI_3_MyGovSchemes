package com.example.myscheme10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnProfile;

    private Button refresh;

    private Button recommend;

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
                refreshInvoke();
            }
        });
    }

    public void profileInvoke() {

        Intent intent = new Intent(this, NewProfileActivity.class);
        startActivity(intent);

    }

    public void refreshInvoke() {


    }

    public void recommendInvoke() {


    }
}