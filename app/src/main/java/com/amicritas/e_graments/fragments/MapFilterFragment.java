package com.amicritas.e_graments.fragments;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;


import com.amicritas.e_graments.R;
import com.amicritas.e_graments.databinding.FragmentMapFilterBinding;



public class MapFilterFragment extends Fragment {



    public MapFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMapFilterBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_map_filter, container, false);



        return binding.getRoot();
    }



    /*private void hideSoftKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(this,INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }*/

    public void openMap(View view) {
        Toast.makeText(getActivity(), "Map opened", Toast.LENGTH_SHORT).show();
    }

}
