package com.innovation.auto.util;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: Innovation
 * @Date: 2018/9/6 15:08
 * @Description:
 */
public class Send {
    public static void main(String[] args){

        StringBuilder code = new StringBuilder();
        Random random = new Random();
        // 生成6位验证码
        for (int i = 0; i < 6; i++) {
            code.append(String.valueOf(random.nextInt(10)));
        }
//        HttpSession session = request.getSession();
//        session.setAttribute("smsPhone", phone);
//        session.setAttribute("smscode", code.toString());
//        session.setAttribute("smsSendTime", new Date().getTime());
        String smsText = "您的登录验证码为" + code + "，请于3分钟内填写。如非本人操作，请忽略本短信。";
        SMSUtil.sendSMS("15206349417",smsText);


        System.out.println("success");

        long timestamp = new Date().getTime();
    }
}
