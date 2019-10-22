package com.example.demenagemoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.demenagemoi.helpers.Utils;

public class EditAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Utils.isAuthenticated()) {
            if (!Utils.isTokenValid()) {
                Utils.refreshToken(EditAccount.this);
            }

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_account);

        }
    }

    public void HomeActivity(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
