package com.cookbook.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class Sms_util {
    public static String SendCode(String phone, int mobile_code) {
        String host = "https://smsapi.api51.cn";
        String path = "/risk_code";
        String method = "GET";
        String appcode = "8a1bf2dde07843abb2dec67502da6c40";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("code", String.valueOf(mobile_code));
        querys.put("mobile", phone);
        String s =null;
        try {
            HttpResponse httpResponse= HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            s = EntityUtils.toString(httpResponse.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}
