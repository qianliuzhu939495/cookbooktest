package com.cookbook.controller.backstage;

import com.cookbook.service.backstage.BackOrderDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("BackOrderDetailController")
public class BackOrderDetailController {
    @Resource
    BackOrderDetailService backOrderDetailService;
    @RequestMapping("backOrderDetailQuery")
    public List<Map<String,Object>> backOrderDetailQuery(){
        return backOrderDetailService.BackOrderDetailQuery();
    }
}
