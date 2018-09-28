package net_utils;

import com.android.volley.VolleyError;

public interface VolleyResponseListener {
    void onError(String error);
    void onResponse(Object response);
}