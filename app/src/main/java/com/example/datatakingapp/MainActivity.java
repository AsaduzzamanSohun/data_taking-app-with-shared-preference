package com.example.datatakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone, subject, university;
    AppCompatButton saveBtn, nextBtn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_text);
        email = findViewById(R.id.email_text);
        phone = findViewById(R.id.phone_text);
        subject = findViewById(R.id.subject_text);
        university = findViewById(R.id.university_text);
        saveBtn = findViewById(R.id.save_btn);
        nextBtn = findViewById(R.id.next_btn);

        sharedPreferences = getSharedPreferences(""+getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        name.setText(sharedPreferences.getString("name", ""));
        email.setText(sharedPreferences.getString("email", ""));
        phone.setText(sharedPreferences.getString("phone", ""));
        subject.setText(sharedPreferences.getString("subject", ""));
        university.setText(sharedPreferences.getString("university", ""));



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myName = name.getText().toString();
                String myEmail = email.getText().toString();
                String myPhone = phone.getText().toString();
                String mySubject = subject.getText().toString();
                String myUniversity = university.getText().toString();

                editor.putString("name", ""+myName);
                editor.putString("email", ""+myEmail);
                editor.putString("phone", ""+myPhone);
                editor.putString("subject", ""+mySubject);
                editor.putString("university", ""+myUniversity);

                editor.apply();

            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);

                finish();

            }
        });

    }
}