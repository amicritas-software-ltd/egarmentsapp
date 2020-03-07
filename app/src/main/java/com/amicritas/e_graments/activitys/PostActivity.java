package com.amicritas.e_graments.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.adapter.CategoryListSpinnerAdapter;
import com.amicritas.e_graments.modals.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    Spinner categorySp;
    EditText productNameEt, subCategoryEt;
    Button createPostBtn;

    FirebaseDatabase firebaseDatabase;

    ArrayList<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //categorySp = findViewById(R.id.spMainCategory);
        productNameEt = findViewById(R.id.etProductTitle);
        subCategoryEt = findViewById(R.id.etProductSubTitle);
        createPostBtn = findViewById(R.id.btnPost);

        firebaseDatabase = FirebaseDatabase.getInstance();

        getCategoryInfo();

        createPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "post", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCategoryInfo() {
        DatabaseReference databaseReference = firebaseDatabase.getReference("category").child("category").child("basic");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Category category = null;
                ArrayList<Category> categoryArrayList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    category = dataSnapshot1.getValue(Category.class);
                    categoryArrayList.add(category);
                }
                setSpinner(categoryArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PostActivity.this, "failed"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setSpinner(ArrayList<Category> categoryArrayList) {
        Spinner spinner = findViewById(R.id.spMainCategory);
        CategoryListSpinnerAdapter categoryListSpinnerAdapter = new CategoryListSpinnerAdapter(this, (ArrayList<Category>) categoryArrayList);
        spinner.setAdapter(categoryListSpinnerAdapter);
        //categoryListSpinnerAdapter.notify();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category allUserResponse = (Category) adapterView.getItemAtPosition(i);
                Toast.makeText(PostActivity.this, ""+allUserResponse.getCategory_name()+" "+allUserResponse.getCategory_id()+allUserResponse.getCategory_icon(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
