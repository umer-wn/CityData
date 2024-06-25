package com.example.citypro.mapper;

import com.example.citypro.entites.Favorites;
import com.example.citypro.entites.LandUse;
import com.example.citypro.entites.StreetView;
import com.example.citypro.entites.Users;
import org.apache.ibatis.annotations.*;
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

    @Select("SELECT MAX(favorite_id)  FROM favorites")
    int getMaxFavoriteID();

    @Select("select * from favorites")
    List<Favorites> getAllFavorites();

    @Select("select * from favorites where user_id =#{user_id} ")
    List<Favorites> getUserFavorites(@Param("user_id") int user_id);

    @Insert("INSERT INTO favorites (favorite_id, user_id, longitude, latitude, distance0101, distance0201, distance0202, distance0301, distance0401, distance0402, distance0403, distance0501, distance0502, distance0503, distance0504, distance0505, note) " +
            "VALUES (#{favorite_id}, #{user_id}, #{longitude}, #{latitude}, #{distance0101}, #{distance0201}, #{distance0202}, #{distance0301}, #{distance0401}, #{distance0402}, #{distance0403}, #{distance0501}, #{distance0502}, #{distance0503}, #{distance0504}, #{distance0505}, #{note})")
    void insertFavorite(@Param("favorite_id") int favorite_id,
                        @Param("user_id") int user_id,
                        @Param("longitude") double longitude,
                        @Param("latitude") double latitude,
                        @Param("distance0101") double distance0101,
                        @Param("distance0201") double distance0201,
                        @Param("distance0202") double distance0202,
                        @Param("distance0301") double distance0301,
                        @Param("distance0401") double distance0401,
                        @Param("distance0402") double distance0402,
                        @Param("distance0403") double distance0403,
                        @Param("distance0501") double distance0501,
                        @Param("distance0502") double distance0502,
                        @Param("distance0503") double distance0503,
                        @Param("distance0504") double distance0504,
                        @Param("distance0505") double distance0505,
                        @Param("note") String note);

    @Delete("delete from favorites where favorite_id = #{favorite_id}")
    void deleteFavoriteItems(@Param("favorite_id")int favorite_id);
}
