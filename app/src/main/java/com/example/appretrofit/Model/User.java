package com.example.appretrofit.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    private String  user_id;
    private String  user_name;
    private String  session_id;
    @SerializedName("body")
    private String text;
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
