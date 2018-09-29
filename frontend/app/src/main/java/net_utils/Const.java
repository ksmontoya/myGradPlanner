package net_utils;

public class Const {
    //Debug baseURL
//    private static final String BASE_URL = "http://localhost:8080/";
    private static final String BASE_URL = "http://proj309-tg-02.misc.iastate.edu:8080/";


    public static final String URL_GET_COURSE_LIST = BASE_URL + "Majors/{id}/Courses";
    public static final String URL_GET_SINGLE_COURSE = BASE_URL + "Majors/{majorId}/Courses/{courseId}";
    public static final String URL_POST_SINGLE_COURSE = BASE_URL + "Majors/{majorId}/Courses";
    public static final String URL_PUT_SINGLE_COURSE = BASE_URL + "Majors/{majorId}/Courses/{courseId}";
    public static final String URL_DELETE_SINGLE_COURSE = BASE_URL + "Majors/{majorId}/Courses/{courseId}";

    public static final String URL_GET_MAJOR_LIST = BASE_URL + "Majors";
    public static final String URL_GET_SINGLE_MAJOR = BASE_URL + "Majors/{majorId}";
    public static final String URL_POST_SINGLE_MAJOR = BASE_URL + "Majors";
    public static final String URL_PUT_SINGLE_MAJOR = BASE_URL + "Majors/{majorId}";
    public static final String URL_DELETE_SINGLE_MAJOR = BASE_URL + "Majors/{majorId}";
}
