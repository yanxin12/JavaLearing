// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game02;

public class Tank {
    private int x;
    private int y;
    private int direct;
    private int speed;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y = y - speed;
    }

    public void moveDown() {
        y = y + speed;
    }

    public void moveRight() {
        x = x + speed;
    }

    public void moveLeft() {
        x = x - speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
