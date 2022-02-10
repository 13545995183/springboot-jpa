package com.example.springbootthymeleaf.entity;

public class user {
    private String username;
    private int age ;
    private String phone;
    private String sex;

    public user(String username, int age, String phone,String sex) {
        this.username = username;
        this.age = age;
        this.phone = phone;
        this.sex=sex;
    }

    public user() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
