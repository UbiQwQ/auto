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



    public static void main(String args[]) {
        byte i = 127;
        i  = (byte) (i + 2);

        int a = 127;
        a = a + 2;
        try{
            double x = 64.0;
            double y = 0.0;
            System.out.println(x/y);

        }catch (Exception e){
            System.out.println("666");
        }

        double b = (short)10/10.2*2;
    }

    @GetMapping("/auto")
    public String hello(){
        return "hello Spring Boot...";
    }



}
