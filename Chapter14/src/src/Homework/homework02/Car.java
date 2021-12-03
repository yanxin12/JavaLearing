// -*- coding: utf-8 -*- 
/**
 * Project: Chapter14
 * Creator: yanking
 * Create time: 2021-10-27 00:38
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package src.Homework.homework02;

public class Car {
    private String name;
    private int prices;

    public Car(String name, int prices) {
        this.name = name;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return  name + '\''+ prices;
    }
}
