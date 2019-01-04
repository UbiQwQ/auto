package com.innovation.auto.module.login.controller;

import com.innovation.auto.entity.User;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.register.service.UserService;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * @Auther: carver
 * @Date: 2019/1/4 10:48
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class Login {

    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    public APIResult login(@RequestParam(value = "userPassword",required = true) String userPassword,
                           @RequestParam(value = "email",required = true) String email,
                           HttpSession session) throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("login successfully...");
        apiResult.setStatus(Constants.SUCCESS);


        User user = userService.selectUserByEmail(email);
        if (null != user){
            if (user.getPassword().equals(userPassword)) {
                session.setAttribute("user",user);
                apiResult.setRes(user);
                return apiResult;
            }else {
                apiResult.setMsg("密码错误login failed...");
                apiResult.setStatus(Constants.ERROR);
                return apiResult;
            }
        }else {
            apiResult.setMsg("用户名不存在login failed...");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }

    }
}
