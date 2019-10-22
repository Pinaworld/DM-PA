package com.example.demenagemoi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.auth0.android.jwt.JWT;
import com.example.demenagemoi.helpers.Constants;
import com.example.demenagemoi.helpers.Utils;
import com.example.demenagemoi.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && !extras.isEmpty()) {
                String email = (String) extras.get("email");
                String password = (String) extras.get("password");
                ((EditText) findViewById(R.id.EmailSignIn)).setText(email);
                ((EditText) findViewById(R.id.PasswordSignIn)).setText(password);
            }
        }
    }

    public void SignUpActivity(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void HomeActivity(View view) {

        try {
            final String email = ((EditText) findViewById(R.id.EmailSignIn)).getText().toString();
            final String password = ((EditText) findViewById(R.id.PasswordSignIn)).getText().toString();

            HashMap<String, String> content = new HashMap<>();
            content.put(Constants.User.EMAIL, email);
            content.put(Constants.User.USER_PASS, password);

            HashMap<String, Object> params = new HashMap<>();
            JSONObject body = Utils.jsonify(content);
            params.put("body", body);
            params.put("route", Constants.User.LOGIN);
            params.put("context", SignIn.this);
            params.put("method", "POST");

            final AsyncTask<HashMap<String, Object>, Void, Response> requestManager = new RequestManager().execute(params);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (requestManager.get() == null) {
                            findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                        }
                        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                        Response response = requestManager.get();

                        if (response.code() == 202) {
                            Toast.makeText(SignIn.this, "Connexion en tant que " + email, Toast.LENGTH_SHORT).show();

                            String responseBody = response.body().string();
                            JSONObject jsonObject = new JSONObject(responseBody);
                            String tokenString = jsonObject.getString("token");
                            JSONObject userObject = jsonObject.getJSONObject("user");
                            User user = new User();
                            user = user.fill(userObject);
                            JWT jwt = new JWT(tokenString);
                            AuthentifiedUser authentifiedUser = AuthentifiedUser.getInstance();
                            authentifiedUser.setToken(jwt);
                            authentifiedUser.setUser(user);

                            Intent intent = new Intent(SignIn.this, Home.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignIn.this, "Erreur lors de la connexion", Toast.LENGTH_SHORT).show();
                        }
                    } catch (ExecutionException | InterruptedException | IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, 1500);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
