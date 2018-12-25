package com.innovation.auto.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.innovation.auto.entity.User;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.service.UserService;
import com.innovation.auto.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: Innovation
 * @Date: 2018/9/15 10:07
 * @Description:
 */
@RestController
@Api(value = "user相关接口", description = "user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "user Register", notes = "注册接口")
    @PostMapping("/rgister")
    public String insertUser(@RequestParam(value = "userName") String userName,
                             @RequestParam(value = "userPassword") String userPassword){

        User user = new User();
        user.setName(userName);
        user.setPassword(userPassword);

        userService.register(user);

        return "success";
    }

    @ApiOperation(value = "user Login", notes = "用户登录接口")
    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {
        //把username和password封装为token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            return "index";
        } catch (Exception e) {
            return "login";
        }
    }


    @ApiOperation(value = "all user", notes = "查询所有用户")
    @GetMapping("/allUser")
    public APIResult allUser(){

        APIResult apiResult = new APIResult();
        apiResult.setMsg("ok");
        apiResult.setStatus(Constants.SUCCESS);

        //查询所有用户
        List<User> listUser = userService.selectAllUser();

        if (listUser != null){
            apiResult.setRes(listUser);
        }else {
            apiResult.setStatus(Constants.ERROR);
            apiResult.setMsg("空空如也");
        }
        return apiResult;
    }

    @GetMapping("/queryUserById")
    public APIResult queryUserById(@RequestParam(value = "userId", required = false) Integer userId) {
        APIResult apiResult = new APIResult();
        apiResult.setMsg("ok");
        apiResult.setStatus(Constants.SUCCESS);

        User user = userService.selectUserById(userId);

        apiResult.setRes(user);
        apiResult.setStatus(Constants.SUCCESS);
        apiResult.setMsg("query success");
        return apiResult;
    }



    @ApiOperation(value = "user pageinfo", notes = "查询用户分页")
    @GetMapping(value = "/queryall")
    public APIResult queryAll(@RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("ok");
        apiResult.setStatus(Constants.SUCCESS);

        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(list);

        if (pageInfo != null){
            apiResult.setRes(pageInfo);
        }else {
            apiResult.setStatus(Constants.ERROR);
            apiResult.setMsg("空空如也");
        }
        return  apiResult;
    }





    //退出登录
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    @ApiOperation(value = "login page", notes = "login page")
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //admin角色才能访问
    @RequestMapping("/admin")
    public String admin() {
        return "admin success";
    }

    //有delete权限才能访问
    @RequestMapping("/edit")
    public String edit() {
        return "edit success";
    }

    @RequestMapping("/test")
    @RequiresRoles("guest")
    public String test(){
        return "test success";
    }
}
