package com.innovation.auto.controller;

import com.innovation.auto.util.SMSUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Auther: Innovation
 * @Date: 2018/9/3 13:39
 * @Vison: 1.0
 * @Description:
 */
@RestController
public class HelloController {


    @GetMapping("/auto")
    public String hello(){
        return "hello Spring Boot...";
    }

}
