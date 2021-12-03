// -*- coding: utf-8 -*- 
/**
 * Project: Chapter18
 * Creator: yanking
 * Create time: 2021-11-05 09:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

import java.io.*;

public class fileMethod {
    public static void findDirandFiles(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < dir.list().length; i++) {
                findDirandFiles(new File(dir, children[i]));
                ;
            }
        }
    }
    //实现遍历目标目录下的所有文件与文件夹
    public static void findDF(File dir) {
        String[] children = dir.list();
        for (int i = 0; i < children.length; i++) {
//            System.out.println(dir + "\\" + children[i]);
            System.out.println(new File(dir, children[i]));
            ;
        }

    }
    public static void isFD(File dir, String direction) {
        String[] children = dir.list();
        int flag = 0;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(direction)) {
                System.out.println("目录下存在文件夹" + direction);
                flag = 1;
                break;
            }

        }
        if (flag == 0) {
            File file = new File(dir, direction);
            boolean mkdir = file.mkdir();
        }else {
            System.out.println("该目录下已经存在指定文件夹！");
        }
    }
    //在指定目录下创建指定文件，如果文件存在则提示已存在
    public  void  creatFile(File dir,String fileName) throws IOException {
        String [] children = dir.list();
        int flag = 0;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(fileName)){//可以使用exits方法判断目录文件是否存在
                System.out.println("指定目录下已存在相同名称的文件!");
                flag = 1;
                break;
            }
        }

        if (flag == 0){
            File file = new File(dir,fileName);
//            if (file.exists())
            file.createNewFile();
            System.out.println("文件创建成功！");
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(dir, fileName)));
        bufferedWriter.write("hello world!");
        System.out.println("Wirting Scuessful !");
        bufferedWriter.close();
    }





}
