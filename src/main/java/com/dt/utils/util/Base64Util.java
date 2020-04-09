package com.dt.utils.util;

import java.util.Base64;

/**
 * Base64
 * @Author jiangyao
 * @Date 2019/6/27 11:08
 **/
public class Base64Util {

    public static String encode(String code){
        return Base64.getEncoder().encodeToString(code.getBytes());
    }

    public static String decode(String code){
        return new String(Base64.getDecoder().decode(code));
    }

    public static void main(String[] s) {
        System.out.println(encode("12312#$%"));
        System.out.println(decode(encode("12312#$%")));
    }
}
