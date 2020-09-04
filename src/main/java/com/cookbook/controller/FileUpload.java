package com.cookbook.controller;


import com.alibaba.fastjson.JSON;
import com.cookbook.dao.MaterialsDetailDao;
import com.cookbook.dao.MenuStepsDao;
import com.cookbook.dao.StudioDao;
import com.cookbook.dao.UserDao;
import com.cookbook.entity.*;
import com.cookbook.service.MenuService;
import com.cookbook.service.StudioService;
import com.show.api.ShowApiRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
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
    @Resource
    MenuService menuService;
    @Resource
    MenuStepsDao menuStepsDao;
    @Resource
    MaterialsDetailDao materialsDetailDao;
    @Resource
    UserDao userDao;
    @Resource
    StudioDao studioDao;
    @Resource
    StudioService studioService;
    String sqlPic="";
    List sts = new ArrayList<String>();
    @RequestMapping("upStudios")
    public String upStudios(@RequestParam("newStudio") String newStudio,@RequestParam("studioDetail") String studioDetail){
        System.out.println(newStudio);
        System.out.println(studioDetail);
        System.out.println(sqlPic);
        System.out.println(sts);
        try {
            Studio studio = JSON.parseObject(newStudio,Studio.class); //菜谱
            List<StudioDetails> studioDetails= JSON.parseArray(studioDetail,StudioDetails.class);//步骤
            studio.setStupic(sqlPic);
            Studio stu = studioService.saveStudio(studio);
            for(Integer s=0;s<studioDetails.size();s++){
                studioDetails.get(s).setSurl((String) sts.get(s));
                studioDetails.get(s).setSid(stu.getSid());
                studioDao.saveStudioDetail(studioDetails.get(s));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "ok";
    }
    @RequestMapping("uploads")
    public String upload(@RequestParam("file1") MultipartFile[] studiopic) throws IOException {
        sqlPic="";
        MultipartFile s=studiopic[0];
        // 原文件名
        String originalFilename = s.getOriginalFilename();
        // 判断是否有文件
        if(null != originalFilename && !"".equals(originalFilename)){
            String fileExt = s.getOriginalFilename().substring(s.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            sqlPic=newVidoeName;
            File fileSave = new File(savePath, newVidoeName);
            s.transferTo(fileSave);
        }
        return "ok";
    }
    @RequestMapping("studiosVideo")
    public String studiosVideo(@RequestParam("file2") MultipartFile[] video) throws IOException {
        sts = new ArrayList<String>();
        System.out.println(video.length);
        for (MultipartFile s:video) {
            // 原文件名
            String originalFilename = s.getOriginalFilename();
            // 判断是否有文件
            if(null != originalFilename && !"".equals(originalFilename)){
                String fileExt = s.getOriginalFilename().substring(s.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                sts.add(newVidoeName);
                File fileSave = new File(savePath, newVidoeName);
                s.transferTo(fileSave);
            }
        }
        return "ok";
    }
    @RequestMapping("/download") //下载
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
    @RequestMapping("/upMenus")
    public String saveMenus(@RequestParam(value = "menu") String menu,@RequestParam(value = "menuStep") String menuStep,@RequestParam(value = "detail") String detail){
        Menu menus = JSON.parseObject(menu,Menu.class); //菜谱
        List<MenuStep> menuSteps= JSON.parseArray(menuStep,MenuStep.class);//步骤

        List<MaterialsDetail> materialsDetails = JSON.parseArray(detail,MaterialsDetail.class);//用料
        menus.setPic(sqlPic);
        Menu savemenu = menuService.savemenu(menus);
        for(Integer s=0;s<menuSteps.size();s++){
            menuSteps.get(s).setmspic((String) sts.get(s));
            menuSteps.get(s).setMid(savemenu.getMid());
            menuSteps.get(s).setMsnum(s+1);
            menuStepsDao.savemenustep(menuSteps.get(s));
        }
        for(Integer m=0;m<materialsDetails.size();m++){
            materialsDetails.get(m).setMid(savemenu.getMid());
            materialsDetailDao.savedetail(materialsDetails.get(m));
        }
        System.out.println(menuSteps);
        return "";
    }
    @RequestMapping("uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("file2") MultipartFile[] image ) throws IOException {
        sts = new ArrayList<String>();
        for(MultipartFile file:image){
            String originalFilename = file.getOriginalFilename();
            // 判断是否有文件
            if(null != originalFilename && !"".equals(originalFilename)){
                //获取文件后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                sts.add(newVidoeName);
                //保存视频
                File fileSave = new File(picturePath, newVidoeName);
                file.transferTo(fileSave);
            }
        }
        System.out.println("sts"+sts);
        return "ok";
    }
    @RequestMapping("uploadpic")
    @ResponseBody
    public String uploadpic(@RequestParam("file1") MultipartFile file1) throws IOException {
        sqlPic="";
        String pics = file1.getOriginalFilename();
        if(null != pics && !"".equals(pics)){
            String fileExt = file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newpic = pikId + "." + fileExt;
            sqlPic=newpic;
            File fileSave = new File(picturePath, newpic);
            file1.transferTo(fileSave);
        }
        System.out.println("pic"+sqlPic);
        return sqlPic;
    }
    @RequestMapping("uploaduserPicsql")
    @ResponseBody
    public String uploaduserPicsql(@RequestParam("uid") String uid) throws IOException {
        userDao.updateUserpic(sqlPic,uid);
        return sqlPic;
    }
}
