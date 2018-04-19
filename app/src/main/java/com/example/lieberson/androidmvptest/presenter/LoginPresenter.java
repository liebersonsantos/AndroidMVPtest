package com.example.lieberson.androidmvptest.presenter;

import com.example.lieberson.androidmvptest.model.User;
import com.example.lieberson.androidmvptest.view.InterfaceLoginView;

public class LoginPresenter implements InterfaceLoginPresenter{

    InterfaceLoginView interfaceLoginView;

    public LoginPresenter(InterfaceLoginView interfaceLoginView) {
        this.interfaceLoginView = interfaceLoginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            interfaceLoginView.onLoginError("You must enter your email");

        else if (loginCode == 1)
            interfaceLoginView.onLoginError("You must enter valid email");

        else if (loginCode == 2)
            interfaceLoginView.onLoginError("Password length must be greater than 6");

        else
            interfaceLoginView.onLoginSucess("Login Sucess");


    }
}
