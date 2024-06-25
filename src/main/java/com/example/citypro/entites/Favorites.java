package com.example.citypro.entites;

public class Favorites {
    public Favorites(int favorites_id, int user_id, double longitude, double latitude, double distance0101, double distance0201, double distance0202, double distance0301, double distance0401, double distance0402, double distance0403, double distance0501, double distance0502, double distance0503, double distance0504, double distance0505, String note) {
        this.favorite_id = favorites_id;
        this.user_id = user_id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance0101 = distance0101;
        this.distance0201 = distance0201;
        this.distance0202 = distance0202;
        this.distance0301 = distance0301;
        this.distance0401 = distance0401;
        this.distance0402 = distance0402;
        this.distance0403 = distance0403;
        this.distance0501 = distance0501;
        this.distance0502 = distance0502;
        this.distance0503 = distance0503;
        this.distance0504 = distance0504;
        this.distance0505 = distance0505;
        this.note = note;
    }

    public Favorites(){
        this.favorite_id = -1;
        this.user_id = -1;
        this.longitude = 0;
        this.latitude = 0;
        this.distance0101 = 0.0;
        this.distance0201 = 0.0;
        this.distance0202 = 0.0;
        this.distance0301 = 0.0;
        this.distance0401 = 0.0;
        this.distance0402 = 0.0;
        this.distance0403 = 0.0;
        this.distance0501 = 0.0;
        this.distance0502 = 0.0;
        this.distance0503 = 0.0;
        this.distance0504 = 0.0;
        this.distance0505 = 0.0;
        this.note = null;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getDistance0101() {
        return distance0101;
    }

    public void setDistance0101(double distance0101) {
        this.distance0101 = distance0101;
    }

    public double getDistance0201() {
        return distance0201;
    }

    public void setDistance0201(double distance0201) {
        this.distance0201 = distance0201;
    }

    public double getDistance0202() {
        return distance0202;
    }

    public void setDistance0202(double distance0202) {
        this.distance0202 = distance0202;
    }

    public double getDistance0301() {
        return distance0301;
    }

    public void setDistance0301(double distance0301) {
        this.distance0301 = distance0301;
    }

    public double getDistance0401() {
        return distance0401;
    }

    public void setDistance0401(double distance0401) {
        this.distance0401 = distance0401;
    }

    public double getDistance0402() {
        return distance0402;
    }

    public void setDistance0402(double distance0402) {
        this.distance0402 = distance0402;
    }

    public double getDistance0403() {
        return distance0403;
    }

    public void setDistance0403(double distance0403) {
        this.distance0403 = distance0403;
    }

    public double getDistance0501() {
        return distance0501;
    }

    public void setDistance0501(double distance0501) {
        this.distance0501 = distance0501;
    }

    public double getDistance0502() {
        return distance0502;
    }

    public void setDistance0502(double distance0502) {
        this.distance0502 = distance0502;
    }

    public double getDistance0503() {
        return distance0503;
    }

    public void setDistance0503(double distance0503) {
        this.distance0503 = distance0503;
    }

    public double getDistance0504() {
        return distance0504;
    }

    public void setDistance0504(double distance0504) {
        this.distance0504 = distance0504;
    }

    public double getDistance0505() {
        return distance0505;
    }

    public void setDistance0505(double distance0505) {
        this.distance0505 = distance0505;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    int favorite_id;
    int user_id;
    double longitude;
    double latitude;
    double distance0101;
    double distance0201;
    double distance0202;
    double distance0301;
    double distance0401;
    double distance0402;
    double distance0403;
    double distance0501;
    double distance0502;
    double distance0503;
    double distance0504;
    double distance0505;
    String note;
}
