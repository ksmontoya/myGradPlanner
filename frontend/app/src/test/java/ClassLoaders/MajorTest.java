package ClassLoaders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Map;

import static org.junit.Assert.*;

public class MajorTest {

    @Test
    public void main() {
        Major majorObject = new MajorBuilder().setMajorName("Music").setId("Com S").createMajor();
        Gson gson = new Gson();
        String json = gson.toJson(majorObject);
        System.out.print("MajorClassssssssssssssssssssssssssS" +json.toString());

        Major major = gson.fromJson(json, Major.class);
        Course courseToDisplay = gson.fromJson(json, Course.class);
    }

    @Test
    public void tryStuff() {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        final Course course = new CourseBuilder().setMajorId("Com S").setCourseShortName("Com S 327").setCourseLongName("Advanced Programming techniques").setDescription("You will learn c in this course yo").createCourse();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();

        String jsonString = gson.toJson(course);
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Map<String, String> myMap = gson.fromJson(json, type);
        System.out.println(myMap);
    }
}