// -*- coding: utf-8 -*- 

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-03 19:48
 * IDE: IntelliJ IDEA
 * Introduction:
 */

public class FileCreat {
    public static void main(String[] args) {


    }

    @Test
    //1.第一种方法
    public void fileCreat01() throws IOException {
        String filename = "F:\\考研计算机资料\\test\\1.txt";
//    FileInputStream fileInputStream = new FileInputStream(filename);
//    fileInputStream.available();
//    fileInputStream.close();
        File file = new File(filename);
        file.createNewFile();
        System.out.println("文件创建成功！");
//    file.delete();
        System.out.println(file.getAbsoluteFile());
    }

    @Test
//第二种方法，父类子类实现
    public void fileCreat02() {
        String parentPath = "F:\\";
        String childPath = "考研计算机资料\\test\\1.txt";
        File file = new File(parentPath, childPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    //第三种创建方法
    @Test
//第二种方法，父类子类实现
    public void fileCreat03() {
        File parentPath = new File("F:\\");
        String childPath = "考研计算机资料\\test\\1.txt";
        File file = new File(parentPath, childPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
//    {
//        String str = "hello world!";
//        byte[] bytes = str.getBytes();
//        System.out.println(bytes.toString());;
//    }



}
