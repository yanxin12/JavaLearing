//// -*- coding: utf-8 -*-
///**
// * Project: Rent_Sys
// * Creator: yanking
// * Create time: 2021-08-04 10:15
// * IDE: IntelliJ IDEA
// * Introduction:
// */
//package com.RentSystem.View;
//
//import com.RentSystem.Service.Service;
//import com.RentSystem.domain.House;
//import com.RentSystem.utils.Utility;
//
//public class View {
//    public boolean loop = true;
//    char key = ' ';
//    private Service houseService = new Service(2);
//    // class is uesd to construct a view of the system
//
//    public void addHouse() {
//        System.out.println("=============添加房屋============");
//        System.out.print("姓名: ");
//        String name = Utility.readString(8);
//        System.out.print("电话: ");
//        String phone = Utility.readString(12);
//        System.out.print("地址: ");
//        String address = Utility.readString(16);
//        System.out.print("月租: ");
//        int rent = Utility.readInt();
//        System.out.print("状态: ");
//        String state = Utility.readString(3);
//        House newHouse = new House(0, name, phone, address, rent, state);
//        if (houseService.add(newHouse)) {
//            System.out.println("=============添加房屋成功============");
//        } else {
//            System.out.println("=============添加房屋失败============");
//        }
//    }
//
//
//    public void findHouse(){
//
//    }
//
//    public void mainMenu() {
//
//        do {
//            System.out.println("\n=============房屋出租系统菜单============");
//            System.out.println("\t\t\t1 新 增 房 源");
//            System.out.println("\t\t\t2 查 找 房 屋");
//            System.out.println("\t\t\t3 删 除 房 屋 信 息");
//            System.out.println("\t\t\t4 修 改 房 屋 信 息");
//            System.out.println("\t\t\t5 房 屋 列 表");
//            System.out.println("\t\t\t6 退      出");
//            System.out.print("请输入你的选择(1-6): ");
//            key = Utility.readChar();
//            switch (key) {
//                case '1':
//                    addHouse();
//                    break;
//                case '2':
//                    findHouse();
//                    break;
//                case '3':
//                    delHouse();
//                    break;
//                case '4':
//                    update();
//                    break;
//                case '5':
//                    listHouses();
//                    break;
//                case '6':
//                    exit();
//                    break;
//            }
//        } while (loop);
//    }
//}
