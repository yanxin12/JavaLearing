// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 22:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {
    MyPanel mp = null;

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 10, 10);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char) e.getKeyCode() + "被按下");
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
            System.out.println("Down!");
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
            System.out.println("Up!");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}