package ClassLoaders;

public class MajorBuilder {
    private String id;
    private String majorName;
    private String majorDescription;

    public MajorBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public MajorBuilder setMajorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    public MajorBuilder setMajorDescription(String majorDescription) {
        this.majorDescription = majorDescription;
        return this;
    }

    public Major createMajor() {
        return new Major(id, majorName, majorDescription);
    }
}