package com.dt.utils.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dt.utils.mapper.UtilsRobotChatLogMapper;
import com.dt.utils.model.UtilsRobotChatLog;
import com.dt.utils.service.RobotChatService;
import com.dt.utils.util.DateUtils;
import com.dt.utils.util.httpevents.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author jiangyao
 * @Date 2019/6/28 11:48
 **/
@Service
public class RobotChatServiceImpl implements RobotChatService {

    @Autowired
    UtilsRobotChatLogMapper robotChatLogMapper;
    @Override
    public Map<String, Object> chat(String content) {
        UtilsRobotChatLog ll = new UtilsRobotChatLog();
        ll.setSendTime(new Date());
        Map<String,Object> respMap = new HashMap<>();
        String rMst = HttpClientUtil.sendGet("http://api.qingyunke.com/api.php?key=free&appid=0&msg="+content);
        JSONObject resultJson = JSON.parseObject(rMst);
        String code =  resultJson.getString("result");
        if ("0".equals(code)){
            respMap.put("msg",resultJson.getString("content"));
        }else {
            respMap.put("msg","我不知道如何回答你的问题了！");
        }
        ll.setReceiveTime(new Date());
        respMap.put("time", DateUtils.date2String(new Date(), "yyyy-MM-dd HH:mm:ss"));
        ll.setChannelName("青云客");
        ll.setReceiveMessage((String)respMap.get("msg"));
        ll.setSendMessang(content);
        robotChatLogMapper.insertSelective(ll);
        return respMap;
    }
}
