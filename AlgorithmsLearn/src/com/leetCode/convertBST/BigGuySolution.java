// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 23:12
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.convertBST;

public class BigGuySolution {
    // 使用逆中序遍历实现
    public int he = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        searchTree(root);
        return root;
    }

    public void searchTree(TreeNode root) {
        if (root == null) {
            return;
        }
        searchTree(root.right);
        he += root.val;
        root.val = he;
        searchTree(root.left);
    }
}
