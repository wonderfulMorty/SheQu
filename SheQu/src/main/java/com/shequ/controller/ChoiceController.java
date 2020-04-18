package com.shequ.controller;

import com.alibaba.fastjson.JSON;
import com.shequ.mapper.ChoiceMapper;
import com.shequ.pojo.Choice;
import com.shequ.pojo.Pay;
import com.shequ.pojo.Sur_Que;
import com.shequ.service.ChoiceService;
import com.shequ.service.Sur_QueService;
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
public class ChoiceController {
   @Autowired
   ChoiceService choiceService;

    @ResponseBody
    @RequestMapping(value = "/findAllChoiceByPage",produces="application/json;charset=UTF-8")
    public String findAllChoiceByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Choice> choices = choiceService.findAllChoiceByPage(start,pageSize);
        List<Choice> choicesAll = choiceService.findAllChoice();
        Layui l = Layui.data(choicesAll.size(), choices);
        String result = JSON.toJSONString(l);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteChoiceById")
    public String deleteChoiceById(@RequestParam("id")String id) {
        int n = choiceService.deleteChoiceById(Integer.parseInt(id));
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/insertChoice")
    public String insertChoice(@RequestBody Map map) {
        int n = choiceService.insertChoice(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/updateChoiceById")
    public String updateChoiceById(@RequestBody Map map) {
        int n = choiceService.updateChoiceById(map);
        if(n>0){
            return "success";
        }
        return "failure";
    }

    @ResponseBody
    @RequestMapping(value = "/findAllUserSurQueAndOptByPage",produces="application/json;charset=UTF-8")
    public String findAllUserSurQueAndOptByPage(@RequestParam("limit") String limit, @RequestParam("page") String page) {
        int start = (Integer.parseInt(page) - 1)*Integer.parseInt(limit);
        int pageSize = Integer.parseInt(limit);
        List<Choice> choices = choiceService.findAllUserSurQueAndOptByPage(start,pageSize);
        List<Choice> choiceAll = choiceService.findAllChoice();
        Layui l = Layui.data(choiceAll.size(), choices);
        String result = JSON.toJSONString(l);
        return result;
    }

}
