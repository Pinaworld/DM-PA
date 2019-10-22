package com.example.demenagemoi.helpers;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;

import com.auth0.android.jwt.JWT;
import com.example.demenagemoi.AuthentifiedUser;
import com.example.demenagemoi.RequestManager;
import com.example.demenagemoi.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class Utils {

    private Utils() {

    }

    public static JSONObject jsonify(Map<String, String> content) throws JSONException {

        JSONObject body = new JSONObject();
        Set<Map.Entry<String, String>> contentEntries = content.entrySet();

        for (Map.Entry<String, String> contentEntry : contentEntries) {
            if (contentEntry.getValue() != null && !contentEntry.getValue().isEmpty())
                body.put(contentEntry.getKey(), contentEntry.getValue());
        }
        return body;
    }

    public static String addRequestParameter(String url, String parameter) {
        return url + parameter + "/";
    }

    public static boolean isAuthenticated() {
        AuthentifiedUser authentifiedUser = AuthentifiedUser.getInstance();
        return authentifiedUser.getUser() != null;
    }

    public static boolean isTokenValid() {
        AuthentifiedUser authentifiedUser = AuthentifiedUser.getInstance();
        return authentifiedUser.getToken().getExpiresAt().before(new Date());
    }

    public static void refreshToken(Activity activity) {


        final AuthentifiedUser authentifiedUser = AuthentifiedUser.getInstance();

        HashMap<String, String> content = new HashMap<>();
        User user = authentifiedUser.getUser();
        content.put(Constants.User.EMAIL, user.getEmail());
        content.put(Constants.User.USER_PASS, user.getPassword());

        HashMap<String, Object> params = new HashMap<>();
        JSONObject body = null;
        try {
            body = Utils.jsonify(content);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.put("body", body);
        params.put("route", Constants.User.LOGIN);
        params.put("context", activity);
        params.put("method", "POST");

        final AsyncTask<HashMap<String, Object>, Void, Response> requestManager = new RequestManager().execute(params);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    while (requestManager.get() == null) {
                    }
                    Response response = requestManager.get();
                    if (response.code() == 202) {

                        String tokenString = response.body().string();
                        JSONObject tokenObject = new JSONObject(tokenString);
                        String token = tokenObject.getString("token");
                        JWT jwt = new JWT(token);
                        authentifiedUser.setToken(jwt);
                    }
                } catch (ExecutionException | InterruptedException | IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }, 1500);
    }
}
