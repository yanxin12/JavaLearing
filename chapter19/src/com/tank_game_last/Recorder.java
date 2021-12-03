// -*- coding: utf-8 -*- 
/**
 * Project: chapter19
 * Creator: yanking
 * Create time: 2021-11-06 00:35
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game_last;

import java.io.*;
import java.util.Vector;

public class Recorder {
    //通过Java的IO流实现Hero击毁坦克数据的实时更新
    protected static int allHitTankNum = 0;
    //辅助变量，判断己方坦克是否已经被击毁
    static int flag = 0;
    //使用静态变量存储己方坦克的方向
//    static int heroDirect;
    //文件读取器的初始化
    static BufferedReader br = null;
    //采用读取每一行的形式进行读取
    static String line = "";
    //实现将击毁坦克数据保存到指定文件夹中
    static String dataPath = "F:\\Java_idea\\chapter19\\src\\com\\tank_game_hitData.txt";
    // 创建一个Node集合存储node数据
    static Vector<Tank> nodes = new Vector<>();
    static Hero hero = null;
    private static BufferedWriter bw = null;

    public static void addallHitTankNum() {
        ++allHitTankNum;
    }

    //在记录类里面实现Node集合的初始化方法
    public static void getNodesandhitNum() throws FileNotFoundException {
        //遍历保存的数据文件，取出击毁坦克数和各个坦克的位置方向信息
        //从Recorder记录的数据文件中读取数据并且进行坦克的重新绘制
        File file = new File(dataPath);
        if (!(file.exists())) {
            System.out.println("没有上一局游戏数据！，请重新开一局游戏！");
            System.exit(0);
        }
        try {//获取击毁坦克数
            br = new BufferedReader(new FileReader(Recorder.dataPath));
            allHitTankNum = Integer.parseInt(Recorder.br.readLine());//读取完一行之后会进行下一行进行读取
            while ((line = Recorder.br.readLine()) != null) {
                //   获取坦克的坐标和方向数据
                String[] xyd = line.split(" ");
                if (Integer.parseInt(xyd[3]) == 1) {
                    Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]));
                    node.setDirect(Integer.parseInt(xyd[2]));
                    nodes.add(node);
                } else if (Integer.parseInt(xyd[3]) == 0) {
                    hero = new Hero(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]));
//                    heroDirect = Integer.parseInt(xyd[2]);
                    hero.setDirect(Integer.parseInt(xyd[2]));
                    flag = 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Recorder.br != null) {
                try {
                    Recorder.br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //保存数据需要保存每一个坦克的位置和方向，即(x,y,direct)
    //每一个坦克的数据保存为一行，通过读取每一行的数据，就可以在开始游戏的时候重新绘制出坦克

    public static void saveDate(Vector<Enemy> enemies, Hero hero) throws IOException {
        bw = new BufferedWriter(new FileWriter(new File(dataPath)));
//        bw.write("当前击毁坦克数量：\t\t" + allHitTankNum);
        bw.write(allHitTankNum + "");
        bw.newLine();
        //保存当前每一个敌人坦克坐标和方向
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.islive) {
                bw.write(enemy.getX() + " " + enemy.getY() + " " + enemy.getDirect() + " 1");
                bw.newLine();
            }
        }
        // 保存己方坦克的位置和方向
        if (hero.islive) {
            bw.write(hero.getX() + " " + hero.getY() + " " + hero.getDirect() + " 0");
            bw.newLine();
        }

//        bw.write(allHitTankNum+"");
        if (bw != null)
            bw.close();
    }


}
