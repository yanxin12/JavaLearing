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

public class tank_game_01 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        tank_game_01 tank_game_01 = new tank_game_01();

    }
    public tank_game_01(){
        mp = new MyPanel();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,750);
        this.setVisible(true);
    }
}
