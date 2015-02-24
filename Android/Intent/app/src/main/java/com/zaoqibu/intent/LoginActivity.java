package com.zaoqibu.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View view) {
        EditText etEmail = (EditText)findViewById(R.id.etEmail);
        EditText etPassword = (EditText)findViewById(R.id.etPassword);

        Intent intent = new Intent();
        intent.putExtra(EMAIL, etEmail.getText().toString());
        intent.putExtra(PASSWORD, etPassword.getText().toString());

        setResult(RESULT_OK, intent);

        finish();
    }
}
