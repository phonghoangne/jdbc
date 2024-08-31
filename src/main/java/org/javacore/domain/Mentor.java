package org.javacore.domain;

public class Mentor {
    // dat ten quy tac lac da va tat ca cac thuoc tinh private
    private Integer mentorId;
    private String fullName;
    private Integer age;
    private Integer gender;


    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public Mentor(Integer mentorId, String fullName, Integer age, Integer gender) {
        this.mentorId = mentorId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public Mentor() {
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "mentorId=" + mentorId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }


}
