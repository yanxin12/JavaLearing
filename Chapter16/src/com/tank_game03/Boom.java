// -*- coding: utf-8 -*- 
/**
 * Project: Chapter16
 * Creator: yanking
 * Create time: 2021-11-02 16:48
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.tank_game03;

public class Boom {
    boolean islive = true;
    protected int x;
    protected int y;
    protected int life = 9;


    public void setLife(int life) {
        this.life = life;
    }

    public void setIslive(boolean islive) {
        this.islive = islive;
    }
    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (this.life > 0) {
            life--;
        } else if (this.life == 0) {
            this.setIslive(false);
        }
    }


}
