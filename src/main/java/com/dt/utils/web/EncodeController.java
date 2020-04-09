//package com.dt.utils.web;
//
//import com.dt.utils.model.UtilsEncodeDecode;
//import com.dt.utils.service.EncodeService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 加密Controller
// * @Author jiangyao
// * @Date 2019/6/27 10:52
// **/
//@Controller
//@RequestMapping("encode")
//public class EncodeController {
//
//    private final static Logger logger = LoggerFactory.getLogger(EncodeController.class);
//
//    @Autowired
//    EncodeService encodeService;
//
//    @RequestMapping("t")
//    @ResponseBody
//    public UtilsEncodeDecode encode(String code){
//        return this.encodeService.encode(code);
//    }
//
//    @RequestMapping("t2")
//    @ResponseBody
//    public String encode1(HttpServletRequest request){
//        return encodeService.countEncode()+"";
//    }
//    @RequestMapping("t3")
//    @ResponseBody
//    public String encode999999999(HttpServletRequest request){
//        this.encodeService.insertEncode();
//        return "线程任务开始执行";
//    }
//}
//package com.dt.utils.web;
//
//import com.dt.utils.model.UtilsEncodeDecode;
//import com.dt.utils.service.EncodeService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 加密Controller
// * @Author jiangyao
// * @Date 2019/6/27 10:52
// **/
//@Controller
//@RequestMapping("encode")
//public class EncodeController {
//
//    private final static Logger logger = LoggerFactory.getLogger(EncodeController.class);
//
//    @Autowired
//    EncodeService encodeService;
//
//    @RequestMapping("t")
//    @ResponseBody
//    public UtilsEncodeDecode encode(String code){
//        return this.encodeService.encode(code);
//    }
//
//    @RequestMapping("t2")
//    @ResponseBody
//    public String encode1(HttpServletRequest request){
//        return encodeService.countEncode()+"";
//    }
//    @RequestMapping("t3")
//    @ResponseBody
//    public String encode999999999(HttpServletRequest request){
//        this.encodeService.insertEncode();
//        return "线程任务开始执行";
//    }
//}
