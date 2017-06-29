package com.example.yugi.gitlabapp;

/**
 * Created by yugi on 2017/6/28.
 */

public class Creator {

    private String id;

    private String username;

    private String name;

    private String type;

    private String avatar;

    private String gender;

    private String email;

    private String schoolId;

    public Creator(String id, String username, String name, String type, String avatar, String gender, String email, String schoolId) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.type = type;
        this.avatar = avatar;
        this.gender = gender;
        this.email = email;
        this.schoolId = schoolId;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getSchoolId() {
        return schoolId;
    }
}
