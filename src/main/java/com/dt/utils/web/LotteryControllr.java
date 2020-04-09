package com.dt.utils.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author jiangyao
 * @Date 2019/10/25 23:55
 **/
@Controller
@RequestMapping("lottery")
public class LotteryControllr {

    @RequestMapping("/down")
    public void downAllHistoryData(){

    }
}
