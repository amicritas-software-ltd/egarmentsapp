package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amicritas.e_graments.R;

public class PreSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_sign_up);
    }

    public void ok(View view) {
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }
}
