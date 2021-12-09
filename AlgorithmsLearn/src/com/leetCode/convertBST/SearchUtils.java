// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 19:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.convertBST;

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

    // 构建树
    public boolean constructTree(int[] nums, int i) {
        // 使用树的层次遍历构建一个二插树
        TreeNode root = new TreeNode();
        root.val = nums[i];

        return true;
    }
}
