package com.amicritas.e_graments.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;


public class LoginActivity extends AppCompatActivity {
    private TextView txtForgotPwd, signUpTv;
    private Button loginWithFbBtn, signInBtn;
    private static final int APP_REQUEST_CODE = 123;
    private PhoneNumber phoneNumber = new PhoneNumber("+880","01761302367","BD");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        init();
        onSignIn();
        onSignUp();
        onFbLogin();
        onForgotPassword();

    }


    private void init() {
        txtForgotPwd = findViewById(R.id.txtForgotPwd);
        signUpTv = findViewById(R.id.tvSignUp);
        loginWithFbBtn = findViewById(R.id.btnFbLogin);
        signInBtn = findViewById(R.id.btnLogin);
    }

    private void onForgotPassword() {
        txtForgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startLoginPage(LoginType.PHONE);

                showForgotPwdDialog();
            }
        });
    }

    private void onFbLogin() {
        loginWithFbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, AccountKitActivity.class);
                AccountKitConfiguration.AccountKitConfigurationBuilder builder =
                        new AccountKitConfiguration.AccountKitConfigurationBuilder(LoginType.PHONE,
                                AccountKitActivity.ResponseType.TOKEN);

                intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                        builder.build());

                startActivityForResult(intent,APP_REQUEST_CODE);

                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==APP_REQUEST_CODE){
            AccountKitLoginResult  loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            String toastMessage;

            if (loginResult.getError()!=null){
                toastMessage = loginResult.getError().getErrorType().getMessage();
                Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
            }else if(loginResult.wasCancelled()){
                toastMessage = "Login Cancelled";
                Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
            }else{
                // Toast.makeText(this, "Success login", Toast.LENGTH_SHORT).show();

                AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                    @Override
                    public void onSuccess(Account account) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onError(AccountKitError accountKitError) {

                    }
                });
            }
        }
    }

    private void onSignUp() {
        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showForgotPwdDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View forgot_view = inflater.inflate(R.layout.forgot_pwd_layout,null);
        builder.setView(forgot_view);


        builder.show();

    }

    private void startLoginPageForEmail(LoginType email) {

        Intent intent = new Intent(this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder builder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(LoginType.EMAIL,
                        AccountKitActivity.ResponseType.TOKEN);

        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                builder.setInitialPhoneNumber(phoneNumber).build());

        startActivityForResult(intent,APP_REQUEST_CODE);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void startLoginPageForPhone(LoginType phone) {
        Intent intent = new Intent(this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder builder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(LoginType.PHONE,
                        AccountKitActivity.ResponseType.TOKEN);

        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                builder.setInitialPhoneNumber(phoneNumber).build());

        startActivityForResult(intent,APP_REQUEST_CODE);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }


    public void click(View view) {
        startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }


    public void onSignIn() {
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
