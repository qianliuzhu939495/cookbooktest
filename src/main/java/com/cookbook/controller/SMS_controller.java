package com.cookbook.controller;

import com.cookbook.util.sms_util;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SMS_controller {
    @RequestMapping("SMS")
    public String SMS(String tel){
        int mobile_code = (int)((Math.random()*9+1)*100000);
        String rs = sms_util.SendCode(tel, mobile_code);
        System.out.println(rs);
        return rs;
    }
}
