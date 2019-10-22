package com.example.demenagemoi;

import android.content.Context;
import android.os.AsyncTask;

import com.example.demenagemoi.helpers.Config;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestManager extends AsyncTask<HashMap<String, Object>, Void, Response> {

    public static final String CONTEXT = "context";
    public static final String ROUTE = "route";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String NO_CACHE = "no-cache";
    public static final String APPLICATION_JSON = "application/json";

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

            Context context = (Context) params.get(CONTEXT);
            String route = (String) params.get(ROUTE);
            String url = Config.getConfigValue(context,"url") + route;

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                    .addHeader(CACHE_CONTROL, NO_CACHE)
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

            Context context = (Context) params.get(CONTEXT);
            String route = (String) params.get(ROUTE);
            String url = Config.getConfigValue(context,"url") + route;

            MediaType mediaType = MediaType.parse(APPLICATION_JSON);
            String bodyContent = params.get("body").toString();
            RequestBody body = RequestBody.create(mediaType, bodyContent);

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                    .addHeader(CACHE_CONTROL, NO_CACHE)
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

            Context context = (Context) params.get(CONTEXT);
            String route = (String) params.get(ROUTE);
            String url = Config.getConfigValue(context,"url") + route;

            MediaType mediaType = MediaType.parse(APPLICATION_JSON);
            String bodyContent = params.get("body").toString();
            RequestBody body = RequestBody.create(mediaType, bodyContent);

            Request request = new Request.Builder()
                    .url(url)
                    .put(body)
                    .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                    .addHeader(CACHE_CONTROL, NO_CACHE)
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

            Context context = (Context) params.get(CONTEXT);
            String route = (String) params.get(ROUTE);
            String url = Config.getConfigValue(context,"url") + route;

            Request request = new Request.Builder()
                    .url(url)
                    .delete()
                    .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                    .addHeader(CACHE_CONTROL, NO_CACHE)
                    .build();

            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    protected void onPostExecute(Response response) {
        //NOT USED
    }
}