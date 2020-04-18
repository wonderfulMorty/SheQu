package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Message;
import com.shequ.pojo.Survey;
import com.shequ.service.SurveyService;
import com.shequ.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class SurveyController {
   @Autowired
   SurveyService surveyService;

    @ResponseBody
    @RequestMapping(value = "/findAllSurveyByPage",produces="application/json;charset=UTF-8")
    public String findAllSurveyByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Survey> surveys = surveyService.findAllSurveyByPage(start,pageSize);
        List<Survey> surveyAll = surveyService.findAllSurvey();
        Layui l = Layui.data(surveyAll.size(), surveys);
        String result = JSON.toJSONString(l);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/findAllSurvey",produces="application/json;charset=UTF-8")
    public String findAllSurvey() {
        List<Survey> surveys = surveyService.findAllSurvey();
        String result = JSON.toJSONString(surveys);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/insertSurvey")
    public String insertSurvey(@RequestBody Map map) {
        int n = surveyService.insertSurvey(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteSurveyById")
    public String deleteSurveyById(@RequestParam("id")String id) {
        int n = surveyService.deleteSurveyById(Integer.parseInt(id));
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateSurveyById")
    public String updateSurveyById(@RequestBody Map map) {
        int n = surveyService.updateSurveyById(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

}
