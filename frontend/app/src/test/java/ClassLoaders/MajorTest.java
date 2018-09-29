package ClassLoaders;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorTest {

    @Test
    public void main() {
        //Create a major object
        Major majorObject = new MajorBuilder().setMajorName("Music").createMajor();
        Gson gson = new Gson();

        //Turn major object to json
        String json = gson.toJson(majorObject);
        System.out.print("MajorClassssssssssssssssssssssssssS" +json.toString());

        //Turn json string to major object
        Major stuff = gson.fromJson(json, Major.class);
        System.out.print("");
    }
}