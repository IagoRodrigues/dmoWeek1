package br.edu.ifsp.arq.login_hardcore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AccessActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        }