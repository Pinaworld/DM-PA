package com.example.demenagemoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.demenagemoi.Helpers.Utils;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Utils.isAuthenticated()) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
        }
    }

    public void DeconnectionActivity(View view) {
        AuthentifiedUserID authentifiedUserID = AuthentifiedUserID.getInstance();
        authentifiedUserID.setID(null);

        Toast.makeText(this, "Déconnexion effectuée !", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SignIn.class);
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

    }
}
