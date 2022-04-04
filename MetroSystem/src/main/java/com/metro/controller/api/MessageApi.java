package com.metro.controller.api;

import com.alibaba.fastjson.JSON;
import com.metro.pojo.Message;
import com.metro.service.MessageService;
import com.metro.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MessageApi {
    @Autowired
    MessageService messageService;
    @Autowired
    RepairService repairService;

    /*
    微信小程序端提供json接口的。显示社区公告数据
     */
    @ResponseBody
    @RequestMapping(value = "/getAllMessage",produces="application/json;charset=UTF-8")
    public String findAllMessage(){
        List<Message> messages = messageService.findAllMessage();
        String result = JSON.toJSONString(messages);
        return result;
    }

}
