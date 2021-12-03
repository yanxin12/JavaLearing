// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-10-28 21:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game_last;

import java.util.Vector;

public class Tank {
    boolean islive = true;
    private int x;
    private int y;
    private int direct;
    private int speed;
    Vector<shot> shots = new Vector<>();

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setIslive(boolean islive) {
        this.islive = islive;
    }

    public void moveUp() {
        if (getY() >= speed) {
            y = y - speed;
        }
    }

    public void moveDown() {
        if (getY() + 60 < 750 + speed)
            y = y + speed;
    }

    public void moveRight() {
        if (getX() + 60 < 1000 + speed)
            x = x + speed;
    }

    public void moveLeft() {
        if (getX() > speed)
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
