package org.javacore.domain;

import org.javacore.contants.Major;

public class StudentDATA extends Student{
    private Double pointOracle;
    private Double pointMysql;
    private Double pointPosgresql;

    public StudentDATA(Integer studentId, String fullName, Integer age, String major, Double pointOracle, Double pointMysql, Double pointPosgresql) {
        super(studentId, fullName, age, major);
        this.pointOracle = pointOracle;
        this.pointMysql = pointMysql;
        this.pointPosgresql = pointPosgresql;
    }

    public StudentDATA() {

    }

    public Double getPointOracle() {
        return pointOracle;
    }

    public void setPointOracle(Double pointOracle) {
        this.pointOracle = pointOracle;
    }

    public Double getPointMysql() {
        return pointMysql;
    }

    public void setPointMysql(Double pointMysql) {
        this.pointMysql = pointMysql;
    }

    public Double getPointPosgresql() {
        return pointPosgresql;
    }

    public void setPointPosgresql(Double pointPosgresql) {
        this.pointPosgresql = pointPosgresql;
    }

    @Override
    public String toString() {
        return "StudentDATA{" +
                "pointOracle=" + pointOracle +
                ", pointMysql=" + pointMysql +
                ", pointPosgresql=" + pointPosgresql +
                ", studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }
}
