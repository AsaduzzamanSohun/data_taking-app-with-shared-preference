package com.example.datatakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DisplayActivity extends AppCompatActivity {


    WebView webView;
    TextView textView, tvName, tvEmail, tvPhone, tvSubject, tvUniversity;
    FloatingActionButton floatingActionButton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_Phone);
        tvSubject = findViewById(R.id.tv_subject);
        tvUniversity = findViewById(R.id.tv_university);
        floatingActionButton = findViewById(R.id.floating_btn);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);

        String setName = sharedPreferences.getString("name", "");
        String setEmail = sharedPreferences.getString("email", "");
        String setPhone = sharedPreferences.getString("phone", "");
        String setSubject = sharedPreferences.getString("subject", "");
        String setUniversity = sharedPreferences.getString("university", "");

        tvName.setText("Name: "+setName);
        tvEmail.setText("Email: "+setEmail);
        tvPhone.setText("Phone: "+setPhone);
        tvSubject.setText("Subject: "+setSubject);
        tvUniversity.setText("University: "+setUniversity);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setIcon(R.drawable.baseline_add_alert_24)
                .setMessage("Are you sure want to exit?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAndRemoveTask();

                    }
                })
                .show();
    }
}