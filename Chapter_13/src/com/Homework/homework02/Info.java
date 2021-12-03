// -*- coding: utf-8 -*- 
/**
 * Project: Chapter_13
 * Creator: yanking
 * Create time: 2021-08-12 20:05
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Homework.homework02;

import java.util.Scanner;

public class Info {
    private String name;
    private  String passwords;
    private  String mail;

    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("name:");
        String temp = scanner.next();
        if (( temp.length())<2 ||(temp.length())>4){
            throw new nameSize("输入姓名格式不正确！");
        }else {
            this.name = temp;
        }
        System.out.print("passwords:");
        temp = scanner.next();
        if ((temp.length())!=6 ){
            throw new passwordsLong("密码大小不为6！");
        }else{
            try {
                Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                throw new passwordDigital("输入密码不全是数字！");
            }
            passwords = temp;
        }
        System.out.print("mail:");
        temp = scanner.next();
        int k = -1;
        int f = -1;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i)=='@'){
                 k = i;
            }
            if (temp.charAt(i) == '.')
                f = i;
        }
        if (k == -1 || f == -1){
            throw new mailContemption("邮箱组成有误！");
        }else if(k>=f){
            throw new mailOrder("邮箱字符顺序有误！");
        }else {
            this.mail = temp;
        }

        System.out.println("注册完成!");

    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", passwords='" + passwords + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
