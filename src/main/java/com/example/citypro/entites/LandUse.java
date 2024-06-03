package com.example.citypro.entites;

public class LandUse {
    public LandUse(double lon, double lat, int UUID, double f_AREA, int level1, int level2) {
        Lon = lon;
        Lat = lat;
        this.UUID = UUID;
        F_AREA = f_AREA;
        Level1 = level1;
        Level2 = level2;
    }

    public LandUse() {
        Lon = 0;
        Lat = 0;
        this.UUID = 0;
        F_AREA = 0;
        Level1 = 0;
        Level2 = 0;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double lon) {
        Lon = lon;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public double getF_AREA() {
        return F_AREA;
    }

    public void setF_AREA(double f_AREA) {
        F_AREA = f_AREA;
    }

    public int getLevel1() {
        return Level1;
    }

    public void setLevel1(int level1) {
        Level1 = level1;
    }

    public int getLevel2() {
        return Level2;
    }

    public void setLevel2(int level2) {
        Level2 = level2;
    }

    double Lon;
    double Lat;
    int UUID;
    double F_AREA;
    int Level1;
    int Level2;
}
