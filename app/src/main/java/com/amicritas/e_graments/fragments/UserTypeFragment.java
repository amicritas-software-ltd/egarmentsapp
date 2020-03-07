package com.amicritas.e_graments.fragments;


import android.os.Build;
import android.os.Bundle;


import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class UserTypeFragment extends Fragment implements View.OnClickListener {

    private RadioGroup radioGroup;
    private TextView basicTv, asABuyerTv, buingHouseTv, factoryTv, tvAcTypeTitle;
    private CardView expandableView;
    private LinearLayout buyerLlayout, buingHuseLlayout, factoryLlayout, basicLlayout,
            basicSelectLayout, buyerSelectLayout, buyingHouseSelectLayout, factorySelectLayout, noneSelectedLayout, selectLayout;
    private ImageView backButtonIv;
    private String userType="";
    private FloatingActionButton fabContinueButton;
    //private RelativeLayout ;


    public UserTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user_type, container, false);

        init(view);
        onButtonNext();
        onBackButton();

        basicLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fabContinueButton.setEnabled(true);
                    }
                }, 200);
                userType = "basic";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(selectLayout, new AutoTransition());
                }

                noneSelectedLayout.setVisibility(View.GONE);
                basicSelectLayout.setVisibility(View.VISIBLE);
                buyerSelectLayout.setVisibility(View.GONE);
                buyingHouseSelectLayout.setVisibility(View.GONE);
                factorySelectLayout.setVisibility(View.GONE);

                basicTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                asABuyerTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                buingHouseTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                factoryTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                basicLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                buyerLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                buingHuseLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                factoryLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });
        buyerLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fabContinueButton.setEnabled(true);
                    }
                }, 200);
                userType = "buyer";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(selectLayout, new AutoTransition());
                }

                noneSelectedLayout.setVisibility(View.GONE);
                basicSelectLayout.setVisibility(View.GONE);
                buyerSelectLayout.setVisibility(View.VISIBLE);
                buyingHouseSelectLayout.setVisibility(View.GONE);
                factorySelectLayout.setVisibility(View.GONE);

                basicTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                asABuyerTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                buingHouseTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                factoryTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                buyerLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                basicLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                buingHuseLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                factoryLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });

        buingHuseLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fabContinueButton.setEnabled(true);
                    }
                }, 200);
                userType = "buyingHouse";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(selectLayout, new AutoTransition());
                }

                noneSelectedLayout.setVisibility(View.GONE);
                basicSelectLayout.setVisibility(View.GONE);
                buyerSelectLayout.setVisibility(View.GONE);
                buyingHouseSelectLayout.setVisibility(View.VISIBLE);
                factorySelectLayout.setVisibility(View.GONE);

                basicTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                asABuyerTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                buingHouseTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                factoryTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                buingHuseLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                buyerLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                basicLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                factoryLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });

        factoryLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fabContinueButton.setEnabled(true);
                    }
                }, 200);
                userType = "factory";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(selectLayout, new AutoTransition());
                }

                noneSelectedLayout.setVisibility(View.GONE);
                basicSelectLayout.setVisibility(View.GONE);
                buyerSelectLayout.setVisibility(View.GONE);
                buyingHouseSelectLayout.setVisibility(View.GONE);
                factorySelectLayout.setVisibility(View.VISIBLE);

                basicTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                asABuyerTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                buingHouseTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                factoryTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                factoryLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                buyerLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                basicLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                buingHuseLlayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });


        return view;
    }

    private void init(View view) {
        basicTv = view.findViewById(R.id.basicTv);
        asABuyerTv = view.findViewById(R.id.buyerTv);
        buingHouseTv = view.findViewById(R.id.buyinghouseTv);
        factoryTv = view.findViewById(R.id.factoryTv);
        backButtonIv = view.findViewById(R.id.backButtonIv);
        //btnNext = view.findViewById(R.id.btnNext);
        tvAcTypeTitle = view.findViewById(R.id.tvAcTypeTitle);
        basicLlayout = view.findViewById(R.id.basicLlayout);
        buyerLlayout = view.findViewById(R.id.buyerLlayout);
        buingHuseLlayout = view.findViewById(R.id.buyingHouseLlayout);
        factoryLlayout = view.findViewById(R.id.factoryLlayout);

        basicSelectLayout = view.findViewById(R.id.basicSelectLayer);
        buyerSelectLayout = view.findViewById(R.id.buyerSelectLayer);
        buyingHouseSelectLayout = view.findViewById(R.id.buyingHoseSelectLayer);
        factorySelectLayout = view.findViewById(R.id.factorySelectLayer);
        noneSelectedLayout = view.findViewById(R.id.noneSelectLayer);
        selectLayout = view.findViewById(R.id.selectedViewRelativeLayout);
        fabContinueButton = view.findViewById(R.id.fav_continue_registration);
    }

    private void onBackButton() {
        backButtonIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });

    }

    private void onButtonNext() {
        fabContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userType.isEmpty()){
                    Fragment selectedFragment = new RegistationFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_in_right, R.anim.slide_out_right).replace(R.id.main_frame_login,
                            selectedFragment).addToBackStack("tag").commit();
                    //Toast.makeText(getActivity(), userType, Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();
                    bundle.putString("userType", userType);
                    selectedFragment.setArguments(bundle);
                }else {
                    Snackbar.make(getActivity().findViewById(android.R.id.content),"Select any type to continue",Snackbar.LENGTH_LONG).show();

                    //Toast.makeText(getActivity(), "Select any type to continue", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onClick(View v) {

    }
}
