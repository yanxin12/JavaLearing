// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:49
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game03;

import javax.swing.*;

public class tank_game_03 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        tank_game_03 tank_game_02 = new tank_game_03();

    }
    public tank_game_03(){
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setVisible(true);

    }
}
