package com.example.citypro.services;

import com.example.citypro.entites.*;
import com.example.citypro.mapper.CityMapper;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
            LandUse landUse1 = cityMapper.findNearestLevelPoint(502,Lon,Lat);
            distInfo.setSchoolDist(getDist(landUse1.getLon(),landUse1.getLat(),Lon,Lat));

            LandUse landUse2 = cityMapper.findNearestLevelPoint(505,Lon,Lat);
            distInfo.setParkDist(getDist(landUse2.getLon(),landUse2.getLat(),Lon,Lat));

            LandUse landUse3 = cityMapper.findNearestLevelPoint(503,Lon,Lat);
            distInfo.setHospitalDist(getDist(landUse3.getLon(),landUse3.getLat(),Lon,Lat));

            LandUse landUse4 = cityMapper.findNearestLevelPoint(301,Lon,Lat);
            distInfo.setFactoryDist(getDist(landUse4.getLon(),landUse4.getLat(),Lon,Lat));
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

}
