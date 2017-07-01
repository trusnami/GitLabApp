package com.example.yugi.gitlabapp.Entity;

/**
 * Created by yugi on 2017/6/22.
 */

public class Person {

    /**
     "id": 64,
     "username": "nanguangtailang",
     "name": "南光太郎",
     "type": "student",
     "avatar": null,
     "gender": "male",
     "email": "ngtl@126.com",
     "schoolId": 1,
     "gitId": 1,
     "number": null,
     "groupId": 0,
     "gitUsername": null
     */

    /**
     "id": 1,
     "username": "liuqin",
     "name": "刘钦",
     "type": "teacher",
     "avatar": null,
     "gender": "male",
     "email": "lq@nju.edu.cn",
     "schoolId": 0,
     "authority": 1
     */

    private int id;

    private String username;

    private String name;

    private String type;

    private String avatar;

    private String gender;

    private String email;
    //  student
    private String gitId;

    private String number;
    //  teacher
    private String authority;

    public int getId() {
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

    public String getGitId() {
        return gitId;
    }

    public String getNumber() {
        return number;
    }

    public String getAuthority() {
        return authority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGitId(String gitId) {
        this.gitId = gitId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
