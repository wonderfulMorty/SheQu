package com.shequ.controller.api;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Pay;
import com.shequ.service.PayService;
import com.shequ.service.RepairService;
import com.shequ.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PayApi {
    @Autowired
    PayService payService;


    @ResponseBody
    @RequestMapping(value = "/insertPayment", method = RequestMethod.POST)
    public String insertPayment(@RequestBody Map map){
        System.out.println("insertPayment:"+map.toString());
        map.put("paytime",new Date());
        int n = payService.insertPayment(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/findPayByUid", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String findPayByUid(@RequestParam("uid") String uid){
        List<Pay> pays = payService.findPayByUid(uid);
        String result = JSON.toJSONString(pays);
        System.out.println(result);
        return result;
    }

}
