package com.example.sdiointernslimited.Models;

public class Users {

    String profilepic, userName, mail, password, userId, city, mobileno;

    public Users(String profilepic, String userName, String mail, String password, String userId, String city, String mobileno) {
        this.profilepic = profilepic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.city = city;
        this.mobileno = mobileno;
    }

    public Users() {
    }

    public Users(String userName, String mail, String password, String city, String mobileno) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.city = city;
        this.mobileno = mobileno;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}

