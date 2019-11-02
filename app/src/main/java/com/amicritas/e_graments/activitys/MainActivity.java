package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.amicritas.e_graments.R;
import com.amicritas.e_graments.fragments.MyProfileFragment;
import com.amicritas.e_graments.fragments.UserFragment;
import com.amicritas.e_graments.fragments.TimelineFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.core.Context;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton postFloatingActionButton;
    ImageView backArrowImg, ivHomeicon, ivProfileIcon, tvTextHome, tvProfileText;
    LinearLayout layoutProfile, layoutHome;
    Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivProfileIcon = findViewById(R.id.ivProfileIcon);
        ivHomeicon = findViewById(R.id.ivHomeicon);
        layoutProfile = findViewById(R.id.layoutProfile);
        layoutHome = findViewById(R.id.layoutHome);
        backArrowImg = findViewById(R.id.imgBackArrow);
        tvTextHome = findViewById(R.id.tvTextHome);
        tvProfileText = findViewById(R.id.tvProfileText);

        onBackArrow();
        setProfile();
        setHome();

        postFloatingActionButton = findViewById(R.id.floatingActionButtonAddPost);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                    new TimelineFragment()).commit();
        }

        onfloatingActionButton();

    }

    private void setHome() {
        layoutHome.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tvProfileText.setImageResource(R.drawable.profile_text_white);
                selectedFragment = new TimelineFragment();
                ivProfileIcon.setImageResource(R.drawable.ic_person);
                ivHomeicon.setImageResource(R.drawable.ic_home_violet);
                tvTextHome.setImageResource(R.drawable.home_text);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                        selectedFragment).commit();
            }
        });

    }

    private void setProfile() {
        layoutProfile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tvTextHome.setImageResource(R.drawable.home_text_white);
                tvProfileText.setImageResource(R.drawable.profile_text_violet);
                ivProfileIcon.setImageResource(R.drawable.ic_person_violet);
                ivHomeicon.setImageResource(R.drawable.ic_home_black_24dp);
                selectedFragment = new MyProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                        selectedFragment).commit();
            }
        });
    }

    private void onfloatingActionButton() {
        postFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));
                //openPopUp();
            }
        });
    }


    private void openPopUp() {
        final AlertDialog.Builder alart = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.all_category_popup, null);

        alart.setView(view);
        final AlertDialog alertDialog = alart.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();

        Button nextBtn = view.findViewById(R.id.btnNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                openPopUp2();
                Toast.makeText(MainActivity.this, "Next clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void openPopUp2() {
        final AlertDialog.Builder alart = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.all_category_popup2, null);

        alart.setView(view);
        final AlertDialog alertDialog = alart.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();

        Button nextBtn = view.findViewById(R.id.btnNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Next clicked 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onBackArrow(){
        //backArrowImg.setOnClickListener(view -> onBackPressed());
    }

}
