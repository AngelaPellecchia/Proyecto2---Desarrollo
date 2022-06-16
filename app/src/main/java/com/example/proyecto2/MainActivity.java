package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    LinearLayout f1, f2, f3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);

        Timer tiempo = new Timer();
        MyTimer mitiempo = new MyTimer();
        tiempo.schedule(mitiempo, 4000,4000);
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    int color2 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    int color3 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    f1.setBackgroundColor(color);
                    f2.setBackgroundColor(color2);
                    f3.setBackgroundColor(color3);
                }
            });
        }
    }
}