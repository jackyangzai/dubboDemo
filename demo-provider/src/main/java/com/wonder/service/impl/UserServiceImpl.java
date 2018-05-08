package com.wonder.service.impl;

import com.wonder.dao.UserDao;
import com.wonder.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public HashMap<String,Object> findAllUser(String key,int pageIndex,int pageSize,String sortField,String sortOrder){
        if(key == null) key="";
        if(!StringUtils.isEmpty(sortField)){
            if("desc".equals(sortOrder)==false) sortOrder="asc";
        }else{
            sortField = "loginname";
            sortOrder = "desc";
        }
        HashMap map = new HashMap();
        map.put("key",key);
        map.put("sortField",sortField);
        map.put("sortOrder",sortOrder);
        ArrayList<Map> dataAll = userDao.findAllUser(map);
        ArrayList data = new ArrayList();
        int start = pageIndex * pageSize, end = start + pageSize;

        for (int i = 0, l = dataAll.size(); i < l; i++) {
            HashMap record = (HashMap)dataAll.get(i);
            if (record == null) continue;
            if (start <= i && i < end)
            {
                data.add(record);
            }
        }

        HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", dataAll.size());
//        System.out.println(result);
        return result;
    }

}
