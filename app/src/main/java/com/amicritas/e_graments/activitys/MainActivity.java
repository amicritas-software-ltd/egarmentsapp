package com.amicritas.e_graments.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.amicritas.e_graments.R;
import com.amicritas.e_graments.fragments.ProfileFragment;
import com.amicritas.e_graments.fragments.TimelineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;
    FloatingActionButton postFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Toast.makeText(MainActivity.this, "fab clicked", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(MainActivity.this, "click assistant", Toast.LENGTH_SHORT).show();

                    startActivity( new Intent(MainActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_news:
                    selectedFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                            selectedFragment).commit();
                    return true;
                case R.id.navigation_premium:
                    //  mTextMessage.setText(R.string.title_settings);
                    Toast.makeText(MainActivity.this, "click premium", Toast.LENGTH_SHORT).show();

                    return true;

                case R.id.navigation_setting:
                    selectedFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                            selectedFragment).commit();

                    return true;


            }


            return false;
        }
    };

}
