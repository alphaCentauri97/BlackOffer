package com.example.blackoffer.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;

import com.example.blackoffer.PurposeAdapter;
import com.example.blackoffer.R;
import com.example.blackoffer.databinding.FragmentRefineBinding;
import com.google.android.material.slider.Slider;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

public class RefineFragment extends Fragment {

    FragmentRefineBinding binding;
    List<String> purposeList;
    PurposeAdapter adapter;

    public RefineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRefineBinding.inflate(inflater, container, false);

        binding.slider.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int val = (int)value;
                slider.setValue(val);
            }
        });
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL));
        purposeList = new ArrayList<>();
        purposeList.add("Coffee");
        purposeList.add("Buisness");
        purposeList.add("Hobbers");
        purposeList.add("Friendship");
        purposeList.add("Movies");
        purposeList.add("Dining");
        purposeList.add("Dating");
        purposeList.add("Matrimony");
        adapter = new PurposeAdapter(getActivity(),purposeList);
        binding.recyclerView.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.spinner_availability,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerMaritialStatus.setAdapter(adapter);
        binding.spinnerMaritialStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return binding.getRoot();
    }
}