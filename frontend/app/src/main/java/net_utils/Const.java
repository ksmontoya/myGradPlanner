package net_utils;

public class Const {
    public static final String BASE_URL = "http://proj309-tg-02.misc.iastate.edu:8080/";
    public static final String URL_GET_COURSE_LIST = BASE_URL + "/majors/{id}/courses";
    public static final String URL_GET_SINGLE_COURSE = BASE_URL + "/majors/{majorId}/courses/{courseId}";
    public static final String URL_POST_SINGLE_COURSE = BASE_URL + "/majors/{majorId}/courses";
    public static final String URL_PUT_SINGLE_COURSE = BASE_URL + "/majors/{majorId}/courses/{courseId}";
    public static final String URL_DELETE_SINGLE_COURSE = BASE_URL + "/majors/{majorId}/courses/{courseId}";

    public static final String URL_GET_MAJOR_LIST = BASE_URL + "/majors";
    public static final String URL_GET_SINGLE_MAJOR = BASE_URL + "/majors/{majorId}";
    public static final String URL_POST_SINGLE_MAJOR = BASE_URL + "/majors";
    public static final String URL_PUT_SINGLE_MAJOR = BASE_URL + "/majors/{majorId}";
    public static final String URL_DELETE_SINGLE_MAJOR = BASE_URL + "/majors/{majorId}";
}
