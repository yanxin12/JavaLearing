// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:43
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game;

public class Hero extends Tank {
    public shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemy() {
        if (shots.size()>5)
            return;
        switch (this.getDirect()) {
            case 0:
                shot = new shot(this.getX() + 20, this.getY(), 0);
                break;
            case 1:
                shot = new shot(this.getX() + 60, this.getY() + 20, 1);
                break;
            case 2:
                shot = new shot(this.getX() + 20, this.getY() + 60, 2);
                break;
            case 3:
                shot = new shot(this.getX(), this.getY() + 20, 3);
                break;
            default:
                System.out.println("方向有误！");
        }
        new Thread(this.shot).start();
        this.shots.add(shot);
    }
}
