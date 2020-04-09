package com.dt.utils.web;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * @Author jiangyao
 * @Date 2019/6/27 13:35
 **/
@Controller
@CrossOrigin
@RequestMapping("test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/t3")
    @ResponseBody
    public String test3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    int i=1;
                    int j=i+1;
                    LOGGER.info(i+"");
                }
            }
        }).start();

        return "t3";
    }
    @RequestMapping(value = "sse",produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String push() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return Math.random()+"\n\n";
    }
    @RequestMapping("")
    public String test1(){
        return "test/test";
    }
    @RequestMapping("/")
    public String test2(){
        return "test/test";
    }


    @Autowired
    StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init(){
        stringRedis=redisTemplate.opsForValue();
    }


    @RequestMapping("/r1")
    @ResponseBody
    public String testString (){
        stringRedis.set("name", "丁洁");
        System.out.println(stringRedis.get("name"));
        return stringRedis.get("name");
    }

}
