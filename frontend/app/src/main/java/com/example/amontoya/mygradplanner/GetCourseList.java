package com.example.amontoya.mygradplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ClassLoaders.Course;
import net_utils.VolleyResponseListener;
import net_utils.VolleyUtils;

import java.util.List;

public class GetCourseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_course_list);

        final TextView mTextView = findViewById(R.id.Course_Names);

        VolleyUtils.getCoursesList(getApplicationContext(), "Com S", new VolleyResponseListener() {
            @Override
            public void onError(String error) {
                mTextView.setText("Error");
            }

            @Override
            public void onResponse(Object response) {
                List<Course> courses = (List) response;
                String result = "";
                for(int i = 0; i < courses.size(); i++){
                    result += (courses.get(i)).getCourseId() + ", ";
                }
                mTextView.setText(result);
            }
        });


    }
}
