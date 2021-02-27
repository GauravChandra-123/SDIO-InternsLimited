package com.example.sdiointernslimited.Models;

public class Students {

    String name, class1, section, rollno, school, gender, age;

    public Students(String name, String class1, String section, String rollno, String school, String gender, String age) {
        this.name = name;
        this.class1 = class1;
        this.section = section;
        this.rollno = rollno;
        this.school = school;
        this.gender = gender;
        this.age = age;
    }

    public Students(){}

    public Students(String name, String class1, String section, String rollno, String school) {
        this.name = name;
        this.class1 = class1;
        this.section = section;
        this.rollno = rollno;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
