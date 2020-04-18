package com.shequ.controller.api;

import com.alibaba.fastjson.JSON;
import com.shequ.pojo.Choice;
import com.shequ.pojo.Question;
import com.shequ.service.ChoiceService;
import com.shequ.service.QuestionService;
import com.shequ.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QueAndOpt {

    @Autowired
    ChoiceService choiceService;
    @Autowired
    QuestionService questionService;
    @Autowired
    SurveyService surveyService;

    @RequestMapping(value = "/getQueAndOpt",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getQueAndOpt(@RequestBody Map m){
        List list = new ArrayList();
        List<Question> questions = questionService.findAllQuestion(Integer.parseInt(m.get("su_id").toString()));
        for (int i=0;i<questions.size();i++){
            int qid = questions.get(i).getId();
            List<Choice> choices = choiceService.findOptOfQue(qid);
            Map map = new HashMap();
            map.put("queandopt",choices);
            list.add(map);
        }
        String result = JSON.toJSONString(list);
        return result;
    }

    @RequestMapping(value = "/getCheckedQueAndOpt",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getCheckedQueAndOpt(@RequestBody List<Choice> choices){
        for (int i=0;i<choices.size();i++){
            Map map = new HashMap();
            Map map2 = new HashMap();
            String uid = choices.get(i).getUid();
            int qid = choices.get(i).getQid();
            int su_id = choices.get(i).getSu_id();
            int cid = choices.get(i).getCid();
            map.put("uid",uid);
            map.put("qid",qid);
            map.put("su_id",su_id);
            surveyService.insertUserSurvey(map);
            List<String> user_sur_id = surveyService.findAllSurveyByUid(uid);
            for (int j=0;j<user_sur_id.size();j++){
                map2.put("user_sur_id",user_sur_id.get(j));
                map2.put("opt_id",cid);
            }

            choiceService.insertUserSurveyOpt(map2);
        }
        System.out.println("cgoices:"+choices);
        return "success";
    }

    @RequestMapping(value = "/findUserQueAndOpt",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String findUserQueAndOpt(@RequestParam("uid") String uid){
        List list = choiceService.findUserQueAndOpt(uid);
        String result = JSON.toJSONString(list);
        System.out.println("result:"+result);
        return result;
    }
}
