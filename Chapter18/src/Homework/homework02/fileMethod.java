// -*- coding: utf-8 -*- 
/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-05 16:55
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework02;

import java.io.*;

public class fileMethod {
    String dir01 = "C:\\Users\\hp\\Desktop\\报名\\第十三届蓝桥杯大赛通知文件\\mytemp\\rpsGame.java";
    String dir02 = "C:\\Users\\hp\\Desktop\\报名\\第十三届蓝桥杯大赛通知文件\\mytemp\\rpsGame02.java";

    //读取文件并且为文件的每一行加上行号
    public void getLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(dir01)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(dir02)));
        String line = null;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write("第" + (++i) + "行:\t\t" + line);
            bufferedWriter.newLine();
        }

        if (bufferedReader!=null){
            bufferedReader.close();
        }
        if (bufferedWriter!=null){
            bufferedWriter.close();
        }
        System.out.println("成功添加行号！");

    }


}
