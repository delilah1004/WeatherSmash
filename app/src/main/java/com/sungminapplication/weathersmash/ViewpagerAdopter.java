package com.sungminapplication.weathersmash;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;

public class ViewpagerAdopter extends FragmentPagerAdapter {
    public ViewpagerAdopter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HomeFirstFragment();

            case 1:
                return new HomeTwoFragment();

            case 2:
                return new HomeThreeFragment();

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
