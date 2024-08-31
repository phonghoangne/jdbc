package org.javacore.domain;

import org.javacore.contants.Major;

public  abstract class Student {
    protected Integer studentId;
    protected String fullName;
    protected Integer age;
    protected String major;

    public Student(Integer studentId, String fullName, Integer age, String major) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.major = major;
    }

    public Student() {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
