package com.amicritas.e_graments.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.utils.OnBackPress;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;


public class MyProfileFragment extends Fragment {
    //private final FragmentActivity activity;
    ImageView imgBackArrow;
    Toolbar toolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    AppBarLayout appBarLayout;
    LinearLayout myPostLayout;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        myPostLayout = view.findViewById(R.id.myPostLayout);
        appBarLayout = view.findViewById(R.id.app_bar);
        mCollapsingToolbarLayout = view.findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitleEnabled(false);
        toolbar = view.findViewById(R.id.toolbar);
        //toolbar.setTitle("My Profile");

        //imgBackArrow = view.findViewById(R.id.imgBackArrow);

        //setBackPress();
        setMyPost();

        appBarLayout.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, i) -> {
            if (i <= -320){
                toolbar.setTitle("My Profile");
            }else {
                toolbar.setTitle("");
            }
        });

        return view;
    }

    private void setMyPost() {
        myPostLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

                fragmentTransaction.replace(R.id.main_frame, new MyPostFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private void setBackPress() {
        imgBackArrow.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.replace(R.id.main_frame, new UserFragment());
            fragmentTransaction.commit();
        });
    }
}
