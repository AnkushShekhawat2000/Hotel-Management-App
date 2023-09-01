package com.example.Hospital.Management.System;

public class Nurse {
    private int nurseId;

    private String name;

    private int age;

    private String qulaification;


    public Nurse(int nurseId, String name, int age, String qulaification) {
        this.nurseId = nurseId;
        this.name = name;
        this.age = age;
        this.qulaification = qulaification;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQulaification() {
        return qulaification;
    }

    public void setQulaification(String qulaification) {
        this.qulaification = qulaification;
    }
}
