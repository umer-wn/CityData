package com.example.citypro.services;

import com.example.citypro.entites.*;
import com.example.citypro.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServices {
    @Autowired
    CityMapper cityMapper;
    private static final int EARTH_RADIUS_KM = 6371;

    public ResultCode login(
            String userID,
            String password
    ){
        ResultCode rc = new ResultCode();

        List<Users>l1 = cityMapper.login(userID,password);
        if(l1.size()!=1)
            rc.setResultCode(-101);

        return rc;
    }

    public ResultCode register(
            String userID,
            String name,
            String password
    ){
        ResultCode rc = new ResultCode();
        List<Users>l1 = cityMapper.checkUserID(userID);
        if(l1.size()!=0){
            rc.setResultCode(-102);
            return rc;
        }

        try{
            cityMapper.register(userID,name,password);
        }catch (Exception e){
            e.printStackTrace();
            rc.setResultCode(-404);
            return rc;
        }
        return rc;
    }

    public ResultCode modifyUserInfo(
            String userID,
            String name,
            String password
    ){
        ResultCode rc = new ResultCode();
        List<Users>l1 = cityMapper.checkUserID(userID);
        if(l1.size()!=1){
            rc.setResultCode(-103);
            return rc;
        }

        try{
            cityMapper.modifyUserInfo(userID,name,password);
        }catch (Exception e){
            e.printStackTrace();
            rc.setResultCode(-404);
            return rc;
        }
        return rc;
    }

    public UserName getUserName(
            String userID
    ){
        UserName userName = new UserName();
        List<Users>l1 = cityMapper.checkUserID(userID);
        if(l1.size()!=1){
            userName.setResultCode(-103);
            return userName;
        }
        userName.setName(l1.get(0).getName());
        return userName;
    }

    private double getDist(double Lon1, double Lat1, double Lon2, double Lat2) {
        // Convert degrees to radians
        double lat1Rad = Math.toRadians(Lat1);
        double lon1Rad = Math.toRadians(Lon1);
        double lat2Rad = Math.toRadians(Lat2);
        double lon2Rad = Math.toRadians(Lon2);

        // Haversine formula
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return EARTH_RADIUS_KM * c;
    }
    public DistInfo getDistInfo(
            double Lon,
            double Lat
    ){
        DistInfo distInfo = new DistInfo();

        try {
//            LandUse landUse1 = cityMapper.findNearestLevelPoint(502,Lon,Lat);
            distInfo.setSchoolDist(getNearDist(Lat,Lon,502));
            distInfo.setParkDist(getNearDist(Lat,Lon,505));
            distInfo.setHospitalDist(getNearDist(Lat,Lon,503));
            distInfo.setFactoryDist(getNearDist(Lat,Lon,301));
//
//            LandUse landUse2 = cityMapper.findNearestLevelPoint(505,Lon,Lat);
//            distInfo.setParkDist(getDist(landUse2.getLon(),landUse2.getLat(),Lon,Lat));
//
//            LandUse landUse3 = cityMapper.findNearestLevelPoint(503,Lon,Lat);
//            distInfo.setHospitalDist(getDist(landUse3.getLon(),landUse3.getLat(),Lon,Lat));
//
//            LandUse landUse4 = cityMapper.findNearestLevelPoint(301,Lon,Lat);
//            distInfo.setFactoryDist(getDist(landUse4.getLon(),landUse4.getLat(),Lon,Lat));
        }catch(Exception e){
            e.printStackTrace();
            distInfo.setResultCode(-1);
            return distInfo;
        }

        return distInfo;
    }

    public StreetView getStreetViewInfo(
            double Lng,
            double Lat
    ){
        StreetView streetView;
        List<StreetView> result = cityMapper.findNearestPointInfo(Lng,Lat);
        streetView = result.get(0);
        return streetView;
    }

    public double getNearDist(
            double Lat,
            double Lon,
            int code
    ) {
        LandUse landUseTest = cityMapper.findNearestLevelPoint(code,Lon,Lat);
        return getDist(landUseTest.getLon(), landUseTest.getLat(),Lon,Lat);
    }
    public ResultCode addFavorite(
            int user_id,
            double Lat,
            double Lon,
            String note
    ){
        try{
            //首先我们需要获得各个位置的距离信息
            Favorites favorites = new Favorites();
            favorites.setUser_id(user_id);

            List<Favorites>allFavorites = cityMapper.getAllFavorites();
            if(allFavorites.size()==0){
                favorites.setFavorite_id(0);
            }else{
                favorites.setFavorite_id(cityMapper.getMaxFavoriteID()+1);
            }
            System.out.println(favorites.getFavorite_id());

            //写入距离信息
            favorites.setDistance0101(getNearDist(Lat,Lon,101));
            favorites.setDistance0201(getNearDist(Lat,Lon,201));
            favorites.setDistance0202(getNearDist(Lat,Lon,202));
            favorites.setDistance0301(getNearDist(Lat,Lon,301));
            favorites.setDistance0401(1);
            favorites.setDistance0402(getNearDist(Lat,Lon,402));
            favorites.setDistance0403(getNearDist(Lat,Lon,403));
            favorites.setDistance0501(getNearDist(Lat,Lon,501));
            favorites.setDistance0502(getNearDist(Lat,Lon,502));
            favorites.setDistance0503(getNearDist(Lat,Lon,503));
            favorites.setDistance0504(getNearDist(Lat,Lon,504));
            favorites.setDistance0505(getNearDist(Lat,Lon,505));

            favorites.setNote(note);
            cityMapper.insertFavorite(favorites.getFavorite_id(), favorites.getUser_id(),
                    Lon, Lat, favorites.getDistance0101(),
                    favorites.getDistance0201(), favorites.getDistance0202(), favorites.getDistance0301(),
                    favorites.getDistance0401(), favorites.getDistance0402(), favorites.getDistance0403(),
                    favorites.getDistance0501(), favorites.getDistance0502(), favorites.getDistance0503(),
                    favorites.getDistance0504(), favorites.getDistance0505(), note);

            return new ResultCode(1);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultCode(-404);
        }
    }

    public UserFavorite getUserFavorite(
            int user_id
    ){
        UserFavorite userFavorite = new UserFavorite();
        try {
            userFavorite.setValue(cityMapper.getUserFavorites(user_id));
            userFavorite.setResultCode(1);
            return userFavorite;
        }catch (Exception e){
            userFavorite.setResultCode(-404);
            return userFavorite;
        }
    }

    public ResultCode deleteUserFavorite(
            int favorite_id
    ){
        ResultCode rc= new ResultCode(1);

        try {
            cityMapper.deleteFavoriteItems(favorite_id);
            return rc;
        }catch (Exception e){
            rc.setResultCode(-404);
            return rc;
        }
    }

}
