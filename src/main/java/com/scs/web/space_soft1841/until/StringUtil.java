package com.scs.web.space_soft1841.until;

import java.util.Random;

/**
 * @Author: 位哲武
 * @Date: 2019/12/3 15:50
 * @Description:
 */
public class StringUtil {
    public static String getVerifyCode(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(10)));
        }
        return stringBuilder.toString();
    }
}
