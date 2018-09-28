package net_utils;

public interface VolleyResponseListener {
    void onError(String message);
    void onResponse(Object response);
}