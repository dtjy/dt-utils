package com.dt.utils.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author jiangyao
 * @Date 2019/12/27 11:16
 **/
public class LoginDemo {

    public static Map<String,String> userMap = new HashMap<>();
    public static final File logFile = new File("E:\\log.txt");
    //登陆失败统计
    public static Map<String,Integer> errorLoginCount = new HashMap<>();
    //登陆成功统计

    public static Map<String,Integer> loginCount = new HashMap<>();
    static {
        //默认帐号
        userMap.put("admin","123456");
        userMap.put("abc","abc");
    }
    public static void main(String[] s){
        //启动
        start();
        while(true){

        }
//        System.out.println(errorLoginCount.get("11"));
    }

    //启动界面
    public static void start(){
        System.out.println("**********创建用户输入1，登陆输入2*************");
        Scanner input=new Scanner(System.in);
        String str= input.nextLine();
        if ("1".equals(str)) {
            //todo
        }else if ("2".equals(str)){
            login();
        }else {
            System.out.println("输入有误，请重新输入");
            start();
        }
    }

    //登陆操作
    public static void login(){
        System.out.println("请输入帐号：");
        Scanner inputUserCode=new Scanner(System.in);
        String userCode= inputUserCode.nextLine();
        System.out.println("请输入密码：");
        Scanner inputPassword=new Scanner(System.in);
        String password= inputPassword.nextLine();
        String mapPasword = userMap.get(userCode);
        if(null == mapPasword){
            System.out.println("帐号或密码错误，请重新输入。");
            logOperate(userCode,0);
            login();
        }else {
            if (mapPasword.equals(password)){
                System.out.println("登陆成功！");
                logOperate(userCode,1);
            }else {
                System.out.println("帐号或密码错误，请重新输入。");
                logOperate(userCode,0);
                login();
            }
        }
    }

    public static void logOperate(String userCode,int type){
        if (type==0){
            loginCount(userCode,0);
            writeLog(userCode+"登陆失败，失败次数："+errorLoginCount.get(userCode)+"，"+time());
        } else {
            loginCount(userCode,1);
            writeLog(userCode+"登陆成功，"+time());
        }
    }

    //日志记录操作 type 0失败 1成功
    public static void writeLog(String log){
        FileWriter fw = null;
        try {
            fw = new FileWriter(logFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(log);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //统计操作 type 0失败 1成功
    public static void loginCount(String userCode,int type){
        if (type==0){
            if (errorLoginCount.get(userCode)==null){
                errorLoginCount.put(userCode,1);
            }else {
                errorLoginCount.put(userCode,errorLoginCount.get(userCode)+1);
            }
        }
        if (type==1){
            if (loginCount.get(userCode)==null){
                loginCount.put(userCode,1);
            }else {
                loginCount.put(userCode,loginCount.get(userCode)+1);
            }
        }
    }

    //时间
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String time() {
        return simpleDateFormat.format(new Date());
    }
}
