package com.example.citypro.entites;

public class UserName {
    public UserName(String name, int resultCode) {
        this.name = name;
        this.resultCode = resultCode;
    }
    public UserName() {
        this.name = null;
        this.resultCode = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    String name;
    int resultCode;
}
