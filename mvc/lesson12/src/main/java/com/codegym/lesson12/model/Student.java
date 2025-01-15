package com.codegym.lesson12.model;

public class Student {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private Integer age;
    private String email;
    private String phone;
    private String address;
    private int clazzId;

    public Student() {
    }

    public Student(String fullName, String username, String password, Integer age, String email, String phone, String address, int clazzId) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.clazzId = clazzId;
    }

    public Student(Integer id, String fullName, String username, String password, Integer age, String email, String phone, String address, int clazzId) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.clazzId = clazzId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", clazzId=" + clazzId +
                '}';
    }
}
