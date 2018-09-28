package com.example.amontoya.mygradplanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ClassLoaders.Course;
import ClassLoaders.CourseBuilder;
import net_utils.VolleyResponseListener;
import net_utils.VolleyUtils;

public class Classes extends android.app.Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.courses, container, false);
        final TextView mTextView = myView.findViewById(R.id.message);
        final EditText editText = myView.findViewById(R.id.editText);
        Button button = myView.findViewById(R.id.button);
        final Course course = new CourseBuilder().setMajorId("Com S").setCourseShortName("Com S 327").setCourseLongName("Advanced Programming techniques").setDescription("You will learn c in this course yo").createCourse();

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                VolleyUtils.postSingleCourse(getContext(), course, "Com S", new VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        mTextView.setText("Failure!");
                    }

                    @Override
                    public void onResponse(Object response) {
                        mTextView.setText("Success!");
                    }
                });
            }
        });


        return myView;
    }
}