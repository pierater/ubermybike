package com.example.idk.myuber;

import android.app.Activity;
//import android.content.Intent;
//import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by Gabriel on 3/14/2015.
 */
public class SplashActivity extends Activity {
    private static final int SPLASH_SHOW_TIME = 3000;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try{
            Thread.sleep(SPLASH_SHOW_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
     * Async Task: can be used to load DB, images during which the splash screen
     * is shown to user
     */
    /*
    private abstract class BackgroundSplashTask extends AsyncTask {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
    }*/

}
