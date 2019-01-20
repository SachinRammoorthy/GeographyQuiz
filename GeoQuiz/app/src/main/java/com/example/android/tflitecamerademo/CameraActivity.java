/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;

/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends Activity {

  LinearLayout draw1, draw2, draw3, draw4, draw5;

  FirebaseDatabase database;
  DatabaseReference rootRef;
  DatabaseReference myRef;

  TextView sample;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
    if (null == savedInstanceState) {
      getFragmentManager()
          .beginTransaction()
          .replace(R.id.container, Camera2BasicFragment.newInstance())
          .commit();
    }

     database = FirebaseDatabase.getInstance();
     rootRef = database.getReference("Location");
     myRef = rootRef.child("country");

     sample = (TextView) findViewById(R.id.sample);

    draw1 = (LinearLayout) findViewById(R.id.draw1);
    //draw2 = (LinearLayout) findViewById(R.id.draw2);
    draw3 = (LinearLayout) findViewById(R.id.draw3);
    draw4 = (LinearLayout) findViewById(R.id.draw4);
    draw5 = (LinearLayout) findViewById(R.id.draw5);

    checkAnswerOne();
      final Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
          @Override
          public void run() {
              checkAnswerThree();
          }
      }, 12000);

      final Handler handler2 = new Handler();
      handler2.postDelayed(new Runnable() {
          @Override
          public void run() {
              checkAnswerFour();
          }
      }, 24000);

      final Handler handler3 = new Handler();
      handler3.postDelayed(new Runnable() {
          @Override
          public void run() {
              checkAnswerFive();
          }
      }, 36000);

      /*final Handler handler4 = new Handler();
      handler4.postDelayed(new Runnable() {
          @Override
          public void run() {
              checkAnswerFive();
              //Do something after 100ms
          }
      }, 40000);*/

    //Start a timer for 2 s
      //      After 2 seconds, get the value of textview, and check.

   /* final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        try{
          Toast.makeText(CameraActivity.this, Camera2BasicFragment.getFinalAnswer().toString(), Toast.LENGTH_LONG).show();
          //return textView.getText().toString();
        } catch (NullPointerException e){
          Toast.makeText(CameraActivity.this, "Not found", Toast.LENGTH_LONG).show();
          //return "Not found";
        }
      }
    }, 5000);*/

    //Toast.makeText(CameraActivity.this, Camera2BasicFragment.getFinalAnswer().toString(), Toast.LENGTH_LONG).show();

  }

  public void checkAnswerOne(){
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        try{
          //return textView.getText().toString();
          //sample.setText(Camera2BasicFragment.getFinalAnswer().toString().toLowerCase());
          if (Camera2BasicFragment.getFinalAnswer().trim().toLowerCase().equals("india")){
            Toast.makeText(CameraActivity.this, "That's right! Viewing on LG", Toast.LENGTH_LONG).show();
            //Switch layout and call next method

            draw1.setVisibility(View.GONE);
            draw3.setVisibility(View.VISIBLE);
            //checkAnswerTwo();

          } else {
            Toast.makeText(CameraActivity.this, "Oops! Right answer on LG", Toast.LENGTH_LONG).show();
          }
        } catch (NullPointerException e){
          Toast.makeText(CameraActivity.this, "Not found", Toast.LENGTH_LONG).show();
          //return "Not found";
        }
        myRef.setValue("India");
      }
    }, 10000);
  }


  /*public void checkAnswerTwo(){
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        try{
          //return textView.getText().toString();
          if (Camera2BasicFragment.getFinalAnswer().trim().toLowerCase().equals("saudiarabia")){
            Toast.makeText(CameraActivity.this, "That's right! Viewing on LG", Toast.LENGTH_LONG).show();
            //Switch layout and call next method

            draw2.setVisibility(View.GONE);
            draw3.setVisibility(View.VISIBLE);
            //checkAnswerThree();

          } else {
            Toast.makeText(CameraActivity.this, "Oops! Right answer on LG", Toast.LENGTH_LONG).show();
          }
        } catch (NullPointerException e){
          Toast.makeText(CameraActivity.this, "Not found", Toast.LENGTH_LONG).show();
          //return "Not found";
        }
        myRef.setValue("Saudi Arabia");
      }
    }, 10000);
  } */


  public void checkAnswerThree(){
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        try{
          //return textView.getText().toString();
          if (Camera2BasicFragment.getFinalAnswer().trim().toLowerCase().equals("taiwan")){
            Toast.makeText(CameraActivity.this, "That's right! Viewing on LG", Toast.LENGTH_LONG).show();
            //Switch layout and call next method

            draw3.setVisibility(View.GONE);
            draw4.setVisibility(View.VISIBLE);
            //checkAnswerFour();

          } else {
            Toast.makeText(CameraActivity.this, "Oops! Right answer on LG", Toast.LENGTH_LONG).show();
          }
        } catch (NullPointerException e){
          Toast.makeText(CameraActivity.this, "Not found", Toast.LENGTH_LONG).show();
          //return "Not found";
        }
        myRef.setValue("Taiwan");
      }
    }, 10000);
  }


  public void checkAnswerFour(){
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        try{
          //return textView.getText().toString();
          if (Camera2BasicFragment.getFinalAnswer().trim().toLowerCase().equals("srilanka")){
            Toast.makeText(CameraActivity.this, "That's right! Viewing on LG", Toast.LENGTH_LONG).show();
            //Switch layout and call next method

            draw4.setVisibility(View.GONE);
            draw5.setVisibility(View.VISIBLE);
            //checkAnswerFive();

          } else {
            Toast.makeText(CameraActivity.this, "Oops! Right answer on LG", Toast.LENGTH_LONG).show();
          }
        } catch (NullPointerException e){
          Toast.makeText(CameraActivity.this, "Not found", Toast.LENGTH_LONG).show();
          //return "Not found";
        }
        myRef.setValue("Sri Lanka");
      }
    }, 10000);
  }


  public void checkAnswerFive(){
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        try{
          //return textView.getText().toString();
          if (Camera2BasicFragment.getFinalAnswer().trim().toLowerCase().equals("australia")){
            Toast.makeText(CameraActivity.this, "That's right! Viewing on LG", Toast.LENGTH_LONG).show();
            //Switch layout and call next method

            startActivity(new Intent(CameraActivity.this, StartActivity.class));

          } else {
            Toast.makeText(CameraActivity.this, "Oops! Right answer on LG", Toast.LENGTH_LONG).show();
          }
        } catch (NullPointerException e){
          Toast.makeText(CameraActivity.this, "Not found", Toast.LENGTH_LONG).show();
          //return "Not found";
        }
        myRef.setValue("Australia");
      }
    }, 10000);
  }



}
