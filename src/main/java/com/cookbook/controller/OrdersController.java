package com.cookbook.controller;

import com.cookbook.dao.StudioDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.Studio;
import com.cookbook.util.AlipayConfig;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@Controller
@RequestMapping("order")
public class OrdersController {
   @Resource
   UserDao userDao;
   @RequestMapping("saveIncome")
   @ResponseBody
   public Integer saveIncome(String uid){
      try {
         int i = userDao.updateUserState(uid);
         System.out.println(i);
         int saveincome = userDao.saveincome(uid);
         System.out.println(saveincome);
         return 2;
      }catch (Exception e){
         e.printStackTrace();
      }
      return 0;
   }
   @Resource
    StudioDao studioDao;
   @RequestMapping("saveuserturnover")
   @ResponseBody
   public Integer saveuserturnover(String uid,String sid){
      try {
         // 添加我购买的 和 他卖出的
          Studio studio = studioDao.queryByid(sid);
          studioDao.savePay(uid,sid,studio.getMoney());
          studioDao.saveIncome(String.valueOf(studio.getUid()),sid,studio.getMoney());
          return 2;
      }catch (Exception e){
         e.printStackTrace();
      }
      return 0;
   }
   @RequestMapping("pay")
   @ResponseBody
    public void pay(String order_number,String bnbname,String order_price,String sid,String state, HttpServletRequest request, HttpServletResponse response) throws IOException{
       //获得初始化的AlipayClient
       AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key,"json",AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
      System.out.println(state+"state");
       System.out.println(sid+"sid");
       //设置请求参数
       AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
       alipayRequest.setReturnUrl(AlipayConfig.return_url+state+"&sid="+sid);
       alipayRequest.setNotifyUrl(AlipayConfig.notify_url);


       //商户订单号，商户网站订单系统中唯一订单号，必填
       String out_trade_no = order_number;
       //付款金额，必填
       String total_amount = order_price;
       //订单名称，必填
       String subject = bnbname;
       //商品描述，可空
//       String body = "sd";
//        String timeout_express = "1m";
       alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
               + "\"total_amount\":\""+ total_amount +"\","
               + "\"subject\":\""+ subject +"\","
//               + "\"body\":\""+ body +"\","
               + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

       //请求
       String form="";
       try {
           form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
       } catch (AlipayApiException e) {
           e.printStackTrace();
       }
       response.setContentType("textml;charset=" + AlipayConfig.charset);
       response.getWriter().write(form);//直接将完整的表单html输出到页面
       response.getWriter().flush();
       response.getWriter().close();
   }

}
