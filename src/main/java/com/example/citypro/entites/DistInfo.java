package com.example.citypro.entites;

public class DistInfo {
    public DistInfo(int resultCode, double factoryDist, double hospitalDist, double schoolDist, double parkDist) {
        this.resultCode = resultCode;
        this.factoryDist = factoryDist;
        this.hospitalDist = hospitalDist;
        this.schoolDist = schoolDist;
        this.parkDist = parkDist;
    }

    public DistInfo() {
        this.resultCode = 1;
        this.factoryDist = 0;
        this.hospitalDist = 0;
        this.schoolDist = 0;
        this.parkDist = 0;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public double getFactoryDist() {
        return factoryDist;
    }

    public void setFactoryDist(double factoryDist) {
        this.factoryDist = factoryDist;
    }

    public double getHospitalDist() {
        return hospitalDist;
    }

    public void setHospitalDist(double hospitalDist) {
        this.hospitalDist = hospitalDist;
    }

    public double getSchoolDist() {
        return schoolDist;
    }

    public void setSchoolDist(double schoolDist) {
        this.schoolDist = schoolDist;
    }

    public double getParkDist() {
        return parkDist;
    }

    public void setParkDist(double parkDist) {
        this.parkDist = parkDist;
    }

    int resultCode;
    double factoryDist;
    double hospitalDist;
    double schoolDist;
    double parkDist;
}
