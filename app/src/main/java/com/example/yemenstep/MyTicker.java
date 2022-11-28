package com.example.yemenstep;

import java.util.Timer;
import java.util.TimerTask;

public class MyTicker {
    private Timer timer = new Timer();
    private MainActivity.Callback_Ticker callback_ticker;
    public MyTicker(MainActivity.Callback_Ticker callback_ticker){
        this.callback_ticker = callback_ticker;
    }
    private int DELAY = 1000;


    public void start(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                callback_ticker.tick();
            }
        },DELAY, DELAY);
    }

    public void stop(){
        timer.cancel();
    }
}
