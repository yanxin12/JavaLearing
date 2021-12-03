// -*- coding: utf-8 -*- 
/**
 * Project: MHL
 * Creator: yanking
 * Create time: 2021-11-20 12:10
 * IDE: IntelliJ IDEA
 * Introduction:
 * 实现满汉楼项目界面程序编写
 * 界面采用控制台界面
 */
package com.View;

import com.Service.*;
import com.Utils.Utility;

public class appView {

    public static void main(String[] args) {
        mainView mainView = new mainView();
    }
}

class mainView {
    private boolean loop = true;
    private diningTableSeverice diningTableSeverice = new diningTableSeverice();
    private employeeService employeeService = new employeeService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();
    private MultiPlayService multiPlayService = new MultiPlayService();
    private loginViewService loginViewService = new loginViewService();

    public mainView() {
        while (loop) {
            System.out.println("=========满汉楼服务系统=========");
            System.out.println("\t\t\t1 登陆满汉楼");
            System.out.println("\t\t\t2 退出满汉楼");
            System.out.print("请输入你的选择:");
            switch (Utility.readInt()) {
                case 1:
                    // 实现登陆功能
                    //使用多表登陆提高对数据读取的准确率
                    System.out.println("请输入登陆员工id：");
                    String empid = Utility.readString(50);
                    System.out.println("请输入登陆员工密码：");
                    String pwd = Utility.readString(50);
                    if (loginViewService.login(empid, pwd)) {
                        System.out.println("=========满汉楼二级菜单=========");
                        System.out.println("\t\t\t1 显示餐桌状态");
                        System.out.println("\t\t\t2 预定餐桌");
                        System.out.println("\t\t\t3 显示所有菜品");
                        System.out.println("\t\t\t4 点餐服务");
                        System.out.println("\t\t\t5 查看账单");
                        System.out.println("\t\t\t6 结账");
                        System.out.println("\t\t\t7 人事管理");
                        System.out.println("\t\t\t9 退出满汉楼");
                        System.out.print("请输入你的选择：");
                        while (loop) {
                            char key = Utility.readChar();
                            switch (key) {
                                case '1':
                                    diningTableSeverice.showTableState();
                                    break;
                                case '2':
                                    System.out.println("请输入需要预定的桌子序号！");
                                    int id = Utility.readInt();
                                    //验证餐桌号是否存在
                                    if (diningTableSeverice.judgeExits(id) == null) {
                                        System.out.println("餐桌号不存在，请重新点单！");
                                        continue;
                                    }
                                    if (diningTableSeverice.judgeState(id)) {
                                        System.out.println("请输入预定人姓名！");
                                        String orderName = Utility.readString(50);
                                        System.out.println("请输入预订人电话!");
                                        String orderTel = Utility.readString(50);
                                        diningTableSeverice.bookTable(id, orderName, orderTel);
                                    } else {
                                        System.out.println("餐桌当前状态不能预定！");
                                    }
                                    break;
                                case '3':
                                    menuService.showMenu();
                                    break;
                                case '4':
                                    while (loop) {
                                        menuService.showMenu();
                                        System.out.println("请输入需要点的菜的id(-1退出)");
                                        int menuid = Utility.readInt();
                                        if (menuid == -1) {
                                            System.out.println("退出点菜！");
                                            break;
                                        }
                                        //验证菜品单号是否存在
                                        if (menuService.getSingleMenu(menuid) == null) {
                                            System.out.println("菜品不存在，请重新点单！");
                                            continue;
                                        }
                                        System.out.println("输入你需要点的份数！");
                                        int nums = Utility.readInt();
                                        System.out.println("请输入餐桌序号");
                                        int diningTableId = Utility.readInt();
                                        //验证餐桌号是否存在
                                        if (diningTableSeverice.judgeExits(diningTableId) == null) {
                                            System.out.println("餐桌号不存在，请重新点单！");
                                            continue;
                                        }
                                        System.out.println("确认订单，Y/N?");
                                        char c = Utility.readConfirmSelection();
                                        if (c == 'Y') {
                                            billService.getBill(menuid, nums, diningTableId);
                                        } else {
                                            break;
                                        }
                                    }
                                    break;
                                case '5':
//                                    billService.listBill();
                                    multiPlayService.MulTabQuery();
                                    break;
                                case '6':
                                    while (loop) {
                                        System.out.println("请输入需要结账的桌子序号！(-1取消)");
                                        int diningTableID = Utility.readInt();
                                        if (diningTableID == -1) {
                                            break;
                                        }
                                        //验证餐桌号是否存在
                                        if (diningTableSeverice.judgeExits(diningTableID) == null) {
                                            System.out.println("餐桌号不存在，请重新结账！");
                                            continue;
                                        }
                                        System.out.println("支付方式（支付宝/微信/现金/回车取消）");
                                        String state = Utility.readString(20, "");
                                        if (state.equals("")) {
                                            break;
                                        }
                                        if (billService.payBill(diningTableID, state)) {
                                            break;
                                        }
                                    }
                                    break;
                                case '7':
                                    System.out.println("人事管理");
                                    break;
                                case '9':
                                    System.out.println("退出满汉楼");
                                    setLoop(false);
                                    break;
                                default:
                                    System.out.println("输入错误，请重新输入");
                            }
                        }
                    } else {
                        System.out.println("登陆失败！请重新登陆!");
                    }

                    break;
                case 2:
                    System.out.println("退出系统！");
                    setLoop(false);
                    break;
                default:
                    System.out.println("请输入正确的选择！");
            }

        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}


