package com.cookbook.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("file")
public class FileUpload {
    // 获取配置文件中的属性值
    @Value("${pic.picturePath}") //图片
    String picturePath;
    @Value("${pic.savePath}")
    String savePath;
    @RequestMapping("uploads")
    public String upload(@RequestParam("file") MultipartFile[] video) throws IOException {
        System.out.println(video.length);
        for (MultipartFile s:video) {
            // 原文件名
            String originalFilename = s.getOriginalFilename();
            // 判断是否有文件
            if(null != originalFilename && !"".equals(originalFilename)){
                /*// 保存文件的路径
                File newFile = new File(filepath);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }*/
                //获取文件后缀
                //获取文件后缀
                String fileExt = s.getOriginalFilename().substring(s.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                //保存视频
                File fileSave = new File(savePath, newVidoeName);
                s.transferTo(fileSave);
            }
        }
        return "ok";
    }
    @RequestMapping("/download")
    public ServletOutputStream download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取下载的文件路径
        File downloadfile = new File(savePath + "/"+fileName);
        // 文件输入流:读文件
        FileInputStream fileInputStream = new FileInputStream(downloadfile);
        // 获取请求的文件类型
        String mimeType = request.getSession().getServletContext().getMimeType(fileName.substring(fileName.lastIndexOf(".")));
        System.out.println(mimeType);
        // 设置响应类型
        response.setContentType(mimeType);
        // 响应头：确定了浏览器打开的方式
        // 默认下载时文件名是download
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        // 输出流
        ServletOutputStream outputStream = response.getOutputStream();
        FileCopyUtils.copy(fileInputStream,outputStream);
        return outputStream;
    }
    @RequestMapping("uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile[] image) throws IOException {

            String originalFilename = image[image.length-1].getOriginalFilename();
            // 判断是否有文件
            if(null != originalFilename && !"".equals(originalFilename)){
                /*// 保存文件的路径
                File newFile = new File(filepath);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }*/
                //获取文件后缀
                //获取文件后缀
                String fileExt = image[image.length-1].getOriginalFilename().substring(image[image.length-1].getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                //保存视频
                File fileSave = new File(savePath, newVidoeName);
                image[image.length-1].transferTo(fileSave);
            }
        return "ok";
    }
}
