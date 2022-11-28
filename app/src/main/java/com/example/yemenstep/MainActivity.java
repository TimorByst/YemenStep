package com.example.yemenstep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public interface Callback_Ticker{void tick();}
    private MyTicker myTicker;

    private MaterialTextView main_LBL_step;

    private Random random = new Random();
    private int num;
    private int steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViews();
        initCallback();
        countSteps();

    }

    private void countSteps() {
        myTicker.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void initCallback() {
        myTicker = new MyTicker(new Callback_Ticker() {
            @Override
            public void tick() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ticker();
                    }
                });
            }
        });
    }

    private void findViews(){
        main_LBL_step = findViewById(R.id.main_LBL_step);
    }

    public void ticker() {
        num = random.nextInt(100);
        steps = Integer.parseInt(main_LBL_step.getText().toString());
        if(num > 90)
            steps += 2;
        else if(num > 70)
            steps++;

        main_LBL_step.setText(""+steps);
    }
}