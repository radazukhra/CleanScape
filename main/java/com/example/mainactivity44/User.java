package com.example.mainactivity44;

public class User {
    private String id;
    private String email;
    private String password;
    private String userName;
    private String nickName;
    private int age;
    private String phoneNumber;

    public User(String id, String userName, String nickName, String email, String password, int age, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.nickName = nickName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getUserName(){
        return userName;
    }
    public String getNickName(){
        return nickName;
    }
    public int getAge(){
        return age;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }


}
