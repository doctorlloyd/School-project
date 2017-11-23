package com.itechhub.datawizards.campuspositioningsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private Button btnRegister;
    private EditText etLogin_Email, etPassword, etFirstName, etLastName, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initialize();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateNullInputs()){

                }else {
                    Toast.makeText(getBaseContext(),"Missing Information",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void initialize(){
        btnRegister = findViewById(R.id.btnRegister);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etLogin_Email = findViewById(R.id.etLogin_Email);
        etPassword = findViewById(R.id.etPassword);
    }

    boolean validateNullInputs(){
        if (TextUtils.isEmpty(etFirstName.getText())) {
            etFirstName.setError("Firstname Required.");
            return false;
        } else {
            etFirstName.setError(null);
        }
        if (TextUtils.isEmpty(etLastName.getText())) {
            etLastName.setError("Lastname Required.");
            return false;
        } else {
            etLastName.setError(null);
        }
        if (TextUtils.isEmpty(etLogin_Email.getText())) {
            etLogin_Email.setError("Email Required.");
            return false;
        } else {
            etLogin_Email.setError(null);
        }
        if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Password Required.");
            return false;
        } else {
            etPassword.setError(null);
        }
        if (TextUtils.isEmpty(etConfirmPassword.getText())) {
            etConfirmPassword.setError("Confirm Password.");
            return false;
        } else {
            etConfirmPassword.setError(null);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getBaseContext(),Login.class));
        finish();
    }
}
