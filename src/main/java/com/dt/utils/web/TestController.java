package com.dt.utils.web;

import com.dt.utils.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangyao
 * @Date 2019/6/27 13:35
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("r1")
    @ResponseBody
    public String testString (String key,String value){
        Boolean f = redisUtil.tryLock(key,value);
        if(!f){
            LOGGER.info("数据{}被上锁",key);
            return redisUtil.get(key).toString();
        }
        if (redisUtil.set(key,value+"_"+key)){
            return "成功";
        }else {
            return "失败";
        }
    }

    @RequestMapping("r2")
    @ResponseBody
    public String testString1 (String key,String value){
        if(redisUtil.tryLock(key,value)){
            LOGGER.info("数据{}被上锁",key);
            return redisUtil.get(key).toString();
        }
        if (redisUtil.set(key,value+"_"+key)){
            return "成功";
        }else {
            return "失败";
        }
    }

    @RequestMapping("r3")
    @ResponseBody
    public String testString3 (String key,String value){
        if (redisUtil.set(key,value+"_"+key)){
            return redisUtil.get(key).toString();
        }else {
            return "失败";
        }
    }

}
