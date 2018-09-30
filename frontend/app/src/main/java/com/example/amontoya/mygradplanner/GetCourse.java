package com.example.amontoya.mygradplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ClassLoaders.Course;
import ClassLoaders.CourseBuilder;
import net_utils.VolleyResponseListener;
import net_utils.VolleyUtils;

public class GetCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_course);


        final TextView mTextView = findViewById(R.id.Course_Name);
        final TextView nTextView = findViewById(R.id.Course_Description);

        VolleyUtils.getSingleCourse(getApplicationContext(), "Com S", "ComS228", new VolleyResponseListener() {
            @Override
            public void onError(String error) {
                mTextView.setText("Error");
                nTextView.setText("Error");
            }

            @Override
            public void onResponse(Object response) {
                Course course = (Course) response;
                mTextView.setText(course.getCourseId());
                nTextView.setText(course.getDescription());
            }
        });


    }
}
