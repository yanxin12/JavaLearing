// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-04 10:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.RentSystem.Service;

import com.RentSystem.domain.House;

public class Service {
    private House [] houses;
    private int houseNum = 1;
    private int idCounter = 1;

    public Service(int size){
        houses = new House[size];
        houses[0] = new House(1,"jack","112", "海淀区", 2000, "未出租");
    }
    public boolean add(House newHouse){
        if(houseNum <= houses.length){
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        houses[houseNum++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }
    private House findHouse(){
        return null;
    }


}
