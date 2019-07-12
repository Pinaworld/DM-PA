package com.example.demenagemoi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void DeconnectionActivity(View view){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void EditAccountActivity(View view){
        Intent intent = new Intent(this, EditAccount.class);
        startActivity(intent);
    }

    public void DemenagementListActivity(View view){
        Intent intent = new Intent(this, DemenagementList.class);
        startActivity(intent);
    }

    public void DemenagementCreateActivity(View view){
        Intent intent = new Intent(this, DemenagementCreate.class);
        startActivity(intent);
    }

    public void MapCarboardActivty(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
