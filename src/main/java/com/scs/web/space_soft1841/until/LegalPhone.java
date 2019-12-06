package com.scs.web.space_soft1841.until;

import io.swagger.models.auth.In;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName LegalPhone
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/6
 **/
public class  LegalPhone {
    public static boolean isMobiPhoneNum(String telNum){
        String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(telNum);
        return m.matches();
    }

    public static void main(String[] args) {
        String  string = "18932386185";
        System.out.println(isMobiPhoneNum(string));

    }
}