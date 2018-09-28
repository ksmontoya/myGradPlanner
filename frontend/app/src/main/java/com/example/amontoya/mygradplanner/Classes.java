package com.example.amontoya.mygradplanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import ClassLoaders.Course;
import ClassLoaders.Major;
import ClassLoaders.MajorBuilder;

public class Classes extends android.app.Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.courses, container, false);
        final TextView mTextView = myView.findViewById(R.id.message);
        final EditText editText = myView.findViewById(R.id.editText);
        final RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Button button = myView.findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = editText.getText().toString();

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://" + url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                Major majorObject = new MajorBuilder().setMajorName("Com S").setId("Com S").createMajor();
                                Gson gson = new Gson();
                                String json = gson.toJson(majorObject);

                                Major major = gson.fromJson(json, Major.class);
                                Course courseToDisplay = gson.fromJson(json, Course.class);
                                courseToDisplay.setDescription("This is it.");

                                mTextView.setText(courseToDisplay.getDescription());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("That didn't work!");
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });


        return myView;
    }
}