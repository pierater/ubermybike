package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chrisgin on 3/14/15.
 */

public class rentalConfirmation extends Activity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_rental_button:
                launch_rent_button();
                break;
        }

    }

    public void launch_rent_button() {
        Intent intent = new Intent(this,rentalFinal.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_confirmation);
        Button rent = (Button) findViewById(R.id.submit_rental_button);
        rent.setOnClickListener(this);
    }
}