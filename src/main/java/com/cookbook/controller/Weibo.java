package com.cookbook.controller;

import org.springframework.stereotype.Controller;
import weibo4j.examples.oauth2.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import weibo4j.Oauth;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@CrossOrigin
@Controller
@RequestMapping("Weibo")
public class Weibo {
    @RequestMapping(value = "callback")
    public String callback(String code) {
        System.out.println("得到的code为：" + code);
        return "success";
    }
    @RequestMapping("test")
    public String get() throws Exception {
        System.out.println(1);
        Oauth oauth = new Oauth();
        BareBonesBrowserLaunch.openURL(oauth.authorize("code"));
        System.out.println(oauth.authorize("code"));
        System.out.print("Hit enter when it's done.[Enter]:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        Log.logInfo("code: " + code);
        try{
            System.out.println(oauth.getAccessTokenByCode(code));
        } catch (WeiboException e) {
            if(401 == e.getStatusCode()){
                Log.logInfo("Unable to get the access token.");
            }else{
                e.printStackTrace();
            }
        }
        return "redirect:callback";
    }
}
