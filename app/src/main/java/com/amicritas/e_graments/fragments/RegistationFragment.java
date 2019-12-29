package com.amicritas.e_graments.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistationFragment extends Fragment {
    private ImageView backButtonIv;
    private TextView tvSignIn, nameErrorTv, emailErrorTv, passwordErrorTv;
    private Button signUpBtn;
    private EditText nameEt, edtEmailReg, edtpasswordReg;
    private String userNameReg, userPasswordReg, userEmailReg;
    private FirebaseAuth mAuth;
    private LinearLayout progressLayout;
    private Matcher passwordMatcher, emailMatcher;

    private String passwordPattarn = "^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            //"(?=.*[a-zA-Z])" +      //any letter
            //"(?=.*[@#$%^&+=])" +    //at least 1 special character
            //"(?=\\S+$)" +           //no white spaces
            ".{6,}" +               //at least 4 characters
            "$";

    private String emailPattarn = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    public RegistationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registation, container, false);

        backButtonIv = view.findViewById(R.id.backButtonIv);
        tvSignIn = view.findViewById(R.id.tvSignIn);
        signUpBtn = view.findViewById(R.id.btnSignUp);
        nameEt = view.findViewById(R.id.edtNameReg);
        edtEmailReg = view.findViewById(R.id.edtEmailReg);
        edtpasswordReg = view.findViewById(R.id.edtpasswordReg);
        nameErrorTv = view.findViewById(R.id.tvErrorNameReg);
        emailErrorTv = view.findViewById(R.id.tvErrorPhoneReg);
        passwordErrorTv = view.findViewById(R.id.tvErrorPasswordReg);
        progressLayout = view.findViewById(R.id.progressLayout);



        mAuth = FirebaseAuth.getInstance();

        Bundle bundle = getArguments();
        String userType = bundle.getString("userType");

        Toast.makeText(getActivity(), ""+userType, Toast.LENGTH_SHORT).show();

        setOnBackButton();
        setOnAlreadySignIn();
        setOnSignUp();
        setFieldView(userType);

        TextWatcher textChange = new TextWatcher() {
            String nameSearchKey, phoneSearchKey, passwordsearchKey;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nameErrorTv.setText("");
                emailErrorTv.setText("");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {

                passwordMatcher = Pattern.compile(passwordPattarn).matcher(edtpasswordReg.getText().toString());
                emailMatcher = Pattern.compile(emailPattarn).matcher(edtEmailReg.getText().toString().trim());

                nameSearchKey = nameEt.getText().toString().trim();
                phoneSearchKey = edtEmailReg.getText().toString().trim();
                passwordsearchKey = edtpasswordReg.getText().toString().trim();
                

                if (editable == edtEmailReg.getEditableText()){
                    if (phoneSearchKey.isEmpty()){
                        emailErrorTv.setText("Email not empty*");
                    }else {
                        if (!emailMatcher.matches()){
                            emailErrorTv.setText("Require valid email*");
                        }else {
                            emailErrorTv.setText("");
                        }
                    }

                }else if (editable == edtpasswordReg.getEditableText()){
                    if (passwordsearchKey.isEmpty()){
                        passwordErrorTv.setText("password not empty*");
                    }
                    else if (!passwordsearchKey.isEmpty()){
                        if (!passwordMatcher.matches()){
                            //passwordErrorTv.setText("password at least 1 upper & lower letter and 6 length**");
                            passwordErrorTv.setText("password at least 6 digit*");
                            Boolean pass = passwordMatcher.matches();
                            //onMacher(pass);
                        }else {
                            passwordErrorTv.setText("");
                        }
                    }
                }
            }
        };

        nameEt.addTextChangedListener(textChange);
        edtEmailReg.addTextChangedListener(textChange);
        edtpasswordReg.addTextChangedListener(textChange);



        return view;

    }

    private void setFieldView(String userType) {
        if (userType.equals("basic")){
            nameEt.setHint("Name");
        }else if (userType.equals("buyer")){
            nameEt.setHint("Name");
        }else if (userType.equals("buyingHouse")){
            nameEt.setHint("Buying house name");
        }else {
            nameEt.setHint("Factory name");
        }

    }

    private void setOnSignUp() {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userNameReg = nameEt.getText().toString().trim();
                userEmailReg = edtEmailReg.getText().toString().trim();
                userPasswordReg = edtpasswordReg.getText().toString();
                if (!userNameReg.isEmpty() && !userEmailReg.isEmpty() && !userPasswordReg.isEmpty()){

                    if (emailMatcher.matches() && passwordMatcher.matches()){
                        progressLayout.setVisibility(View.VISIBLE);
                        createUser(userNameReg, userEmailReg, userPasswordReg);
                    }
                    else {
                        Toast.makeText(getActivity(), "Input all valid information", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getActivity(), "Input all required field", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void createUser(String userNameReg, String userEmailReg, String userPasswordReg) {
        mAuth.createUserWithEmailAndPassword(userEmailReg, userPasswordReg)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            progressLayout.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "successful: ", Toast.LENGTH_SHORT).show();
                            updateUserInfo(userNameReg, userEmailReg, userPasswordReg, mAuth.getCurrentUser());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressLayout.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "error: "+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void updateUserInfo(String userNameReg, String userEmailReg, String userPasswordReg, FirebaseUser currentUser) {
        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder().setDisplayName(userNameReg).build();

        currentUser.updateProfile(profileUpdate).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //Toast.makeText(getActivity(), "profile update", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    private void setOnAlreadySignIn() {
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment selectedFragment = new LoginFragment();
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_in_left, R.anim.slide_out_left).replace(R.id.main_frame_login,
                        selectedFragment).addToBackStack("tag").commit();
            }
        });
    }

    private void setOnBackButton() {
        backButtonIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });
    }

}
