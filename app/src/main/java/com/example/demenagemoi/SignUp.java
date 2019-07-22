package com.example.demenagemoi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demenagemoi.Helpers.Constants;
import com.example.demenagemoi.Helpers.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class SignUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void SignInActivity(View view) {
        try {
            final String lastName = ((EditText) findViewById(R.id.LastName)).getText().toString();
            final String firstName = ((EditText) findViewById(R.id.FirstName)).getText().toString();
            final String zipCode = ((EditText) findViewById(R.id.ZipCode)).getText().toString();
            final String city = ((EditText) findViewById(R.id.City)).getText().toString();
            final String email = ((EditText) findViewById(R.id.EmailSignUp)).getText().toString();
            final String password = ((EditText) findViewById(R.id.Password)).getText().toString();

            HashMap<String, String> content = new HashMap<>();
            content.put(Constants.User.LAST_NAME, lastName);
            content.put(Constants.User.FIRST_NAME, firstName);
            content.put(Constants.User.ZIP_CODE, zipCode);
            content.put(Constants.User.CITY, city);
            content.put(Constants.User.EMAIL, email);
            content.put(Constants.User.PASSWORD, password);

            HashMap<String, Object> params = new HashMap<>();
            JSONObject body = Utils.jsonify(content);
            params.put("body", body);
            params.put("route", Constants.User.BASE_USER);
            params.put("context", SignUp.this);
            params.put("method", "POST");

            final AsyncTask<HashMap<String, Object>, Void, Response> requestManager = new RequestManager().execute(params);
            findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                        int code = requestManager.get().code();

                        if (code != 201) {
                            Toast.makeText(SignUp.this, "Erreur lors de la création de l'utilisateur", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this, "Création réussie !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUp.this, SignIn.class);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            startActivity(intent);
                        }
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, 500);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
