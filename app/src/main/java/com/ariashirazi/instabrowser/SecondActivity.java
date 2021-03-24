package com.ariashirazi.instabrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    TextView txt1;
    Button button16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }



    public void btnStartClick(View view){

        txt1 = findViewById(R.id.txt1);
        txt1.setText("Your request is successfully submitted.We try to optimize your account.It may take a few hours or days");



    }
}
