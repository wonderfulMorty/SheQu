package com.metro.controller.api;

import com.alibaba.fastjson.JSON;
import com.metro.pojo.Survey;
import com.metro.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class SurveyApi {
   @Autowired
   SurveyService surveyService;

    /*
    微信小程序端提供json接口的。显示问卷标题数据
     */
    @ResponseBody
    @RequestMapping(value = "/getAllSurvey",produces="application/json;charset=UTF-8")
    public String getAllSurvey() {
        List<Survey> surveys = surveyService.findAllSurvey();
        String result = JSON.toJSONString(surveys);
        System.out.println(result);
        return result;
    }

}
