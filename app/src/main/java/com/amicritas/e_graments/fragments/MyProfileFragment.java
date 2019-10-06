package com.amicritas.e_graments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.utils.OnBackPress;


public class MyProfileFragment extends Fragment {
    private final FragmentActivity activity;


    public MyProfileFragment(FragmentActivity activity) {
        // Required empty public constructor
        this.activity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);



        return view;
    }
}
