package com.example.citypro.mapper;

import com.example.citypro.entites.LandUse;
import com.example.citypro.entites.StreetView;
import com.example.citypro.entites.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityMapper {

    @Select("select * from users where user_id = #{user_id} and password = #{password}")
    List<Users> login(@Param("user_id")String user_id, @Param("password")String password);


    @Select("select * from users where user_id = #{user_id}")
    List<Users> checkUserID(@Param("user_id")String user_id);

    @Insert("insert into users values(#{user_id},#{name},#{password}) ")
    void register(@Param("user_id")String user_id,@Param("name")String name, @Param("password")String password);

    @Insert("update users set name = #{name} and password = #{password} where user_id = #{user_id} ")
    void modifyUserInfo(@Param("user_id")String user_id,@Param("name")String name, @Param("password")String password);

    @Select("SELECT * " +
            "FROM LandUse " +
            "WHERE Level2 = #{Level} " +
            "ORDER BY 6371 * ACOS(" +
            "    COS(RADIANS(#{knownLat})) * COS(RADIANS(Lat)) * COS(RADIANS(Lon) - RADIANS(#{knownLon})) + " +
            "    SIN(RADIANS(#{knownLat})) * SIN(RADIANS(Lat))" +
            ") ASC " +
            "LIMIT 1")
    LandUse findNearestLevelPoint(@Param("Level")int Level, @Param("knownLon") double knownLon, @Param("knownLat") double knownLat);

    @Select("SELECT * " +
            "FROM street_view " +
            "ORDER BY 6371 * ACOS(" +
            "    COS(RADIANS(#{knownlat})) * COS(RADIANS(lat)) * COS(RADIANS(lng) - RADIANS(#{knownlng})) + " +
            "    SIN(RADIANS(#{knownlat})) * SIN(RADIANS(lat))" +
            ") ASC " +
            "LIMIT 1")
    List<StreetView> findNearestPointInfo(@Param("knownlng") double knownlng, @Param("knownlat") double knownlat);
}
