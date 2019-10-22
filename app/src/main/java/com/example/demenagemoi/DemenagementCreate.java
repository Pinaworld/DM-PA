package com.example.demenagemoi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demenagemoi.helpers.Constants;
import com.example.demenagemoi.helpers.Utils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class DemenagementCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Utils.isAuthenticated()) {
            if (!Utils.isTokenValid()) {
                Utils.refreshToken(DemenagementCreate.this);
            }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_demenagement_create);
            Button createRemoval = findViewById(R.id.createRemoval);

            createRemoval.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        final String dateRemoval = ((EditText) findViewById(R.id.dateRemoval)).getText().toString();
                        final String beginningLoc = ((EditText) findViewById(R.id.beginningLoc)).getText().toString();
                        final String arrivalLoc = ((EditText) findViewById(R.id.arrivalLoc)).getText().toString();
                        final String descriptionRemoval = ((EditText) findViewById(R.id.descriptionRemoval)).getText().toString();

                        HashMap<String, String> content = new HashMap<>();
                        content.put(Constants.Removal.DATE, dateRemoval);
                        content.put(Constants.Removal.ADDRESS, beginningLoc);
                        content.put(Constants.Removal.ARRIVAL_ADDRESS, arrivalLoc);
                        content.put(Constants.Removal.DESCRIPTION, descriptionRemoval);

                        HashMap<String, Object> params = new HashMap<>();
                        JSONObject body = Utils.jsonify(content);
                        params.put("body", body);
                        params.put("route", Constants.Removal.BASE_REMOVAL);
                        params.put("context", DemenagementCreate.this);
                        params.put("method", "POST");

                        final AsyncTask<HashMap<String, Object>, Void, Response> requestManager = new RequestManager().execute(params);
                        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    while (requestManager.get() == null) {
                                        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                                    }
                                    Response response = requestManager.get();
                                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                                    int code = response.code();

                                    if (code != 200) {
                                        Toast.makeText(DemenagementCreate.this, "Erreur lors de la création du déménagement", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(DemenagementCreate.this, "Création réussie !", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(DemenagementCreate.this, Home.class);
                                        startActivity(intent);
                                    }

                                } catch (ExecutionException | InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 1500);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void HomeActivity(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
