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

import java.io.IOException;

public class GKActivity extends AppCompatActivity {

    LinearLayout q1, q2, q3, q4, q5, result;
    Button sub1, sub2, sub3, sub4, sub5, back;
    EditText et1, et2, et3, et4, et5;
    TextView tv_result;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gk);

        q1 = (LinearLayout) findViewById(R.id.gkq1);
        q2 = (LinearLayout) findViewById(R.id.gkq2);
        q3 = (LinearLayout) findViewById(R.id.gkq3);
        q4 = (LinearLayout) findViewById(R.id.gkq4);
        q5 = (LinearLayout) findViewById(R.id.gkq5);
        result = (LinearLayout) findViewById(R.id.results);

        sub1 = (Button) findViewById(R.id.gksub_1);
        sub2 = (Button) findViewById(R.id.gksub_2);
        sub3 = (Button) findViewById(R.id.gksub_3);
        sub4 = (Button) findViewById(R.id.gksub_4);
        sub5 = (Button) findViewById(R.id.gksub_5);
        back = (Button) findViewById(R.id.back);

        et1 = (EditText) findViewById(R.id.gket1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);

        tv_result = (TextView) findViewById(R.id.tv_results);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference("Location");
        DatabaseReference myRef = rootRef.child("country");

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et1.getText().toString();

                if(answer.toLowerCase().equals("indonesia")){
                    Toast.makeText(GKActivity.this, "That's right! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                }

                else{
                    Toast.makeText(GKActivity.this, "Oops! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                }

                myRef.setValue("Indonesia");
                q1.setVisibility(View.GONE);
                q2.setVisibility(View.VISIBLE);


            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et2.getText().toString();
                if(answer.trim().toLowerCase().equals("dubai")){

                    Toast.makeText(GKActivity.this, "That's right! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                }

                else{
                    Toast.makeText(GKActivity.this, "Oops! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                }

                myRef.setValue("Dubai");
                q2.setVisibility(View.GONE);
                q3.setVisibility(View.VISIBLE);

            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et3.getText().toString();
                if(answer.trim().toLowerCase().equals("nile")){

                    Toast.makeText(GKActivity.this, "That's right! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                }

                else{
                    Toast.makeText(GKActivity.this, "Oops! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                }

                myRef.setValue("Nile River");
                q3.setVisibility(View.GONE);
                q4.setVisibility(View.VISIBLE);

            }
        });

        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et4.getText().toString();
                if(answer.trim().toLowerCase().equals("athens")){

                    Toast.makeText(GKActivity.this, "That's right! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                }

                else{
                    Toast.makeText(GKActivity.this, "Oops! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                }

                myRef.setValue("Athens");
                q4.setVisibility(View.GONE);
                q5.setVisibility(View.VISIBLE);

            }
        });

        sub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = et1.getText().toString();
                if(answer.trim().toLowerCase().equals("france")){

                    Toast.makeText(GKActivity.this, "That's right! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                    count = count + 1;
                }

                else{
                    Toast.makeText(GKActivity.this, "Oops! Now showing on liquid galaxy", Toast.LENGTH_LONG).show();
                }

                myRef.setValue("France");
                q5.setVisibility(View.GONE);
                result.setVisibility(View.VISIBLE);
                tv_result.setText("You scored " + Integer.toString(count));

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GKActivity.this, QuizSection.class);
                startActivity(intent);
            }
        });


    }
}
