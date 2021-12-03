// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-11-01 19:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game;

public class shot implements Runnable {
    public int x;
    public int y;
    public boolean islive = true;
    private int speed = 10;
    private int direct = 0;

    public shot(int x, int y, int direct) {
        this.direct = direct;
        this.x = x;
        this.y = y;
    }

    public void setIslive(boolean islive) {
        this.islive = islive;
    }

    @Override
    public void run() {
        while (islive) {
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
                default:
                    System.out.println("方向有误！direct = " + direct);
            }
//            System.out.println("x = " + x + "y = " + y);
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750) && islive) {
                this.setIslive(false);
//                System.out.println("子弹销毁!");
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}