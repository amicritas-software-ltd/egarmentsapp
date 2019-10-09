package com.amicritas.e_graments.fragments;


import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;



public class DateFilterFragment extends Fragment {

    private LinearLayout categoryBlankLayout;
    DatePicker filterDatePicker;
    Button getDatebtn;
    View fromDateView, toDateView;
    TextView fromDateTv, toDateTv;
    String filterStartDate, filterEndDate;

    boolean BUTTON_PRESS_STATUS = true;



    public DateFilterFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_filter, container, false);
        filterDatePicker = view.findViewById(R.id.filterDatePeaker);
        getDatebtn = view.findViewById(R.id.btnGetDate);
        fromDateTv = view.findViewById(R.id.tvFromDate);
        toDateTv = view.findViewById(R.id.tvToDate);
        fromDateView = view.findViewById(R.id.viewFromDate);
        toDateView = view.findViewById(R.id.viewToDate);
        fromDateView.setBackgroundResource(R.color.colorPrimary);
        //fromDateView.setAnimation();

        fromDateTv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                getDatebtn.setText("Next");
                BUTTON_PRESS_STATUS = true;
                fromDateView.setBackgroundResource(R.color.colorPrimary);
                toDateView.setBackgroundResource(R.color.white);
                filterStartDate = currentDate();
            }
        });

        toDateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatebtn.setText("Ok");
                BUTTON_PRESS_STATUS = false;
                fromDateView.setBackgroundResource(R.color.white);
                toDateView.setBackgroundResource(R.color.colorPrimary);
                filterEndDate = currentDate();
            }
        });

        getDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (BUTTON_PRESS_STATUS == true){
                    getDatebtn.setText("Ok");
                    fromDateView.setBackgroundResource(R.color.white);
                    toDateView.setBackgroundResource(R.color.colorPrimary);
                    filterStartDate = currentDate();
                    BUTTON_PRESS_STATUS = false;
                }else {
                    filterEndDate = currentDate();
                    Toast.makeText(getActivity(), "Start date: "+filterStartDate+" End date: "+filterEndDate, Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(getActivity(), "date: "+currentDate(), Toast.LENGTH_SHORT).show();
            }
        });


        categoryBlankLayout = view.findViewById(R.id.categoryBlankLayout);
        categoryBlankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_out_bottom, R.anim.slide_out_top).remove(DateFilterFragment.this).commit();
            }
        });


        return view;
    }

    String currentDate(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(filterDatePicker.getDayOfMonth()+"/");
        stringBuilder.append((filterDatePicker.getMonth()+1)+"/");
        stringBuilder.append(filterDatePicker.getYear());

        return stringBuilder.toString();
    }



}
