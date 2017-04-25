package com.example.jonguk.andrappintro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Jonguk on 2017. 4. 24..
 */

public class IntroPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mItems;

    public IntroPageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        mItems = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }
}
