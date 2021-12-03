// -*- coding: utf-8 -*- 
/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-05 09:01
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

import java.io.File;
import java.io.IOException;

public class homework01 {
    public static void main(String[] args) throws IOException {
//        System.out.println("遍历目录");
//        File dir = new File("E:\\mytemp"); //要遍历的目录
        File dir = new File("C:\\Users\\hp\\Desktop\\报名\\第十三届蓝桥杯大赛通知文件\\mytemp"); //要遍历的目录
//        System.out.println(dir.list().length);
//        System.out.println(dir);
//        findDirandFiles(dir);
//        findDF(dir);
//        isFD(dir, "mytemp");
        fileMethod fileMethod = new fileMethod();
        fileMethod.creatFile(dir,"hello.txt");



    }



}
