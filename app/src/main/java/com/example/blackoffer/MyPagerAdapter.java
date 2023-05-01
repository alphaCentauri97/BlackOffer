package com.example.blackoffer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.blackoffer.TabbedFragment.BagFragment;
import com.example.blackoffer.TabbedFragment.ContactFragment;
import com.example.blackoffer.TabbedFragment.PeopleFragment;


public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){

            case 0: return new PeopleFragment();
            case 1: return new BagFragment();
            case 2: return new ContactFragment();

            default:return new PeopleFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
