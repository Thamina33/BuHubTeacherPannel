package com.example.buhubteacherpannel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainPage extends AppCompatActivity {

    TabLayout mtabLayout;
    TabItem signInF;
    TabItem signUpF;
    ViewPager mPager;
    PageController_tabLayout  mPageConteoller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //hide actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mtabLayout = findViewById(R.id.tabLayput);
        signInF = findViewById(R.id.signInF);
        signUpF = findViewById(R.id.signUpF);
        mPager = findViewById(R.id.viewPager);

        mPageConteoller = new PageController_tabLayout(getSupportFragmentManager(),mtabLayout.getTabCount());
        mPager.setAdapter(mPageConteoller);

        mtabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtabLayout));


    }
}
