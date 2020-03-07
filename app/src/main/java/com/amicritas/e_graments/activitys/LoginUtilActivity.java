package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.fragments.LoginFragment;
import com.amicritas.e_graments.fragments.TimelineFragment;

public class LoginUtilActivity extends AppCompatActivity {
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_util);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_login,
                    new LoginFragment()).commit();
        }
    }
}
