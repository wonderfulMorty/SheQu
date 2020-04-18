package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Sur_Que;
import com.shequ.pojo.Survey;
import com.shequ.service.Sur_QueService;
import com.shequ.service.SurveyService;
import com.shequ.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class Sur_QueController {
   @Autowired
   Sur_QueService sur_queService;

    @ResponseBody
    @RequestMapping(value = "/findAllSur_QueByPage",produces="application/json;charset=UTF-8")
    public String findAllSurveyByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Sur_Que> sur_ques = sur_queService.findAllSur_QueByPage(start,pageSize);
        List<Sur_Que> sur_queAll = sur_queService.findAllSur_Que();
        Layui l = Layui.data(sur_queAll.size(), sur_ques);
        String result = JSON.toJSONString(l);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSur_QueById")
    public String deleteSur_QueById(@RequestParam("id")String id) {
        int n = sur_queService.deleteSur_QueById(Integer.parseInt(id));
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/insertSur_Que")
    public String insertSur_Que(@RequestBody Map map) {
        int n = sur_queService.insertSur_Que(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSur_QueById")
    public String updateSur_QueById(@RequestBody Map map) {
        Map dataMap = new HashMap();
        /*dataMap.put("id",Integer.parseInt(map.get("id").toString()));
        dataMap.put("su_id",Integer.parseInt(map.get("su_id").toString()));
        dataMap.put("qid",Integer.parseInt(map.get("qid").toString()));*/
        int n = sur_queService.updateSur_QueById(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

}
