package com.amicritas.e_graments.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.activitys.LoginActivity;
import com.amicritas.e_graments.activitys.MainActivity;
import com.amicritas.e_graments.activitys.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private static boolean LOGIN_STATE = false;
    private Button loginBtn, registationBtn;
    private TextView signUpTv, forgotPasswordtv, emailErrorTv, passwordErrorTv;
    private EditText userEmail, userPassword;
    private SharedPreferences sharedPreferences;
    private Fragment selectedFragment;
    private FirebaseAuth mAuth;
    private LinearLayout progressLayout;
    private Matcher passwordMatcher,emailMatcher;
    private String emailSearchKey, passwordsearchKey;

    String passwordPattarn = "^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            //"(?=.*[a-zA-Z])" +      //any letter
            //"(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{6,}" +               //at least 4 characters
            "$";

    private String emailPattarn = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        sharedPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences("e_garments", MODE_PRIVATE);

        loginBtn = view.findViewById(R.id.btnLogin);
        signUpTv = view.findViewById(R.id.tvSignUp);
        userEmail = view.findViewById(R.id.edtEmailLogin);
        userPassword = view.findViewById(R.id.edtUserPasswordLogin);
        progressLayout = view.findViewById(R.id.progressLayout);
        emailErrorTv = view.findViewById(R.id.tvErrorEmailReg);
        passwordErrorTv = view.findViewById(R.id.tvErrorPasswordReg);



        /*EditText password = (EditText) findViewById(R.id.password_text);
        password.setTypeface(Typeface.DEFAULT);
        password.setTransformationMethod(new PasswordTransformationMethod());*/

        TextWatcher textChange = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //emailErrorTv.setText("");
                //passwordErrorTv.setText("");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //emailErrorTv.setText("");
                //passwordErrorTv.setText("");
            }

            @Override
            public void afterTextChanged(Editable editable) {

                passwordMatcher = Pattern.compile(passwordPattarn).matcher(userPassword.getText().toString());
                emailMatcher = Pattern.compile(emailPattarn).matcher(userEmail.getText().toString().trim());

                emailSearchKey = userEmail.getText().toString().trim();
                passwordsearchKey = userPassword.getText().toString().trim();

                if (editable == userEmail.getEditableText()){
                    if (emailSearchKey.isEmpty()){
                        emailErrorTv.setText("Email not empty*");
                    }else {
                        if (!emailMatcher.matches()){
                            emailErrorTv.setText("Require valid email*");
                        }else {
                            emailErrorTv.setText("");
                        }
                    }

                }else if (editable == userPassword.getEditableText()){
                    if (passwordsearchKey.isEmpty()){
                        passwordErrorTv.setText("password not empty*");
                    }
                    else if (!passwordsearchKey.isEmpty()){
                        if (!passwordMatcher.matches()){
                            passwordErrorTv.setText("password at least 1 upper & lower letter and 6 length**");
                            Boolean pass = passwordMatcher.matches();
                            //onMacher(pass);
                        }else {
                            passwordErrorTv.setText("");
                        }
                    }
                }
            }
        };

        userEmail.addTextChangedListener(textChange);
        userPassword.addTextChangedListener(textChange);

        mAuth = FirebaseAuth.getInstance();

        setOnCheckLoginState();


        setOnLogin(userEmail,userPassword);
        setOnSignUp();

        return view;
    }



    private void setOnCheckLoginState() {
        LOGIN_STATE = sharedPreferences.getBoolean("loginType", false);

        if (LOGIN_STATE == true){
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            Objects.requireNonNull(getActivity()).finish();
        }
    }

    private void setOnSignUp() {
        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), SignUpActivity.class));
                selectedFragment = new UserTypeFragment();
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_in_right, R.anim.slide_out_right).replace(R.id.main_frame_login,
                        selectedFragment).addToBackStack("tag").commit();
                /*Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);*/


            }
        });
    }

    private void setOnLogin(EditText userEmail, EditText userPassword) {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String email = userEmail.getText().toString().trim();
                String password = userPassword.getText().toString().trim();

                if(emailMatcher.matches() == true && passwordMatcher.matches() == true){
                    progressLayout.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                progressLayout.setVisibility(View.GONE);
                                Toast.makeText(getActivity(), "login with "+mAuth.getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();
                                onLoginSuccess();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressLayout.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                    Toast.makeText(getActivity(), "Input all required field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void onLoginSuccess() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("loginType", true);
        editor.apply();
        editor.commit();
        startActivity(intent);
        Objects.requireNonNull(getActivity()).finish();
    }

}
