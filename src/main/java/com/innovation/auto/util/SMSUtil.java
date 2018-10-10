package com.innovation.auto.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

/**
 * @Auther: Innovation
 * @Date: 2018/9/6 13:41
 * @Description:
 */
public class SMSUtil {

    public static void sendSMS(String phoneNumber,String smsText) {
        // 短信应用SDK AppID     // 1400开头
        int appid = 1400135952;
        // 短信应用SDK AppKey
        String appkey = "a6122c20106e997fc75e56d22f65e152";
//        String smsSign = "【JNSJ】您的验证码是：1258";
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            // 签名参数未提供或者为空时，会使用默认签名发送短信
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumber,
                    smsText, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();

        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }catch (Exception e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }



//    public static int sendSMS(String phoneNumber,String smsText) {
//        // 短信应用SDK AppID     // 1400开头
//        int appid = 1400135952;
//        // 短信应用SDK AppKey
//        String appkey = "a6122c20106e997fc75e56d22f65e152";
//        try {
//            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
//            // 签名参数未提供或者为空时，会使用默认签名发送短信
//            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumber,
//                    smsText, "", "");
//            System.out.println(result);
//        } catch (HTTPException e) {
//            // HTTP响应码错误
//            e.printStackTrace();
//
//        } catch (JSONException e) {
//            // json解析错误
//            e.printStackTrace();
//        } catch (IOException e) {
//            // 网络IO错误
//            e.printStackTrace();
//        }catch (Exception e) {
//            // 网络IO错误
//            e.printStackTrace();
//        }
//
//        return 0;
//    }

}
