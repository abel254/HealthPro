package com.example.healthpro.Authentication;

public class Reg {
    int id;
    String firstname;
    String lastname;
    String currentWeight;
    String targetWeight;
    String birth;
    String gender;

    public Reg(int id, String firstname, String lastname, String currentWeight, String targetWeight, String birth, String gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.birth = birth;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(String targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
