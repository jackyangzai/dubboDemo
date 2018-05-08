package com.wonder.controller;

import com.wonder.service.UserService;
import flexjson.JSONSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/userList.do")
    public String toUserList(){
//        List<Map> list =  userService.findAllUser();
//        for(Map map : list){
//            System.out.println(map);
//        }
        return "userList";
    }
    @ResponseBody
    @RequestMapping(value = "/getUserData.do",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
    public String findAllUser(HttpServletRequest request, HttpServletResponse response){

        //查询条件
        String key = request.getParameter("key");
        //分页查询条件
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //排序
        String sortField = request.getParameter("sortField");
        String sortOrder = request.getParameter("sortOrder");
        HashMap map = userService.findAllUser(key,pageIndex,pageSize,sortField,sortOrder);
        JSONSerializer serializer = new JSONSerializer();
        String json = serializer.deepSerialize(map);
//        System.out.println(json);
        return json;
    }
}
