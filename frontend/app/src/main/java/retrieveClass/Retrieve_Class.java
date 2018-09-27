package retrieveClass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.amontoya.mygradplanner.R;

import org.json.JSONObject;

import ClassLoaders.Course;
import ClassLoaders.CourseBuilder;


public class Retrieve_Class extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_class);
        final TextView mTextView = (TextView) findViewById(R.id.message);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final RequestQueue queue = Volley.newRequestQueue(this);
        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new Button.OnClickListener();

            @Override
            public void onClick(View view) {

                String url = editText.getText().toString();

                // Request a string response from the provided URL.
                JsonObjectRequest jsonRequest = new JsonObjectRequest
                        (Request.Method.GET, "http://" + url, null, new Response.Listener<JSONObject>() {
                            Course course = new Course();

                            @Override
                            public void onResponse(JSONObject response) {
                                // Display the first 500 characters of the response string.

                                mTextView.setText("Response" + response.toString());
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                mTextView.setText("That didn't work!");
                            }
                        });

                // Add the request to the RequestQueue.
                queue.add(jsonRequest);
            }
        });
    }
}
