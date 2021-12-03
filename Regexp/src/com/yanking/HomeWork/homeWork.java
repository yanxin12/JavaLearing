// -*- coding: utf-8 -*- 
/**
 * Project: Regexp
 * Creator: yanking
 * Create time: 2021-11-21 18:26
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.yanking.HomeWork;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homeWork {

    //1 验证邮箱
    @Test
    public void vertifyEmail() {
        String content = "2412709981@qq.com.tsinghua.org.cn";
//        String regstr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        String regstr = "^[\\w-]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("格式不匹配!");
        }
        if (content.matches(regstr)) {
            System.out.println("Yes");
        }


    }

    //2 验证整数或者小数
    @Test
    public void vertifyNums() {
        String content = "-0.890";
        String regstr01 = "^[-+]?[1-9](\\d)*(\\.0+)?$";//整数
        String regstr02 = "^[-+]?([1-9]\\d*|0)\\.\\d+$";//小数
        String regstr = "^[-+]?([1-9]+|0)(\\.\\d+)?$";

        Pattern pattern = Pattern.compile(regstr01);
        Matcher matcher = pattern.matcher(content);
        if (content.matches(regstr01)) {
            matcher.find();
            System.out.println(matcher.group(0));
            System.out.println("数字为整数！");
        }
        //判断小数
        pattern = Pattern.compile(regstr02);
        matcher = pattern.matcher(content);
        if (content.matches(regstr02)) {
            matcher.find();
            System.out.println(matcher.group(0));
            System.out.println("数字为小数！");
        }



    }

    //3 实现对域名进行解析
    @Test
    public void analyURL() {
//        String content = "http://www.sohu.com:8080/abc/index.htm";
        String content = "http://www.baidu13312.com:8080/aaa/xxx/yyy//////index.htm";
        String regstr = "^([a-zA-Z]+)://(\\w+\\.\\w+\\.[a-zA-Z]+):(\\d{4})[\\w-/]*/(\\w+\\.\\w+)$";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("协议："+matcher.group(1));
            System.out.println("域名："+matcher.group(2));
            System.out.println("端口："+matcher.group(3));
            System.out.println("文件名："+matcher.group(4));
        }

    }

}
