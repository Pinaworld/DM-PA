package com.example.demenagemoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.demenagemoi.Helpers.Utils;

public class DemenagementCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Utils.isAuthenticated()) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_demenagement_create);
        }
    }

    public void HomeActivity(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
