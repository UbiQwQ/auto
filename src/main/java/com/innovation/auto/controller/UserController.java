package com.innovation.auto.controller;

import com.innovation.auto.entity.User;
import com.innovation.auto.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    UserService userService;

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
}
