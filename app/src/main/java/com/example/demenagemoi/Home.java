package com.example.demenagemoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.demenagemoi.helpers.Utils;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Utils.isAuthenticated()) {
            if (!Utils.isTokenValid()) {
                Utils.refreshToken(Home.this);
            }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
        }
        else {
            Toast.makeText(this, "Vous n'êtes pas authentifié", Toast.LENGTH_SHORT).show();
            DeconnectionActivity(null);
        }
    }

    public void DeconnectionActivity(View view) {

        Intent intent = new Intent(this, SignIn.class);
        AuthentifiedUser authentifiedUser = AuthentifiedUser.getInstance();

        intent.putExtra("email", authentifiedUser.getUser().getEmail());
        intent.putExtra("password", authentifiedUser.getUser().getPassword());

        authentifiedUser.setUser(null);
        authentifiedUser.setToken(null);

        Toast.makeText(this, "Déconnexion effectuée !", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }

    public void EditAccountActivity(View view) {
        Intent intent = new Intent(this, EditAccount.class);
        startActivity(intent);
    }

    public void DemenagementListActivity(View view) {
        Intent intent = new Intent(this, DemenagementList.class);
        startActivity(intent);
    }

    public void DemenagementCreateActivity(View view) {
        Intent intent = new Intent(this, DemenagementCreate.class);
        startActivity(intent);
    }

    public void MapCarboardActivty(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //NOT USED
    }
}
