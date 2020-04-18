package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Question;
import com.shequ.pojo.Survey;
import com.shequ.service.QuestionService;
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
public class QuestionController {
   @Autowired
   QuestionService questionService;

    @ResponseBody
    @RequestMapping(value = "/findAllQuestionsByPage",produces="application/json;charset=UTF-8")
    public String findAllQuestionsByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Question> questions = questionService.findAllQuestionsByPage(start,pageSize);
        List<Question> questionsAll = questionService.findAllQuestions();
        Layui l = Layui.data(questionsAll.size(), questions);
        String result = JSON.toJSONString(l);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/findAllQuestions",produces="application/json;charset=UTF-8")
    public String findAllQuestions() {
        List<Question> questions = questionService.findAllQuestions();
        String result = JSON.toJSONString(questions);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/insertQuestion")
    public String insertQuestion(@RequestBody Map map) {
        int n = questionService.insertQuestion(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteQuestionById")
    public String deleteQuestionById(@RequestParam("id")String id) {
        int n = questionService.deleteQuestionById(Integer.parseInt(id));
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateQuestionById")
    public String updateQuestionById(@RequestBody Map map) {
        int n = questionService.updateQuestionById(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

}
