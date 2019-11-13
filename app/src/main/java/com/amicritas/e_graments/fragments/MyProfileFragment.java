package com.amicritas.e_graments.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.activitys.UserUtilsActivity;
import com.amicritas.e_graments.utils.OnBackPress;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;


public class MyProfileFragment extends Fragment {
    //private final FragmentActivity activity;
    ImageView imgBackArrow;
    Toolbar toolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    AppBarLayout appBarLayout;
    LinearLayout myPostLayout, myOrderLayout, myPaymentLayout;
    Dialog myDialog;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        myPaymentLayout = view.findViewById(R.id.myPaymentLayout);
        myOrderLayout = view.findViewById(R.id.myOrderLayout);
        myPostLayout = view.findViewById(R.id.myPostLayout);
        appBarLayout = view.findViewById(R.id.app_bar);
        mCollapsingToolbarLayout = view.findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitleEnabled(false);
        toolbar = view.findViewById(R.id.toolbar);
        //toolbar.setTitle("My Profile");

        myDialog = new Dialog(Objects.requireNonNull(getActivity()));

        //imgBackArrow = view.findViewById(R.id.imgBackArrow);

        //setBackPress();
        setMyPost();
        setOrder();
        setPayment();

        appBarLayout.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, i) -> {
            if (i <= -380){
                toolbar.setTitle("My Profile");
            }else {
                toolbar.setTitle("");
            }
        });

        return view;
    }

    private void setPayment() {
        myPaymentLayout.setOnClickListener(v ->
                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show());
    }

    private void setOrder() {
        myOrderLayout.setOnClickListener(v -> {
            ImageView ivCloseOrderWindow;
            LinearLayout myPostLayout, myOrderLayout;

            myDialog.setContentView(R.layout.order_layout);
            ivCloseOrderWindow = myDialog.findViewById(R.id.ivCloseOrderWindow);
            myPostLayout = myDialog.findViewById(R.id.myPostLayout);
            myOrderLayout = myDialog.findViewById(R.id.myOrderLayout);

            ivCloseOrderWindow.setOnClickListener(v1 -> myDialog.dismiss());

            myPostLayout.setOnClickListener(v12 -> {
                Intent intent = new Intent(getActivity(), UserUtilsActivity.class);
                startActivity(intent);
            });
            myOrderLayout.setOnClickListener(v13 -> {
                Intent intent = new Intent(getActivity(), UserUtilsActivity.class);
                startActivity(intent);
            });
            Objects.requireNonNull(myDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();

            /*PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            popupMenu.inflate(R.menu.order_menu);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                popupMenu.setForceShowIcon(true);
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.menu_my_order:
                            Intent intent = new Intent(getActivity(), UserUtilsActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.menu_my_sale:
                            Intent i = new Intent(getActivity(), UserUtilsActivity.class);
                            startActivity(i);
                            break;
                    }
                    return false;
                }
            });
            popupMenu.show();*/
        });
    }

    private void setMyPost() {
        myPostLayout.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

            fragmentTransaction.replace(R.id.main_frame, new MyPostFragment());
            fragmentTransaction.commit();
        });
    }

    /*private void setBackPress() {
        imgBackArrow.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.replace(R.id.main_frame, new UserFragment());
            fragmentTransaction.commit();
        });
    }*/
}
