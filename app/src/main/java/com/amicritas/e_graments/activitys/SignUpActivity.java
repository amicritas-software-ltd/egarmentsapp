package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amicritas.e_graments.R;

public class SignUpActivity extends AppCompatActivity {

    TextView signInTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();
        onSignUpClicked();
    }

    private void onSignUpClicked() {
        signInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        signInTv = findViewById(R.id.tvSignIn);
    }

    public void btnBack(View view) {
        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
        finish();
    }
}
