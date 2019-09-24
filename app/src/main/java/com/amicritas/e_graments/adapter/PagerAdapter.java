package com.amicritas.e_graments.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.amicritas.e_graments.fragments.BasicFragment;
import com.amicritas.e_graments.fragments.PremiumFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;
    public PagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                BasicFragment basicFragment = new BasicFragment();
                return basicFragment;
            case 1:
                PremiumFragment premiumFragment  = new PremiumFragment();
                return premiumFragment;
                default:
                    return null;
        }


    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
