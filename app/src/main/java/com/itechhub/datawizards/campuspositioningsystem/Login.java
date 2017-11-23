package com.itechhub.datawizards.campuspositioningsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btnLoginRegister, btnLogin;
    private EditText etUserName, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initialize();

        btnLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),Register.class));
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateNullInputs()){
                    if(validateUser()){
                        startActivity(new Intent(getBaseContext(),HomePage.class));
                        finish();
                    }else {
                        Toast.makeText(getBaseContext(),"User Does Not Exist",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(),"Missing Information",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void initialize(){
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginRegister = findViewById(R.id.btnLoginRegister);
        etPassword=findViewById(R.id.etPassword);
        etUserName=findViewById(R.id.etLogin_Email);
    }

    boolean validateNullInputs(){
        if (TextUtils.isEmpty(etUserName.getText())) {
            etUserName.setError("Email Required.");
            return false;
        } else {
            etUserName.setError(null);
        }
        if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Password Required.");
            return false;
        } else {
            etPassword.setError(null);
        }
        return true;
    }
    boolean validateUser(){

        return false;
    }
}
