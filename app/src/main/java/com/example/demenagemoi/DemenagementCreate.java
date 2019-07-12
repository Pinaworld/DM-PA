package com.example.demenagemoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DemenagementCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demenagement_create);
    }

    public void HomeActivity(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
