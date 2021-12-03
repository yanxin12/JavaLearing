// -*- coding: utf-8 -*- 

import java.io.*;

/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-04 19:34
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class Bufferbuf {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\hp\\Desktop\\Mathmodel\\21\\2021年D题\\program\\data_get_rr.m";
        String writePath = "C:\\Users\\hp\\Desktop\\报名\\copy.doc";
        BufferedInputStream bio = null;
        BufferedOutputStream bis = null;
        bio = new BufferedInputStream(new FileInputStream(filePath));
        bis = new BufferedOutputStream(new FileOutputStream(writePath));
        byte[] buff = new byte[1024];
        int readLen = 0;
        while ((readLen = bio.read(buff)) != -1) {
            bis.write(buff,0,readLen);
        }
        if (bio != null)
            bio.close();
        if (bis != null)
            bis.close();


    }
}
