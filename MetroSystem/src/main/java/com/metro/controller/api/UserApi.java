package com.metro.controller.api;

import com.metro.service.UserService;
import com.metro.util.RandNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class UserApi {
    @Autowired
    UserService userService;

    /*
    微信小程序端提供json接口的。显示社区公告数据
     */
    @ResponseBody
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String RegisterUser(@RequestBody Map map){
        System.out.println(map.toString());
        map.put("uid", RandNum.getGUID());
        int n = userService.insertUser(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String userLogin(@RequestBody Map map){
        System.out.println(map.toString());
        String uid = userService.findUidByPNumAndPwd(map);
        if(uid!=null){
            return uid;
        }
        return "failure";
    }

}
