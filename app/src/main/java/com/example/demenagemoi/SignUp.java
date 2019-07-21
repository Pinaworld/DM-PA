package com.example.demenagemoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demenagemoi.Helpers.Constants;
import com.example.demenagemoi.Helpers.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    View.OnClickListener sendRequestListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                String lastName = ((EditText) findViewById(R.id.LastName)).getText().toString();
                String firstName = ((EditText) findViewById(R.id.FirstName)).getText().toString();
                String zipCode = ((EditText) findViewById(R.id.ZipCode)).getText().toString();
                String city = ((EditText) findViewById(R.id.City)).getText().toString();
                String email = ((EditText) findViewById(R.id.EmailSignUp)).getText().toString();
                String password = ((EditText) findViewById(R.id.Password)).getText().toString();

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
                params.put("context", getApplicationContext());

                new RequestManager().execute(params);

            } catch (JSONException e) {
                e.printStackTrace();
            }
/*
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(v.getContext());
            String url = "http://192.168.79.1:8081/user/login";

            //Parameters
            JSONArray jsonArray = new JSONArray();
            String string = ((AppCompatEditText) lastName).getText().toString();
            //jsonArray.put();

            // Request a string response from the provided URL.
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    String test = "";
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String test = "";
                }
            });

            // Add the request to the RequestQueue.
            queue.add(jsonArrayRequest);
*/
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Button signUpButton = findViewById(R.id.ConfirmSignUp);
        signUpButton.setOnClickListener(sendRequestListener);
    }

    public void SignInActivity(View view) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

}
