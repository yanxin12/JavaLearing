// -*- coding: utf-8 -*- 
/**
 * Project: Regexp
 * Creator: yanking
 * Create time: 2021-11-21 09:55
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.yanking.Regexp_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class classTrain {

    @Test
    public void regularExpressionTest() {
//        String content = "1998年冬天有19999个苹果树被种植在" +
//                "北纬110°东经66°的一个666666平方米的林场！";
        String content = "1111111";
//        Pattern pattern = Pattern.compile("\\d{2}(\\d{2})?");
//        Pattern pattern = Pattern.compile("1{4}|1{3}");
        Pattern pattern = Pattern.compile("1{3,7}"); //贪婪匹配
//        Pattern pattern = Pattern.compile("1{3}|1{4}");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
        }


    }

    @Test
    //通过IO流获取大文件，并且声称String进行正则表达搜索
    public void fileRegExp() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(
                            new File("F:\\JAVA_CODE\\login.java")));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void fileRegExp_02() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(
                    new File("F:\\JAVA_CODE\\login.java"));
            int readlen = 0;
            char[] buf = new char[1024];
//            byte[] buf = new byte[1024];
            while ((readlen = fileReader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readlen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public void fileRegExp_03() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(
                    new File("F:\\JAVA_CODE\\login.java"));
            int readlen = 0;
//            char[] buf = new char[1024];
            byte[] buf = new byte[1024];
            while ((readlen = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readlen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileRegExp_04() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    new File("F:\\JAVA_CODE\\login.java"))));
            int readlen = 0;
            char[] buf = new char[1024];
//            byte[] buf = new byte[1024];
            while ((readlen = reader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readlen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}