package com.dt.utils.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author jiangyao
 * @Date 2019/6/27 11:25
 **/
public class Md5Util {

    public static String encode(String text){
        return DigestUtils.md5Hex(text);
    }
}
