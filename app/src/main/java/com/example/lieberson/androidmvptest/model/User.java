package com.example.lieberson.androidmvptest.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements InterfaceUser {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
//        1 --> check email is empty
//        2 --> check email is matches pattern
//        3 --> check password length > 6

        if (TextUtils.isEmpty(getEmail()))
            return 0;

        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;

        else if (getPassword().length() <= 6)
            return 2;

        else
            return -1;

    }
}
