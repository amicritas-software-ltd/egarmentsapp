package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ProductDetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    LinearLayout messageLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        messageLL = findViewById(R.id.layoutMessage);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitleEnabled(false);

        messageLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, MessengerActivity.class);
                startActivity(intent);
                //Toast.makeText(ProductDetailsActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("E-garments");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);*/
    }
}
