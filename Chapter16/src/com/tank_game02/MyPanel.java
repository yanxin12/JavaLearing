// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:44
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<Enemy> enemies = new Vector<>();
    int EnemySize = 3;

    public MyPanel() {
        hero = new Hero(200, 200);
        for (int i = 0; i < EnemySize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            enemies.add(enemy);
            enemy.setDirect(2);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(hero.getX(), hero.getY(), g, 1, hero.getDirect());
        for (int i = 0; i < enemies.size(); i++) {
            drawTank(enemies.get(i).getX(), enemies.get(i).getY(), g, 0, enemies.get(i).getDirect());
        }
        hero.setSpeed(8);
    }
    //    封装画坦克类
    public void drawTank(int x, int y, Graphics g, int type, int direct) {
//        判断类型实现坦克颜色
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

//        判断坦克方向并且绘制坦克
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//坦克左边履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中心
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边履带
                g.fillOval(x + 10, y + 20, 20, 20);//坦克顶盖
                g.drawLine(x + 20, y + 30, x + 20, y);//坦克炮筒
                break;

            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;

            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");

        }


    }

    //实现坦克转向
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
//            System.out.println("get message!");
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
