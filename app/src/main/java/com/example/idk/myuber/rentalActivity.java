package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chrisgin on 3/14/15.
 */
public class rentalActivity extends Activity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_rental_button:
                launch_rent_button();
                break;
        }

    }

    public void launch_rent_button() {
        Intent intent = new Intent(this,rentalConfirmation.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);
        Button rent = (Button) findViewById(R.id.continue_rental_button);
        rent.setOnClickListener(this);
    }
}
