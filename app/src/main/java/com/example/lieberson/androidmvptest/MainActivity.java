package com.example.lieberson.androidmvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lieberson.androidmvptest.presenter.InterfaceLoginPresenter;
import com.example.lieberson.androidmvptest.presenter.LoginPresenter;
import com.example.lieberson.androidmvptest.view.InterfaceLoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements InterfaceLoginView{

    private EditText editEmail;
    private EditText editPassword;
    private Button btnLogin;

    InterfaceLoginPresenter interfaceLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //
        interfaceLoginPresenter = new LoginPresenter(this);

        //event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interfaceLoginPresenter.onLogin(editEmail.getText().toString(), editPassword.getText().toString());

            }
        });

    }

    private void initViews() {

        editEmail = findViewById(R.id.edit_email_id);
        editPassword = findViewById(R.id.edit_password_id);
        btnLogin = findViewById(R.id.btn_login_id);

    }

    @Override
    public void onLoginSucess(String message) {

        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {

        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
