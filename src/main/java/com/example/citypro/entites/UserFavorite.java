package com.example.citypro.entites;

import java.util.List;

public class UserFavorite {
    public UserFavorite(List<Favorites> value, int resultCode) {
        this.value = value;
        this.resultCode = resultCode;
    }

    public UserFavorite() {
        this.value = null;
        this.resultCode = 1;
    }

    public List<Favorites> getValue() {
        return value;
    }

    public void setValue(List<Favorites> value) {
        this.value = value;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    List<Favorites> value;
    int resultCode;
}
