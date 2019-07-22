package com.example.demenagemoi;

import android.content.Context;
import android.os.AsyncTask;

import com.example.demenagemoi.Helpers.Config;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class RequestManager extends AsyncTask<HashMap<String, Object>, Void, Response> {

    protected Response doInBackground(HashMap<String, Object>... parameterMaps) {
        Response response = null;
        HashMap<String, Object> params = parameterMaps[0];
        String method = (String) params.get("method");
        if ("GET".equals(method)) {
            response = doGet(params);
        } else if ("POST".equals(method)) {
            response = doPost(params);
        } else if ("UPDATE".equals(method)) {
            response = doUpdate(params);
        } else if ("DELETE".equals(method)) {
            response = doDelete(params);
        }


        return response;
    }

    private Response doGet(HashMap<String, Object> params) {
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();

            Context context = (Context) params.get("context");
            String protocol = Config.getConfigValue(context, "protocol");
            String ipAddress = Config.getConfigValue(context, "ipAddress");
            String port = Config.getConfigValue(context, "port");
            String route = (String) params.get("route");
            String url = protocol + ipAddress + ":" + port + "/" + route;

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private Response doPost(HashMap<String, Object> params) {
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();

            Context context = (Context) params.get("context");
            String protocol = Config.getConfigValue(context, "protocol");
            String ipAddress = Config.getConfigValue(context, "ipAddress");
            String port = Config.getConfigValue(context, "port");
            String route = (String) params.get("route");
            String url = protocol + ipAddress + ":" + port + "/" + route;

            MediaType mediaType = MediaType.parse("application/json");
            String bodyContent = params.get("body").toString();
            RequestBody body = RequestBody.create(mediaType, bodyContent);

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private Response doUpdate(HashMap<String, Object> params) {
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();

            Context context = (Context) params.get("context");
            String protocol = Config.getConfigValue(context, "protocol");
            String ipAddress = Config.getConfigValue(context, "ipAddress");
            String port = Config.getConfigValue(context, "port");
            String route = (String) params.get("route");
            String url = protocol + ipAddress + ":" + port + "/" + route;

            MediaType mediaType = MediaType.parse("application/json");
            String bodyContent = params.get("body").toString();
            RequestBody body = RequestBody.create(mediaType, bodyContent);

            Request request = new Request.Builder()
                    .url(url)
                    .put(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private Response doDelete(HashMap<String, Object> params) {
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();

            Context context = (Context) params.get("context");
            String protocol = Config.getConfigValue(context, "protocol");
            String ipAddress = Config.getConfigValue(context, "ipAddress");
            String port = Config.getConfigValue(context, "port");
            String route = (String) params.get("route");
            String url = protocol + ipAddress + ":" + port + "/" + route;

            Request request = new Request.Builder()
                    .url(url)
                    .delete()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    protected void onPostExecute(Response response) {

    }
}