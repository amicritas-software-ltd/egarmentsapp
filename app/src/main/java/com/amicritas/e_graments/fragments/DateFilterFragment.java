package com.amicritas.e_graments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.amicritas.e_graments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateFilterFragment extends Fragment {

    private LinearLayout categoryBlankLayout;


    public DateFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_filter, container, false);
        categoryBlankLayout = view.findViewById(R.id.categoryBlankLayout);
        categoryBlankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_top).remove(DateFilterFragment.this).commit();
            }
        });

        return view;
    }


}
