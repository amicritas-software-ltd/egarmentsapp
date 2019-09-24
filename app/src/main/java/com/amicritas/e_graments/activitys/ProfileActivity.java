package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.amicritas.e_graments.R;
import com.scwang.wave.MultiWaveHeader;

public class ProfileActivity extends AppCompatActivity {
    MultiWaveHeader waveHeader;
    ImageView backArrowimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backArrowimg = findViewById(R.id.imgBackArrow);
        waveHeader = findViewById(R.id.waveHeader);
        /*waveHeader.setStartColor(R.color.colorWaveStart);
        waveHeader.setCloseColor(R.color.colorWaveClose);*/

        onBackArrowClicked();
    }

    private void onBackArrowClicked() {
        backArrowimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void btnClick(View view) {
        startActivity(new Intent(ProfileActivity.this, UpdateProfileActivity.class));
    }
}
