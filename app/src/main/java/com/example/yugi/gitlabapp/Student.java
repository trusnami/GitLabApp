package com.example.yugi.gitlabapp;

/**
 * Created by yugi on 2017/6/28.
 */

/*{
        "id": 235,
        "username": "121250137",
        "name": "学生279",
        "type": "student",
        "avatar": null,
        "gender": "male",
        "email": "121250137@smail.nju.edu.cn",
        "schoolId": 1,
        "gitId": 0,
        "number": "121250137",
        "groupId": 8,
        "gitUsername": "121250137"
        }*/
public class Student {

    private String id;

    private String username;

    private String name;

    private String type;

    private String avatar;

    private String gender;

    private String email;

    private String schoolId;

    private String gitId;

    private String number;

    private String groupId;

    private String gitUsername;

    public Student(String id, String username, String name, String type, String avatar, String gender, String email,
                   String schoolId, String gitId, String number, String groupId, String gitUsername) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.type = type;
        this.avatar = avatar;
        this.gender = gender;
        this.email = email;
        this.schoolId = schoolId;
        this.gitId = gitId;
        this.number = number;
        this.groupId = groupId;
        this.gitUsername = gitUsername;
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

    public String getGitId() {
        return gitId;
    }

    public String getNumber() {
        return number;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGitUsername() {
        return gitUsername;
    }
}
