package com.example.ejemplo;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.slider.RangeSlider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(){
            @Override
            public void run()
            {
                try {
                    sleep(3000);
                }
                catch (InterruptedException e){e.printStackTrace();}
                finally{
                    Intent intent = new Intent(MainActivity.this, Principal.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
        }
    }