// -*- coding: utf-8 -*- 
/**
 * Project: Regexp
 * Creator: yanking
 * Create time: 2021-11-21 15:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.yanking.Regexp_;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class classStrain02 {

    @Test
    public void regexp_train() {
        String content = "超人打怪兽";
//        String content = "超";
        // 1 判断输入字符是否为汉字
        String regstr = "^[\0391-\uffe5]+$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("匹配失败！");
        }


    }

    //验证邮政编码
    @Test
    public void regexp_postcode() {
        String content = "123128";
//        String content = "超";
        // 1 判断输入字符是否为汉字
        String regstr = "^[1-9]\\d{5}$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("匹配失败！");
        }


    }

    //验证QQ号码
    @Test
    public void regexp_QQcode() {
        String content = "3147054652";
        String regstr = "^[1-9]\\d{4,9}$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("匹配失败！");
        }


    }

    //验证手机号码
    @Test
    public void regexp_PhoneNum() {
        String content = "13692931021";
//        String regstr = "^13|14|15|18\\d{10}$";
//        String regstr = "^1[3|4|5|8]\\d{9}$";
        String regstr = "^(13|14|15|18)\\d{9}$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("匹配失败！");
        }


    }

    //验证URL
    @Test
    public void regexp_URL() {
        String content = "https://www.bing.com/search?form=MOZLBR&pc=MOZI&q=b%E7%AB%99";
//        String content = "http://www.bing.com.cn";
        String regstr = "^(https://|http://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-=|&@?.%!#]*)?$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("匹配失败！");
        }

        //全匹配方法
        System.out.println(Pattern.matches(regstr, content));


    }

    //验证商品号
    @Test
    public void regexp_ShopNum() {
        String content = "12345-333999888";
//        String regstr = "^\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}$";
        String regstr = "^\\d{5}-((\\d)\\2{2}){3}$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("匹配失败！");
        }

        //全匹配方法
        System.out.println(Pattern.matches(regstr, content));


    }


    //结巴去重
    @Test
    public void regexp_simple() {
        String content = "我....我要....学学学学....编程Java！";
        String regstr = "[\0391-\uffe5]+";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        content = "";
        while (matcher.find()) {
            content += matcher.group(0);
        }
        regstr = "(.)\\1+";
        pattern = Pattern.compile(regstr);
        matcher = pattern.matcher(content);
        while (matcher.find()) {
            content = matcher.replaceAll("$1");
//            System.out.println(matcher.group(0));
        }
        System.out.println(content);

    }
}
