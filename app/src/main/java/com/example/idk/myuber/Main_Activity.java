package com.example.idk.myuber;

import android.app.ActionBar;
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
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
        fragmentManager = getSupportFragmentManager();

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Map");
        tab1.setTabListener(this);

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

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0)
        {
            return "Map";
        }
        if(position == 1)
        {
            return "Post Bike";
        }
        
        return null;
    }
}