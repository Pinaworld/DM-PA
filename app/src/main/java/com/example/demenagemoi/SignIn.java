package com.example.demenagemoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void SignUpActivity(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void HomeActivity(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}