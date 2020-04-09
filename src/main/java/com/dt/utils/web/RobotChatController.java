package com.dt.utils.web;

import com.dt.utils.service.RobotChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author jiangyao
 * @Date 2019/6/28 11:38
 **/
@Controller
@CrossOrigin
@RequestMapping("robotChat")
public class RobotChatController {

    @Autowired
    RobotChatService robotChatService;

    @RequestMapping("/chat")
    public String chat(String content){
        return "robotChat/chat";
    }

    @RequestMapping("/send")
    @ResponseBody
    public Map<String,Object> sendChat(String content){
        Map<String,Object> map = robotChatService.chat(content);
        return map;
    }
}
