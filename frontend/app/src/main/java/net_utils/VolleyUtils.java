package net_utils;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ClassLoaders.Course;
import ClassLoaders.Major;

public class VolleyUtils {

    public static void getMajorsList(Context context, final VolleyResponseListener listener) {
        Type returnType = new TypeToken<List<Major>>() {
        }.getType();
        makeHttpRequest(context, null, Request.Method.GET, returnType, listener, Const.URL_GET_MAJOR_LIST);
    }

    public static void getCoursesList(Context context, String majorId, final VolleyResponseListener listener) {
        String url = Const.URL_GET_COURSE_LIST.replace("{id}", majorId);
        Type returnType = new TypeToken<List<Course>>() {
        }.getType();
        makeHttpRequest(context, null, Request.Method.GET, returnType, listener, url);
    }

    public static void getSingleMajor(Context context, String majorId, final VolleyResponseListener listener) {
        String url = Const.URL_GET_SINGLE_MAJOR.replace("{majorId}", majorId);
        Type returnType = Major.class;
        makeHttpRequest(context, null, Request.Method.GET, returnType, listener, url);
    }

    public static void getSingleCourse(Context context, String majorId, String courseId, final VolleyResponseListener listener) {
        String url = Const.URL_GET_SINGLE_COURSE.replace("{majorId}", majorId).replace("{courseId}", courseId);
        Type returnType = Course.class;
        makeHttpRequest(context, null, Request.Method.GET, returnType, listener, url);
    }

    public static void postSingleCourse(Context context, Course inputCourse, String majorId, final VolleyResponseListener listener) {
        String url = Const.URL_POST_SINGLE_COURSE.replace("{majorId}", majorId);
        Type returnType = Course.class;
        makeHttpRequest(context, inputCourse, Request.Method.POST, returnType, listener, url);
    }


    private static void makeHttpRequest(Context context, final Object postInput, int requestMethodType, final Type returnType, final VolleyResponseListener listener, String url) {
        final RequestQueue queue = Volley.newRequestQueue(context);
        final Gson gson = new Gson();
        final String jsonString = gson.toJson(postInput);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(requestMethodType, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String json) {
                        // Display the first 500 characters of the json string.
//                        Object returnObject = gson.fromJson(json, returnType);
                        listener.onResponse("no");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.toString());
            }

        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return jsonString.getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}