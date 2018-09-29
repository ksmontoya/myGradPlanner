package com.example.amontoya.mygradplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import ClassLoaders.Course;
import ClassLoaders.CourseBuilder;
import net_utils.VolleyResponseListener;
import net_utils.VolleyUtils;


public class VolleyUtilExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_util_example);


        final TextView mTextView = findViewById(R.id.message);
        final Course course = new CourseBuilder().setMajorId("Com S").setCourseShortName("Com S 327").setCourseLongName("Advanced Programming techniques").setDescription("You will learn c in this course yo").createCourse();

        /*
        1-To run volleyUtils, you have to write VolleyUtils.[What do you want to do?]
            in my case, I wrote VolleyUtils.getMajorsList because I want a list of majors
        2-As parameters, you must give it a context, and you also must give it a volleyListener, which
            looks exactly as my stuff does below.
            *Note that the methods may need more parameters, but they will start with context, and end with a listener.
        3-Then you have to implement both onError, and onResponse methods.
            -Onerror, you may want to create a toast or display a message saying it didn't work
            -onResponse, you may want to grab that object, and display it on the screen, or
            notify the user that something good happened.
         */
        VolleyUtils.getMajorsList(getApplicationContext(), new VolleyResponseListener() {
            @Override
            public void onError(String error) {
                mTextView.setText("failed!");
            }

            @Override
            public void onResponse(Object response) {
                //What do you want to do if you succeed?
                mTextView.setText("Success!");
            }
        });
    }
}