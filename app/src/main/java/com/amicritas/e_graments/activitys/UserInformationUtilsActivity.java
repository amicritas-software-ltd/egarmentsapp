package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.fragments.TimelineFragment;
import com.amicritas.e_graments.fragments.UserInformationFragment;

public class UserInformationUtilsActivity extends AppCompatActivity {

    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_utils);

        selectedFragment = new UserInformationFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.user_information_frame,
                selectedFragment).commit();
    }
}
