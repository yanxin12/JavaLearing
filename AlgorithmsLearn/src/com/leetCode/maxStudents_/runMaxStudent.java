// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2022-01-03 15:05
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.maxStudents_;

public class runMaxStudent {
    public static void main(String[] args) {
        // char[][] seats = {{'#', '.', '.', '.', '#'}, {'.', '#', '.', '#', '.'}, {'.', '.', '#', '.', '.'}, {'.', '#', '.', '#', '.'}, {'#', '.', '.', '.', '#'}};
        // char[][] seats = {{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}};
        // char[][] seats = {{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}};
        char[][] seats = {{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}};
//         System.out.println(new maxStudents_().maxStudents(seats));
        System.out.println(new maxStudentUpdate().maxStudents(seats));
        System.out.println(new BigBullResolution().maxStudents(seats));
        for (char[] ints : seats) {
            for (char c : ints) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}
