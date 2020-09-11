package com.cookbook.controller;

import com.cookbook.entity.MaterialsDetail;
import com.cookbook.service.MaterialsDetailService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("MaterialsDetailController")
public class MaterialsDetailController {
    @Resource
    MaterialsDetailService materialsDetailService;
    @RequestMapping("queryBymid")
    public List<MaterialsDetail> queryBymid(Integer mid) throws Exception {
        return materialsDetailService.queryBymid(mid);
    }
}
