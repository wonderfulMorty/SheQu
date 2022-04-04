package com.metro.controller.api;

import com.metro.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VoteApi {
    @Autowired
    VoteService voteService;

    @ResponseBody
    @RequestMapping(value = "/insertVote", method = RequestMethod.POST)
    public String insertVote(@RequestBody Map map){
        System.out.println("insertVote:"+map.toString());
        Map dataMap = new HashMap();
        dataMap.put("uid",map.get("uid"));
        dataMap.put("title",map.get("title"));
        dataMap.put("text",map.get("text"));
        dataMap.put("optionCount",map.get("optionCount"));
        List list = (List) map.get("options");
        for (int i=0;i<list.size();i++){
            HashMap m = (HashMap) list.get(i);
            dataMap.put("opt"+i,m.get("value"));
        }
        int n = voteService.insertVote(dataMap);
        if(n>0){
            return "success";
        }
        return "failure";
    }
}
