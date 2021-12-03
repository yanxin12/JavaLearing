// -*- coding: utf-8 -*- 
/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-04 17:30
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package bufferReader_;

import java.io.*;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

public class BufferReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\hp\\Desktop\\Mathmodel\\21\\2021年D题\\program\\data_get_rr.m";
        String writePath = "C:\\Users\\hp\\Desktop\\报名\\copy.txt";
//        String filePath = "F:\\JAVA_CODE\\Homework01.java";
        FileReader fileReader = new FileReader(filePath);
        //需要在写文件的时候采用追加的方式需要在bufferWriter里面的节点流里面进行设置
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writePath, true));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            //按每一行进行到导入，导入完成后需要换行
            bufferedWriter.newLine();

        }
        if (bufferedReader != null)
            bufferedReader.close();
        if (bufferedWriter != null)
            bufferedWriter.close();

    }
}
