// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:49
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class tank_game_05 extends JFrame {
    MyPanel mp = null;

    public tank_game_05() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 900);
        this.addKeyListener(mp);
        this.setVisible(true);

        //通过在JFrame中增加相应关闭窗口实现窗口关闭保存数据功能
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("关闭窗口！");
                try {
                    Recorder.saveDate(mp.enemies, mp.hero);
                    System.out.println("数据已保存！");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });




    }

    public static void main(String[] args) {
        tank_game_05 tank_game_02 = new tank_game_05();
    }
}
