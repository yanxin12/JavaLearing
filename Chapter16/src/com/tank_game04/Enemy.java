// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-29 09:23
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game04;

import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    Vector<com.tank_game04.shot> shots = new Vector<>();
    com.tank_game04.shot shot = null;
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


    @Override
    public void run() {
        while (true) {
            switch (this.getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
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
