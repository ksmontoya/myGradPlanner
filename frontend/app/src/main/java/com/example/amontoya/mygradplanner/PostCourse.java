package com.example.amontoya.mygradplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ClassLoaders.Course;
import ClassLoaders.CourseBuilder;
import ClassLoaders.Major;
import ClassLoaders.MajorBuilder;
import net_utils.VolleyResponseListener;
import net_utils.VolleyUtils;

public class PostCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_course);

        //variables elements
       // finGETTINGal TextView mTextView = findViewById(R.id.courses);
        final List<Major> majorList = new ArrayList<Major>();

        // COURSE
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
                        //GETS THE ID NAME AND DESCRIPTION FROM THE USER
                        EditText IDEditText = (EditText) findViewById(R.id.CourseIDEntered);
                        String courseID = IDEditText.getText().toString();

                        EditText nameEditText = (EditText) findViewById(R.id.CourseNameEntered);
                        String courseName = nameEditText.getText().toString();

                        EditText descriptionEditText = (EditText) findViewById(R.id.CourseDescriptionEntered);
                        String courseDescription = descriptionEditText.getText().toString();


                        //CREATES AND SENDS A COURSE OBJECT TO THE SERVER
                        if( TextUtils.isEmpty(IDEditText.getText())){
                            IDEditText.setError( "courseId is required!" );

                        }else{
                            createAnObject(majorID,courseID,courseName,courseDescription);
                        }

                    }
                });

    }

    private void createAnObject(String MajorId , String courseId, String courseName, String courseDescription) {
        Course CourseObject = new CourseBuilder().setMajorId(MajorId).setCourseId(courseId).setCourseLongName(courseName).setDescription(courseDescription).createCourse();

        //Sends this jason object to the server
        sendObjectToServer(CourseObject);

    }

    private void sendObjectToServer(Course courseObject) {

        //final TextView mTextView = findViewById(R.id.courses);

        VolleyUtils.postSingleCourse(getApplicationContext(),courseObject, courseObject.getMajor().getId(), new VolleyResponseListener() {
            @Override
            public void onError(String error) {
                //mTextView.setText("failed!");
                Toast.makeText(getBaseContext(), "Failed posting the course!",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Object response) {
                //What do you want to do if you succeed?
                //mTextView.setText("Success!");
                Toast.makeText(getBaseContext(), "Succeed posting the course!",
                        Toast.LENGTH_LONG).show();
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



}


