// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 19:29
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package YoungMatric;

public class YoungMatric {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {14, 15, 16, 17}};
        if (new YoungMatricUtils().isExist(A, 8)) {
            System.out.println("存在");
        } else {
            System.out.println("不存在！");
        }

    }
}
