package com.example.idk.myuber;

import android.app.Activity;
//import android.content.Intent;
//import android.os.AsyncTask;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Gabriel on 3/14/2015.
 */
public class SplashActivity extends Activity {
    private static final int SPLASH_SHOW_TIME = 2000;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Main_Activity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SHOW_TIME);

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
