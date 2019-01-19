package com.example.android.tflitecamerademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class QuizSection extends AppCompatActivity {

    CardView draw, flag, gk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_section);

        draw = (CardView) findViewById(R.id.draw);
        flag = (CardView) findViewById(R.id.flag);
        gk = (CardView) findViewById(R.id.gk);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSection.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSection.this, FlagActivity.class);
                startActivity(intent);
            }
        });

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizSection.this, GKActivity.class);
                startActivity(intent);
            }
        });




    }
}
