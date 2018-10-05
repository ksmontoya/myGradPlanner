package com.example.amontoya.mygradplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ClassLoaders.Course;
import ClassLoaders.Major;
import net_utils.VolleyResponseListener;
import net_utils.VolleyUtils;

import java.util.ArrayList;
import java.util.List;

public class GetCourseList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_course_list);

        //variables elements
        // final TextView mTextView = findViewById(R.id.courses);
        final List<Major> majorList = new ArrayList<Major>();
        final TextView mTextView = findViewById(R.id.Course_Names);

        //GETTING COURSE
        //method to get the major Id and to create a course object
        VolleyUtils.getMajorsList(getApplicationContext(), new VolleyResponseListener() {
            @Override
            public void onError(String error) {
                // mTextView.setText("failed!");
                Toast.makeText(getBaseContext(), "Failed loading courses !",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Object response) {
                //What do you want to do if you succeed?
                majorList.addAll((List<Major>) response);
                ArrayList<String> majorIDs = new ArrayList<>();

                for (int i = 0; i < majorList.size(); i++) {
                    majorIDs.add(majorList.get(i).getId());
                }

                majorDropDown(majorIDs);
                // mTextView.setText("Success!" + majorIDs.toString());
            }
        });

        ((Button) findViewById(R.id.postButton))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String majorID = ((Spinner) findViewById(R.id.major_dropdown)).getSelectedItem().toString();


                    VolleyUtils.getCoursesList(getApplicationContext(), majorID, new VolleyResponseListener() {
                        @Override
                        public void onError(String error) {
                            Toast.makeText(getBaseContext(), "Failed loading courses !",
                                    Toast.LENGTH_LONG).show();
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
                });

    }
    protected void majorDropDown(List<String> majorList) {
        Spinner dropdown = findViewById(R.id.major_dropdown);
        //create a list of items for the spinner.
        String[] items = majorList.toArray(new String[majorList.size()]);
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        //((Spinner)findViewById(R.id.major_dropdown)).getSelectedItem()

    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_get_course_list);
//
//        final TextView mTextView = findViewById(R.id.Course_Names);
//
//        String majorID = ((Spinner) findViewById(R.id.major_dropdown)).getSelectedItem().toString();
//
//        VolleyUtils.getCoursesList(getApplicationContext(), majorID, new VolleyResponseListener() {
//            @Override
//            public void onError(String error) {
//                Toast.makeText(getBaseContext(), "Failed loading courses !",
//                        Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onResponse(Object response) {
//                List<Course> courses = (List) response;
//                String result = "";
//                for(int i = 0; i < courses.size(); i++){
//                    result += (courses.get(i)).getCourseId() + ", ";
//                }
//                mTextView.setText(result);
//            }
//        });
//
//
//    }
}
