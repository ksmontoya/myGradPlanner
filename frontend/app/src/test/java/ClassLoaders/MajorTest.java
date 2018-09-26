package ClassLoaders;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorTest {

    @Test
    public void main() {
        Major majorObject = new MajorBuilder().setMajorName("Music").createMajor();
        Gson gson = new Gson();
        String json = gson.toJson(majorObject);
        System.out.print("MajorClassssssssssssssssssssssssssS" +json.toString());

    }
}