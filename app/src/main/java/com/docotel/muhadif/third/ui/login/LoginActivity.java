package com.docotel.muhadif.third.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.docotel.muhadif.third.R;
import com.docotel.muhadif.third.ui.detail.DetailActivity;
import com.docotel.muhadif.third.ui.main.MainActivity;

import java.io.UnsupportedEncodingException;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    public static final int LOGIN_SUCCESS = 112 ;
    private LoginPresenter presenter;
    private Button btnLogin;
    private ImageButton ibBackLogin;
    private EditText etEmail, etPassword;
    private ProgressBar progressDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        presenter.onCreate(this);

    }

    @Override
    public void loginSuccess() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        finish();
        startActivity(mainIntent);
    }

    @Override
    public void loginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initView() {
        progressDetail = findViewById(R.id.progress_detail);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void initListener() {

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void startTask() {
        progressDetail.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishedTask() {
        progressDetail.setVisibility(View.GONE);

    }

    @Override
    public void failureTask(String message) {

    }

    @Override
    public void info(String message) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login :
                login();

        }
    }

    private void login() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please fill email and password", Toast.LENGTH_SHORT).show();
        } else {
            try {
                presenter.login(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
