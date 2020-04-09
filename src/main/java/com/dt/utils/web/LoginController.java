package com.dt.utils.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author jiangyao
 * @Date 2019/7/1 21:52
 **/
@Controller
public class LoginController {

    @RequestMapping({"","/","index","index.html","index.jsp", "index.htm"})
    public String index(){
        return "index";
    }
}
