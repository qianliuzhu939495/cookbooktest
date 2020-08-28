package com.cookbook.service.backstage;

import com.cookbook.entity.Functions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class backmenuService {
    @Resource
    com.cookbook.dao.backstageDao.backmenuDao backmenuDao;
    public List<Functions> queryFunction(){
        return backmenuDao.queryFunction();
    }
    public int updateFunctions(String Fname,Integer Fid){
        return backmenuDao.updateFunctions(Fname,Fid);
    }
    public List<Map<String,Object>> queryCustomer(){
        return backmenuDao.queryCustomer();
    }
    public int updateCustomer(Integer state,Integer cid){
        return  backmenuDao.updateCustomer(state, cid);
    }
    public int updateCustomerPwd(String Pwd,Integer cid){
        return  backmenuDao.updateCustomerPwd(Pwd, cid);
    }
    public Integer insertCusotmer(String cname,String Lognum,String Pwd,Integer state,Integer Rid){
        int l = backmenuDao.insertCustomer(cname, Lognum, Pwd, state);
        int cid = backmenuDao.cid();
        int i = backmenuDao.insertCustomer_role(cid, Rid);
        return l+i;
    }
}
