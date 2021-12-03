// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-28 17:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Homework.homework01;

public class homework {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1",new User(1,18,"小明"));
        userDAO.save("2",new User(2,20,"小韩"));
        userDAO.save("3",new User(3,19,"小黄"));
        System.out.println(userDAO.get("3"));
        userDAO.update("3",new User(3,34,"老韩"));
        System.out.println(userDAO.get("3"));
        System.out.println(userDAO.list());
        userDAO.delete("2");
        System.out.println(userDAO.list());
        
        
        

    }
}
