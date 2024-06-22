package com.example.citypro.entites;

public class StreetView {
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getVegetationPortion() {
        return vegetationPortion;
    }

    public void setVegetationPortion(double vegetationPortion) {
        this.vegetationPortion = vegetationPortion;
    }

    public double getSkyPortion() {
        return skyPortion;
    }

    public void setSkyPortion(double skyPortion) {
        this.skyPortion = skyPortion;
    }

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public StreetView(double lng, double lat, double vegetationPortion, double skyPortion, String road_name, String english) {
        this.lng = lng;
        this.lat = lat;
        this.vegetationPortion = vegetationPortion;
        this.skyPortion = skyPortion;
        this.road_name = road_name;
        this.english = english;
    }

    public StreetView() {
        this.lng = 0;
        this.lat = 0;
        this.vegetationPortion = 0;
        this.skyPortion = 0;
        this.road_name = null;
        this.english = null;
    }

    double lng;
    double lat;
    double vegetationPortion;
    double skyPortion;
    String road_name;
    String english;
}
