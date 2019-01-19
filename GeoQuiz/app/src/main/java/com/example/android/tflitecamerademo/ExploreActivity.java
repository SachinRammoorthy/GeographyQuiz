package com.example.android.tflitecamerademo;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExploreActivity extends AppCompatActivity {

    CardView eiffel;
    CardView taj;
    CardView statueOfLiberty;
    CardView christ;
    CardView machuPicchu;
    CardView chichenItza;
    CardView colosseum;
    CardView pyramids;

    ImageButton searchBtn;
    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = database.getReference("Location");
        DatabaseReference myRef = rootRef.child("country");

        eiffel = (CardView) findViewById(R.id.eiffel);
        taj = (CardView) findViewById(R.id.taj);
        statueOfLiberty = (CardView) findViewById(R.id.statue_of_liberty);
        chichenItza = (CardView) findViewById(R.id.chichen);
        christ = (CardView) findViewById(R.id.christ);
        machuPicchu = (CardView) findViewById(R.id.machu);
        colosseum = (CardView) findViewById(R.id.colosseum);
        pyramids = (CardView) findViewById(R.id.pyramids);

        searchBtn = (ImageButton) findViewById(R.id.searchbtn);
        searchText = (EditText) findViewById(R.id.search);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue(searchText.getText().toString());
                Toast.makeText(ExploreActivity.this, "Viewing " + searchText.getText().toString() + " on Liquid Galaxy.", Toast.LENGTH_LONG).show();
            }
        });


        eiffel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Eiffel Tower");
            }
        });

        taj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Taj Mahal");
            }
        });

        machuPicchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Machu Picchu");
            }
        });

        christ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Christ the Redeemer");
            }
        });

        chichenItza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Chichen Itza");
            }
        });

        statueOfLiberty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Statue of Liberty");
            }
        });

        pyramids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("The Great Pyramid of Giza");
            }
        });

        colosseum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue("Colosseum");
            }
        });


        //myRef.setValue("India");
    }


}
