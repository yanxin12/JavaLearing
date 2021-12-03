// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:44
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game_last;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    static Scanner scanner = new Scanner(System.in);
    Hero hero = null;
    //定义Vector类型的敌人坦克向量
    Vector<Enemy> enemies = new Vector<>();
    //定义Vector类型的爆炸图片
    Vector<Boom> booms = new Vector<>();
    //设定敌人坦克数量
    int EnemySize = 8;
    //初始化爆炸图片变量
    Image image01 = null;
    Image image02 = null;
    Image image03 = null;


    public MyPanel() {



        //初始化爆炸图片变量
        image01 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image02 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image03 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));


        //游戏开始之前播放游戏音乐
//        System.out.println("播放音乐！");
        new AePlayWave("src\\111.wav").start();

        //在这里进行判断，是否新开游戏或者继续上一局游戏
        System.out.println("Please select your choice : 1. The new game \t 2. Continue the last game");
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                //初始化自己坦克位置
                hero = new Hero(500, 690);
                // 初始化敌人坦克
                for (int i = 0; i < EnemySize; i++) {
                    Enemy enemy = new Enemy(100 * (i + 1), 0);
                    enemy.setDirect(2);
                    enemy.setSpeed(2);
                    new Thread(enemy).start();
                    enemies.add(enemy);
                }
                break;
            case 2:
                try {
                    Recorder.getNodesandhitNum();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //遍历Nodes集合并且绘制出集合里面的坦克
                int i = 0;
                for (; i < Recorder.nodes.size(); i++) {
                    Tank tank = Recorder.nodes.get(i);
                    //把node的转化为Enemy类型
                    Enemy enemy = new Enemy(tank.getX(), tank.getY());
                    enemy.setDirect(tank.getDirect());
                    enemies.add(enemy);
                    enemy.setSpeed(2);
                    new Thread(enemy).start();
                }
                //己方坦克数据需要和地方坦克数据区分开来，不然会造成地方坦克叛变情况！
                if (Recorder.flag == 1) {
                    hero = Recorder.hero;
                } else {
                    System.out.println("己方坦克已被击毁！请重新开始游戏！");
                    System.exit(0);
                }

                break;
            default:
                System.out.println("你的输入有误！");
                System.exit(0);
        }
              //初始化敌人坦克内部数据，方便解决坦克重叠问题
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.setEnemies(enemies);
        }

    }

    //创建一个绘图函数，画出已经击毁的坦克数量
    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("隶书", Font.BOLD, 25);
        g.setFont(font);


        g.drawString("您累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 0);
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(Recorder.allHitTankNum), 1080, 100);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0, 0, 1000, 750);
        if (hero != null && hero.islive) {
            drawTank(hero.getX(), hero.getY(), g, 1, hero.getDirect());
        }
        //判断中的两个顺序不能调换，不然会出现空指针异常
        //原因是hero.shot在没有按下J键的时候是null
        //所以让shot不为空的时候才进行判断可以避免出现空指针异常
        //绘制我方坦克子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            shot shot = hero.shots.get(i);
            if (shot.islive)
                g.fill3DRect(shot.x, shot.y, 2, 2, false);
            else
                hero.shots.remove(shot);
        }
        //实现爆炸效果
        //根据爆炸类中的life长短绘制三张爆炸图片
        for (int i = 0; i < booms.size(); i++) {
            //取出爆炸变量
            Boom boom = booms.get(i);
            //根据Boom类实现爆炸效果
            if (boom.islive) {//通过islive变量实现爆炸事件的发生和结束
                if (boom.life > 6) {
                    g.drawImage(image01, boom.x, boom.y, 60, 60, this);
                } else if (boom.life > 3) {
                    g.drawImage(image02, boom.x, boom.y, 60, 60, this);
                } else {
                    g.drawImage(image03, boom.x, boom.y, 60, 60, this);
                }
            }
            //减少boom生命值，实现爆炸过渡效果
            boom.lifeDown();
            if (boom.life == 0) {
                boom.setIslive(false);
            }
        }

        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).islive) {
                drawTank(enemies.get(i).getX(), enemies.get(i).getY(), g, 0, enemies.get(i).getDirect());
                //画出敌人的子弹（根据设定敌人弹夹数量调整一段时间内敌人坦克所能发出子弹数）
                for (int j = 0; j < enemies.get(i).shots.size(); j++) {
                    shot shot = enemies.get(i).shots.get(j);
                    //绘制
                    if (shot.islive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemies.get(i).shots.remove(shot);
                    }
                }
            }
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
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;

            case 1:
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

    // 包装子弹击中敌人方法
    public void hitTank(shot shot, Tank enemy) {
        if (enemy.islive) {
            switch (enemy.getDirect()) {
                //坦克上下方向和左右方向形状一样，可以归为一类
                //坦克消失的时候就是爆炸发生的时候，故在此时天剑爆炸效果
                case 0:
                case 1:
                    if (shot.x > enemy.getX() && shot.x < enemy.getX() + 40
                            && shot.y > enemy.getY() && shot.y < enemy.getY() + 60) {
                        shot.setIslive(false);
                        enemy.setIslive(false);
                        enemies.remove(enemy);
                        if (enemy instanceof Enemy) {
                            Recorder.addallHitTankNum();
                        }
                        shot = null;
//                        hero.shots.remove(shot);
                        booms.add(new Boom(enemy.getX(), enemy.getY()));
                    }
                    break;
                case 2:
                case 3:
                    if (shot.x > enemy.getX() && shot.x < enemy.getX() + 60
                            && shot.y > enemy.getY() && shot.y < enemy.getY() + 40) {
                        shot.setIslive(false);
                        shot = null;
                        enemy.setIslive(false);
                        enemies.remove(enemy);
//                        hero.shots.remove(shot);
                        if (enemy instanceof Enemy) {
                            Recorder.addallHitTankNum();
                        }
                        booms.add(new Boom(enemy.getX(), enemy.getY()));
                    }
                    break;
            }
        }
    }

    // 对弹夹中的每一颗子弹都进行hitTank方法
    public void hitEnemy() {
        //取出弹夹中的每一颗子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            shot shot = hero.shots.get(i);
            //对每一颗shot子弹进行hitTank方法
            if (shot != null && shot.islive) {
                for (int j = 0; j < enemies.size(); j++) {
                    hitTank(hero.shot, enemies.get(j));
                }
            }
        }
    }


    public void hitHero() {
        //遍历每一个还存活的敌人坦克，取出每一个塔克的弹夹，调用hitTank方法
        for (int i = 0; i < enemies.size(); i++) {//取出enemies集合中的所有敌人坦克
            Enemy enemy = enemies.get(i);
            if (enemy.islive) {//如果该坦克还存活，取出该坦克所有子弹并且调用hitTank方法
                for (int j = 0; j < enemy.shots.size(); j++) {
                    shot shot = enemy.shots.get(j);
                    if (shot != null && shot.islive) {
                        hitTank(shot, hero);
                    }
                }
            }
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
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
//            for (int i = 0; i < hero.shots.size(); i++) {
//                if (hero.shot == null || !hero.shot.islive)
            hero.shotEnemy();
//            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hero != null && hero.shots.size() > 0)
                hitEnemy();
            hitHero();
            this.repaint();
        }
    }
}
