package com.scs.web.space_soft1841.controller;

import java.security.MessageDigest;

/**
 * @Author: 位哲武
 * @Date: 2019/12/3 12:06
 * @Description:
 */
public class Md5 {
    /**
     * MD5密文的实现，判断密码是否正确
     * @param s
     * @return
     */
    public static String MD5(String s) {
        char[] hexDigits ={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
                chars[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(chars);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
