package com.amicritas.e_graments.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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


        skipLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment selectedFragment = new LoginFragment();
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_in_up, R.anim.slide_out_up).replace(R.id.main_frame_login,
                        selectedFragment).addToBackStack("tag").commit();
                //Toast.makeText(getActivity(), userType, Toast.LENGTH_SHORT).show();

                //startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });


        backButtonIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });

        return view;
    }

}
