package com.example.order;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();



        Thread thread = new Thread(){
            public void run(){

                try {
                    sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();

                }finally {

                    FirebaseUser crrentUser = firebaseAuth.getCurrentUser();
                    if (crrentUser == null){
                        Intent registerIntent = new Intent(SplashActivity.this , Register_Activity.class);
                        startActivity(registerIntent);
                        finish();

                    }else {

                        Intent mainintent = new Intent(SplashActivity.this , MainActivity.class);
                        startActivity(mainintent);
                        finish();
                    }


                }
                finish();
            }




        };thread.start();



    }




}