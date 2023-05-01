package com.example.blackoffer.Fragments;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blackoffer.MyPagerAdapter;
import com.example.blackoffer.R;
import com.example.blackoffer.databinding.FragmentExploreBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ExploreFragment extends Fragment {

    FragmentExploreBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String []titles = {"People", "Bag","Contact"};

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabColor = ContextCompat.getColor(getContext(),R.color.white);
                tab.getIcon().setColorFilter(tabColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabColor = ContextCompat.getColor(getContext(),R.color.iconColor);
                tab.getIcon().setColorFilter(tabColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getActivity()));
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setIcon(R.drawable.people);
                    break;
                case 1:
                    tab.setIcon(R.drawable.bag);
                    break;
                case 2:
                    tab.setIcon(R.drawable.contact);
                    break;
            }
        }).attach();
        return view;
    }
}