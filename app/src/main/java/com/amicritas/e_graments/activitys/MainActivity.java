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

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton postFloatingActionButton;
    ImageView backArrowImg, ivHomeicon, ivProfileIcon, tvTextHome, tvProfileText, ivIconFavorite, ivTextFavorite;
    LinearLayout layoutProfile, layoutHome, layoutSave, dehazeLayout, layoutTopProfile,viewProfileLinerLayout, myGetHelpLayout;
    Fragment selectedFragment = null;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView tvUserNameNav;
    View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);

        layoutTopProfile = findViewById(R.id.layoutTopProfile);
        tvUserNameNav = findViewById(R.id.tvUserNameNav);

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
        layoutHome.setBackgroundResource(R.drawable.nav_button_background);

        setSupportActionBar(toolbar);

        onBackArrow();
        setProfile();
        setHome();
        setSavePost();
        setDehaze();
        setTopProfile();

        postFloatingActionButton = findViewById(R.id.floatingActionButtonAddPost);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                    new TimelineFragment()).commit();
        }

        onfloatingActionButton();
        setClick();
        setGetHelp();


        //tvUserNameNav.setText("sou");
    }

    private void setGetHelp() {

        myGetHelpLayout = headerView.findViewById(R.id.myGetHelpLayout);
        myGetHelpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "helloo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setClick() {

        viewProfileLinerLayout = headerView.findViewById(R.id.viewProfileLinerLayout);
        viewProfileLinerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setTopProfile() {
        layoutTopProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
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
                //Objects.requireNonNull(getSupportActionBar()).show();
                tvProfileText.setImageResource(R.drawable.profile_text_white);
                selectedFragment = new TimelineFragment();
                ivProfileIcon.setImageResource(R.drawable.ic_person_white);
                ivHomeicon.setImageResource(R.drawable.ic_home_white);
                tvTextHome.setImageResource(R.drawable.home_nav_text_white);
                ivIconFavorite.setImageResource(R.drawable.ic_heart_outline_violet);
                ivTextFavorite.setImageResource(R.drawable.favorite_text_violet);
                layoutHome.setBackgroundResource(R.drawable.null_background);
                layoutSave.setBackgroundResource(R.drawable.nav_button_background);
                layoutProfile.setBackgroundResource(R.drawable.null_background);
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
                //Objects.requireNonNull(getSupportActionBar()).show();
                tvProfileText.setImageResource(R.drawable.profile_text_white);
                selectedFragment = new TimelineFragment();
                ivProfileIcon.setImageResource(R.drawable.ic_person_white);
                ivHomeicon.setImageResource(R.drawable.ic_home_violet);
                tvTextHome.setImageResource(R.drawable.home_nav_text_violet);
                ivIconFavorite.setImageResource(R.drawable.ic_heart_outline);
                ivTextFavorite.setImageResource(R.drawable.favorite_text_white);
                layoutHome.setBackgroundResource(R.drawable.nav_button_background);
                layoutSave.setBackgroundResource(R.drawable.null_background);
                layoutProfile.setBackgroundResource(R.drawable.null_background);
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
                tvTextHome.setImageResource(R.drawable.home_nav_text_white);
                tvProfileText.setImageResource(R.drawable.profile_text_violet);
                ivProfileIcon.setImageResource(R.drawable.ic_person_violet);
                ivHomeicon.setImageResource(R.drawable.ic_home_white);
                ivIconFavorite.setImageResource(R.drawable.ic_heart_outline);
                ivTextFavorite.setImageResource(R.drawable.favorite_text_white);
                layoutProfile.setBackgroundResource(R.drawable.nav_button_background);
                layoutHome.setBackgroundResource(R.drawable.null_background);
                layoutSave.setBackgroundResource(R.drawable.null_background);
                selectedFragment = new MyProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                        selectedFragment).commit();
                //Objects.requireNonNull(getSupportActionBar()).hide();
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

    /*LinearLayout viewProfileLinerLayout = findViewById(R.id.viewProfileLinerLayout);
    viewProfileLinerLayout.*/



}
