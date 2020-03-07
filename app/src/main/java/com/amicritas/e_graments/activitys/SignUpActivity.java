package com.amicritas.e_graments.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    TextView signInTv, nameErrorTv, phoneNumberErrorTv, passwordErrorTv;
    EditText nameEt, phoneEt, passwordEt;
    Button signUpBtn;

    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;


    String passwordPattarn = "^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            //"(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{6,}" +               //at least 4 characters
            "$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseReference = FirebaseDatabase.getInstance().getReference("e_garments");
        firebaseAuth = FirebaseAuth.getInstance();

        init();
        onSetSignUp();

        TextWatcher textChange = new TextWatcher() {
            String nameSearchKey, phoneSearchKey, passwordsearchKey;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nameErrorTv.setText("");
                phoneNumberErrorTv.setText("");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {

                nameSearchKey = nameEt.getText().toString().trim();
                phoneSearchKey = phoneEt.getText().toString().trim();
                passwordsearchKey = passwordEt.getText().toString().trim();

                Matcher matcher = Pattern.compile(passwordPattarn).matcher(passwordEt.getText().toString().trim());

                if (editable == nameEt.getEditableText()){
                    if (nameSearchKey.isEmpty()){
                        nameErrorTv.setText("name must require*");
                    }
                    else if (!nameSearchKey.isEmpty()){
                        nameErrorTv.setText("");
                    }
                }else if (editable == phoneEt.getEditableText()){
                    if (phoneSearchKey.isEmpty()){
                        phoneNumberErrorTv.setText("phone number not empty*");
                    }
                    else if (!phoneSearchKey.isEmpty()){
                        phoneNumberErrorTv.setText("");
                    }
                }else if (editable == passwordEt.getEditableText()){
                    if (passwordsearchKey.isEmpty()){
                        passwordErrorTv.setText("password not empty*");
                    }
                    else if (!passwordsearchKey.isEmpty()){
                        if (!matcher.matches()){
                            passwordErrorTv.setText("password at least 1 upper & lower letter and 6 length*");
                        }else {
                            passwordErrorTv.setText("");
                        }
                    }
                }
            }
        };

        nameEt.addTextChangedListener(textChange);
        phoneEt.addTextChangedListener(textChange);
        passwordEt.addTextChangedListener(textChange);
    }

    private void onSetSignUp() {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "+88"+nameEt.getText().toString().trim();
                String phoneNumber = phoneEt.getText().toString().trim();
                String password = passwordEt.getText().toString().trim();

                /*if (!names.isEmpty() && !phoneNumber.isEmpty() && !password.isEmpty()){
                    firebaseAuth.createUserWithEmailAndPassword(names, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "login Success", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(SignUpActivity.this, "login Unsuccess try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }*/

                if (phoneNumber.isEmpty() || phoneNumber.length() < 10) {
                    phoneNumberErrorTv.setText("Valid number is required");
                    return;
                }

                Intent intent = new Intent(SignUpActivity.this, VarifyActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phonenumber", phoneNumber);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
    }

    private void init() {
        signInTv = findViewById(R.id.tvSignIn);
        nameEt = findViewById(R.id.edtNameReg);
        phoneEt = findViewById(R.id.edtPhoneReg);
        passwordEt = findViewById(R.id.edtpasswordReg);
        signUpBtn = findViewById(R.id.btnSignUp);
        nameErrorTv = findViewById(R.id.tvErrorNameReg);
        phoneNumberErrorTv = findViewById(R.id.tvErrorPhoneReg);
        passwordErrorTv = findViewById(R.id.tvErrorPasswordReg);


    }

    public void btnBack(View view) {
        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
        finish();
    }

    /*@Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }*/
}

