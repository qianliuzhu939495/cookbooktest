package com.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import weibo4j.Oauth;
import weibo4j.http.ImageItem;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

@CrossOrigin
@Controller
@RequestMapping("Weibo")
public class Weibo {
    String Access_Token;
    @RequestMapping(value = "callback")
    @ResponseBody
    public String callback(String code) {
        Access_Token=code;
        System.out.println("得到的code为：" + code);
        return "success";
    }
    @RequestMapping("test")
    public String get() throws Exception {
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
    public String getToken(){
        return "";
    }
    @RequestMapping("sends")
    @ResponseBody
    public String sends() throws Exception {
        Timeline tl = new Timeline(Access_Token);
        tl.updateStatus("打开全能吃货一起淦起来！http://localhost:8081/#/");
        File image = new File("E:\\school\\vue\\school\\vue03\\static\\jpg\\logo2.jpg");
        FileInputStream in = new FileInputStream(image);
        byte[] ba = new byte[in.available()];
        in.read(ba);
        ImageItem it = new ImageItem(ba);
        //防止发送图片时中文乱码
        String content = URLEncoder.encode("打开全民吃货一起吃起来！http://localhost:8081/#/");
        tl.uploadStatus(content, it);
        in.close();
        return "ok";
    }
}
