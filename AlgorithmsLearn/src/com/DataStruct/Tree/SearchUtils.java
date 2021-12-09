// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 19:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.Tree;

public class SearchUtils {
    // 实现树的中序遍历
    public TreeNode midSearch(TreeNode root) {
        if (root == null) {
            System.out.print("null\t");
            return null;
        }
        System.out.print(root.val + "\t");
        midSearch(root.left);
        midSearch(root.right);
        return null;
    }
}
