package com.example.demenagemoi.Helpers;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Utils {

    public static JSONObject jsonify(HashMap<String, String> content) throws JSONException {

        JSONObject body = new JSONObject();
        Set<Map.Entry<String, String>> contentEntries = content.entrySet();

        for (Map.Entry<String, String> contentEntry : contentEntries) {
            if (contentEntry.getValue() != null && !contentEntry.getValue().isEmpty())
                body.put(contentEntry.getKey(), contentEntry.getValue());
        }
        return body;
    }

    public static String addRequestParameter(String url, String parameter)
    {
        return url + parameter + "/";
    }
}
