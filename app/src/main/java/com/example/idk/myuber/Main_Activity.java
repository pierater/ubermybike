package com.example.idk.myuber;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Mikaami13 on 3/14/2015.
 */
public class Main_Activity extends FragmentActivity{

    ViewPager viewPager=null;
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
        fragmentManager = getSupportFragmentManager();
    }


}

class MyAdapter extends FragmentPagerAdapter
{


    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i == 0)
        {
            fragment = new MapsActivity();
        }
        if(i == 1)
        {
            fragment = new PostBike();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}