// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-29 09:23
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game_last;

import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    Vector<com.tank_game_last.shot> shots = new Vector<>();
    Vector<Enemy> enemies = new Vector<>();
    com.tank_game_last.shot shot = null;
    private int maxShot = 3;

    //    private int speed = 6;
    //可能由于动态绑定机制，这边凡是有关speed的方法都无法访问这里赋的值
    //所以即用即设
    public Enemy(int x, int y) {
        super(x, y);
    }

    public void getEnemyShot() {
        if (shots.size() < maxShot) {
            //根据坦克方向创建子弹对象
            switch (getDirect()) {
                case 0:
                    shot = new shot(getX() + 20, getY(), getDirect());
                    break;
                case 1:
                    shot = new shot(getX() + 60, getY() + 20, getDirect());
                    break;
                case 2:
                    shot = new shot(getX() + 20, getY() + 60, getDirect());
                    break;
                case 3:
                    shot = new shot(getX(), getY() + 20, getDirect());
                    break;
            }
            shots.add(shot);
            new Thread(shot).start();
        }
    }

    //初始化enemies向量
    public void setEnemies(Vector<Enemy> enemies) {
        this.enemies = enemies;
    }

    //根据老韩画的8种情况分类模拟
    public boolean isTouchTank() {
        switch (getDirect()) {
            case 0:
                // 坦克方向朝上，分两种情况讨论
                for (int i = 0; i < enemies.size(); i++) {//遍历所有坦克，判断是否重合
                    Enemy enemy = enemies.get(i);
                    if (this != enemy) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            //左上角坐标
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 40
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 60)
                                return true;
                            //右上角坐标
                            if (getX() + 40 > enemy.getX()
                                    && getX() + 40 <= enemy.getX() + 40
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 60)
                                return true;
                        }
                        //前行方向坦克为左右移动
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 60
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 40)
                                return true;
                            //右上角坐标
                            if (getX() + 40 > enemy.getX()
                                    && getX() + 40 <= enemy.getX() + 60
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 40)
                                return true;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemies.size(); i++) {//遍历所有坦克，判断是否重合
                    Enemy enemy = enemies.get(i);
                    if (this != enemy) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {//前行坦克方向为上下方向
                            //右上角坐标
                            if (getX() + 60 > enemy.getX()
                                    && getX() + 60 <= enemy.getX() + 40
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 60)
                                return true;
                            //右下角坐标
                            if (getX() + 60 > enemy.getX()
                                    && getX() + 60 <= enemy.getX() + 40
                                    && getY() + 40 >= enemy.getY()
                                    && getY() + 40 <= enemy.getY() + 60)
                                return true;
                        }

                        //前行方向坦克为左右移动
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (getX() + 60 > enemy.getX()
                                    && getX() + 60 <= enemy.getX() + 60
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 40)
                                return true;
                            //右下角坐标
                            if (getX() + 60 > enemy.getX()
                                    && getX() + 60 <= enemy.getX() + 60
                                    && getY() + 40 >= enemy.getY()
                                    && getY() + 40 <= enemy.getY() + 40)
                                return true;
                        }
                    }
                }
                break;
            case 2://判断坦克方向向下
                for (int i = 0; i < enemies.size(); i++) {//遍历所有坦克，判断是否重合
                    Enemy enemy = enemies.get(i);
                    if (this != enemy) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {//前行坦克方向为上下方向
                            //左下角坐标
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 40
                                    && getY() + 60 >= enemy.getY()
                                    && getY() + 60 <= enemy.getY() + 60)
                                return true;
                            //右下角坐标
                            if (getX() + 40 > enemy.getX()
                                    && getX() + 40 <= enemy.getX() + 40
                                    && getY() + 60 >= enemy.getY()
                                    && getY() + 60 <= enemy.getY() + 60)
                                return true;
                        }

                        //前行方向坦克为左右移动
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 60
                                    && getY() + 60 >= enemy.getY()
                                    && getY() + 60 <= enemy.getY() + 40)
                                return true;
                            //右下角坐标
                            if (getX() + 40 > enemy.getX()
                                    && getX() + 40 <= enemy.getX() + 60
                                    && getY() + 60 >= enemy.getY()
                                    && getY() + 60 <= enemy.getY() + 40)
                                return true;
                        }
                    }
                }
                break;
            case 3://判断坦克方向为向左运动
                for (int i = 0; i < enemies.size(); i++) {//遍历所有坦克，判断是否重合
                    Enemy enemy = enemies.get(i);
                    if (this != enemy) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {//前行坦克方向为上下方向
                            //左上角坐标
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 40
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 60)
                                return true;
                            //左下角坐标
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 40
                                    && getY() + 60 >= enemy.getY()
                                    && getY() + 60 <= enemy.getY() + 60)
                                return true;
                        }

                        //前行方向坦克为左右移动
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 60
                                    && getY() >= enemy.getY()
                                    && getY() <= enemy.getY() + 40)
                                return true;
                            //左下角坐标
                            if (getX() > enemy.getX()
                                    && getX() <= enemy.getX() + 60
                                    && getY() + 60 >= enemy.getY()
                                    && getY() + 60 <= enemy.getY() + 40)
                                return true;
                        }
                    }
                }
                break;
        }
        return false;
    }


    @Override
    public void run() {
        while (true) {
            switch (this.getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (!(isTouchTank()))
                            this.moveUp();
                        if (getY() <= 0)
                            break;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (!(isTouchTank()))
                            this.moveRight();
                        if (getX() + 60 > 1000)
                            break;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (!(isTouchTank()))
                            this.moveDown();
                        if (getY() + 60 > 750)
                            break;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (!(isTouchTank()))
                            this.moveLeft();
                        if (getX() <= 0)
                            break;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //实现敌人坦克的随机转向
            this.setDirect((int) (Math.random() * 4));
            if (!(this.islive)) {
                break;
            }
            getEnemyShot();

        }


    }
}
