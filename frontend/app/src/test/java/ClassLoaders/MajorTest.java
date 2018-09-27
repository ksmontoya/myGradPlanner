package ClassLoaders;

import com.google.gson.Gson;

import org.junit.Test;

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
}