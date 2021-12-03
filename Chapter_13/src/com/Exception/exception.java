// -*- coding: utf-8 -*- 
/**
 * Project: Chapter_13
 * Creator: yanking
 * Create time: 2021-08-12 10:21
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Exception;

import java.util.Scanner;

public class exception {
    // 使用异常提示输入字母
    boolean loop = true;

    public void m1() {
        Scanner scanner = new Scanner(System.in);
        char res = ' ';
        while (loop) {

            try {
                System.out.println("Please input a char of 'a' - 'z' or 'A'-'Z' ! ");
                res = scanner.next().charAt(0);
                System.out.println("The letter you input is " + res);
                if ( (res < 'a'&&res>'Z')|| res > 'z' || res < 'A'  ) {
                    throw new CustomException("输入的不是字母！");
                }else{
                    loop = false;
                }


            } catch(Exception e){
                e.printStackTrace();
                System.out.println("请重新输入！");
        }


    }
}


}
