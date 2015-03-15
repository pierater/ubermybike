package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chrisgin on 3/15/15.
 */
public class rentalFinal extends Activity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_menu_button:
                launch_rent_button();
                break;
        }

    }

    public void launch_rent_button() {
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_final);
        Button rent = (Button) findViewById(R.id.main_menu_button);
        rent.setOnClickListener(this);
    }
}