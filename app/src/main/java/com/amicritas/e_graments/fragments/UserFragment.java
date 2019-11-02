package com.amicritas.e_graments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;

public class UserFragment extends Fragment {

    LinearLayout profileCard, postCard;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user, container, false);


        profileCard = view.findViewById(R.id.profile_card);
        postCard = view.findViewById(R.id.post_card);

        setOnProfileCard();
        setOnMyPost();

        return view;
    }


    private void setOnMyPost() {
        postCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

                fragmentTransaction.replace(R.id.main_frame, new MyPostFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private void setOnProfileCard() {
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

                fragmentTransaction.replace(R.id.main_frame, new MyProfileFragment());

// Start the animated transition.
                fragmentTransaction.commit();
            }
        });
    }

}
