package com.dt.utils.util;

import java.security.MessageDigest;

/**
 * @Author jiangyao
 * @Date 2019/6/27 11:29
 **/
public class Sha1Util {

    private static String tab = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz0123456789+/";
//
//    /**
//     * sha1加密
//     * @param origin
//     * @param charsetname
//     * @return
//     */
//    public static String encode(String origin, String charsetname) {
//        try {
//            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
//            if ((charsetname == null) || ("".equals(charsetname))) {
//                return bytesToHexString(sha1.digest(origin.getBytes()));
//            } else {
//                return bytesToHexString(sha1.digest(origin.getBytes(charsetname)));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static String bytesToHexString(byte[] b) {
//        StringBuffer resultSb = new StringBuffer();
//        for (int i = 0; i < b.length; i++) {
//            int n = b[i];
//            if (n < 0) {
//                n += 256;
//            }
//            int d1 = n / 16;
//            int d2 = n % 16;
//            resultSb.append(hexDigit[d1] + hexDigits[d2]);
//        }
//        return resultSb.toString();
//    }
}
