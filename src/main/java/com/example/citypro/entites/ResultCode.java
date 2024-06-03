package com.example.citypro.entites;

public class ResultCode {
    int resultCode;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode() {
        this.resultCode = 1;
    }
}
