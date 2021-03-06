package ClassLoaders;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Major {


	private String id;

	private String majorName;
	private String majorDescription;

	public String getId() {
		return id;
	}

	public Major setId(String id) {
		this.id = id;
		return this;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Major(String id, String majorName, String majorDescription) {
		super();
		this.id = id;
		this.majorName = majorName;
		this.majorDescription = majorDescription;
	}

	public Major() {
		super();
	}

	public String getMajorDescription() {
		return majorDescription;
	}

	public void setMajorDescription(String majorDescription) {
		this.majorDescription = majorDescription;
	}

	@Override
	public String toString() {
		return "Major{" +
				"id='" + id + '\'' +
				", majorName='" + majorName + '\'' +
				", majorDescription='" + majorDescription + '\'' +
				'}';
	}

	//only a test
//creating objects and coverting them into jsons
    public static void main(String[] args){
        Major majorObject = new MajorBuilder().setId("Music301").setMajorName("Music").setMajorDescription("This class teaches music").createMajor();

        Gson gson = new Gson();
        String json = gson.toJson(majorObject);
        System.out.print("MajorClassssssssssssssssssssssssssS" +json.toString());
    }

    public Map<String,String> getObjectMap() {
		return null;
    }
}