package com.amicritas.e_graments.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.amicritas.e_graments.R;
import com.amicritas.e_graments.fragments.UserFragment;
import com.amicritas.e_graments.fragments.TimelineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;
    FloatingActionButton postFloatingActionButton;
    ImageView backArrowImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backArrowImg = findViewById(R.id.imgBackArrow);
        onBackArrow();

        navView = findViewById(R.id.nav_view);
        postFloatingActionButton = findViewById(R.id.floatingActionButtonAddPost);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                    new TimelineFragment()).commit();
        }

        onfloatingActionButton();

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_assistant:
                    // mTextMessage.setText(R.string.title_assistant);

                    startActivity( new Intent(MainActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_news:
                    selectedFragment = new UserFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                            selectedFragment).commit();
                    return true;
                case R.id.navigation_premium:
                    //  mTextMessage.setText(R.string.title_settings);
                    Toast.makeText(MainActivity.this, "click premium", Toast.LENGTH_SHORT).show();

                    return true;

                case R.id.navigation_setting:
                    selectedFragment = new UserFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                            selectedFragment).commit();

                    return true;


            }


            return false;
        }
    };


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
