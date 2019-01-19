package com.example.android.tflitecamerademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FlagActivity extends AppCompatActivity {

    LinearLayout q1, q2, q3, q4, q5, results;
    Button sub1, sub2, sub3, sub4, sub5, back;
    EditText et1, et2, et3, et4, et5;
    TextView tv;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        q1 = (LinearLayout) findViewById(R.id.q1);
        q2 = (LinearLayout) findViewById(R.id.q2);
        q3 = (LinearLayout) findViewById(R.id.q3);
        q4 = (LinearLayout) findViewById(R.id.q4);
        q5 = (LinearLayout) findViewById(R.id.q5);
        sub1 = (Button) findViewById(R.id.sub_1);
        sub2 = (Button) findViewById(R.id.sub_2);
        sub3 = (Button) findViewById(R.id.sub_3);
        sub4 = (Button) findViewById(R.id.sub_4);
        sub5 = (Button) findViewById(R.id.sub_5);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);

        back = (Button) findViewById(R.id.back);
        results = (LinearLayout) findViewById(R.id.results);
        tv = (TextView) findViewById(R.id.tv_results);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference("Location");
        DatabaseReference myRef = rootRef.child("country");

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et1.getText().toString();
                if (answer.toLowerCase().equals("india")){
                    Toast.makeText(FlagActivity.this, "That's the right answer! Viewing on Liquid Galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                } else {
                    Toast.makeText(FlagActivity.this, "Nope, that ain't right! Showing the right answer on Liquid Galaxy.", Toast.LENGTH_LONG).show();
                }
                myRef.setValue("India");
                q1.setVisibility(View.GONE);
                q2.setVisibility(View.VISIBLE);
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et2.getText().toString();
                if (answer.toLowerCase().equals("united states")){
                    Toast.makeText(FlagActivity.this, "That's the right answer! Viewing on Liquid Galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                } else {
                    Toast.makeText(FlagActivity.this, "Nope, that ain't right! Showing the right answer on Liquid Galaxy.", Toast.LENGTH_LONG).show();
                }
                myRef.setValue("United States of America");
                q2.setVisibility(View.GONE);
                q3.setVisibility(View.VISIBLE);
            }
        });


        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et3.getText().toString();
                if (answer.toLowerCase().equals("china")){
                    Toast.makeText(FlagActivity.this, "That's the right answer! Viewing on Liquid Galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                } else {
                    Toast.makeText(FlagActivity.this, "Nope, that ain't right! Showing the right answer on Liquid Galaxy.", Toast.LENGTH_LONG).show();
                }
                myRef.setValue("China");
                q3.setVisibility(View.GONE);
                q4.setVisibility(View.VISIBLE);
            }
        });


        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et4.getText().toString();
                if (answer.toLowerCase().equals("sri lanka")){
                    Toast.makeText(FlagActivity.this, "That's the right answer! Viewing on Liquid Galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                } else {
                    Toast.makeText(FlagActivity.this, "Nope, that ain't right! Showing the right answer on Liquid Galaxy.", Toast.LENGTH_LONG).show();
                }
                myRef.setValue("Sri Lanka");
                q4.setVisibility(View.GONE);
                q5.setVisibility(View.VISIBLE);
            }
        });


        sub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et5.getText().toString();
                if (answer.toLowerCase().equals("poland")){
                    Toast.makeText(FlagActivity.this, "That's the right answer! Viewing on Liquid Galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                } else {
                    Toast.makeText(FlagActivity.this, "Nope, that ain't right! Showing the right answer on Liquid Galaxy.", Toast.LENGTH_LONG).show();
                }
                myRef.setValue("Poland");
                q5.setVisibility(View.GONE);
                tv.setText("You scored " + Integer.toString(count));
                results.setVisibility(View.VISIBLE);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlagActivity.this, StartActivity.class));
            }
        });



    }
}
