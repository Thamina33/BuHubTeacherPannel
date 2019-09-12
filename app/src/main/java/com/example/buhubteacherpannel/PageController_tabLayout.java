package com.example.buhubteacherpannel;

import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageController_tabLayout extends FragmentPagerAdapter {

    int tabCount;

    public PageController_tabLayout(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new SignIn_Fragment();
            case 1:
                return new SignUp_Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
