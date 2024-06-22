package com.example.citypro.controller;
import com.example.citypro.entites.DistInfo;
import com.example.citypro.entites.ResultCode;
import com.example.citypro.entites.UserName;
import com.example.citypro.entites.StreetView;
import com.example.citypro.services.CityServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}
