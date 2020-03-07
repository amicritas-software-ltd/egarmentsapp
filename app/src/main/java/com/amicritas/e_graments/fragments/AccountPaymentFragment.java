package com.amicritas.e_graments.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.activitys.MainActivity;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountPaymentFragment extends Fragment {
    private LinearLayout skipLlayout;
    private ImageView backButtonIv;
    private String userType;


    public AccountPaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_payment, container, false);
        skipLlayout = view.findViewById(R.id.skipLlayout);
        backButtonIv = view.findViewById(R.id.backButtonIv);

        Bundle bundle = getArguments();
        userType = bundle.getString("userType");


        skipLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment selectedFragment = new RegistationFragment();
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_in_up, R.anim.slide_out_up).replace(R.id.main_frame_login,
                        selectedFragment).addToBackStack("tag").commit();

                Bundle bundle = new Bundle();
                bundle.putString("userType", userType);
                bundle.putBoolean("skip", true);
                selectedFragment.setArguments(bundle);
                Toast.makeText(getActivity(),userType, Toast.LENGTH_SHORT).show();

            }
        });


        backButtonIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Objects.requireNonNull(getActivity()).onBackPressed();

                /*Fragment selectedFragment = new RegistationFragment();
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_in_up, R.anim.slide_out_up).replace(R.id.main_frame_login,
                        selectedFragment).addToBackStack("tag").commit();*/
                startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });

        return view;
    }

}
