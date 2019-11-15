package com.amicritas.e_graments.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.amicritas.e_graments.R;
import com.amicritas.e_graments.fragments.MyProfileFragment;
import com.amicritas.e_graments.fragments.TimelineFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    FloatingActionButton postFloatingActionButton;
    ImageView backArrowImg, ivHomeicon, ivProfileIcon, tvTextHome, tvProfileText, ivIconFavorite, ivTextFavorite;
    LinearLayout layoutProfile, layoutHome, layoutSave, dehazeLayout;
    Fragment selectedFragment = null;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navigationView);

        ivProfileIcon = findViewById(R.id.ivProfileIcon);
        drawerLayout = findViewById(R.id.drawer_layout);
        ivHomeicon = findViewById(R.id.ivHomeicon);
        layoutProfile = findViewById(R.id.layoutProfile);
        layoutHome = findViewById(R.id.layoutHome);
        layoutSave = findViewById(R.id.layoutSave);
        backArrowImg = findViewById(R.id.imgBackArrow);
        tvTextHome = findViewById(R.id.tvTextHome);
        tvProfileText = findViewById(R.id.tvProfileText);
        ivTextFavorite = findViewById(R.id.ivTextFavorite);
        ivIconFavorite = findViewById(R.id.ivIconFavorite);
        toolbar = findViewById(R.id.toolbar);
        dehazeLayout = findViewById(R.id.dehazeLayout);

        setSupportActionBar(toolbar);

        onBackArrow();
        setProfile();
        setHome();
        setSavePost();
        setDehaze();

        postFloatingActionButton = findViewById(R.id.floatingActionButtonAddPost);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                    new TimelineFragment()).commit();
        }

        onfloatingActionButton();

    }

    private void setDehaze() {
        dehazeLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
    }

    private void setSavePost() {
        layoutSave.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tvProfileText.setImageResource(R.drawable.profile_text_white);
                selectedFragment = new TimelineFragment();
                ivProfileIcon.setImageResource(R.drawable.ic_person);
                ivHomeicon.setImageResource(R.drawable.ic_home_black_24dp);
                tvTextHome.setImageResource(R.drawable.home_text_white);
                ivIconFavorite.setImageResource(R.drawable.ic_heart_outline_violet);
                ivTextFavorite.setImageResource(R.drawable.favorite_text_violet);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                        selectedFragment).commit();
            }
        });
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
                tvTextHome.setImageResource(R.drawable.home_text_violet);
                ivIconFavorite.setImageResource(R.drawable.ic_heart_outline);
                ivTextFavorite.setImageResource(R.drawable.favorite_text_white);
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
                ivIconFavorite.setImageResource(R.drawable.ic_heart_outline);
                ivTextFavorite.setImageResource(R.drawable.favorite_text_white);
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
