package com.example.citypro.controller;
import com.example.citypro.entites.*;
import com.example.citypro.services.CityServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cityInfo")
public class Controller {

    @Autowired
    CityServices cityServices;

    @GetMapping("/Test")
    @Operation(summary = "测试后端连接性", description = "测试后端连接性")
    public String getTest(){
        return "城市消息后端启动成功！";
    }

    //返回-101代表输入的账号或密码非法，返回1代表登录成功
    @GetMapping("/login")
    @Operation(summary = "登录", description = "给出用户id和密码，实现登录功能")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "登录成功"),
            @ApiResponse(responseCode = "400", description = "非法的账号或密码")
    })
    public ResultCode login(
            @Parameter(description = "用户ID", required = true) @RequestParam("user_id") String userID,
            @Parameter(description = "密码", required = true) @RequestParam("password") String password
    ){
        return cityServices.login(userID, password);
    }

    //返回-102代表user_id已经注册过了，返回-404代表特殊故障，返回1代表登录成功
    @GetMapping("/register")
    @Operation(summary = "注册", description = "给出用户id、姓名和密码，实现注册功能，用户ID建议前端直接生成或者采用用户输入的形式")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "注册成功"),
            @ApiResponse(responseCode = "400", description = "用户ID已经注册过"),
            @ApiResponse(responseCode = "404", description = "特殊故障")
    })
    public ResultCode register(
            @Parameter(description = "用户ID", required = true) @RequestParam("user_id") String userID,
            @Parameter(description = "姓名", required = true) @RequestParam("name") String name,
            @Parameter(description = "密码", required = true) @RequestParam("password") String password
    ){
        return cityServices.register(userID, name, password);
    }

    //返回-103代表user_id不存在，返回-404代表特殊故障，返回1修改成功
    @GetMapping("/modifyUserInfo")
    @Operation(summary = "修改用户信息", description = "给出用户id、姓名和密码，实现修改用户姓名功能")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "修改成功"),
            @ApiResponse(responseCode = "400", description = "用户ID不存在"),
            @ApiResponse(responseCode = "404", description = "特殊故障")
    })
    public ResultCode modifyUserInfo(
            @Parameter(description = "用户ID", required = true) @RequestParam("user_id") String userID,
            @Parameter(description = "姓名", required = true) @RequestParam("name") String name,
            @Parameter(description = "密码", required = true) @RequestParam("password") String password
    ){
        return cityServices.modifyUserInfo(userID, name, password);
    }

    //返回-103代表user_id不存在，返回-404代表特殊故障，返回1信息获取成功
    @GetMapping("/getUserName")
    @Operation(summary = "获取用户姓名", description = "给出用户id，获得用户姓名")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "信息获取成功"),
            @ApiResponse(responseCode = "400", description = "用户ID不存在"),
            @ApiResponse(responseCode = "404", description = "特殊故障")
    })
    public UserName getUserName(
            @Parameter(description = "用户ID", required = true) @RequestParam("user_id") String userID
    ){
        return cityServices.getUserName(userID);
    }

    //返回-1代表信息获取失败，返回1信息获取成功
    @GetMapping("/getDistInfo")
    @Operation(summary = "获取周围最近的公园、医院、工厂和学校的距离", description = "给出经纬度，获取对应的信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "信息获取成功"),
            @ApiResponse(responseCode = "400", description = "信息获取失败")
    })
    public DistInfo getDistInfo(
            @Parameter(description = "经度", required = true) @RequestParam("Lon") double Lon,
            @Parameter(description = "纬度", required = true) @RequestParam("Lat") double Lat
    ){
        return cityServices.getDistInfo(Lon, Lat);
    }

    @GetMapping("/getStreetViewInfo")
    @Operation(summary = "获取周围最近点的信息", description = "给出经纬度，获取对应的信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "信息获取成功"),
            @ApiResponse(responseCode = "400", description = "信息获取失败")
    })
    public StreetView getStreetViewInfo(
            @Parameter(description = "经度", required = true) @RequestParam("Lng") double Lng,
            @Parameter(description = "纬度", required = true) @RequestParam("Lat") double Lat
    ){
        return cityServices.getStreetViewInfo(Lng, Lat);
    }

    @GetMapping("/cityNews")
    public List<NewsItem> getNews() {
        // 构造一些 NewsItem 对象，并设置特定的时间
        List<NewsItem> newsItems = Arrays.asList(
                new NewsItem(
                        "前滩国际商务区获上海市绿色生态城区示范区称号 推动绿色发展与产业发展深度融合",
                        LocalDateTime.of(2024, Month.JUNE, 26, 19, 20, 59),
                        "https://www.jfdaily.com/sgh/detail?id=1354967"
                ),
                new NewsItem(
                        "全力打造“上海北外滩、都市新标杆”，区领导调研北外滩街道",
                        LocalDateTime.of(2024, Month.JUNE, 26, 22, 27, 23),
                        "https://www.thepaper.cn/newsDetail_forward_27781564"
                ),
                new NewsItem(
                        "产业发展和城市建设“加速度” 上海南汇“年轻的城”日新月异",
                        LocalDateTime.of(2024, Month.JUNE, 26, 22, 7, 36),
                        "https://baijiahao.baidu.com/s?id=1801845932847700684&wfr=spider&for=pc"
                )
        );

        return newsItems;
    }
    @GetMapping("/addFavorite")
    public ResultCode addFavorite(
            @RequestParam("user_id")int user_id,
            @RequestParam("Lat")double Lat,
            @RequestParam("Lon")double Lon,
            @RequestParam("note")String note
    ){
        return cityServices.addFavorite(user_id,Lat,Lon,note);
    }

    @GetMapping("/getUserFavorite")
    public UserFavorite getUserFavorite(
            @RequestParam("user_id")int user_id
    ){
        return cityServices.getUserFavorite(user_id);
    }

    @GetMapping("/deleteUserFavorite")
    public ResultCode deleteUserFavorite(
            @RequestParam("favorite_id")int favorite_id
    ){
        return cityServices.deleteUserFavorite(favorite_id);
    }


}
