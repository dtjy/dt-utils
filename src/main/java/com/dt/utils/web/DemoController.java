/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.dt.utils.web;

import com.alibaba.fastjson.JSON;
import com.dt.utils.model.User;
import com.dt.utils.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/data")
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/json")
    @ResponseBody
    public JSONObject demo1(){
        User user = new User("rt","qw");
        User user1 = new User("ra","sqw");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        return JSONUtil.toJSONObject(list);

    }

    @RequestMapping("/json2")
    @ResponseBody
    public JSONArray demo3(){
        User user = new User("rt","qw");
        User user1 = new User("ra","sqw");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        return JSONUtil.toJSONArray(list);

    }
    @RequestMapping("/json1")
    @ResponseBody
    public Object demo2(){
//        Map<String,Object> map = new HashMap<>();
        User user = new User("rt","qw");
        User user1 = new User("ra","sqw");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        return JSON.toJSON(list);

    }
//    @RequestMapping("/demo")
//    @ResponseBody
//    public String demo(String name) {
//        return Strings.isNullOrEmpty(name) ? "demo" : name;
//    }
//
//    @RequestMapping("/person")
//    @ResponseBody
//    public Person getPersonInfo() {
//        return new Person("skyarthur", 30);
//    }
//
//    @RequestMapping("/model")
//    public ModelAndView getModel() {
//        logger.info("/model request");
//        Person person = new Person("skyarthur", 30);
//        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
//        modelAndView.addObject(person);
//        return modelAndView;
//    }
//
//    @RequestMapping("/json")
//    public ModelAndView getJsonView() {
//        logger.info("/json");
//        Person person = new Person("skyarthur", 30);
//        ModelAndView modelAndView = new ModelAndView("jsonView");
//        modelAndView.addObject(person);
//        return modelAndView;
//    }
//
//    public static void main(String[] s){
//        Person person = new Person("skyarthur", 30);
//
//        System.out.println(person.getName());
//    }

    public static void main(String[] s){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("12");
        list.add("ds");
        list.add(",0.");

        if (list.contains("3")) {
            System.out.println("1");
        } else {
            System.out.println("3");
        }
    }
}
