package org.javacore.domain;

public class StudentUDPM extends Student{
    private Double pointJava1;
    private Double pointJava2;
    private Double pointJava3;

    public StudentUDPM(Integer studentId, String fullName, Integer age, String major, Double pointJava1, Double pointJava2, Double pointJava3) {
        super(studentId, fullName, age, major);
        this.pointJava1 = pointJava1;
        this.pointJava2 = pointJava2;
        this.pointJava3 = pointJava3;
    }

    public StudentUDPM() {
        super();
    }

    public Double getPointJava1() {
        return pointJava1;
    }

    public void setPointJava1(Double pointJava1) {
        this.pointJava1 = pointJava1;
    }

    public Double getPointJava2() {
        return pointJava2;
    }

    public void setPointJava2(Double pointJava2) {
        this.pointJava2 = pointJava2;
    }

    public Double getPointJava3() {
        return pointJava3;
    }

    public void setPointJava3(Double pointJava3) {
        this.pointJava3 = pointJava3;
    }

    @Override
    public String toString() {
        return "StudentUDPM{" +
                "pointJava1=" + pointJava1 +
                ", pointJava2=" + pointJava2 +
                ", pointJava3=" + pointJava3 +
                ", studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }
}
